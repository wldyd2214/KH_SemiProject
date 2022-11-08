package com.kh.nuriter.payment.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.payment.model.service.PaymentService;
import com.kh.nuriter.payment.model.vo.Payment;
import com.kh.nuriter.payment.model.vo.PaymentDetail;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/payment.pms")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid =request.getParameter("imp");
		String userNum = request.getParameter("userNum");
		String nuriNum = request.getParameter("nuriNum");
		String cardNum = request.getParameter("cardNum");
		String terminateDate = request.getParameter("endDate");

		System.out.println(terminateDate);

		java.sql.Date endDate = null;

		if(terminateDate != "" || terminateDate != null) {
			String[] dateArr = terminateDate.split("-");

			int[] arr = new int[dateArr.length];

			for(int i = 0; i < dateArr.length; i++) {
				arr[i] = Integer.parseInt(dateArr[i]);
			}

			endDate = new java.sql.Date(new GregorianCalendar(arr[0], arr[1] - 1, arr[2]).getTimeInMillis());


		}else {
			endDate = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}




		Payment p = new Payment();
		p.setpId(pid);
		p.setUserNum(userNum);
		p.setNuriNum(nuriNum);
		int result5 = new PaymentService().checkPayment(userNum, nuriNum); // 이전에 결제 기록 확인
		System.out.println("result 5 : " + result5);

		//이전에 결제 기록이 없다면 결제진행
		if(result5 < 1){

			int result =new PaymentService().InsertPayment(p); //결제

			Payment p1 = new Payment(); //참가신청
			p1.setUserNum(userNum);
			p1.setNuriNum(nuriNum);
			p1.setTerminateDate(endDate);



			int result2 =0; //참가신청
			int result3 =0;//결제디테일

			PaymentDetail pd = new PaymentDetail();
			pd.setPid(pid);
			pd.setCardNum(cardNum);

			int result4 = 0;
			result4 = new PaymentService().updateAttention(userNum, nuriNum);
			if(result4 >0){
				System.out.println("attention삭제 성공");
			}else{
				System.out.println("attention 삭제 실패");
			}

			String page="";
			result2 = new PaymentService().InsertApplication(p1);
			result3 = new PaymentService().InsertPaymentDetail(pd);
			if(result>0 && result2>0 && result3>0){
				System.out.println("payment 성공이다,");
				page="/selectNuriterOne.nu?num="+nuriNum;
				request.getRequestDispatcher(page).forward(request, response);

			}else{
				page="/selectNuriterOne.nu?num="+nuriNum;
				request.getRequestDispatcher(page).forward(request, response);
			}



		}else{
			response.getWriter().write(result5);
			response.sendRedirect("selectNuriterOne.nu?num="+nuriNum);
			System.out.println("결제기록 확인 후 결제불가 성공");
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