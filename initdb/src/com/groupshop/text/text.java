package com.groupshop.text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import com.groupshop.dao.DataBase;
import com.groupshop.dao.PicDao;
import com.groupshop.dao.SqlDao;
import com.groupshop.daoImpl.PicDaoImp;
import com.groupshop.daoImpl.SqlDaoImp;

public class text extends HttpServlet implements ServletContextListener{

	/**
	 * @param args
	 */
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//			SqlDao sd = new SqlDaoImp();
//			sd.getAllDate();
//		}
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			DataBase.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method 
		try {
			DataBase.conn = new DataBase().getConn();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		SqlDao sd = new SqlDaoImp();
		sd.getTableName();
		sd.getAllDate();
		PicDao pd = new PicDaoImp();
		PicDaoImp.PICNAME = pd.getAllPicName();
	}

//	public static void main(String args[]) {
//
//		SqlDao sd = new SqlDaoImp();
////		System.out.println(sd.getAllDate());
//		
////		sd.getInsertSql(2200);
//		
//
////		try{
////			Socket socket=new Socket("127.0.0.1",11211);
////			//�򱾻���4700�˿ڷ����ͻ�����
////			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
////			//��ϵͳ��׼�����豸����BufferedReader����
////			PrintWriter os=new PrintWriter(socket.getOutputStream());
////			//��Socket����õ��������������PrintWriter����
////			BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
////			//��Socket����õ�����������������Ӧ��BufferedReader����
////			String readline;
////			readline=sin.readLine(); //��ϵͳ��׼�������һ�ַ���
////			while(!readline.equals("bye")){
////				//���ӱ�׼���������ַ���Ϊ "bye"��ֹͣѭ��
////				os.println(readline);
////				//����ϵͳ��׼���������ַ��������Server
////				os.flush();
////				//ˢ���������ʹServer�����յ����ַ���
////				System.out.println("Client:"+readline);
////				//��ϵͳ��׼����ϴ�ӡ������ַ���
////				System.out.println("Server:"+is.readLine());
////				//��Server����һ�ַ���������ӡ����׼�����
////				readline=sin.readLine(); //��ϵͳ��׼�������һ�ַ���
////			} //����ѭ��
////			os.close(); //�ر�Socket�����
////			is.close(); //�ر�Socket������
////			socket.close(); //�ر�Socket
////		}catch(Exception e) {
////			System.out.println("Error"+e); //�������ӡ������Ϣ
////		}
//	}
}
