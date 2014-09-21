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
	 * ����javaBeanʵ����
	 * @param tableName	���ݿ����
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
			pw.println("* ͨ�����ݿ��ڱ���ֶζ�̬���� javabean");
			pw.println("**/");
			pw.println("public class "+tableName.substring(0,1).toUpperCase()+tableName.substring(1)+" \n{\t");

			//��������
			conn = db.getConn();
			//����Ԥ������
//			pment = conn.prepareStatement("select * from cyxxb.dbo."+tableName+" where 1 = 2");
			pment = conn.prepareStatement("select * from "+tableName+" where 1 = 2");

			rs = pment.executeQuery();

			ResultSetMetaData metaData = rs.getMetaData();

			//��ȡ��������
			int colum = metaData.getColumnCount();

			for (int i = 1; i <= colum; i++)
			{
				String pStr = ""; //setXxxx
				String typeStr = ""; //����


				//��ȡ����
				String columName = metaData.getColumnName(i);
				//��ȡÿһ�е���������
				int type = metaData.getColumnType(i);

				//�ж�
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
				
				
				

				//��װ private �����
				pStr += "private "+typeStr+" "+columName+";";

				//��� private ���ֶ�
				pw.println("\t"+pStr+"");

			}


			String constructStr = ""; //����
			//��װ�ղι���
			constructStr += "public "+tableName.substring(0,1).toUpperCase()+tableName.substring(1)+"()\n\t{\n\n\t}";
			//����ղι���
			pw.println("\n\t"+constructStr+"\n");

			for (int i = 1; i <= colum; i++)
			{
				String getStr = "";
				String setStr = "";
				String typeStr = "";

				//��ȡ����
				String columName = metaData.getColumnName(i);
				//��ȡÿһ�е���������
				int type = metaData.getColumnType(i);

				//�ж�
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

				//��װ set �����
				setStr += "public void set"+columName.substring(0, 1).toUpperCase()+""+columName.substring(1)+"("+typeStr+" "+columName+")\n\t{\n";
				setStr += "\t\tthis."+columName+" = "+columName+";\n\t}";

				//��װget��� 
				getStr += "public "+typeStr+" get"+columName.substring(0,1).toUpperCase()+""+columName.substring(1)+"()\n\t{\n\t";
				getStr += "\treturn this."+columName+";\n\t}";

				//��� set
				pw.println("\t"+setStr);
				// ��� get
				pw.println("\t"+getStr);
			}
			pw.println("}");

			//����
			pw.flush();
			pw.close();

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//�ر�����
			db.closeAll();
		}
	}
}


