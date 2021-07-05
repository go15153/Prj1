package notice.controller.customer;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeDelProcController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeDelProcController");
		String seq = request.getParameter("c");
		
		NoticeDao dao = new NoticeDao();
		Notice n = dao.getNotice(seq);
		
		int af = dao.delete(n);
		
		PrintWriter ou = response.getWriter();
		//jsp로 forward
		if(af>0) {
			response.sendRedirect("notice.jsp");
		}else {
			System.out.println("삭제 오류");
		}
			
	}
}
