package com.kh.nuriter.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.board.model.sevice.BoardService;
import com.kh.nuriter.board.model.vo.board;
import com.kh.nuriter.board.model.vo.reportNuri;
import com.kh.nuriter.member.model.vo.Member;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;




/**
 * Servlet implementation class ReportSendServlet
 */
@WebServlet("/reportSend.rs")
public class ReportSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportSendServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rTitle = request.getParameter("rTitle");
		String rContent = request.getParameter("rContent");
		String rUser = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getUserNumber());
		String nuriNum =request.getParameter("nuriNum");
		String ownerNum = request.getParameter("rOwnerNum");


		/*board rNuri = new board();
		rNuri.setBoardTitle(rTitle);
		rNuri.setBoardContent(rContent);
		rNuri.setUserNum(rUser);
		rNuri.setNuriNum(nuriNum);
		rNuri.set
	*/
			reportNuri rNuri = new reportNuri();
			rNuri.setBoardTitle(rTitle);
			rNuri.setBoardContent(rContent);
			rNuri.setUserNum(Integer.parseInt(rUser));
			rNuri.setNuriNum(nuriNum);
			rNuri.setN_ownerNum(ownerNum);
			

		int result = new BoardService().InsertReportNuri(rNuri);
		
		String page="";
		
		if(result > 0){
			System.out.println("성공");
			page="/selectNuriterOne.nu?num="+nuriNum;
			request.getRequestDispatcher(page).forward(request, response);
			
		}else{
			System.out.println("실패");

		}
		/*RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
*/

		System.out.println(nuriNum);
		System.out.println(rTitle);
		System.out.println(rContent);
		System.out.println(rUser);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
