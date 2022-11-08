package com.kh.nuriter.nuriter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class UpdateNuriBossApproveToNServlet
 */
@WebServlet("/updateNuribossStatus2.nu")
public class UpdateNuriBossApproveToNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNuriBossApproveToNServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("누리장 승인취소 시키는 서블릿 이동 완료!");
		/*String applyNum = request.getParameter("applyNum");
		System.out.println("누리장 applyNum : " + applyNum);*/
		String userNum = request.getParameter("userNum");
		System.out.println("누리장 userNum : " + userNum);
		
		int result = new NuriterService().updateNuribossApproveToN(userNum);
		int result2 = new NuriterService().updateMemberGrade2(userNum);
		
		System.out.println("누리장 approve 바뀌면 1 : " + result);
		System.out.println("누리장인 멤버 grade 바뀌면1 : " + result2);
		
		if(result > 0 || result2 > 0){
			response.sendRedirect("selectNuriBossDetailList2.nu");
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
