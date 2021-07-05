package notice.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeEditProcController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeEditController");
		String seq = request.getParameter("c");
		
		String title = new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");
		String content = new String(request.getParameter("content").getBytes("iso-8859-1"),"utf-8");
		
		NoticeDao dao = new NoticeDao();
		Notice n = new Notice();
		n.setSeq(seq);
		n.setTitle(title);
		n.setContent(content);
		
		int af = dao.update(n);
		
		
		//request에 n을 저장
		request.setAttribute("n", n);
		//jsp로 forward
		if(af>0) {
			request.getRequestDispatcher("noticeDetail.do").forward(request, response);
		}else {
			System.out.println("수정 오류");
		}
	}
}
