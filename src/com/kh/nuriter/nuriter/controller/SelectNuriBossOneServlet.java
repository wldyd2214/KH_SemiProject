package com.kh.nuriter.nuriter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.nuriter.model.service.NuriterService;
import com.kh.nuriter.nuriter.model.vo.Nuriboss;

/**
 * Servlet implementation class SelectNuriBossOneServlet
 */
@WebServlet("/selectOneNuriboss.nu")
public class SelectNuriBossOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNuriBossOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("누리보스 하나 조회 서블릿 이동 완료");
		
		String num = request.getParameter("num");
		System.out.println(num);
		
		Nuriboss nb = new NuriterService().selectOneNuriboss(num);
		
		String page = "";
		System.out.println(nb);
		
		if(nb != null){
			page = "views/admin/nuribossDetailBeforeAccept.jsp";
			request.setAttribute("nb", nb);
		}else{
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "누리장 신청 디테일 조회 실패!");
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
