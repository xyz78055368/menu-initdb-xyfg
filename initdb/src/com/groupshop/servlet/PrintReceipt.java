package com.groupshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupshop.entity.BankInfo;
import com.groupshop.print.LocatePrint;

public class PrintReceipt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PrintReceipt() {
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

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		LocatePrint lp = new LocatePrint();
		BankInfo bi = new BankInfo();
		bi.setMerchantName(request.getParameter("MerchantName"));	//�̻�����
		bi.setMerchantNo(request.getParameter("MerchantNo"));	//�̻����
		bi.setTermimalNo(request.getParameter("TermimalNo"));	//�ն˱��
		bi.setOperatorNo(request.getParameter("OperatorNo"));	//����Ա��
		bi.setIssuer(request.getParameter("Issuer"));	//������
		bi.setAcQuirer(request.getParameter("AcQuirer"));	//�յ���
		bi.setCardNum(request.getParameter("CardNum"));	//����
		bi.setTxnType(request.getParameter("TxnType"));	//��������
		bi.setBatchNo(request.getParameter("BatchNo"));	//���κ�
		bi.setInvoiceNo(request.getParameter("InvoiceNo"));	//��ѯ��
		bi.setTraceNo(request.getParameter("TraceNo")); 	//��ˮ��
		bi.setDate(request.getParameter("Date"));	//��������
		bi.setTime(request.getParameter("Time"));	//����ʱ��
		bi.setAuthCode(request.getParameter("AuthCode"));	//��Ȩ��
		bi.setReferNo(request.getParameter("ReferNo"));		//�ο���
		bi.setAmount(request.getParameter("Amount"));		//���
		lp.bankInfo = bi;
		lp.printContent();
		request.getRequestDispatcher("PrintTest.html").forward(request,response);
		out.flush();
		out.close();
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
