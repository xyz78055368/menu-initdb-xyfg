package com.groupshop.daoImpl;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.groupshop.dao.BuildDTO;
import com.groupshop.dao.DataBase;
import com.groupshop.dao.InsertSql;
import com.groupshop.dao.SqlDao;
import com.groupshop.entity.Billitem;
import com.groupshop.entity.Cate;
import com.groupshop.text.InsertTableText;

public  class SqlDaoImp extends DataBase implements SqlDao {

	public static String[] SqlStrings;
	public SqlDaoImp(){

	}
	public Element eltStu;
	//	public Document doc;
	public Element text;
	public Document doc;
	public Element root;

	Logger logger = Logger.getLogger(SqlDaoImp.class.getName());
	String path ;
	/**
	 * 得到所有表中的insert语句
	 */
	public int getAllDate() {
		InsertTableText.getAllInsert = new ArrayList();
		List tnames = this.getTableName();
		InsertSql is = new InsertSql();
		int j = 0;
		for(int i = 0; i<tnames.size();i++){
			String tablename = tnames.get(i).toString();
			j = is.creatDel(doc, root, tablename,j,InsertTableText.getAllInsert);
			j = is.insert(doc, root,  tablename,j,InsertTableText.getAllInsert);
		}
		this.closeAll();
		return j;	
	}





	public int getAllDate(double i){
		int j = 0;
		String str = "";
		logger.debug(str + "**"+InsertTableText.getAllInsert.size());
		j = InsertTableText.getAllInsert.size();
		return j;
	}




	public static List TABLENAME;
	/**
	 * 得到数据库的表名
	 */
	public List getTableName() {
		TABLENAME = new ArrayList();
		String sql = "select name from sysobjects where type='U'";
		try {
			conn = DataBase.startConn(conn);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String tname = rs.getString(1);
				if(!tname.equals("communication")&&!tname.equals("tablereserve")&&!tname.equals("B_HZK")&&!tname.equals("dpic_copy")&&!tname.equals("obj_copy")&&!tname.equals("billserial")&&!tname.equals("transbill")&&!tname.equals("machineudid")&&!tname.equals("dtproperties")&&!tname.equals("transtable")&&!tname.equals("transdish")&&!tname.equals("dpic")&&!tname.equals("dishinpage")&&!tname.equals("setmealdish")&&!tname.equals("setmeal")){
					logger.debug(tname);
					TABLENAME.add(tname);
				}
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return TABLENAME;
	}

	public String getInsertSql(int i) {
		String str = "";
		SAXReader reader = new SAXReader();
		try{
			String path = SqlDaoImp.class.getResource("").toString();
			path = path.replace("%20", " ");
			path = path.substring(6, path.lastIndexOf("/daoImpl/"));
			Document  doc = reader.read(new File(path+"/sql/all.xml"));
			Element database = (Element)doc.selectSingleNode("//options[@no='"+i+"']");   
			//			List list = database.elements(); 
			Element el = (Element)database.element("text");
			str = el.getText();
			logger.debug(i+ "*"+ str);
		}
		catch(Exception ex){
			//			ex.printStackTrace();
			logger.debug("500 "+ str +"数据读取失败");
		}
		return str;
	}





	public Billitem getBillItem(String zwbh, int i){

		String sql = "select top 1 b.id as tableid,zdbh,cmmc,cmsl,cmdj,cmje,sjje,kwbh,tmbj,wdbz,fwyh,cmbh,RWID,dwbh from cyxxb.dbo.B_WDK as a left join yljg.dbo.dtable as b on a.zwbh = b.tablename where a.zwbh = '"+zwbh+"' and a.rwid not in (select top "+i+" rwid from cyxxb.dbo.B_WDK where zwbh= '"+zwbh+"' order by rwid) order by rwid";
		Billitem bi = new Billitem();
		try {
			conn = this.getConn();
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				bi.setTableid(rs.getInt("tableid"));
				bi.setBillno(rs.getString("zdbh"));
				bi.setItemname(rs.getString("cmmc"));
				bi.setItemnum(rs.getDouble("cmsl"));
				bi.setItemprice(rs.getDouble("cmdj"));
				bi.setItemtotal(rs.getDouble("cmje"));
				bi.setItemamount(rs.getDouble("sjje"));
				bi.setItemremark(rs.getString("kwbh"));
				bi.setOrdertime(rs.getString("tmbj"));
				bi.setWdbz(rs.getString("wdbz"));
				bi.setWaiter(rs.getString("fwyh"));
				bi.setDishid(rs.getInt("cmbh"));
				bi.setId(rs.getInt("RWID"));
				bi.setItemspec(rs.getString("dwbh"));
				bi.setDiscount(bi.getItemtotal()-bi.getItemamount());
			}
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bi;


		//		this.getBillItemList(zwbh);
		//		Billitem b = (Billitem) (this.billItemList.get(i));
		//		return b;
	}

	public static List<Billitem> billItemList;

	public List getBillItemList(String zwmc){
		billItemList = new ArrayList<Billitem>();
		List<Billitem> list = new ArrayList<Billitem>();
		List list1 = new ArrayList();
		String sql="";
		String zwbh = "";
		try {
			sql = "select b.zwmc from dtable AS a LEFT JOIN transtable AS b on b.ipadbh = a.id where a.id = ?";
			pstmt  = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(zwmc));
			rs = pstmt.executeQuery();
			while(rs.next()){
				zwbh = rs.getString(1);
			}
			rs.close();
			pstmt.close();
			sql = "select b.id, zdbh,cmmc,cmsl,cmdj,cmje,sjje,kwbh,tmbj,wdbz,fwyh,cmbh,RWID,dwbh from "+DataBase.POSNAME+".dbo.B_WDK as a left join "+DataBase.MENAME+".dbo.dtable as b on a.zwbh = b.tablename where a.zwbh =?";

			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, zwbh);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Billitem bi = new Billitem();
				bi.setTableid(rs.getInt(1));
				bi.setBillno(rs.getString(2));
				bi.setItemname(rs.getString(3));
				bi.setItemnum(rs.getDouble(4));
				bi.setItemprice(rs.getDouble(5));
				bi.setItemtotal(rs.getDouble(6));
				bi.setItemamount(rs.getDouble(7));
				bi.setItemremark(rs.getString(8));
				bi.setOrdertime(rs.getString(9));
				bi.setWdbz(rs.getString(10));
				bi.setWaiter(rs.getString(11));
				bi.setDishid(rs.getInt(12));
				bi.setId(rs.getInt(13));
				bi.setItemspec(rs.getString(14));
				bi.setDiscount(bi.getItemtotal()-bi.getItemamount());
				list.add(bi);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			logger.error("数据库语句执行失败！"+sql);
		}
		
