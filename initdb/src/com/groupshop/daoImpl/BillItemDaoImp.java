package com.groupshop.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.groupshop.dao.BillItemDao;
import com.groupshop.dao.DataBase;
import com.groupshop.entity.Billitem;

public class BillItemDaoImp extends DataBase implements BillItemDao {
	public List BillItemList ;
	public List billItemList;

	public String billItem(String tName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getBillItemByList(String billNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBillItemNo(String tName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	public void getBillItemList(String zwbh){
		List list = new ArrayList();
		List list1 = new ArrayList();
		String sql = "select zdbh,cmmc,cmsl,cmdj,cmje,sjje,kwbh,tmbj,wdbz,fwyh,cmbh from cyxxb.dbo.B_WDK where zwbh ='"+zwbh+"'";
		try {
			conn = this.getConn();
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				Billitem bi = new Billitem();
				bi.setBillno(rs.getString(1));
				bi.setItemname(rs.getString(2));
				bi.setItemnum(rs.getDouble(3));
				bi.setItemprice(rs.getDouble(4));
				bi.setItemtotal(rs.getDouble(5));
				bi.setItemamount(rs.getDouble(6));
				bi.setItemremark(rs.getString(7));
				bi.setOrdertime(rs.getString(8));
				bi.setWdbz(rs.getString(9));
				bi.setWaiter(rs.getString(10));
				bi.setDishid(rs.getInt(11));
				bi.setDiscount(bi.getItemtotal()-bi.getItemamount());
				bi.setTableid(Integer.parseInt(zwbh));
				list.add(bi);
			}
			rs.close();
			pstmt.close();
			for(int i = 0; i<list.size();i++){
				Billitem bi = (Billitem)list.get(i);
				String sql1="select id from yljg.dbo.billitemstatus where statusname ='"+bi.getWdbz()+"'";
				pstmt = conn.prepareStatement(sql1);
				rs = pstmt.executeQuery();
				if(rs.next()){
					bi.setStatus(rs.getInt(1));
					list1.add(bi);
				}
				rs.close();
				pstmt.close();
			}
			this.closeAll();
			conn = this.getConn();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		this.billItemList = list1;
	}


	public int billcount(String zwbh){
		this.getBillItemList(zwbh);
		int count = 0;
		count = this.billItemList.size();
		return count;
	}

	public Billitem getBillItem(String zwbh, int i){
		this.getBillItemList(zwbh);
		Billitem b = (Billitem) (this.billItemList.get(i));
		return b;
	}

	public String getInsertBillItemSql(Billitem bi) {
		String sql = "insert into billitem(billno,itemname,itemnum,itemprice,itemtotal,itemamount" +
		",discount,count,show,kitchen,itemremark,ordertime,opt,communi,tableid,status,waiter," +
		"itemspec,dishid) values " +
		"('"+bi.getBillno()+"','"+bi.getItemname()+"',"+bi.getItemnum()+","+bi.getItemprice()+","+bi.getItemtotal()
		+","+bi.getItemamount()+","+bi.getDiscount()+","+bi.getCount()+","+bi.getShow()+","+bi.getKitchen()
		+",'"+bi.getItemremark()+"','"+bi.getOrdertime().substring(0, bi.getOrdertime().length()-2)+"','"+bi.getOpt()+"',"+bi.getCommuni()+
		","+bi.getTableid()+","+bi.getStatus()+",'"+bi.getWaiter()+"','"+bi.getItemspec()+"',"+bi.getDishid()+")" ;
		String[] param = new String [0];
		this.execulQ(sql, param);
		return sql;
	}

	
	

	
	
	
	
	/**
	 * 通过桌位名称获得账单编号
	 */
//	public String getBillItemNo(String tName) {
//		String num = "";
//		try {
//			conn = this.getConn();
//			cstmt = conn.prepareCall("{call cyxxb.dbo.P_ZWXX (1,?,'')}");
//			cstmt.setString(1, tName);
//			rs = cstmt.executeQuery();
//			if(rs.next()){
//				num = rs.getString("ZDBH");
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}
//	
//	public List getBillItemByList(String tName) {
//		List list = new ArrayList();
//		try {
//			conn = this.getConn();
//			String id = "";
//			String sql = "select id from dtable where tablename = "+tName;
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()){
//				id = rs.getString(1);
//			}
//			rs.close();
//			pstmt.close();
//			cstmt = conn.prepareCall("{call cyxxb.dbo.spGenInsertSQL ('billitem',?)}");
//			cstmt.setString(1, id);
//			rs = cstmt.executeQuery();
//			while(rs.next()){
//				String bi = "";
//				bi = rs.getString(1);
//				list.add(bi);
//			}
//			rs.close();
//			cstmt.close();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			this.closeAll();
//		}
//		return list;
//	}
//	public String billItem(String tName,int i){
//		this.BillItemList = this.getBillItemByList(tName);
//		String sql = this.BillItemList.get(i).toString();
////		for(int i=0;i<this.BillItemList.size();i++){
////			String temp = (String)this.BillItemList.get(i);
////			sql = sql+temp +"\n";
////		}
//		return sql;
//	}
}
