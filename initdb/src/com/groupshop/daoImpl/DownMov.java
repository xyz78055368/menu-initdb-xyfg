package com.groupshop.daoImpl;

import java.sql.SQLException;

import com.groupshop.dao.DataBase;
import com.groupshop.entity.Dpic;

public class DownMov extends DataBase {
	public String getAllMovNames(){
		String movNames= "";
		String sql = "select Movname from movs ";
		try {
			conn = DataBase.startConn(conn);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String temp = rs.getString(1);
				movNames = movNames + temp + ",";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return movNames;
	}
}
