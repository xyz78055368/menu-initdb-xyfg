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
		bi.setMerchantName(request.getParameter("MerchantName"));	//商户名称
		bi.setMerchantNo(request.getParameter("MerchantNo"));	//商户编号
		bi.setTermimalNo(request.getParameter("TermimalNo"));	//终端编号
		bi.setOperatorNo(request.getParameter("OperatorNo"));	//操作员号
		bi.setIssuer(request.getParameter("Issuer"));	//发卡行
		bi.setAcQuirer(request.getParameter("AcQuirer"));	//收单行
		bi.setCardNum(request.getParameter("CardNum"));	//卡号
		bi.setTxnType(request.getParameter("TxnType"));	//消费类型
		bi.setBatchNo(request.getParameter("BatchNo"));	//批次号
		bi.setInvoiceNo(request.getParameter("InvoiceNo"));	//查询号
		bi.setTraceNo(request.getParameter("TraceNo")); 	//流水号
		bi.setDate(request.getParameter("Date"));	//交易日期
		bi.setTime(request.getParameter("Time"));	//交易时间
		bi.setAuthCode(request.getParameter("AuthCode"));	//授权码
		bi.setReferNo(request.getParameter("ReferNo"));		//参考号
		bi.setAmount(request.getParameter("Amount"));		//金额
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
