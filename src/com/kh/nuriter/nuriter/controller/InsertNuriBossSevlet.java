package com.kh.nuriter.nuriter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.Nuriboss;

/**
 * Servlet implementation class InsertNuriBossSevlet
 */
@WebServlet("/insertBoss.nu")
public class InsertNuriBossSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNuriBossSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNum = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getUserNumber());
		String category = request.getParameter("category");
		String files = request.getParameter("summerText");
		
		Nuriboss n = new Nuriboss();
		n.setUserNum(userNum);
		n.setCategoryNum(category);
		n.setBossContent(files);
		
		System.out.println(n.toString());
		
		//서비스로 전달
		int result = new NuriterService().insertNuriBoss(n);
				
		//처리 결과에 따른 뷰 페이지 결정
		String page = "";
				
		if(result > 0){
			page = "views/common/successPage.jsp";
			request.setAttribute("msg", "누리장 신청이 완료되었습니다.");
		}else{
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "누리터 신청에 실패하셨습니다!");		
		}
				
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
