package ex0503.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	static DataSource ds;
	/**
	 * ·Îµå
	 */
	

	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:/comp/env/jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ¿¬°á
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	/**
	 * ´Ý±â
	 * insert,update,delete
	 */
	public static void dbClose(Statement st,Connection conn) {
			try {
				if(st!=null) st.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * select´Ý±â
	 */
	public static void dbClose(Statement st,Connection conn,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			dbClose(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}