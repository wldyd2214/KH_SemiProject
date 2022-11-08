package com.kh.nuriter.attend.model.service;

import static com.kh.nuriter.common.JDBCTemplate.close;
import static com.kh.nuriter.common.JDBCTemplate.commit;
import static com.kh.nuriter.common.JDBCTemplate.getConnection;
import static com.kh.nuriter.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.nuriter.attend.model.dao.AttendDao;
import com.kh.nuriter.attend.model.vo.Attend;
import com.kh.nuriter.attend.model.vo.Attendprint;
import com.kh.nuriter.attend.model.vo.Enter;
import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.dao.NuriterDao;
import com.kh.nuriter.nuriter.model.vo.Nuriter;

public class AttendService {

	public int insertattend(String checkcode, String usernum) {
		Connection con=getConnection();
		
		int result = new AttendDao().insertattend(con, checkcode, usernum);
		
		if(result >0){
			commit(con);
		}else{
			rollback(con);
		}
		
		return result;
	}

	public Attend attendCheck(String checkcode, String usernum) {
		Connection con=getConnection();
		
		Attend attend = new AttendDao().attendCheck(con, checkcode, usernum);
		
		commit(con);
		
		close(con);
		
		System.out.println("서비스 attend : " + attend);
		
		return attend;
	}

	public ArrayList<Attend> attendOk(String usernum) {
		Connection con=getConnection();
		
		ArrayList<Attend> attend = new AttendDao().attendOk(con, usernum);
		
		commit(con);
		
		close(con);
		
		System.out.println("서비스 attend : " + attend);
		
		return attend;
	}

	public ArrayList<Attendprint> attendprint(String nunum) {
		Connection con=getConnection();
		
		ArrayList<Attendprint> att = new AttendDao().attendprint(con, nunum);
		/*ArrayList<HashMap<String, Object>> att = new AttendDao().attendprint(con, nunum);*/
		
		commit(con);
		
		close(con);
		
		System.out.println("서비스 attendprint : " + att);
		
		return att;
	}

	public ArrayList<Enter> enterprint(String nunum) {
		Connection con=getConnection();
		
		/*ArrayList<HashMap<String, Object>> en = new AttendDao().enterprint(con, nunum);*/
		ArrayList<Enter> en = new AttendDao().enterprint(con, nunum);
		
		commit(con);
		
		close(con);
		
		System.out.println("서비스  enterprint : " + en);
		
		return en;
	}

	public ArrayList<Attendprint> attendprint2(String nunum, String date) {
		Connection con=getConnection();
		
		ArrayList<Attendprint> att2 = new AttendDao().attendprint2(con, nunum, date);
		/*ArrayList<HashMap<String, Object>> att = new AttendDao().attendprint(con, nunum);*/
		
		commit(con);
		
		close(con);
		
		System.out.println("서비스 attendprint : " + att2);
		
		return att2;
  }
  
	public int getListCount(String nuriNum) {
		Connection con = getConnection();        
	    int listCount = new AttendDao().getListCount(con, nuriNum);
	         
	    close(con);
	         
	    return listCount;
	}

	public ArrayList<Member> selectMyNuriMember(int currentPage, int limit, String nuriNum) {
		Connection con = getConnection();
        
	    ArrayList<Member> list = new AttendDao().selectMyNuriMemberList(con, currentPage, limit, nuriNum);
	         
	    close(con);
	         
	    return list;

	}

}
