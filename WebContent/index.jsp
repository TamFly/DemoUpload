<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="./js/angular.min.js"></script>
</head>
<body ng-app="myApp" ng-controller="myCtrl">
	<table>
		<tr ng-repeat="x in name">
			<td>{{x}}</td>
		</tr>
	</table>
	<script type="text/javascript">
		var app = angular.module('myApp', []);
		app.controller('myCtrl', function($scope, $http) {
			$http.jsonp('api.do', {jsonpCallbackParam: 'callback'})
				.success(function(res){
					$scope.name = res.data.name;
				})
				.error(function() {
					console.log('error');
				});
		});
	</script>
</body>
</html>