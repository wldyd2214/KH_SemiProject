package com.kh.nuriter.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.nuriter.member.model.service.MemberService;
import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class deleteMemberServlet
 */
@WebServlet("/deleteMember.me")
public class deleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		
		Member m = (Member)session.getAttribute("loginUser");
		
	    System.out.println(m);
		int result = new MemberService().deleteMember(m);
		
		if(result > 0) {
			session.invalidate();
			ArrayList<HashMap<String, Object>> pictureList = new NuriterService().selectThumbnailList1();
			ArrayList<HashMap<String, Object>> pictureList2 = new NuriterService().selectThumbnailList2();
			ArrayList<HashMap<String, Object>> pictureList3 = new NuriterService().selectThumbnailList3();
			/*response.sendRedirect("index.jsp");*/
			/*RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);*/
			request.setAttribute("pictureList", pictureList);
			request.setAttribute("pictureList2", pictureList2);
			request.setAttribute("pictureList3", pictureList3);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "회원 탈퇴 실패!!");
			
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
