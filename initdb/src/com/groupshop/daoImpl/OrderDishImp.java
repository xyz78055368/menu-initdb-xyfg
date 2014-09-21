package com.groupshop.daoImpl;


import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.groupshop.dao.BillItemDao;
import com.groupshop.dao.DataBase;
import com.groupshop.dao.OrderDish;
import com.groupshop.entity.B_wdk;
import com.groupshop.entity.Billitem;

public class OrderDishImp extends DataBase implements OrderDish {

	Logger logger = Logger.getLogger(OrderDishImp.class.getName());
	
	public String orderDish(B_wdk bwdk,int xfks) {
		String ZWMC = bwdk.getZWBH();
		String CMBH = bwdk.getCMBH();
		String CMFH = "0";
		double CMDJ = 0;
		double CMSL = bwdk.getCMSL();
		String KWBH = bwdk.getKWBH();
		String ZFBH = "";
		String TMBJ = bwdk.getTMBJ();
		String FWYH = bwdk.getFWYH();
		//int XFKS = 1;
		int XFKS = xfks;
		double FZSL = bwdk.getFZSL();
		double FZJE = bwdk.getFZJE();
		if(isAllreadyOrdered(ZWMC, CMBH, CMSL, TMBJ)){
			return "OK;菜品编号"+ CMBH +"已经点过";
		}
		if (checkSaleOver(CMBH)) {
			return "OK;菜品："+bwdk.getCMMC()+"已沽清";
		}
		if(KWBH==null){
			KWBH="";
		}
		if(CMFH==null){
			CMFH="0";
		}
		if(ZFBH==null){
			ZFBH="";
		}


				String yhtcbh="";
				double dcjc=-1;
				Date tctmbj= new Date(System.currentTimeMillis());
				if(yhtcbh==null){
					yhtcbh="";
				}

		String info = "";
			try {
//				conn = DataBase.startConn(conn);
//				String sql = "select CMDJ from "+DataBase.POSNAME+".dbo.B_CMK where CMBH = '"+CMBH +"'";
////			conn = this.getConn();
//				pstmt = conn.prepareStatement(sql);
//				rs= pstmt.executeQuery();
//				if(rs.next()){
//					CMDJ = rs.getDouble(1);
////					CMMC = rs.getString(2);
//				}
//				rs.close();
//				pstmt.close();
				CMDJ = bwdk.getCMDJ();
				//cstmt = conn.prepareCall("{call cyxxb.dbo.P_CMXZ(?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt = conn.prepareCall(" {? = call "+DataBase.POSNAME+".dbo.P_CMXZ4Ipad(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				//cstmt = conn.prepareCall("{call "+DataBase.POSNAME+".dbo.P_CMXZ(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.registerOutParameter(1,Types.INTEGER);				
				cstmt.setString(2,ZWMC);
				cstmt.setString(3,CMBH);
				cstmt.setString(4,CMFH);
				cstmt.setDouble(5,CMDJ);
				cstmt.setDouble(6,CMSL);
				cstmt.setString(7,KWBH);
				cstmt.setString(8,ZFBH);
				cstmt.setString(9,  TMBJ);
				cstmt.setString(10,FWYH);
				cstmt.setInt(11, XFKS);
				cstmt.setDouble(12, FZSL);
				cstmt.setDouble(13, FZJE);
//				cstmt.setDouble(11, 1);
//				cstmt.setDouble(12, 32);
				cstmt.setDouble(14, dcjc);
				cstmt.setString(15, yhtcbh);
				cstmt.setDate(16,  tctmbj);
				
				
				cstmt.execute();
				int res = cstmt.getInt(1);
				//System.out.println("CSTMT的值是："+ cstmt.getInt(1));
				//cstmt.executeUpdate();
				logger.info("CSTMT的值是："+ cstmt.getInt(1));
				cstmt.close();
				if(res==0){
					info = "OK;";
				}else{
					info="OK;"+bwdk.getCMMC()+ "点菜失败";
				}
				cstmt = conn.prepareCall(" {? = call "+DataBase.POSNAME+".dbo.P_CALMONEY(?)}");
				cstmt.registerOutParameter(1,Types.INTEGER);				
				cstmt.setString(2,ZWMC);
				cstmt.execute();
				res = cstmt.getInt(1);
				cstmt.close();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				info = "Error;"+ e.getMessage(); 
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		return info;
	}

	private boolean isAllreadyOrdered(String zwmc,String cmbh,double cmsl,String sjbj){
		boolean isTrue = false;
		String sql = "select * from "+POSNAME+".dbo.b_wdk where zwbh = ? and cmbh = ? and cmsl = ? and tmbj = ?";
		try {
			conn = startConn(conn);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zwmc);
			pstmt.setString(2, cmbh);
			pstmt.setDouble(3, cmsl);
			pstmt.setString(4, sjbj);
			rs = pstmt.executeQuery();
			if(rs.next()){
				isTrue = true;
			}
			this.closeAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isTrue;
	}

	public static boolean isDateEquals(String date1,String date2){  
		try{  
			DateFormat df = DateFormat.getDateTimeInstance();
			return df.parse(date1).equals(df.parseObject(date2));
		} catch (ParseException e) {
			e.getMessage();
			return false;  
		}catch(Exception e){  
			e.printStackTrace();
			return false;
		}  
	}


	public String findDate(String zwmc,String cmbh){
		String date="";
		String sql = "select TMBJ from "+DataBase.POSNAME+".dbo.b_wdk where zwbh = ? and cmbh = ?";
		try {
			conn = startConn(conn);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zwmc);
			pstmt.setString(2, cmbh);
			rs = pstmt.executeQuery();
			if(rs.next()){
				date = rs.getString("TMBJ");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
	}


	public String getCmbhByDishId(int dishid) {
//		String sql = "select b.cmbh from dish as a left join transdish as b on a.dishbh=b.dishbh where a.id=?";
		String sql = "select cmbh from transdish where dishbh = ?";
		String cmbh = "";
		try {
			conn = DataBase.startConn(conn);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dishid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cmbh = rs.getString(1);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cmbh;
	}


	public String getZwmcByTableId(int tableId) {
//		String sql = "select a.tablename from dtable as a left join transtable as b on a.tableno =b.ipadtableid where a.id= ?";
		String sql = "select a.zwmc from transtable as a left join dtable as b on a.ipadbh = b.id where b.id = ?";
		String zwmc = "";
		try {
			conn = DataBase.startConn(conn);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tableId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				zwmc = rs.getString(1);
			}
			
			
			rs.close();
			pstmt.close();
			zwmc = OrderDishImp.addStringLength(zwmc, " ", 10);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zwmc;
	}

	public static String addStringLength(String str,String addStr,int lenth){
		int k = 0;
		k = str.getBytes().length;
		for(int i=k;i<lenth;i++){
			str = str + addStr;
			if(str.getBytes().length==lenth) break;
		}
		return str;
	}
	
	public boolean checkSaleOver(String dishNo) {
		String sql = "select count(*) from "+ DataBase.POSNAME+".dbo.b_gqk where cmbh="+dishNo+" and GQSL=0";
		conn = DataBase.startConn(conn);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count  = rs.getInt(1);
				closeAll();
				return count>0?true:false;
			}
		} catch (SQLException e) {
			
		}
		return false;
	}
}
