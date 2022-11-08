package com.kh.nuriter.notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.nuriter.board.model.vo.reportNuri;
import com.kh.nuriter.notice.model.vo.Notice;

import static com.kh.nuriter.common.JDBCTemplate.*;

public class NoticeDao {
	private Properties prop = new Properties();
	
	public NoticeDao(){
		String fileName = NoticeDao.class.getResource("/sql/notice/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//공지사항 전체조회
	public ArrayList<Notice> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice n = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Notice>();
			
			while(rset.next()){
				n = new Notice();
				
				n.setbRownum(rset.getString("rnum"));
				n.setbNumber(rset.getString("board_number"));
				n.setbTitle(rset.getString("board_title"));
				n.setbContent(rset.getString("board_content"));
				n.setUserNumber(rset.getString("nickname"));
				n.setbCount(rset.getInt("bcount"));
				n.setbDate(rset.getDate("board_date"));
				
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int insertNotice(Connection con, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, n.getbTitle());
			pstmt.setString(2, n.getbContent());
			pstmt.setString(3, n.getUserNumber());
			pstmt.setDate(4, n.getbDate());
			/*pstmt.setString(5, "공지사항");*/
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}
	
	public Notice selectOne(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice n = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				n = new Notice();
				
				n.setbNumber(rset.getString("board_number"));
				n.setbTitle(rset.getString("board_title"));
				n.setbContent(rset.getString("board_content"));
				n.setUserNumber(rset.getString("nickname"));
				n.setbCount(rset.getInt("bcount"));
				n.setbDate(rset.getDate("board_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		System.out.println(n);
		
		return n;
	}
	public int updateNotice(Connection con, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, n.getbTitle());
			pstmt.setDate(2, n.getbDate());
			pstmt.setString(3, n.getbContent());
			pstmt.setString(4, n.getbNumber());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	public int updateCount(Connection con, String getbNumber) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, getbNumber);
			pstmt.setString(2, getbNumber);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteNotice(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int Insertqna(Notice n, Connection con) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertqna");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, n.getbTitle());
			pstmt.setString(2, n.getbContent());
			pstmt.setInt(3, Integer.parseInt(n.getUserNumber()));
			pstmt.setDate(4, n.getbDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			
		}
		
		
		
		return result;
	}
	public ArrayList<Notice> SelectqnaList(Connection con, int currentPage, int limit) {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice n = null;
		
		String query = prop.getProperty("selectqnaList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startNum =(currentPage -1)* limit + 1;
			int endNum = startNum + limit-1;
			
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Notice>();
			
			while(rset.next()){
				n = new Notice();
				
				n.setbNumber(rset.getString("board_number"));
				n.setbTitle(rset.getString("board_title"));
				n.setbContent(rset.getString("board_content"));
				n.setUserNumber(rset.getString("nickname"));
				n.setbDate(rset.getDate("board_date"));
				
				list.add(n);
				
				System.out.println("민지 n : "+n);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}
		return list;
	}
	public int QnaListCount(Connection con) {
		int listCount =0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("qnaListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				listCount = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}
	public Notice SelectqnaDetail(Connection con, String boardNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Notice n  =null;
		
		String query = prop.getProperty("selectqnadetail");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, boardNum);
			
			rset = pstmt.executeQuery();
			if(rset.next()){
				n = new Notice();
				
				n.setbNumber(rset.getString("board_number"));
				n.setbTitle(rset.getString("board_title"));
				n.setbContent(rset.getString("board_content"));
				n.setUserNumber(rset.getString("nickname"));
				n.setbDate(rset.getDate("board_date"));
				
			}
			System.out.println(n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
			
		}
		
		
		return n;
	}
	public int InsertqnaComment(Connection con, String boardNum, String content, String writer) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertComment");
		

		try {
			System.out.println(boardNum);
			System.out.println(content);
			System.out.println(writer);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, boardNum); 
			pstmt.setString(2, content);
			pstmt.setString(3, writer);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		System.out.println("민지야 댓글 추가 성공"+result);
		
		return result;
	}
	
	
	public ArrayList<HashMap<String, Object>> selectqnaComment(Connection con, String boardNum) {
		ArrayList<HashMap<String, Object>> commentList = null;
		HashMap<String, Object> hmap = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectqnaComment");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, boardNum);
			
			
			rset = pstmt.executeQuery();
			
			commentList = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()){
				hmap = new HashMap<String, Object>();
				
				hmap.put("nickname", rset.getString("nickname"));
				hmap.put("comment_date", rset.getString("comment_date"));
				hmap.put("comment_content", rset.getString("comment_content"));
				
				commentList.add(hmap);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return commentList;
	}

}
