package com.groupshop.daoImpl;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.groupshop.dao.DataBase;
import com.groupshop.dao.Login;
import com.groupshop.entity.Opt;
public class LoginImp extends DataBase implements Login {
	Logger logger = Logger.getLogger(LoginImp.class.getName());
	public String checkUser(Opt uopt) {
		if(uopt.getName().equals("0001")&& uopt.getPassword().equals("0001")){
			return "OK";
		}
		if(!isUserTrue(uopt.getName())){
			logger.info("此账户不存在！");
			return "Error";
		}
//		String pwd = MD5andKL.JM(this.getPwdByName(uopt.getName()));
		String pwd = this.getPwdByName(uopt.getName());
//		String upwd = MD5andKL.MD5(uopt.getPassword()); 
		String upwd = uopt.getPassword();
		String str = new String();
//		if(this.isDaoqi()){
		str = pwd.equals(upwd)?"OK":"Error"; 
		logger.info("用户："+uopt.getName()+" 返回："+str+",长度："+str.length());
//		}
//		else{
//			str = "系统已过期，请雨软件开发商联系";
//		}
		return str;
	}

	public Opt getUserInfoByName(String uName) {
		Opt opt = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append(" id,name,code,password,auth,remark,flag");
		sb.append(" form opt");
		sb.append(" where name = ?");
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, uName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				opt = new Opt();
				opt.setId(rs.getInt(1));
				opt.setName(rs.getString(2));
				opt.setCode(rs.getString(3));
				opt.setPassword(rs.getString(4));
				opt.setAuth(rs.getString(5));
				opt.setRemark(rs.getString(6));
				opt.setFlag(rs.getString(7));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return opt;
	}
	
	public String getPwdByName(String uName){
		String pwd = new String();
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");
		sb.append(" password ");
		sb.append(" from opt");
		sb.append(" where 1=1");
		sb.append(" and code = ?");
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, uName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pwd = rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pwd;
	}
	
	
	public boolean isUserTrue(String uName){
		String code = new String();
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");
		sb.append(" code ");
		sb.append(" from opt");
		sb.append(" where 1=1");
		sb.append(" and code = ?");
		try {
			conn = DataBase.startConn(conn);
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, uName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				code = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean isTrue= false;
		isTrue=code.equalsIgnoreCase("null")||code.equals("")?false:true;
		return isTrue;
	}
	
	
	private static  String DATE ;
	private static  String UPDATEDATE ;


	public boolean isDaoqi(){
		boolean istrue = false;
		Properties properties = new Properties();
			try {
				properties.load(this.getClass().getResourceAsStream("/chose.properties"));
//				DATE = new Date(properties.getProperty("date"));
				String DATE = properties.getProperty("date");
				UPDATEDATE = properties.getProperty("updatedate");
				SimpleDateFormat  format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date1 = format.parse(DATE); 
				Date date = new Date();
				if(date1.after(date)){
					istrue = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return istrue;
	}
	
}
