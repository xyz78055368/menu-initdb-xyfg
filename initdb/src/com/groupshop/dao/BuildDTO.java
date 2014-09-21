package com.groupshop.dao;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class BuildDTO
{
	/**
	 * 创建javaBean实体类
	 * @param tableName	数据库表名
	 */
	public void build(String tableName)
	{
		Connection conn = null;
		PreparedStatement pment = null;
		ResultSet rs = null;
		PrintWriter pw = null;

		DataBase db = new DataBase();
		try
		{
			pw = new PrintWriter(new File("src/com/groupshop/entity/"+tableName.substring(0,1).toUpperCase()+tableName.substring(1)+".java"));

			pw.println("package com.groupshop.entity;\n\n");
			pw.println("import java.sql.Date;\n\n");
			pw.println("/**");
			pw.println("* 通过数据库内表的字段动态生成 javabean");
			pw.println("**/");
			pw.println("public class "+tableName.substring(0,1).toUpperCase()+tableName.substring(1)+" \n{\t");

			//创建连接
			conn = db.getConn();
			//构建预处理器
//			pment = conn.prepareStatement("select * from cyxxb.dbo."+tableName+" where 1 = 2");
			pment = conn.prepareStatement("select * from "+tableName+" where 1 = 2");

			rs = pment.executeQuery();

			ResultSetMetaData metaData = rs.getMetaData();

			//获取表单的列数
			int colum = metaData.getColumnCount();

			for (int i = 1; i <= colum; i++)
			{
				String pStr = ""; //setXxxx
				String typeStr = ""; //类型


				//获取列名
				String columName = metaData.getColumnName(i);
				//获取每一列的数据类型
				int type = metaData.getColumnType(i);

				//判断
				if(Types.INTEGER == type)
				{
					typeStr = "int";
				}
				else if(Types.VARCHAR == type||Types.CHAR == type||-1==type||Types.CHAR ==type)
				{
					typeStr = "String";
				}
				else if(Types.NUMERIC == type||Types.DECIMAL == type)
				{
					typeStr = "double";
				}
				else if(Types.TIMESTAMP == type)
				{
					typeStr = "Date";
				}else if(Types.FLOAT ==type){
					typeStr = "float";
				}
				
				
				

				//组装 private 的语句
				pStr += "private "+typeStr+" "+columName+";";

				//输出 private 的字段
				pw.println("\t"+pStr+"");

			}


			String constructStr = ""; //构造
			//组装空参构造
			constructStr += "public "+tableName.substring(0,1).toUpperCase()+tableName.substring(1)+"()\n\t{\n\n\t}";
			//输出空参构造
			pw.println("\n\t"+constructStr+"\n");

			for (int i = 1; i <= colum; i++)
			{
				String getStr = "";
				String setStr = "";
				String typeStr = "";

				//获取列名
				String columName = metaData.getColumnName(i);
				//获取每一列的数据类型
				int type = metaData.getColumnType(i);

				//判断
				if(Types.INTEGER == type)
				{
					typeStr = "int";
				}
				else if(Types.VARCHAR == type||Types.CHAR == type||type==-1||Types.CHAR ==type)
				{
					typeStr = "String";
				}
				else if(Types.NUMERIC == type||Types.DECIMAL == type)
				{
					typeStr = "double";
				}
				else if(Types.TIMESTAMP == type)
				{
					typeStr = "Date";
				}else if(Types.FLOAT ==type){
					typeStr = "float";
				}

				//组装 set 的语句
				setStr += "public void set"+columName.substring(0, 1).toUpperCase()+""+columName.substring(1)+"("+typeStr+" "+columName+")\n\t{\n";
				setStr += "\t\tthis."+columName+" = "+columName+";\n\t}";

				//组装get语句 
				getStr += "public "+typeStr+" get"+columName.substring(0,1).toUpperCase()+""+columName.substring(1)+"()\n\t{\n\t";
				getStr += "\treturn this."+columName+";\n\t}";

				//输出 set
				pw.println("\t"+setStr);
				// 输出 get
				pw.println("\t"+getStr);
			}
			pw.println("}");

			//缓冲
			pw.flush();
			pw.close();

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//关闭连接
			db.closeAll();
		}
	}
}


