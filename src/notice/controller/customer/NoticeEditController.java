package notice.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeEditController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeEditController");
		String seq = request.getParameter("c");
		
		NoticeDao dao = new NoticeDao();
		Notice n = dao.getNotice(seq);
		
		//request에 n을 저장
		request.setAttribute("n", n);
		//jsp로 forward
		request.getRequestDispatcher("noticeEdit.jsp").forward(request, response);
	}
}