		return billItemList = list;
	}

	public String getInsertBillItemSql(Billitem bi,String zwmc) {
		String sql = "";
//		if(bi==null){
//			sql = "select * from "+POSNAME+".dbo.b_zwk where zwbh = ?";
//			pstmt  = conn.prepareStatement(sql);
//			pstmt.setString(1, zwbh);
//			rs = pstmt.executeQuery();
//			String billNo= "";
//			if(rs.next()){
//				billNo = rs.getString(1);
//			}
//			rs.close();
//			pstmt.close();
//			if(billNo!=""){
//				sql = "DELETE from B_WDK where ZDBH = '"+billNo+"'";
//			}
//		}
		try {
			sql = "insert into billitem(billno,itemname,itemnum,itemprice,itemtotal,itemamount" +
			",discount,count,show,kitchen,itemremark,ordertime,opt,communi,status,waiter," +
			"itemspec,dishid) values " +
			"("+bi.getBillno()+",'"+bi.getItemname()+"',"+bi.getItemnum()+","+bi.getItemprice()+","+bi.getItemtotal()
			+","+bi.getItemamount()+","+bi.getDiscount()+","+bi.getCount()+","+bi.getShow()+","+bi.getKitchen()
			+",'"+bi.getItemremark()+"','"+bi.getOrdertime().substring(0, bi.getOrdertime().length()-2)+"',"+bi.getOpt()+","+bi.getCommuni()+
			","+bi.getStatus()+",'"+bi.getWaiter()+"','"+bi.getItemspec()+"',"+bi.getDishid()+")" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			int billno = Integer.parseInt(bi.getBillno());
			sql = "insert into billitem(id,uid,billno,itemname,itemnum,itemprice,itemtotal,itemamount" +
			",discount,count,show,kitchen,itemremark,ordertime,opt,communi,status,waiter," +
			"itemspec,dishid,mac_id) values " +
			"("+bi.getId()+","+bi.getId()+","+billno+",'"+bi.getItemname()+"',"+bi.getItemnum()+","+bi.getItemprice()+","+bi.getItemtotal()
			+","+bi.getItemamount()+","+bi.getDiscount()+","+bi.getCount()+","+bi.getShow()+","+bi.getKitchen()
			+",'"+bi.getItemremark()+"','"+bi.getOrdertime().substring(0, bi.getOrdertime().length()-2)+"',1,"+bi.getCommuni()+
			","+bi.getStatus()+",'"+bi.getWaiter()+"','"+bi.getItemspec()+"',"+bi.getDishid()+",2)" ;
			logger.debug(sql);
		} catch (Exception e) {
			logger.error("数据库语句执行失败！SQL："+sql);
		}
		return sql;
	}





	public int billcount(String zwbh){
		logger.debug("桌位名称："+zwbh);
		int count = 0 ;
		count = this.getBillItemList(zwbh).size();
		logger.debug(" 数据总个数：*"+ count);
		return count;
	}


	public int getDishIdByCmbh(int Cmbh){
		int dishid=0;
		String sql2 = "select a.id from dish as a left join transdish as b on a.dishbh = b.dishbh where b.cmbh = ?";
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, Cmbh);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dishid = rs.getInt(1);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dishid;
	}

	public int getTableIdByZwmc(String zwmc){
		int tableid=0;
		String sql2 = "select a.id from dish as a left join transdish as b on a.dishbh = b.dishbh where b.cmbh = ?";
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, zwmc);
			rs = pstmt.executeQuery();
			if(rs.next()){
				tableid = rs.getInt(1);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tableid;
	}




	/*
	 * 点击率中获取菜类(non-Javadoc)
	 * @see com.groupshop.dao.SqlDao#getAllCate()
	 */
	public List<Cate> getAllCate() {
		// TODO Auto-generated method stub
		List<Cate> lst = new ArrayList<Cate>();
		return lst;
	}
}
