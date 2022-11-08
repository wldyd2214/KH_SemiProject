package com.kh.nuriter.payment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.payment.model.service.PaymentService;

/**
 * Servlet implementation class DoRefundNuriServlet
 */
@WebServlet("/doRefundNuri.pa")
public class DoRefundNuriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRefundNuriServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String nuriNum = request.getParameter("nuriNum");
		System.out.println("누리터 번호 : " + nuriNum);
		String userNum = request.getParameter("userNum");
		System.out.println("환불 누리원 번호 : " + userNum);
		
		Member m = (Member)session.getAttribute("loginUser");
		
	    System.out.println(m);
		//Paydetail refund_state 바꿔주기
	    int result = new PaymentService().doRefundNuri(nuriNum, userNum);		
	    int result2 = new NuriterService().deleteMyNuri(userNum, nuriNum);
	    
		if(result > 0 && result2 > 0) {
			response.sendRedirect("selectMyNuriList.nu");
		}else {
			request.setAttribute("msg", "환불 실패");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
