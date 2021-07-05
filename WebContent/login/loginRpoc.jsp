<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<%
	String id = request.getParameter("id");
	String pass = request.getParameter("password");

	//db연결
	String seq = request.getParameter("c");
	String sql = "select id,pwd from member where id = ?";
	//db connect
	//드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//접속
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "123456";
	Connection conn = DriverManager.getConnection(url, user, pw);
	
	//실행
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery(); // select 실행
	
	//내가 입력한 id,pass와 db에 저장된 내용과 비교
	String ypass =""; //db에 있는 pwd
	int x=-1;
	String msg="";
	if(rs.next()){
		ypass = rs.getString("pwd");
		if(ypass.equals(pass)){ // loginForm에 입력한 password
			x=1;
		}else{ //패스워드 불일치
			x=0;
		}
	}else{ // 아이디 없음
		x=-1;
	}
	System.out.println("xxxx : " + x);
	
	//x값에 따라 어느페이지로 보낼지 결정
	if(x==1){ //로그인 성공
		session.setAttribute("sessionID", id);
		msg="../mainForm.jsp";
	}else if(x==0){ // 패스워드 오류
		msg="loginForm.jsp?msg=0";
	}else if(x==-1){ // 아이디 없음
		msg="loginForm.jsp?msg=-1";
	}
	
	response.sendRedirect(msg);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>loginRpoc.jsp</h3>
</body>
</html>