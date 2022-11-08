package com.kh.nuriter.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.nuriter.notice.model.dao.NoticeDao;
import com.kh.nuriter.notice.model.vo.Notice;
import com.kh.nuriter.nuriter.model.dao.NuriterDao;

import static com.kh.nuriter.common.JDBCTemplate.*;

public class NoticeService {

	//공지사항 전체조회
	public ArrayList<Notice> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectList(con, currentPage, limit);
		
		close(con);
		
		return list;
	}

	public int insertNotice(Notice n) {
		Connection con = getConnection();
		
		int result = new NoticeDao().insertNotice(con, n);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new NoticeDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public Notice selectOne(String num) {
		Connection con = getConnection();
		
		int result = 0;
		Notice n = new NoticeDao().selectOne(con, num);
		
		if(n != null){
			result = new NoticeDao().updateCount(con, n.getbNumber());
			if(result > 0){
				commit(con);
			}else{
				rollback(con);
			}
		}
		close(con);
		return n;
	}

	public int updateNotice(Notice n) {
		Connection con = getConnection();
		
		int result = new NoticeDao().updateNotice(con, n);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteNotice(String num) {
		Connection con = getConnection();
		
		int result = new NoticeDao().deleteNotice(con, num);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	
	
	
	//qna
	public int Insertqna(Notice n) {
		int result = 0;
		Connection con = getConnection();
		
		result = new NoticeDao().Insertqna(n,con);
		
		if(result >0){
			commit(con);
		}else{
			rollback(con);
			
		}
		close(con);
		
		return result;
	}

	public ArrayList<Notice> SelectqnaList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Notice> list = new NoticeDao().SelectqnaList(con,currentPage,limit);
		
		close(con);
		
		
		
		return list;
	}

	public int QnaListCount() {
		Connection con = getConnection();
		
		int listCount = new NoticeDao().QnaListCount(con);
		
		close(con);
		
		
		
		return listCount;
	}

	public Notice SelectqnaDetail(String boardNum) {
		Connection con  = getConnection();
		
		Notice n = new NoticeDao().SelectqnaDetail(con,boardNum);
		if(n != null){
			commit(con);
			
		}else{
			rollback(con);
			
		}
		close(con);
		
		
		return n;
	}

	public int InsertqnaComment(String boardNum, String content, String writer) {
		Connection con = getConnection();
		
		int result = new NoticeDao().InsertqnaComment(con,boardNum,content,writer);
		
		if(result >0){
			commit(con);
			
		}else{
			rollback(con);
			
		}
		
		return result;
	}

	public ArrayList<HashMap<String, Object>> selectqnaComment(String boardNum) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> commentList = new NoticeDao().selectqnaComment(con, boardNum);
		
		close(con);
		
		return commentList;
	}

	
	
}
