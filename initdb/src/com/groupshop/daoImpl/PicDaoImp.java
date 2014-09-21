package com.groupshop.daoImpl;



import java.sql.SQLException;

import com.groupshop.dao.DataBase;
import com.groupshop.dao.PicDao;
import com.groupshop.entity.Dpic;

public class PicDaoImp extends DataBase implements PicDao {
	public static String PICNAME ;
	public String getAllPicName() {
		String sql = "select picname from dpic";
		String str = "";
		try {
			conn = DataBase.startConn(conn);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()){
				Dpic dp = new Dpic();
				dp.setPicname(rs.getString(1));
				str = str + dp.getPicname() + ",";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return str;
	}

}
