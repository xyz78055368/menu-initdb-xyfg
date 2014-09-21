package com.groupshop.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.channels.FileLock;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownMove extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownMove() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/octet-stream");
		String movName = request.getParameter("name");
		//PrintWriter out = response.getWriter();
		System.out.println("视频:"+movName);
		request.getRequestDispatcher("mov/"+movName).forward(request,response);
//		String fileName = "./mov/"+movName;
//		java.io.File file = new java.io.File(fileName);
//		InputStream  in = null;
//		try {
//			System.out.println(request.getPathInfo());
//            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
//            //一次读多个字节
//            byte[] tempbytes = new byte[100];
//            int byteread = 0;
//            in = new FileInputStream(fileName);
//            showAvailableBytes(in);
//            // 读入多个字节到字节数组中，byteread为一次读入的字节数
//            while ((byteread = in.read(tempbytes)) != -1) {
//                System.out.write(tempbytes, 0, byteread);
//                out.print(tempbytes);
//            }
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e1) {
//                }
//            }
//        }

	}

	private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
