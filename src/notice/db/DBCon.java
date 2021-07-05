package notice.db;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBCon {
	public static Connection getConnection() throws Exception{		
		Context initCtx = new InitialContext();
		Context envCtx=(Context)initCtx.lookup("java:comp/env");
		DataSource ds =(DataSource)envCtx.lookup("jdbc/noticeOrcl");
		Connection con = ds.getConnection();
		
		return con;
	}
}
