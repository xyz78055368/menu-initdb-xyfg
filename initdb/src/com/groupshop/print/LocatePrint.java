package com.groupshop.print;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.Image;
//import java.awt.image.ImageObserver;
//import java.awt.image.ImageProducer;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.JOptionPane;

import com.groupshop.entity.BankInfo;

/**
 * java定位打印，把打印内容打到指定的地方。
 * 
 * @author lyb
 * 
 */
public class LocatePrint implements Printable {
	private int PAGES = 0;

	private String printStr;
	public final static Image image = Toolkit.getDefaultToolkit().getImage("C:/DBHelper/YLlogo.png");
	public  BankInfo bankInfo ;
	
	/*
	 * Graphic指明打印的图形环境；PageFormat指明打印页格式（页面大小以点为计量单位，
	 * 1点为1英寸的1/72，1英寸为25.4毫米。A4纸大致为595×842点）；page指明页号
	 */
	public int print(Graphics gp, PageFormat pf, int page)
	throws PrinterException {
		Graphics2D g2 = (Graphics2D) gp;
		g2.setPaint(Color.black); // 设置打印颜色为黑色
		if (page >= PAGES) // 当打印页号大于需要打印的总页数时，打印工作结束
			return Printable.NO_SUCH_PAGE;
		g2.translate(pf.getImageableX(), pf.getImageableY());// 转换坐标，确定打印边界
		Font font = new Font("宋体", Font.PLAIN, 10);// 创建字体
		g2.setFont(font);
		// 打印当前页文本
		//int printFontCount = printStr.length();// 打印字数
		int printFontSize = font.getSize()+4;// Font 的磅值大小
		//float printX = 80 / 2; // 给定字符点阵，X页面正中
		//float printY = 600 / 2; // 给定字符点阵，Y页面正中
		//float printMX = printX - (printFontCount * printFontSize / 2);// 打印到正中间
		//float printMY = printY - printFontSize / 2;// 打印到正中间
		//g2.drawString(printStr, 30, 60); // 具体打印每一行文本，同时走纸移位
		g2.drawImage(image, 30, 10, null);
		g2.drawString("持卡人存根(CARDHOLDER COPY)", 30, 60+printFontSize); 
		g2.drawString("-------------------------------", 30, 60+printFontSize*2);
		g2.drawString("商户名称(MFRCHANT NAME)：", 30, 60+printFontSize*3);
		g2.drawString("中电信达", 50, 60+printFontSize*4);
		g2.drawString("商户号(MER)：12345678989", 30, 60+printFontSize*5); 
		g2.drawString("终端号(TER)："+ bankInfo.getTermimalNo(), 30, 60+printFontSize*6);
		g2.drawString("-------------------------------", 30, 60+printFontSize*7);
		g2.drawString("发卡行(ISSUER)："+ bankInfo.getIssuer(), 30, 60+printFontSize*8);
		g2.drawString("收单行："+ bankInfo.getAcQuirer(), 30, 60+printFontSize*9);
		g2.drawString("卡号(CARD NO.)：", 30, 60+printFontSize*10);
		g2.drawString(bankInfo.getCardNum(), 40, 60+printFontSize*11);
		g2.drawString("交易类型(TXN TYPE)：消费", 30, 60+printFontSize*12);
		g2.drawString("批次号(BATCH NO.)："+ bankInfo.getBatchNo(), 30, 60+printFontSize*13);
		g2.drawString("授权码(AUTH CODE)："+bankInfo.getAuthCode(), 30, 60+printFontSize*14);
		g2.drawString("有效期(EXP DATE)：2014/03", 30, 60+printFontSize*15);
		g2.drawString("交易参考号："+ bankInfo.getReferNo(), 30, 60+printFontSize*16);
		g2.drawString("日期时间："+bankInfo.getDate() +" "+ bankInfo.getTime(), 30, 60+printFontSize*17);
		g2.drawString("交易金额：RMB："+ bankInfo.getAmount(), 30, 60+printFontSize*18);
		g2.drawString("操作员号(OPERATOR NO)："+bankInfo.getOperatorNo(), 30, 60+printFontSize*19);
		g2.drawString("--------------------------------", 30, 60+printFontSize*20);
		g2.drawString("备注(REFERENCE)", 30, 60+printFontSize*21);
		g2.drawString("--------------------------------", 30, 60+printFontSize*22);
		g2.drawString("持卡人签名(CARDHOLDER SIGNATURE)", 30, 60+printFontSize*23);
		g2.drawString("", 30, 60+printFontSize*24);
		g2.drawString("", 30, 60+printFontSize*25);
		g2.drawString("--------------------------------", 30, 60+printFontSize*26);
		font =  new Font("宋体",Font.ITALIC,5);
		g2.setFont(font);
		g2.drawString("本人确认以上交易同意将其记入本卡账户", 30, 60+printFontSize*27);
		//g2.drawImage(data1, 30, 60+printFontSize*28, null);
		return Printable.PAGE_EXISTS; // 存在打印页时，继续打印工作
	}

	// 打印内容到指定位置
	public void printContent() {
		printStr = "打印测试内容jslkjf\n\rklsdfjlsddjfsdlkjs\n\rlfjddlkfj\n\rlsdjk";// 获取需要打印的目标文本

		if (printStr != null && printStr.length() > 0) // 当打印内容不为空时
		{
			PAGES = 1; // 获取打印总页数
			// 指定打印输出格式
			DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;

			// 定位默认的打印服务
			PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
			// 创建打印作业
			DocPrintJob job = printService.createPrintJob();
			// 设置打印属性
			PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			// 设置纸张大小,也可以新建MediaSize类来自定义大小
			pras.add(MediaSizeName.NA_5X7);
			DocAttributeSet das = new HashDocAttributeSet();
			// 指定打印内容
			Doc doc = new SimpleDoc(this, flavor, das);
			
			// 不显示打印对话框，直接进行打印工作
			try {
				job.print(doc, pras); // 进行每一页的具体打印操作
			} catch (PrintException pe) {
				pe.printStackTrace();
			}
		} else {
			// 如果打印内容为空时，提示用户打印将取消
			JOptionPane.showConfirmDialog(null,
					"Sorry, Printer Job is Empty, Print Cancelled!",

					"Empty", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void main(String[] args) {
		LocatePrint lp = new LocatePrint();
		lp.printContent();
	}

}
