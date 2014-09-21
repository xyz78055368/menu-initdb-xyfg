package com.groupshop.entity;

public class BankInfo {
	private String merchantName;	//商户名称
	private String merchantNo;		//商户编号
	private String termimalNo;		//终端编号
	private String operatorNo;		//操作员号
	private String issuer;			//发卡行
	private String acQuirer;		//收单行
	private String cardNum;			//卡号
	private String txnType;			//消费类型
	private String batchNo;			//批次号
	private String invoiceNo;		//查询号
	private String traceNo;			//流水号
	private String date;			//交易日期
	private String time;			//交易时间
	private String authCode;		//授权码
	private String referNo;			//参考号
	private String amount;			//金额
	private String reference;		//备注
	
	
	public String getMerchantName() {	
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getTermimalNo() {
		return termimalNo;
	}
	public void setTermimalNo(String termimalNo) {
		this.termimalNo = termimalNo;
	}
	public String getOperatorNo() {
		return operatorNo;
	}
	public void setOperatorNo(String operatorNo) {
		this.operatorNo = operatorNo;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getAcQuirer() {
		return acQuirer;
	}
	public void setAcQuirer(String acQuirer) {
		this.acQuirer = acQuirer;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getReferNo() {
		return referNo;
	}
	public void setReferNo(String referNo) {
		this.referNo = referNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
}
