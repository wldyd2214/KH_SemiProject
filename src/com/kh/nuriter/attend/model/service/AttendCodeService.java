package com.kh.nuriter.attend.model.service;

import static com.kh.nuriter.common.JDBCTemplate.close;
import static com.kh.nuriter.common.JDBCTemplate.commit;
import static com.kh.nuriter.common.JDBCTemplate.getConnection;
import static com.kh.nuriter.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.nuriter.attend.model.dao.AttendCodeDao;
import com.kh.nuriter.attend.model.vo.AttendCode;
import com.kh.nuriter.member.model.dao.MemberDao;

public class AttendCodeService {

	public AttendCode selectOneCode(String nunum) {
		Connection con = getConnection();
		System.out.println("서비스" + nunum);
		AttendCode c = new AttendCodeDao().selectOneCode(con, nunum);
		
		commit(con);
		
		close(con);
		
		return c;
	}

	public int insertOneCode(AttendCode ac) {
		Connection con=getConnection();
		
		int result=new AttendCodeDao().insertOneCode(ac, con);
		
		if(result > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);
		
		System.out.println("attend result :" + result);
		return result;
	}

	public AttendCode codeCheck(String nunum) {
		Connection con=getConnection();
		AttendCode atcode = new AttendCodeDao().codeCheck(con, nunum);
		
		commit(con);
		
		close(con);
		
		System.out.println("서비스 atcode : " + atcode);
		return atcode;
	}

}
