package com.kh.nuriter.nuriter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.nuriter.model.service.NuriterService;

/**
 * Servlet implementation class UpdateNuriBossAfterGiveMoney
 */
@WebServlet("/updatePayStatus.nu")
public class UpdateNuriBossAfterGiveMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNuriBossAfterGiveMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("누리터 지급상태 변경하는 서블릿 이동 완료!");
		String nuriNum = request.getParameter("nuriNum");
		System.out.println("누리터 번호 : " + nuriNum);
		
		
		int payStatus = new NuriterService().updateNuriterPayStatus(nuriNum);
		System.out.println("누리터 지급상태 바뀌었으면 1 : " + payStatus);
		
		String nuriPayStatus = new NuriterService().selectNuriterPayStatus(nuriNum);
		System.out.println("바뀐 누리터 지급상태 : " + nuriPayStatus);
		
		/*String page = "";
		
		if(payStatus > 0) {
			page="views/admin/detailInfoOfMoney.jsp";
			request.setAttribute("nuriPayStatus", nuriPayStatus);
		}else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "누리장에게 돈 지급 실패");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);*/
		
		response.sendRedirect("selectNuriTotalMoney.nu?nuriNum="+nuriNum);
		/*response.sendRedirect("selectNuriTotalMoney.nu?payStatus="+payStatus);*/
		/*selectNuriTotalMoney.nu?nuriNum="+nuriNum+"&ownerNum="+ownerNum
*/		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
