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
 * java��λ��ӡ���Ѵ�ӡ���ݴ�ָ���ĵط���
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
	 * Graphicָ����ӡ��ͼ�λ�����PageFormatָ����ӡҳ��ʽ��ҳ���С�Ե�Ϊ������λ��
	 * 1��Ϊ1Ӣ���1/72��1Ӣ��Ϊ25.4���ס�A4ֽ����Ϊ595��842�㣩��pageָ��ҳ��
	 */
	public int print(Graphics gp, PageFormat pf, int page)
	throws PrinterException {
		Graphics2D g2 = (Graphics2D) gp;
		g2.setPaint(Color.black); // ���ô�ӡ��ɫΪ��ɫ
		if (page >= PAGES) // ����ӡҳ�Ŵ�����Ҫ��ӡ����ҳ��ʱ����ӡ��������
			return Printable.NO_SUCH_PAGE;
		g2.translate(pf.getImageableX(), pf.getImageableY());// ת�����꣬ȷ����ӡ�߽�
		Font font = new Font("����", Font.PLAIN, 10);// ��������
		g2.setFont(font);
		// ��ӡ��ǰҳ�ı�
		//int printFontCount = printStr.length();// ��ӡ����
		int printFontSize = font.getSize()+4;// Font �İ�ֵ��С
		//float printX = 80 / 2; // �����ַ�����Xҳ������
		//float printY = 600 / 2; // �����ַ�����Yҳ������
		//float printMX = printX - (printFontCount * printFontSize / 2);// ��ӡ�����м�
		//float printMY = printY - printFontSize / 2;// ��ӡ�����м�
		//g2.drawString(printStr, 30, 60); // �����ӡÿһ���ı���ͬʱ��ֽ��λ
		g2.drawImage(image, 30, 10, null);
		g2.drawString("�ֿ��˴��(CARDHOLDER COPY)", 30, 60+printFontSize); 
		g2.drawString("-------------------------------", 30, 60+printFontSize*2);
		g2.drawString("�̻�����(MFRCHANT NAME)��", 30, 60+printFontSize*3);
		g2.drawString("�е��Ŵ�", 50, 60+printFontSize*4);
		g2.drawString("�̻���(MER)��12345678989", 30, 60+printFontSize*5); 
		g2.drawString("�ն˺�(TER)��"+ bankInfo.getTermimalNo(), 30, 60+printFontSize*6);
		g2.drawString("-------------------------------", 30, 60+printFontSize*7);
		g2.drawString("������(ISSUER)��"+ bankInfo.getIssuer(), 30, 60+printFontSize*8);
		g2.drawString("�յ��У�"+ bankInfo.getAcQuirer(), 30, 60+printFontSize*9);
		g2.drawString("����(CARD NO.)��", 30, 60+printFontSize*10);
		g2.drawString(bankInfo.getCardNum(), 40, 60+printFontSize*11);
		g2.drawString("��������(TXN TYPE)������", 30, 60+printFontSize*12);
		g2.drawString("���κ�(BATCH NO.)��"+ bankInfo.getBatchNo(), 30, 60+printFontSize*13);
		g2.drawString("��Ȩ��(AUTH CODE)��"+bankInfo.getAuthCode(), 30, 60+printFontSize*14);
		g2.drawString("��Ч��(EXP DATE)��2014/03", 30, 60+printFontSize*15);
		g2.drawString("���ײο��ţ�"+ bankInfo.getReferNo(), 30, 60+printFontSize*16);
		g2.drawString("����ʱ�䣺"+bankInfo.getDate() +" "+ bankInfo.getTime(), 30, 60+printFontSize*17);
		g2.drawString("���׽�RMB��"+ bankInfo.getAmount(), 30, 60+printFontSize*18);
		g2.drawString("����Ա��(OPERATOR NO)��"+bankInfo.getOperatorNo(), 30, 60+printFontSize*19);
		g2.drawString("--------------------------------", 30, 60+printFontSize*20);
		g2.drawString("��ע(REFERENCE)", 30, 60+printFontSize*21);
		g2.drawString("--------------------------------", 30, 60+printFontSize*22);
		g2.drawString("�ֿ���ǩ��(CARDHOLDER SIGNATURE)", 30, 60+printFontSize*23);
		g2.drawString("", 30, 60+printFontSize*24);
		g2.drawString("", 30, 60+printFontSize*25);
		g2.drawString("--------------------------------", 30, 60+printFontSize*26);
		font =  new Font("����",Font.ITALIC,5);
		g2.setFont(font);
		g2.drawString("����ȷ�����Ͻ���ͬ�⽫����뱾���˻�", 30, 60+printFontSize*27);
		//g2.drawImage(data1, 30, 60+printFontSize*28, null);
		return Printable.PAGE_EXISTS; // ���ڴ�ӡҳʱ��������ӡ����
	}

	// ��ӡ���ݵ�ָ��λ��
	public void printContent() {
		printStr = "��ӡ��������jslkjf\n\rklsdfjlsddjfsdlkjs\n\rlfjddlkfj\n\rlsdjk";// ��ȡ��Ҫ��ӡ��Ŀ���ı�

		if (printStr != null && printStr.length() > 0) // ����ӡ���ݲ�Ϊ��ʱ
		{
			PAGES = 1; // ��ȡ��ӡ��ҳ��
			// ָ����ӡ�����ʽ
			DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;

			// ��λĬ�ϵĴ�ӡ����
			PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
			// ������ӡ��ҵ
			DocPrintJob job = printService.createPrintJob();
			// ���ô�ӡ����
			PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			// ����ֽ�Ŵ�С,Ҳ�����½�MediaSize�����Զ����С
			pras.add(MediaSizeName.NA_5X7);
			DocAttributeSet das = new HashDocAttributeSet();
			// ָ����ӡ����
			Doc doc = new SimpleDoc(this, flavor, das);
			
			// ����ʾ��ӡ�Ի���ֱ�ӽ��д�ӡ����
			try {
				job.print(doc, pras); // ����ÿһҳ�ľ����ӡ����
			} catch (PrintException pe) {
				pe.printStackTrace();
			}
		} else {
			// �����ӡ����Ϊ��ʱ����ʾ�û���ӡ��ȡ��
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
