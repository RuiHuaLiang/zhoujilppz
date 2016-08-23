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
 * @�������ߣ��ܽ�
 * @����ʱ�䣺2016-8-16(����)
 * @�����汾��1.0
 * 
 * @�޸��ߣ�
 * @�޸İ汾��
 * @�޸�ʱ�䣺
 * @�޸�������
 * @��ʷ�汾��
 */
public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @author �ܽ�
	 * service
	 * ������̨����Ա���й�����
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ú�̨����������
		String command = request.getParameter("command");
		if("adminLogin".equals(command)){	
			adminLogin(request,response);
		}
	}

	private void adminLogin(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		//����ύ�����Ĺ���Ա�˻�������
		String adminAccount = request.getParameter("adminaccount");
		String adminPassword = request.getParameter("adminpassword");
		//����service���еĵĵ�¼�жϷ���
		AdminService service = new AdminService();
		Admin loginAdmin = service.login(adminAccount,adminPassword);
		
		if(loginAdmin != null){
			// ����Ϣ���浽session�������� ��ת����̨������;
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", loginAdmin);
			// �����ض���session��ֵ���Դ���ȥ��JSP�п�ֱ����ֵ
			try {
					response.sendRedirect(request.getContextPath()
										+ "/manageview/mainbackstate.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		}else{
			request.setAttribute("info","�˻����������");
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