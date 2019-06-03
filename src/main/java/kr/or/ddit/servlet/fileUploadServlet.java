package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class fileUploadServlet
 */
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class fileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(fileUploadServlet.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String profile = request.getParameter("profile");

		Part part = request.getPart("profile");

		// 파일이 존재할 때만 파일을 정해진 위치에 기록한다.
		if (part.getSize() > 0) {

			String contentDisposition = part.getHeader("content-disposition");
			String fileName = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(fileName);

			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			if (uploadFolder.exists()) {
				// 파일 디스크에 쓰기
				// 아래에 write메서드에 경로 및 파일명을 기술하면 해당 경로에 아래와 같은 파일명 및 확장자로
				// 파일디스크에 생성된다.
				part.write(uploadPath + "\\" + UUID.randomUUID().toString()
						+ ext);
				part.delete();
			}

		}

	}

}
