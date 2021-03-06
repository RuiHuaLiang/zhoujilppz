package com.zjlppz.servlet.backservlet_zhoujie;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zjlppz.bean.Admin;
import com.zjlppz.services.backServices_zhoujie.AdminService;
/**
 * @创建作者：周洁
 * @创建时间：2016-8-16(下午)
 * @创建版本：1.0
 * 
 * @修改者：
 * @修改版本：
 * @修改时间：
 * @修改描述：
 * @历史版本：
 */
public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @author 周洁
	 * service
	 * 处理后台管理员的有关请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得后台的请求内容
		String command = request.getParameter("command");
		if("adminLogin".equals(command)){	
			adminLogin(request,response);
		}
	}

	private void adminLogin(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		//获得提交上来的管理员账户和密码
		String adminAccount = request.getParameter("adminaccount");
		String adminPassword = request.getParameter("adminpassword");
		//调用service包中的的登录判断方法
		AdminService service = new AdminService();
		Admin loginAdmin = service.login(adminAccount,adminPassword);
		
		if(loginAdmin != null){
			// 将信息保存到session对象中再 跳转到后台主界面;
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", loginAdmin);
			// 请求重定向，session的值可以传过去，JSP中可直接拿值
			try {
					response.sendRedirect(request.getContextPath()
										+ "/manageview/mainbackstate.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		}else{
			request.setAttribute("info","账户或密码错误！");
			try {
				request.getRequestDispatcher("/manageview/mainbackstate.jsp").forward(request, response);
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
