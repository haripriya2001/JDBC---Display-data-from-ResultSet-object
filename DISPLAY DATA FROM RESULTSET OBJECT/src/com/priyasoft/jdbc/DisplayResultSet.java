package com.priyasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DisplayResultSet {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			st=con.createStatement();
			rs=st.executeQuery("select * from emp1");
			ResultSetMetaData md=rs.getMetaData();
			int count=md.getColumnCount();
			for(int i=1;i<=count;i++)
			{
				System.out.print(md.getColumnName(i)+"\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i=1;i<=count;i++)
				{
				System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				st.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
