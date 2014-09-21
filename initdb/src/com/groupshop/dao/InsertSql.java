package com.groupshop.dao;


import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

public class InsertSql extends DataBase {

	/**
	 * @param args
	 */
	//	public static void main(String[] args) {
	//		// TODO Auto-generated method stub
	//		InsertSql i = new InsertSql();
	//		i.insert("dish");
	//	}
	public InsertSql(){
	}
	public String path;

	public String[] strings;
	public int i ;


	public int insert( Document doc, Element root, String tablename,int j ,List strings){
		if(tablename.equals("dishhits")||tablename.equals("bill")||tablename.equals("dcbillitem")||tablename.equals("tablebill")||tablename.equals("billitem")||tablename.equals("obj_copy")||tablename.equals("dish_copy")){
			return j;
		}
		String billNo = "";
		try {
			cstmt = conn.prepareCall("{call spgeninsertsql(?,?)}");
			cstmt.setString(1,tablename);
			cstmt.setString(2, "");
			rs = cstmt.executeQuery();
			while(rs.next()){
				billNo = rs.getString(1);
				logger.debug(billNo);
				strings.add(billNo) ;
				j++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return j;
	}


	public int creatDel(Document doc, Element root, String tablename ,int j,List strings) {
		if(tablename.equals("billitem")||tablename.equals("obj_copy")||tablename.equals("dish_copy")){
			return j;
		}
		String insertsql = "delete from " + tablename;
		strings.add(insertsql);
		logger.debug(" ¶ÁÈ¡É¾³ý"+tablename+"Êý¾ÝÓï¾ä");
		j++;
		return j;
	}
}
