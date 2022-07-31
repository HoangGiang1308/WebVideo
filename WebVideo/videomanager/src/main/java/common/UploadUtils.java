package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;


public class UploadUtils {
	public static String processUploadField(String filedName, HttpServletRequest req,
			String stroredFolder, String stroredFilename) throws IOException, ServletException  {
		Part filePart =req.getPart(filedName);
		if(filePart == null || filePart.getSize() == 0) {
			return "";
		}
		if(stroredFolder == null) {
			stroredFolder = "/uploads";
		}
		if(stroredFilename == null) {
			stroredFilename = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
		}else {
			stroredFilename += "." + FilenameUtils.getExtension(Path.of(filePart.getSubmittedFileName()).toString());
		}
		String uploadFolder = req.getServletContext().getRealPath(stroredFolder);
		
		Path upLoadPath = Paths.get(uploadFolder);
		if (!Files.exists(upLoadPath)) {
			Files.createDirectory(upLoadPath);
		}
		filePart.write(Paths.get(upLoadPath.toString(),stroredFilename).toString());
		return stroredFilename;
	}
}
