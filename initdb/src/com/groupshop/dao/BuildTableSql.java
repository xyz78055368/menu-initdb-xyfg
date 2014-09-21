package com.groupshop.dao;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildTableSql extends DataBase{
	public String make(Class classname){
		BuildTableSql bts=new BuildTableSql();
		Field fieldList[] = classname.getDeclaredFields();
		//		System.out.println(classname.getSimpleName());
		String sqlStr = "create TABLE IF NOT EXISTS "+classname.getSimpleName()+" ( ";
		for(int i =0;i<fieldList.length;i++){
			String type = bts.StrSub(fieldList[i].toString());
			if(type.equals("Int")){
				type = "integer";
			}else if(type.equals("String")||type.equals("Date")){
				type = "TEXT";
			}else if(type.equals("Double")){
				type = "NUMERIC";
			}
			String temp = fieldList[i].getName().toString() +" "+ type +",";
			sqlStr = sqlStr + temp;
		}
		sqlStr = sqlStr.substring(0,sqlStr.length()-1)+" );";
		//		System.out.println(sqlStr);
		return sqlStr;
	}

	public String StrSub(String str){
		String laststr;
		int charHAt=str.indexOf(".");
		int cutHStr=str.indexOf(".",charHAt+1);
		int charEAt=str.indexOf(" ");
		int cutEStr=str.indexOf(" ",charEAt+1); 
		String strtemp=str.substring(charEAt+1, cutEStr);

		int itempp=strtemp.indexOf(".");
		int ilast=strtemp.lastIndexOf(".");

		if(itempp==-1){
			laststr=strtemp.substring(0,1).toUpperCase()+strtemp.substring(1);
		}else{
			laststr=strtemp.substring(ilast+1);}

		return laststr;
	}


	public void creatSqlFild(String tableName,String creatsql){
		String filePath = "src/com/groupshop/sql/"+tableName+".sql";
		filePath = filePath.toString();
		File myFilePath = new File(filePath);
		if (!myFilePath.isDirectory()) {
			OutputStreamWriter osw;
			try {
				osw = new OutputStreamWriter(new FileOutputStream(filePath));
				osw.flush();
				osw.write(creatsql,0,creatsql.length());   
				osw.close();  
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

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
		for(int i=0;i<list.size();i++){
			String tableName = list.get(i).toString();
			logger.info(tableName);
			BuildTableSql bts=new BuildTableSql();
			String creatsql = "";
			if(tableName.equals("billitem")){
				creatsql = bts.make(com.groupshop.entity.Billitem.class);
			}else if(tableName.equals("bill")){
				creatsql = bts.make(com.groupshop.entity.Bill.class);
			}else if(tableName.equals("billitemstatus")){
				creatsql = bts.make(com.groupshop.entity.Billitemstatus.class);
			}else if(tableName.equals("cate")){
				creatsql = bts.make(com.groupshop.entity.Cate.class);
			}else if(tableName.equals("communication")){
				creatsql = bts.make(com.groupshop.entity.Communication.class);
			}else if(tableName.equals("dish")){
				creatsql = bts.make(com.groupshop.entity.Dish.class);
			}else if(tableName.equals("dishinpage")){
				creatsql = bts.make(com.groupshop.entity.Dishinpage.class);
			}else if(tableName.equals("dpic")){
				creatsql = bts.make(com.groupshop.entity.Dpic.class);
			}else if(tableName.equals("dtable")){
				creatsql = bts.make(com.groupshop.entity.Dtable.class);
			}else if(tableName.equals("dtablecate")){
				creatsql = bts.make(com.groupshop.entity.Dtablecate.class);
			}else if(tableName.equals("ipad_billitem")){
				creatsql = bts.make(com.groupshop.entity.Ipad_billitem.class);
			}else if(tableName.equals("method")){
				creatsql = bts.make(com.groupshop.entity.Method.class);
			}else if(tableName.equals("obj")){
				creatsql = bts.make(com.groupshop.entity.Obj.class);
			}else if(tableName.equals("opt")){
				creatsql = bts.make(com.groupshop.entity.Opt.class);
			}else if(tableName.equals("seat")){
				creatsql = bts.make(com.groupshop.entity.Seat.class);
			}else if(tableName.equals("tablebill")){
				creatsql = bts.make(com.groupshop.entity.Tablebill.class);
			}else if(tableName.equals("transdish")){
				creatsql = bts.make(com.groupshop.entity.Transdish.class);
			}else if(tableName.equals("transtable")){
				creatsql = bts.make(com.groupshop.entity.Transtable.class);
			}
			else if(tableName.equals("dtablestatus")){
				creatsql = bts.make(com.groupshop.entity.Dtablestatus.class);
			}
			bts.creatSqlFild(tableName, creatsql);

		}
	}



	public static void main(String[] args) {
		BuildTableSql bts=new BuildTableSql();
		bts.build();
	}
}
