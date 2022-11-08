package com.kh.nuriter.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.member.model.service.MemberService;
import com.kh.nuriter.member.model.vo.Member;

/**
 * Servlet implementation class SearchMemberServlet
 */
@WebServlet("/searchMember")
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String searchCondition = request.getParameter("searchCondition");
		
		//System.out.println(searchCondition);
		
		ArrayList<Member> list = null;
		
		if(searchCondition.equals("findId")){
			String userId = request.getParameter("searchValue");
			System.out.println(userId);
			list = new MemberService().searchId(userId);
			
		}else if(searchCondition.equals("findName")){
			String userName = request.getParameter("searchValue");
			System.out.println(userName);
			list = new MemberService().searchName(userName);
			
		}else{
			String userNickname = request.getParameter("searchValue");
			System.out.println(userNickname);
			list = new MemberService().searchNickname(userNickname);
			
		}
		
		String page = "views/admin/searchResult.jsp";
		
		if(list != null || list.size() > 0){
			request.setAttribute("list", list);
			request.setAttribute("searchCondition", searchCondition);		
		}else{
			request.setAttribute("msg", "검색 결과가 없습니다");
			request.setAttribute("searchCondition", searchCondition);
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
