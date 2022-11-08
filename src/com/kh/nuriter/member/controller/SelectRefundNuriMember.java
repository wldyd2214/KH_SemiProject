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
import com.kh.nuriter.member.model.vo.PageInfo;

/**
 * Servlet implementation class SelectRefundNuriMember
 */
@WebServlet("/selectRefundNuriMember.rm")
public class SelectRefundNuriMember extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectRefundNuriMember() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int currentPage;
      int limit;
      int maxPage;
      int startPage;
      int endPage;
      
      int currentPage2;
      int maxPage2;
      int startPage2;
      int endPage2;
      
      currentPage = 1;
      currentPage2 = 1;

      if(request.getParameter("currentPage") != null){
         currentPage = Integer.parseInt(request.getParameter("currentPage"));
      }
      
      if(request.getParameter("currentPage2") != null){
         currentPage2 = Integer.parseInt(request.getParameter("currentPage2"));
      }

      System.out.println("1번 currentPage : " + currentPage);
      System.out.println("2번 currentPage : " +currentPage2);

      int listCount = new MemberService().getRefundMemberCount();
      int listCount2 = new MemberService().getRefundMemberCount2();
      
      limit = 5;

      maxPage = (int)((double)listCount / limit + 0.9);
      maxPage2 = (int)((double)listCount2 / limit + 0.9);

      startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;
      startPage2 = (((int)((double)currentPage2 / limit + 0.9)) -1) * limit + 1;

      endPage = startPage + limit - 1;
      endPage2 = startPage2 + limit - 1;

      if(maxPage < endPage){
         endPage = maxPage;
      }

      if(maxPage2 < endPage2){
         endPage2 = maxPage2;
      }
      
      PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
      PageInfo pi2 = new PageInfo(currentPage2, listCount2, limit, maxPage2, startPage2, endPage2);
      
      ArrayList<Member> refundList = new MemberService().selectRefundNuriMember(currentPage, limit);
      ArrayList<Member> refundList2 = new MemberService().selectRefundNuriMember2(currentPage2, limit);
      
      
      System.out.println("환불전 누리원 리스트 : " + refundList);
      System.out.println("환불후 누리원 리스트 : " + refundList2);
      
      String page = "";
      
      if(refundList != null){
         page="views/member/refundMemberList.jsp";
         request.setAttribute("refundList", refundList);
         request.setAttribute("refundList2", refundList2);
         request.setAttribute("pi", pi);
         request.setAttribute("pi2", pi2);
      }else{
         page="views/common/errorPage.jsp";
         request.setAttribute("msg", "환불완료된 누리원 조회 실패!");
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