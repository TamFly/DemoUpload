package form;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class APIForm extends ActionForm {
	private String jsonString;

	/**
	 * @return the jsonString
	 */
	public String getJsonString() {
		return jsonString;
	}

	/**
	 * @param jsonString
	 *            the jsonString to set
	 */
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

}
