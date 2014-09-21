package com.groupshop.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.groupshop.dao.BillDao;
import com.groupshop.dao.DataBase;
import com.groupshop.entity.Billitem;
import com.groupshop.entity.Tablebill;

public class BillDaoImp extends DataBase implements BillDao {
	public static List<String> SQLSTR;
	Logger logger = Logger.getLogger(BillDaoImp.class.getName());
	public int UpdateDtable() {
		try {
			this.getSqlTableBill(getTableBill());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SQLSTR.size();
	}
	private List<Tablebill> getTableBill(){
		List<Tablebill> list = new ArrayList<Tablebill>();
		String sql = "select a.ZDBH,a.xfks,a.ZWBH,a.DQJE,a.KZSJ,b.ipadbh ,c.id,c.tableno from "+DataBase.POSNAME+".dbo.B_ZWK as a left join "+DataBase.MENAME+".dbo.transtable as b on a.ZWMC = b.ZWMC left join "+DataBase.MENAME+".dbo.dtable as c on b.ipadbh = c.id where len(a.ZDBH) >1";
		try {
			conn = DataBase.startConn(conn);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			laudsfdfsdfsdyer:
			while(rs.next()){
				Tablebill tb = new Tablebill();
				try{
					tb.setTableid(rs.getInt("id"));
				}catch(Exception e){
					e.printStackTrace();
					break laudsfdfsdfsdyer;
				}
				tb.setTableno(rs.getString("tableno"));
				tb.setSerBillno(rs.getString("ZDBH"));
				tb.setSerTableno(rs.getString("ZWBH"));
				tb.setAmount(rs.getDouble("DQJE"));
				tb.setStarttime(rs.getString("KZSJ"));
				tb.setDinningpeople(rs.getInt("xfks"));
				list.add(tb);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	private void getSqlTableBill(List<Tablebill> list) throws SQLException{
		SQLSTR = new ArrayList<String>();
		String sql = "delete from tablebill";
		conn = DataBase.startConn(conn);
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.clearParameters();
		SQLSTR.add(sql);
		sql = "delete from bill";
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.clearParameters();
		SQLSTR.add(sql);
		for(int i=0;i<list.size();i++){
			Tablebill tb = list.get(i);
			sql = "insert into tablebill(billno,mac_id,tableid,seatid) values ("+tb.getSerBillno()+",'01',"+tb.getTableid()+",0)";
			SQLSTR.add(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.clearParameters();
			sql = "insert into bill(billno,mac_id,total,amount,starttime,opt,dinningpeople) values ("+tb.getSerBillno()+",'01',"+tb.getAmount()+","+tb.getAmount()+",'"+tb.getStarttime()+"',01,"+tb.getDinningpeople()+")";
			SQLSTR.add(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.clearParameters();
		}
	}
}
