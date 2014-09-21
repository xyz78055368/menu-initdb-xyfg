package com.groupshop.dao;



import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class DataBase {

	//	Logger logger = Logger.getLogger(DBUtil.class.getName());
	private static  String DRIVER ;
	private static  String URL ;
	private static String USER ;
	private  static String PASS;
	
	public static  String POSNAME;
	public static  String MENAME;
	public static Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public CallableStatement cstmt;
	Logger logger = Logger.getLogger(DataBase.class.getName());

	public Connection getConn() throws ClassNotFoundException{
		Connection conn = null;
		Properties properties = new Properties();
		try {
			FileInputStream is =  new FileInputStream("C:\\DBHelper\\TSYGDB.properties");
			properties.load(is);

			DRIVER = properties.getProperty("driver");
			URL = properties.getProperty("url");
			USER = properties.getProperty("user");
			PASS = properties.getProperty("password");
			POSNAME = properties.getProperty("posname");
			MENAME = properties.getProperty("mename");
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASS);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}


	public void closeAll(){
		try {
			if(rs !=null){
				rs.close();
				rs = null;
			}
			if(pstmt!=null){
				pstmt.close();
				pstmt = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public int execulQ(String sql,String[] param){
		int num = 0;
		try {
			conn = DataBase.startConn(conn);
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<param.length;i++){
				pstmt.setString(i+1, param[i]);
			}
			num = pstmt.executeUpdate();
		
		} catch (SQLException e) {
		}
		return num;
	}
	public static Connection startConn(Connection conn){
		try {
			while(conn== null||conn.isClosed()){
				conn = new DataBase().getConn();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
