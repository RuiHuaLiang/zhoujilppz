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

			// 取得一个5位随机字母数字字符串
			String s = RandomStringUtils.random(5, true, true);

			// 保存入session,用于与用户的输入进行比较.
			// 注意比较完之后清除session.
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

			// 设定背景色
			g.setColor(getRandColor(200, 250));
			g.fillRect(0, 0, width, height);

			// 设定字体
			Font mFont = new Font("华文新魏", Font.HANGING_BASELINE, 18);
			g.setFont(mFont);				 

			// 画边框
			// g.setColor(Color.BLACK);
			// g.drawRect(0, 0, width - 1, height - 1);

			// 随机产生干扰线，使图象中的认证码不易被其它程序探测到
			g.setColor(getRandColor(160, 200));

			// 生成随机类
			Random random = new Random();
			for (int i = 0; i < 155; i++) {
			  	int x2 = random.nextInt(width);
			  	int y2 = random.nextInt(height);
			  	int x3 = random.nextInt(12);
			  	int y3 = random.nextInt(12);
			  	g.drawLine(x2, y2, x2 + x3, y2 + y3);
			 }

			 // 将认证码显示到图象中
			 g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

			 // 第一位指随机数，第二位指随机数左右位移，第三位指随机数上下位移
			 g.drawString(s, 10, 18);

			 // 图象生效
			 g.dispose();

			 // 输出图象到页面
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
