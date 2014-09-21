package com.groupshop.daoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.groupshop.dao.CreatTableDao;
import com.groupshop.dao.SqlDao;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CreatTableDaoImp implements CreatTableDao {
	Logger logger = Logger.getLogger(CreatTableDaoImp.class.getName());
	public String getCreatTableSql(int i) {
		String createSql = "";
		String tname = "";
		try {
			if(i< SqlDaoImp.TABLENAME.size()){
				String name = SqlDaoImp.TABLENAME.get(i).toString();
				createSql = this.getDropSqlStr(name);
			}else {
				i = i - SqlDaoImp.TABLENAME.size();
				String name = SqlDaoImp.TABLENAME.get(i).toString();
				createSql = this.getCreatSqlStr(name);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return createSql;
	}

	/**
	 * 获得数据库表 的个数
	 */
	public int getTableCount() {
		int num = 0;
		num = SqlDaoImp.TABLENAME.size()*2;
//		List list = sd.getTableName();
		logger.debug(num);
		return num;
	}
	
	
	
	public String getCreatSqlStr(String tname) throws IOException {
		String Str = "";
		BufferedReader br = null;
		String path = CreatTableDaoImp.class.getResource("").toString();
		path = path.replace("%20", " ");
//		System.out.println(path);
		path = path.substring(6, path.lastIndexOf("/daoImpl/"));
//		System.out.println(path);
		try {
			br = new BufferedReader(new FileReader(new File(path + "/sql/"+ tname +".sql")));
			String temp = br.readLine();
			while (temp != null) {
				Str += temp;
				temp = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			br.close();
		}
		return Str;
	}

		public String getDropSqlStr(String tname) throws IOException {
			String Str = "";
			BufferedReader br = null;
			String path = CreatTableDaoImp.class.getResource("").toString();
			path = path.replace("%20", " ");
//			System.out.println(path);
			path = path.substring(6, path.lastIndexOf("/daoImpl/"));
//			System.out.println(path);
			try {
				br = new BufferedReader(new FileReader(new File(path + "/sql/drop"+ tname +".sql")));
				String temp = br.readLine();
				while (temp != null) {
					Str += temp;
					temp = br.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally{
				br.close();
			}
			return Str;
		}
}
