package com.groupshop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Build extends DataBase{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Build b = new Build();
		b.build();
//		BuildDTO dto = new BuildDTO();
//		dto.build("b_wdk");
	}

	/**
	 * 自动生成JAVABEAN实体类
	 */
	public void build(){
		String sql = "select name from sysobjects where type='U'";
		BuildDTO dto = new BuildDTO();
		List list = new ArrayList();
		try {
			this.conn = this.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String tname = rs.getString(1);
				if(!tname.equals("dtproperties")){
					list.add(tname);
				}
			}
			this.closeAll();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i<list.size();i++){
			String tname = (String)list.get(i);
			System.out.println(tname);
			dto.build(tname);
		}
	}
}
