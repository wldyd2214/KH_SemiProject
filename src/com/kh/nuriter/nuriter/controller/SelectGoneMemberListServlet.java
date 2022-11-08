package com.kh.nuriter.nuriter.controller;

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
import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.PageInfo;

/**
 * Servlet implementation class SelectGoneMemberListServlet
 */
@WebServlet("/selectGoneMemberList.nu")
public class SelectGoneMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectGoneMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징처리
				int currentPage;
				int limit;
				int maxPage;
				int startPage;
				int endPage;
				currentPage = 1;
				if(request.getParameter("currentPage") != null){
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				System.out.println("1번 : " +currentPage  );

				int listCount = new MemberService().getGoneMemberListCount();
				System.out.println("탈퇴한 멤버 수 : " + listCount);

				limit = 5;

				maxPage = (int)((double)listCount / limit + 0.9);
				
				startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;

				endPage = startPage + limit - 1;

				if(maxPage < endPage){
					endPage = maxPage;
				}

				PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

				ArrayList<Member> list = new MemberService().selectGoneMemberList(currentPage, limit);

				System.out.println("탈퇴회원 조회 서블릿 이동완료!");
				System.out.println(list);
				String page = "";

				if(list != null){
					page="views/admin/goneMemberList.jsp";
					request.setAttribute("list", list);
					
					request.setAttribute("pi", pi);
					
				}else{
					page="views/common/errorPage.jsp";
					request.setAttribute("msg", "누리장 조회 실패!");
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
