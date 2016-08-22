package com.zjlppz.servlet.lrservlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;

public class CodeServlet extends HttpServlet {

	 public void init() throws ServletException {
		  
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
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int width = 75;
			int height = 25;

			// ȡ��һ��5λ�����ĸ�����ַ���
			String s = RandomStringUtils.random(5, true, true);

			// ������session,�������û���������бȽ�.
			// ע��Ƚ���֮�����session.
			HttpSession session = request.getSession(true);
			session.setAttribute("imageShow", s);

			response.setContentType("images/jpeg");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			ServletOutputStream out = response.getOutputStream();
			BufferedImage image = new 
			  	       BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();

			// �趨����ɫ
			g.setColor(getRandColor(200, 250));
			g.fillRect(0, 0, width, height);

			// �趨����
			Font mFont = new Font("������κ", Font.HANGING_BASELINE, 18);
			g.setFont(mFont);				 

			// ���߿�
			// g.setColor(Color.BLACK);
			// g.drawRect(0, 0, width - 1, height - 1);

			// ������������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
			g.setColor(getRandColor(160, 200));

			// ���������
			Random random = new Random();
			for (int i = 0; i < 155; i++) {
			  	int x2 = random.nextInt(width);
			  	int y2 = random.nextInt(height);
			  	int x3 = random.nextInt(12);
			  	int y3 = random.nextInt(12);
			  	g.drawLine(x2, y2, x2 + x3, y2 + y3);
			 }

			 // ����֤����ʾ��ͼ����
			 g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

			 // ��һλָ��������ڶ�λָ���������λ�ƣ�����λָ���������λ��
			 g.drawString(s, 10, 18);

			 // ͼ����Ч
			 g.dispose();

			 // ���ͼ��ҳ��
			 ImageIO.write((BufferedImage) image, "JPEG", out);
			 out.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	private Color getRandColor(int fc, int bc) {	 
		 Random random = new Random();
		 if (fc > 255){
			 fc = 255;
		 }
		 if (bc > 255){
			 bc = 255;
		 }    
		 int r = fc + random.nextInt(bc - fc);
		 int g = fc + random.nextInt(bc - fc);
	     int b = fc + random.nextInt(bc - fc);
		 return new Color(r, g, b);
	}

}
