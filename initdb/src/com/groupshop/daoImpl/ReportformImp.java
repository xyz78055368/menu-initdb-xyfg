package com.groupshop.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.groupshop.dao.DataBase;
import com.groupshop.dao.IReportform;
import com.groupshop.entity.DishHitsbb;
import com.groupshop.entity.Dishhits;

public class ReportformImp extends DataBase implements IReportform {

	public List<DishHitsbb> getDishHitsCatebbList() {
		
		
		List<DishHitsbb> dhbl = new ArrayList<DishHitsbb>();

		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append(" c.id,c.catename,'', 0, '',count(itemnum), count(a.time) ");
		sb.append(" from dishhits as a ");
		sb.append(" left join dish as b on a.dishid=b.id");
		sb.append(" left join cate as c on b.upper=c.id");
		sb.append(" left join billitem as d on d.dishid = b.id");
		sb.append(" where 1=1");
//		sb.append(" and catename = ?");
		sb.append(" group by c.id,c.catename");
		sb.append(" union");
		sb.append(" select");
		sb.append(" c.id,c.catename,dname, price, spec,count(itemnum), count(a.time)");
		sb.append(" from dishhits as a");
		sb.append(" left join dish as b on a.dishid=b.id");
		sb.append(" left join cate as c on b.upper=c.id");
		sb.append(" left join billitem as d on d.dishid = b.id");
		sb.append(" where 1=1");
	//	sb.append(" and catename = ?");
		sb.append(" group by c.id,c.catename,dname, price, spec");
		sb.append(" order by  c.id, count(a.time) desc");
		String sql = sb.toString();
		System.out.println(sql);

		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while(rs.next()){
				//c.id,c.catename,'', 0, '', count(a.time)
				DishHitsbb dh = new DishHitsbb();
				dh.setCateName(rs.getString(2));
				dh.setDishName(rs.getString(3));
				dh.setPrice(rs.getDouble(4));
				dh.setSpec(rs.getString(5));
				dh.setOrederNum(rs.getDouble(6));
				dh.setInPicNum(rs.getDouble(7));
				dhbl.add(dh);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dhbl;
	}

	public List<DishHitsbb> getDishHitsbbList() {
		List<DishHitsbb> dhbl = new ArrayList<DishHitsbb>();

		StringBuilder sb = new StringBuilder();
//		sb.append(" select ");
//		sb.append(" dname, price, spec, count(a.time)");
//		sb.append(" from dishhits as a ");
//		sb.append(" left join dish as b on a.dishid=b.id");
//		sb.append(" left join cate as c on b.upper=c.id");
//		sb.append(" where 1=1");
//		sb.append(" group by dname, price, spec");
//		sb.append(" union");
		sb.append(" select ");
		sb.append(" dname, price, spec, count(a.time)");
		sb.append(" from dishhits as a");
		sb.append(" left join dish as b on a.dishid=b.id");
		sb.append(" left join cate as c on b.upper=c.id");
		sb.append(" where 1=1");
		sb.append(" group by dname, price, spec");
		sb.append(" order by count(a.time) desc");
		String sql = sb.toString();
System.out.println(sql);
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				//dname, price, spec, count(a.time)
				DishHitsbb dh = new DishHitsbb();
				dh.setDishName(rs.getString(1));
				dh.setPrice(rs.getDouble(2));
				dh.setSpec(rs.getString(3));
				dh.setInPicNum(rs.getDouble(4));
				dhbl.add(dh);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dhbl;
	}

	public List<DishHitsbb> getDianJiLv() {
		List<DishHitsbb> dhbl = new ArrayList<DishHitsbb>();

		StringBuilder sb = new StringBuilder();
		sb.append("select");
		sb.append("c.id,c.catename,'', 0, '', count(a.time) ,sum(d.itemnum) ");
		sb.append(" from dishhits as a ");
		sb.append(" left join dish as b on a.dishid=b.id");
		sb.append(" left join cate as c on b.upper=c.id");
		sb.append(" LEFT JOIN billitem as d on d.dishid = b.id ");
		sb.append(" where 1=1");
		sb.append(" group by c.id,c.catename");
		sb.append(" union");
		sb.append(" select");
		sb.append(" c.id,c.catename,'', 0, '', count(a.time) ,sum(d.itemnum)");
		sb.append(" from dishhits as a");
		sb.append(" left join dish as b on a.dishid=b.id");
		sb.append(" left join cate as c on b.upper=c.id");
		sb.append(" LEFT JOIN billitem as d on d.dishid = b.id ");
		sb.append(" where 1=1");
		sb.append(" group by c.id,c.catename,dname, price, spec");
		sb.append(" order by  c.id,count(a.time) desc");
		String sql = sb.toString();

		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				//c.id,c.catename,'', 0, '', count(a.time)
				DishHitsbb dh = new DishHitsbb();

				dh.setCateName(rs.getString(2));
				dh.setDishName(rs.getString(3));
				dh.setPrice(rs.getDouble(4));
				dh.setSpec(rs.getString(5));
				dh.setInPicNum(rs.getDouble(6));
				dhbl.add(dh);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dhbl;
	}
	
	public String updateHits(Dishhits dh){
		String mes = "";
		StringBuilder sb = new StringBuilder();
		sb.append("insert into ");
		sb.append(" dishhits");
		sb.append(" ( machineno,tableid,dishid,time)");
		sb.append(" values (?,?,?,?)");
			String[] param = new String[] {
				dh.getMachineno(),
				dh.getTableid()+"",
				dh.getDishid()+"",
				dh.getTime()+""
			};
		int n =  this.execulQ(sb.toString(), param);
		if(n>0){
			mes = "OK";
		}
		return mes;
	}
	

}
