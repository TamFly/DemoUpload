package action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import form.FileUploadForm;

public class FileUploadAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FileUploadForm fileUploadForm = (FileUploadForm) form;
		FormFile file = fileUploadForm.getFile();
		String filePath = getServlet().getServletContext().getRealPath("/") + "files/upload";
		File folder = new File(filePath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String fileName = file.getFileName();
		if (!"".equals(fileName)) {
			File newFile = new File(filePath, fileName);
			if (!newFile.exists()) {
				FileOutputStream fos = new FileOutputStream(newFile);
				fos.write(file.getFileData());
				fos.flush();
				fos.close();
			}
			System.out.println("Success "+newFile.getAbsoluteFile().getPath().replace("\\", "/"));
		}
		return mapping.findForward("success");
	}
}
