package com.kh.nuriter.nuriter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.Nuriter;
import com.kh.nuriter.nuriter.model.vo.PageInfo;

/**
 * Servlet implementation class SelectSearchNuriter
 */
@WebServlet("/selectSearch.nu")
public class SelectSearchNuriter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSearchNuriter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		
		//페이징 처리
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = new NuriterService().getSearchNuriterListCount(search);
		
		System.out.println("listCount => " + listCount);
		
		limit = 8;
		
		maxPage = (int)((double)listCount / limit + 0.9) ;
		
		startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;
		
		endPage = startPage + limit - 1;
		
		if(maxPage < endPage){
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		System.out.println("누리터 리스트 서블릿 이동 완료!");
		ArrayList<Nuriter> list = new NuriterService().selectSearcgNuriterList(search); //해당 카테고리에 대한 리스트를 ArrayList로 가져온다.
		
		System.out.println(list);
		
		ArrayList<HashMap<String, Object>> pictureList = new NuriterService().selectSearchThumbnailList(currentPage, limit, search);
		
		System.out.println("pictureList => " + pictureList);
		
		String page = "";
		
		if(list != null){
			page = "views/member/category.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("pictureList", pictureList);
		}else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "누리터 목록 조회 실패");
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
