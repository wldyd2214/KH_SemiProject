package com.kh.nuriter.nuriter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class UpdateNuriBossStatusServlet
 */
@WebServlet("/updateNuribossStatus.nu")
public class UpdateNuriBossStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNuriBossStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("누리장 승인 받기 위한 서블릿 이동 완료!");
		/*String num = request.getParameter("applyNum");
		System.out.println(num);*/
		
		String num2 = request.getParameter("userNum");
		System.out.println(num2);
		
		int result = new NuriterService().updateNuribossStatus(num2);
		int result2 = new NuriterService().updateMemberGrade(num2);
		
		
		if(result > 0 && result > 0){
			System.out.println("누리장 승인 및 멤버 등급 변경 완료!");
			response.sendRedirect(request.getContextPath() + "/selectNuriBossDetailList.nu");
		}else{
			request.setAttribute("msg", "누리장 승인 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
