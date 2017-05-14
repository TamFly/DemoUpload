package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import form.APIForm;

public class APIAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");
		APIForm apiForm = (APIForm) form;
		ArrayList<String> arr = new ArrayList<>();
		arr.add("aaaaaaaaaaa");
		arr.add("bbbbbbbbbbb");
		arr.add("ccccccccccc");
		JSONObject object = new JSONObject();
		object.put("name", arr);
		apiForm.setJsonString(object.toString());
		System.out.println(object.toString());
		return mapping.findForward("success");
	}
}
