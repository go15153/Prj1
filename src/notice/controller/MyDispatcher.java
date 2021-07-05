package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import notice.controller.customer.NoticeDelProcController;
import notice.controller.customer.NoticeDetailController;
import notice.controller.customer.NoticeEditController;
import notice.controller.customer.NoticeEditProcController;

public class MyDispatcher extends HttpServlet {
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGetdoPost 모두받기");
		String uri = request.getRequestURI();
		String conPath=request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println("URI : " + uri);
		System.out.println("conPath : "+conPath);
		System.out.println("com : " +com);
		
		Controller controller = null;
		
		try {
			if(com.equals("/customer/noticeDetail.do")) {
				controller =new NoticeDetailController();
			}else if(com.equals("/customer/noticeEdit.do")) {
				controller = new NoticeEditController();
			}else if(com.equals("/customer/noticeEditProc.do")) {
				controller = new NoticeEditProcController();
			}else if(com.equals("/customer/noticeDelProc.do")) {
				controller = new NoticeDelProcController();
			}
			controller.execute(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		doService(request, reponse);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		doService(request, reponse);
	}
}
