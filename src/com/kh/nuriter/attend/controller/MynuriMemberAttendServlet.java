package com.kh.nuriter.attend.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.attend.model.service.AttendService;
import com.kh.nuriter.attend.model.vo.Attend;
import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.Nuriter;

/**
 * Servlet implementation class MynuriMemberAttend
 */
@WebServlet("/mynuriMemberAttend.at")
public class MynuriMemberAttendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MynuriMemberAttendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nunum = request.getParameter("nunum");
		String usernum= request.getParameter("usernumber");
		String nickName = request.getParameter("nickName");
		System.out.println("누리원 닉네임 : " + nickName);
		
		Nuriter n = new NuriterService().selectOpenOne(nunum);
		
		
		ArrayList<Attend> attend = new AttendService().attendOk(usernum);
		
		System.out.println("서비스 attendOk attend : " + attend);
		
		String page ="";
		
		System.out.println(n);
		
		
		if(n != null){
			page = "views/attend/csCheckMyMember.jsp";
			request.setAttribute("n", n);
			request.setAttribute("attend", attend);
			request.setAttribute("nickName", nickName);
		}else{
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 실패");
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
