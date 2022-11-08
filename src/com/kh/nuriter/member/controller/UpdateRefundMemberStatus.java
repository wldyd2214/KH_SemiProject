package com.kh.nuriter.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nuriter.member.model.service.MemberService;

/**
 * Servlet implementation class UpdateRefundMemberStatus
 */
@WebServlet("/updateRefundMember.rm")
public class UpdateRefundMemberStatus extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRefundMemberStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("환불 넘버값 넣어주는 서블릿 이동 완료!");
      String num = request.getParameter("num");
      System.out.println(num);
      
      int result = new MemberService().updateRefundNumber(num);
      
      
      if(result > 0){
         response.sendRedirect("selectRefundNuriMember.rm");
         /*response.sendRedirect("selectNuriTotalMoney.nu?payStatus="+payStatus);*/
      }else{
         request.setAttribute("msg", "환불 승인 실패!");
           request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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