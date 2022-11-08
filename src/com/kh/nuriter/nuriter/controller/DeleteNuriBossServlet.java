package com.kh.nuriter.nuriter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class DeleteNuriBossServlet
 */
@WebServlet("/deleteNuriboss.nu")
public class DeleteNuriBossServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNuriBossServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("applyNum");
		String num2 = request.getParameter("userNum");
		
		System.out.println("누리장신청번호 : " + num + " 유저번호 : " + num2);
		
		int result = new NuriterService().deleteNuriboss(num);
		
		
		if(result > 0){
			response.sendRedirect(request.getContextPath() + "/selectNuriBossDetailList.nu");
		}else{
			request.setAttribute("msg", "누리장 승인 거부 완료!");
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
