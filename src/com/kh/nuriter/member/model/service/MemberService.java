package com.kh.nuriter.member.model.service;

import static com.kh.nuriter.common.JDBCTemplate.close;
import static com.kh.nuriter.common.JDBCTemplate.commit;
import static com.kh.nuriter.common.JDBCTemplate.getConnection;
import static com.kh.nuriter.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.nuriter.member.model.dao.MemberDao;
import com.kh.nuriter.member.model.vo.Member;

public class MemberService {

	public Member loginCheck(String userEmail, String password) {
		Connection con = getConnection();
		
		Member loginUser = new MemberDao().loginCheck(con, userEmail, password);
		
		System.out.println("service userid : " +userEmail);
		System.out.println("service userpwd : " +password);
		close(con);
		
		return loginUser;
		
		//return new MemberDao().loginCheck(con, userId, password);
	}
	
	//회원 가입용 메소드
	public int insertMember(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertMember(con, m);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
				
		return result;
	}

	public int deleteMember(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().deleteMember(con, m);
		
		if(result >0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	



	public int updateMember(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().updateMember(con, m);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
				
		return result;
	}
	
	/*

	public ArrayList<Member> selectAll() {
	Connection con = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectAll(con);
		
		close(con);
		
		return list;
	}
*/
	public int idCheck(String userEmail) {
		Connection con = getConnection();
		
		int result = new MemberDao().idCheck(con, userEmail);
		
		
		close(con);
		
		
		return result;
		
	}

	public Member snsloginMember(String userEmail) {
		Connection con=getConnection();
		Member loginUser = new MemberDao().snsloginMember(con, userEmail);
		
		System.out.println("service userid : " +userEmail);
		close(con);
		
		return loginUser;
	}

	public int snsMember(Member m) {
		Connection con=getConnection();
		
		int result=new MemberDao().snsMember(m, con);
		
		if(result > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);
		
		System.out.println("sns 서비스 result :" + result);
		return result;
	}

	public Member finId(String userName, String phone) {
		Connection con = getConnection();
		
		Member loginUser = new MemberDao().finid(con, userName, phone);
		
		System.out.println("service userName : " +userName);
		System.out.println("service phone : " +phone);
		close(con);
		
		return loginUser;
	}

	public Member checkEmail(String userEmail) {
		Connection con = getConnection();
		
		Member loginUser = new MemberDao().checkEmail(con, userEmail);
		
		
		close(con);

		return loginUser;
	}

	public int passwordUpdate(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().passwordUpdate(con, m);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
				
		return result;
	}

	public Member selectNuriBossInfo(String ownerNum) {
		Connection con = getConnection();
		
		Member m = new MemberDao().selectNuriBossInfo(con, ownerNum);
		
		close(con);
		
		return m;
	}

	public int getGoneMemberListCount() {
		  Connection con = getConnection();
	      
	      int listCount = new MemberDao().getGoneMemberListCount(con);
	      
	      close(con);
	      
	      return listCount;
	}

	public ArrayList<Member> selectGoneMemberList(int currentPage, int limit) {
		Connection con = getConnection();
	     ArrayList<Member> list = new MemberDao().selectGoneMemberList(con, currentPage, limit);
	      
	      close(con);
	      
	      return list;
	}

	public ArrayList<Member> selectAll() {
		Connection con = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectAll(con);
		
		close(con);
		
		return list;
	}

	public ArrayList<Member> selectRefundNuriMember(int currentPage, int limit) {
	      Connection con = getConnection();
	      
	      ArrayList<Member> refundList = new MemberDao().selectRefundNuriMember(con, currentPage, limit);
	      
	      close(con);
	      
	      return refundList;
	   }

	   public ArrayList<Member> selectRefundNuriMember2(int currentPage2, int limit) {
	      Connection con = getConnection();
	      
	      ArrayList<Member> refundList2 = new MemberDao().selectRefundNuriMember2(con, currentPage2, limit);
	      
	      close(con);
	      
	      return refundList2;
	   }
	
	   
	   public int getRefundMemberCount() {
		      Connection con = getConnection();
		      
		      int result = new MemberDao().getRefundMemberCount(con);
		      
		      close(con);
		      
		      return result;
		   }

		   public int getRefundMemberCount2() {
		      Connection con = getConnection();
		      
		      int result = new MemberDao().getRefundMemberCount2(con);
		      
		      close(con);
		      
		      return result;
		   }   
	 
		   public int updateRefundNumber(String num) {
			      Connection con = getConnection();
			      
			      int result = new MemberDao().updateRefundNumber(con, num);
			      
			      if(result > 0){
			         commit(con);
			      }else{
			         rollback(con);
			      }
			      
			      return result;
			   }

		public ArrayList<Member> searchId(String userId) {
			Connection con = getConnection();
			
			ArrayList<Member> list = new MemberDao().searchId(con, userId);
			
			close(con);
			
			return list;
		}

		public ArrayList<Member> searchName(String userName) {
			Connection con = getConnection();
			
			ArrayList<Member> list = new MemberDao().searchName(con, userName);
			
			System.out.println("서비스 :" + userName);
			
			close(con);
			
			return list;
		}

		public ArrayList<Member> searchNickname(String userNickname) {
			Connection con = getConnection();
			
			ArrayList<Member> list = new MemberDao().searchNickname(con, userNickname);
			
			close(con);
			
			return list;
		}

		public int snsMember1(Member m) {
			Connection con=getConnection();
			
			int result=new MemberDao().snsMember1(m, con);
			
			if(result > 0){
				commit(con);
			}
			else{
				rollback(con);
			}
			
			close(con);
			
			System.out.println("sns 서비스 result :" + result);
			return result;
		}

		public Member snsloginMember1(String userEmail) {
			Connection con=getConnection();
			Member loginUser = new MemberDao().snsloginMember1(con, userEmail);
			
			System.out.println("service userid : " +userEmail);
			close(con);
			
			return loginUser;
		}	   

	/*public int snsloginMember(Member m) {
		Connection con=getConnection();
		
		int result=new MemberDao().snsloginMember(m, con);
		
		if(result > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}*/

}