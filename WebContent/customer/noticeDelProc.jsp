<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
	%>
	
	<%
		/* String seq = request.getParameter("c");
		String sql = "delete from notices where seq = ?";
		//db connect
		//드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "123456";
		Connection conn = DriverManager.getConnection(url,user,pass);
		
		//실행
		Statement st = conn.createStatement(); 
		
		//결과
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);
		int af = pstmt.executeUpdate(); // return int
				
		if(af>0){//del이 되었다.
			response.sendRedirect("notice.jsp");
		} else {
			out.write("삭제오류");
		} */
		
		
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>noticeDelProc.jsp</title>
</head>
<body>
	<h3>noticeDelProc.jsp</h3>
</body>
</html>