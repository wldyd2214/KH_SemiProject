package com.kh.nuriter.nuriter.model.dao;

import static com.kh.nuriter.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.nuriter.nuriter.model.vo.Attachment;
import com.kh.nuriter.nuriter.model.vo.Category;
import com.kh.nuriter.nuriter.model.vo.Nuriboss;
import com.kh.nuriter.nuriter.model.vo.Nuriter;

public class NuriterDao {

	private Properties prop = new Properties();

	public NuriterDao() {
		String fileName = NuriterDao.class.getResource("/sql/nuriter/nuriter-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//누리터 개설
	public int insertNuriter(Connection con, Nuriter n) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertNuriter");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, n.getOwnerNum()); //회원번호
			pstmt.setString(2, n.getCategoryNum()); //카테고리 넘버
			pstmt.setString(3, n.getNuriTitle()); //제목
			pstmt.setString(4, n.getContent()); //내용
			pstmt.setDate(5, n.getStartDate()); //시작
			pstmt.setDate(6, n.getEndDate()); //종료
			pstmt.setString(7, n.getStartTime()); //시작 종료 시간
			pstmt.setString(8, n.getPlace()); //장소
			pstmt.setString(9, n.getPrice()); //가격
			pstmt.setString(10, n.getPersonnel()); //총원
			pstmt.setInt(11, n.getAttendCount()); //총 출석일수

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Category> selectCategoryList(Connection con, String name) {
		ArrayList<Category> list = null;
		/*Statement stmt = null;*/
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectCategoryList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);

			rset = pstmt.executeQuery();

			list = new ArrayList<Category>();

			while(rset.next()) {
				Category c = new Category();
				c.setCno(rset.getString("CATEGORY_ID"));
				c.setCname(rset.getString("category_name"));

				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public int insertNuriBoss(Connection con, Nuriboss n) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertNuriBoss");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, n.getUserNum()); //회원번호
			pstmt.setString(2, n.getCategoryNum()); //카테고리 넘버
			pstmt.setString(3, n.getBossContent()); //제목

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	//누리터 번호 가져오기
	public String selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String nuriNum = " ";

		String query = prop.getProperty("selectCurrval");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				nuriNum = rset.getString(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(stmt);
			close(rset);
		}

		return nuriNum;
	}

	//누리터 개설시 Board, 썸네일 테이블에 데이터 삽입 
	public int insertNuriterBoard(Connection con, Nuriter n) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertNuriterBoard");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, n.getNuriTitle()); //게시판 제목
			pstmt.setString(2, n.getContent()); //게시판 내용
			pstmt.setString(3, n.getOwnerNum()); //작성자 번호
			pstmt.setString(4, n.getNuriNum()); //누리터 번호

			System.out.println("누리터 번호당 =>" + n.getNuriNum());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	//Board 번호 가져오기
	public String selectBoardCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String BoardNum = " ";

		String query = prop.getProperty("selectBoardCurrval");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				BoardNum = rset.getString(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(stmt);
			close(rset);
		}

		return BoardNum;
	}

	//누리터 개설시 대표 사진 등록 기능
	public int insertNuriterAttachment(Connection con, Nuriter n, ArrayList<Attachment> fileList, String BoardId) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertBoardAttachment");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, BoardId); //현재 게시판 번호
			pstmt.setString(2, fileList.get(0).getOrigin()); //사진이름
			pstmt.setString(3, fileList.get(0).getChange()); //바꿀사진이름
			pstmt.setString(4, fileList.get(0).getPath()); //파일경로

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	//누리터 사진 테이블을 사용하지 않아 주석 처리함
	/*public int insertNuriterPoto(Connection con, Nuriter n, ArrayList<Attachment> fileList) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertNuriPoto");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, n.getNuriNum()); //누리터번호
			pstmt.setString(2, fileList.get(0).getOrigin()); //카테고리 넘버
			pstmt.setString(3, fileList.get(0).getChange()); //제목
			pstmt.setString(4, fileList.get(0).getPath()); //파일경로

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}*/

	public int getListCount(Connection con, String userNum) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("listCount");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userNum);
			rset = pstmt.executeQuery();

			if(rset.next()){
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<Nuriter> selectOpenList(Connection con, int currentPage, int limit, String userNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Nuriter> list = null;

		String query = prop.getProperty("selectOpenList");
		System.out.println(query);
		try {
			//stmt = con.createStatement();
			//rset = stmt.executeQuery(query);
			pstmt = con.prepareStatement(query);

			//조회 시작 할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, userNum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			if(rset != null){
				list = new ArrayList<Nuriter>();
				while(rset.next()){
					Nuriter n = new Nuriter();
					n.setNuriTitle(rset.getString("nuri_name"));
					System.out.println(n.getNuriTitle());
					System.out.println("받았니?");
					n.setStartDate(rset.getDate("start_date"));
					System.out.println(n.getStartDate());
					n.setEndDate(rset.getDate("end_date"));
					System.out.println(n.getEndDate());
					n.setPlace(rset.getString("place"));
					System.out.println(n.getPlace());
					n.setPrice(rset.getString("price"));
					System.out.println(n.getPrice());
					n.setApplicationDate(rset.getDate("application_date"));
					System.out.println(n.getApplicationDate());

					list.add(n);

				}
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//close(stmt);
			close(rset);
			close(pstmt);
		}



		return list;


	}

	//누리터 리스트 출력 기능
	public ArrayList<Nuriter> selectNuriterList(Connection con, String category) {
		ArrayList<Nuriter> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Nuriter n = null;

		String query = prop.getProperty("selectNuriterList");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, category);

			rset = pstmt.executeQuery();

			list = new ArrayList<Nuriter>();

			while(rset.next()){
				n = new Nuriter();

				n.setNuriNum(rset.getString("NURI_NUMBER"));
				n.setOwnerNum(rset.getString("OWNER_NUMBER"));
				n.setCategoryNum(rset.getString("CATEGORY_ID"));
				n.setNuriNum(rset.getString("NURI_NAME"));
				n.setContent(rset.getString("NCONTENT"));
				n.setStartDate(rset.getDate("START_DATE"));
				n.setEndDate(rset.getDate("END_DATE"));
				n.setStartTime(rset.getString("START_TIME"));
				n.setPlace(rset.getString("PLACE"));
				n.setPrice(rset.getString("PRICE"));
				n.setApplicationDate(rset.getDate("APPLICATION_DATE"));
				n.setPersonnel(rset.getString("PERSONNEL"));
				/*System.out.println(rset.getInt("REPORT_COUNT"));
				n.setReportCount(rset.getInt("REPORT_COUNT"));*/
				n.setProgress(rset.getString("PROGRESS"));
				n.setAttendCount(rset.getInt("ATTEND_COUNT"));

				list.add(n);
				System.out.println("누리터 DAO에서 list.add 성공");
			}

			System.out.println("selectNuriterList: " + list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	/*public ArrayList<HashMap<String, Object>> selectThumbnailList(Connection con, int currentPage, int limit) {
		ArrayList<HashMap<String, Object>> pictureList = null;
		HashMap<String, Object> hmap = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectNuriterThumbnailMap");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			pictureList = new ArrayList<HashMap<String, Object>>();

			while(rset.next()){
				hmap = new HashMap<String, Object>();

				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("owner_number", rset.getString("owner_number"));
				hmap.put("nickname", rset.getString("nickname"));
				hmap.put("nuri_name", rset.getString("nuri_name"));
				hmap.put("category_name", rset.getString("category_name"));
				hmap.put("ncontent", rset.getString("ncontent"));
				hmap.put("start_date", rset.getDate("start_date"));
				hmap.put("end_date", rset.getString("end_date"));
				hmap.put("start_time", rset.getString("start_time"));
				hmap.put("place", rset.getString("place"));
				hmap.put("price", rset.getInt("price"));
				hmap.put("application_date", rset.getDate("application_date"));
				hmap.put("personnel", rset.getInt("personnel"));
				hmap.put("progress", rset.getString("PROGRESS"));
				hmap.put("attend", rset.getShort("attend_count"));
				hmap.put("fid", rset.getString("fid"));
				hmap.put("origin_name", rset.getString("origin_name"));
				hmap.put("change_name", rset.getString("change_name"));
				hmap.put("file_path", rset.getString("file_path"));
				hmap.put("upload_date", rset.getDate("upload_date"));

				pictureList.add(hmap);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return pictureList;
	}*/

	//해당 카테고리를 카운트하는 기능
	public int getNuriterListCount(Connection con, String category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;

		String query = prop.getProperty("nuriterListCount");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, category);

			rset = pstmt.executeQuery();

			if(rset.next()){
				listCount = rset.getInt(1);
			}

			System.out.println("DAO의 listCount => " + listCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}


		return listCount;
	}

	public ArrayList<Nuriter> selectEndList(Connection con, int currentPage, int limit, String userNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Nuriter> list = null;

		String query = prop.getProperty("selectEndedList");

		try {
			//stmt = con.createStatement();
			//rset = stmt.executeQuery(query);
			pstmt = con.prepareStatement(query);

			//조회 시작 할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, userNum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			if(rset != null){
				list = new ArrayList<Nuriter>();
				while(rset.next()){
					Nuriter n = new Nuriter();
					n.setNuriTitle(rset.getString("nuri_name"));
					System.out.println(n.getNuriTitle());
					n.setStartDate(rset.getDate("start_date"));
					System.out.println(n.getStartDate());
					n.setEndDate(rset.getDate("end_date"));
					System.out.println(n.getEndDate());
					n.setPlace(rset.getString("place"));
					System.out.println(n.getPlace());
					n.setPrice(rset.getString("price"));
					System.out.println(n.getPrice());
					n.setApplicationDate(rset.getDate("application_date"));
					System.out.println(n.getApplicationDate());

					list.add(n);

				}
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//close(stmt);
			close(rset);
			close(pstmt);
		}



		return list;

	}


	public int updateCount(Connection con, String num) {
		System.out.println("업데이트 카운트 실행 중");
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			pstmt.setString(2, num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}


		System.out.println("업데이트 카운트 실행완료");

		return result;
	}

	public Nuriter selectOne(Connection con, String num, int interest, int enterCount) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Nuriter n = null;

		String query = prop.getProperty("selectOne");

		try {
			pstmt = con.prepareStatement(query);
			System.out.println("num=" + num);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				n = new Nuriter();

				n.setNuriNum(rset.getString("nuri_number"));
				n.setCategoryName(rset.getString("category_name"));
				n.setNickName(rset.getString("nickname"));
				n.setOwnerNum(rset.getString("owner_number"));
				n.setCategoryNum(rset.getString("category_id"));
				n.setNuriTitle(rset.getString("nuri_name"));
				n.setContent(rset.getString("ncontent"));
				n.setStartDate(rset.getDate("start_date"));
				n.setEndDate(rset.getDate("END_DATE"));
				n.setStartTime(rset.getString("START_TIME"));
				n.setPlace(rset.getString("place"));
				n.setPrice(rset.getString("price"));
				n.setApplicationDate(rset.getDate("application_date"));
				n.setPersonnel(rset.getString("PERSONNEL"));
				n.setProgress(rset.getString("progress"));
				n.setAttendCount(rset.getInt("attend_count"));
				n.setInterestCount(interest);
				n.setEnterCount(enterCount);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}


		return n;


	}
  
  public ArrayList<HashMap<String, Object>> selectMyThumbnailList(Connection con, int currentPage, int limit,
         String userNum) {
      ArrayList<HashMap<String, Object>> pictureList = null;
      HashMap<String, Object> hmap = null;
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = prop.getProperty("selectMyNuriterThumbnailMap");
      
      try {
         pstmt = con.prepareStatement(query);
         
         int startRow = (currentPage - 1) * limit + 1;
         int endRow = startRow + limit - 1;
         
         pstmt.setString(1, userNum);
         pstmt.setInt(2, startRow);
         pstmt.setInt(3, endRow);
         
         rset = pstmt.executeQuery();
         
         pictureList = new ArrayList<HashMap<String, Object>>();
         
         while(rset.next()){
            hmap = new HashMap<String, Object>();
            
            hmap.put("nuri_number", rset.getString("nuri_number"));
            hmap.put("owner_number", rset.getString("owner_number"));
            hmap.put("nickname", rset.getString("nickname"));
            hmap.put("nuri_name", rset.getString("nuri_name"));
            hmap.put("category_name", rset.getString("category_name"));
            hmap.put("ncontent", rset.getString("ncontent"));
            hmap.put("start_date", rset.getDate("start_date"));
            hmap.put("end_date", rset.getString("end_date"));
            hmap.put("start_time", rset.getString("start_time"));
            hmap.put("place", rset.getString("place"));
            hmap.put("price", rset.getInt("price"));
            hmap.put("application_date", rset.getDate("application_date"));
            hmap.put("personnel", rset.getInt("personnel"));
            /*hmap.put("progress", rset.getString("PROGRESS"));*/
            /*hmap.put("attend", rset.getShort("attend_count"));*/
            hmap.put("fid", rset.getString("fid"));
            hmap.put("origin_name", rset.getString("origin_name"));
            hmap.put("change_name", rset.getString("change_name"));
            hmap.put("file_path", rset.getString("file_path"));
            hmap.put("upload_date", rset.getDate("upload_date"));
            
            pictureList.add(hmap);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      
      return pictureList;
   }

	public ArrayList<Nuriboss> selectNuribossList2(Connection con, int currentPage, int limit) {
		ArrayList<Nuriboss> bossList2 = null;
		PreparedStatement pstmt = null;
		/*Statement stmt = null;*/
		ResultSet rset = null;
		Nuriboss nb = null;

		String query = prop.getProperty("selectNuribossList2");

		try {
			/*stmt = con.createStatement();
				rset = stmt.executeQuery(query);*/

			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			bossList2 = new ArrayList<Nuriboss>();

			while(rset.next()){
				nb = new Nuriboss();

				nb.setApplyNum(rset.getString("apply_id"));
				nb.setUserNum(rset.getString("user_number"));
				nb.setUserName(rset.getString("user_name"));
				nb.setCategoryNum(rset.getString("category_name"));
				nb.setBossContent(rset.getString("newnuri_content"));
				nb.setPotoPath(rset.getString("planfile_path"));
				nb.setPotoName(rset.getString("planfile_name"));
				nb.setApplyDate(rset.getDate("apply_date"));

				bossList2.add(nb);
			}

			System.out.println(bossList2);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return bossList2;

	}
	public int getMyNuriListCount(Connection con, String userNum) {
	      PreparedStatement pstmt = null;
	       int listCount = 0;
	       ResultSet rset = null;
	         
	       String query = prop.getProperty("myNuriListCount");
	         
	         try {
	            pstmt = con.prepareStatement(query);
	            
	            pstmt.setString(1, userNum);
	            rset = pstmt.executeQuery();
	            
	            if(rset.next()){
	               listCount = rset.getInt(1);
	            }
	            
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }finally{
	            close(rset);
	            close(pstmt);
	         }
	         
	         return listCount;
	   }

	   public ArrayList<Nuriter> selectMyNuriList(Connection con, int currentPage, int limit, String userNum) {
	         PreparedStatement pstmt = null;
	         ResultSet rset = null;
	         
	         ArrayList<Nuriter> list = null;
	         
	         String query = prop.getProperty("selectMyNuriList");
	         System.out.println(query);
	         try {
	            //stmt = con.createStatement();
	            //rset = stmt.executeQuery(query);
	            pstmt = con.prepareStatement(query);
	            
	            //조회 시작 할 행 번호와 마지막 행 번호 계산
	             int startRow = (currentPage - 1) * limit + 1;
	             int endRow = startRow + limit - 1;
	             
	             pstmt.setString(1, userNum);
	             pstmt.setInt(2, startRow);
	             pstmt.setInt(3, endRow);
	             rset = pstmt.executeQuery();
	            
	            if(rset != null){
	               list = new ArrayList<Nuriter>();
	               while(rset.next()){
	                  Nuriter n = new Nuriter();
	                  n.setNuriNum(rset.getString("nuri_number"));
	                  System.out.println(n.getNuriNum());
	                  n.setNuriTitle(rset.getString("nuri_name"));
	                  System.out.println(n.getNuriTitle());
	                  //n.setOwnerNum(rset.getString("nickname"));
	                  //System.out.println(n.getOwnerNum());
	                  n.setStartDate(rset.getDate("start_date"));
	                  System.out.println(n.getStartDate());
	                  n.setEndDate(rset.getDate("end_date"));
	                  System.out.println(n.getEndDate());
	                  n.setPlace(rset.getString("place"));
	                  System.out.println(n.getPlace());
	                  n.setPrice(rset.getString("price"));
	                  System.out.println(n.getPrice());
	                  n.setApplicationDate(rset.getDate("application_date"));
	                  System.out.println(n.getApplicationDate());
	                  
	                  list.add(n);
	                  
	               }
	            }
	            
	            
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }finally{
	            //close(stmt);
	            close(rset);
	            close(pstmt);
	         }
	         
	         
	         
	         return list;
	   }

	public ArrayList<Nuriter> selectOpenList1(Connection con, int currentPage, int limit, String userNum) {
		 PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      ArrayList<Nuriter> list = null;
	      
	      String query = prop.getProperty("selectOpenList1");
	      System.out.println(query);
	      try {
	         //stmt = con.createStatement();
	         //rset = stmt.executeQuery(query);
	         pstmt = con.prepareStatement(query);
	         
	         //조회 시작 할 행 번호와 마지막 행 번호 계산
	          int startRow = (currentPage - 1) * limit + 1;
	          int endRow = startRow + limit - 1;
	          
	          pstmt.setString(1, userNum);
	          /*pstmt.setInt(2, startRow);
	          pstmt.setInt(3, endRow);*/
	          rset = pstmt.executeQuery();
	         
	         if(rset != null){
	            list = new ArrayList<Nuriter>();
	            while(rset.next()){
	               Nuriter n = new Nuriter();
	               n.setNuriNum(rset.getString("nuri_number"));
	               System.out.println(n.getNuriNum());
	               n.setNuriTitle(rset.getString("nuri_name"));
	               System.out.println(n.getNuriTitle());
	               System.out.println("받았니?");
	               n.setStartDate(rset.getDate("start_date"));
	               System.out.println(n.getStartDate());
	               n.setEndDate(rset.getDate("end_date"));
	               System.out.println(n.getEndDate());
	               n.setPlace(rset.getString("place"));
	               System.out.println(n.getPlace());
	               n.setPrice(rset.getString("price"));
	               System.out.println(n.getPrice());
	               n.setApplicationDate(rset.getDate("application_date"));
	               System.out.println(n.getApplicationDate());
	               
	               list.add(n);
	               
	            }
	         }
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally{
	         //close(stmt);
	    	  close(rset);
	         close(pstmt);
	      }
	      
	      
	      
	      return list;
	}
	
	 public ArrayList<Nuriter> selectMyNuriList1(Connection con, int currentPage, int limit, String userNum) {
		 PreparedStatement pstmt = null;
         ResultSet rset = null;
         
         ArrayList<Nuriter> list1 = null;
         
         String query = prop.getProperty("selectMyNuriList1");
         System.out.println(query);
         try {
            //stmt = con.createStatement();
            //rset = stmt.executeQuery(query);
            pstmt = con.prepareStatement(query);
            
            //조회 시작 할 행 번호와 마지막 행 번호 계산
             int startRow = (currentPage - 1) * limit + 1;
             int endRow = startRow + limit - 1;
             
             pstmt.setString(1, userNum);
             pstmt.setInt(2, startRow);
             pstmt.setInt(3, endRow);
             rset = pstmt.executeQuery();
            
            if(rset != null){
               list1 = new ArrayList<Nuriter>();
               while(rset.next()){
                  Nuriter n = new Nuriter();
                  n.setNuriNum(rset.getString("nuri_number"));
	               System.out.println(n.getNuriNum());
	               n.setNuriTitle(rset.getString("nuri_name"));
	               System.out.println(n.getNuriTitle());
	               System.out.println("받았니?");
	               n.setStartDate(rset.getDate("start_date"));
	               System.out.println(n.getStartDate());
	               n.setEndDate(rset.getDate("end_date"));
	               System.out.println(n.getEndDate());
	               n.setPlace(rset.getString("place"));
	               System.out.println(n.getPlace());
	               n.setPrice(rset.getString("price"));
	               System.out.println(n.getPrice());
	               n.setApplicationDate(rset.getDate("application_date"));
	               System.out.println(n.getApplicationDate());
                  
                  list1.add(n);
                  
               }
            }
            
            
         } catch (SQLException e) {
            e.printStackTrace();
         }finally{
            //close(stmt);
            close(rset);
            close(pstmt);
         }
         
         
         
         return list1;
   }  

	 public ArrayList<Nuriboss> selectNuribossList(Connection con, int currentPage, int limit) {
         ArrayList<Nuriboss> bossList = null;
         PreparedStatement pstmt = null;
         ResultSet rset = null;
         Nuriboss nb = null;
         
         String query = prop.getProperty("selectNuribossList");
         
         try {
            pstmt = con.prepareStatement(query);
            
            int startRow = (currentPage - 1) * limit + 1;
            int endRow = startRow + limit - 1;
            
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, endRow);
            
            rset = pstmt.executeQuery();
            
            bossList = new ArrayList<Nuriboss>();
            
            while(rset.next()){
               nb = new Nuriboss();
               
               nb.setApplyNum(rset.getString("apply_id"));
               nb.setUserNum(rset.getString("user_number"));
               nb.setUserName(rset.getString("user_name"));
               nb.setCategoryNum(rset.getString("category_name"));
               nb.setBossContent(rset.getString("newnuri_content"));
               nb.setPotoPath(rset.getString("planfile_path"));
               nb.setPotoName(rset.getString("planfile_name"));
               nb.setApplyDate(rset.getDate("apply_date"));
               
               bossList.add(nb);
            }
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            close(rset);
            close(pstmt);
         }
         return bossList;
	}

	public Nuriter selectOpenOne(Connection con, String nunum) {
		Nuriter n = new Nuriter();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("updateCount");
		/*String query = null;*/	
		try {

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			pstmt.setString(2, nunum);
			rset = pstmt.executeQuery();

			query = prop.getProperty("selectOpenOne");

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nunum);
			rset = pstmt.executeQuery();

			System.out.println("rest : " + rset);

			while(rset.next()){		
				n.setNuriNum(rset.getString("nuri_number"));
				System.out.println(n.getNuriNum());
				n.setNuriTitle(rset.getString("nuri_name"));
				System.out.println(n.getNuriTitle());
				System.out.println("받았니?");
				n.setStartDate(rset.getDate("start_date"));
				System.out.println(n.getStartDate());
				n.setEndDate(rset.getDate("end_date"));
				System.out.println(n.getEndDate());
				n.setPlace(rset.getString("place"));
				System.out.println(n.getPlace());
				n.setPrice(rset.getString("price"));
				System.out.println(n.getPrice());
				n.setApplicationDate(rset.getDate("application_date"));
				System.out.println(n.getApplicationDate());
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);

		}


		return n;

	}

	public int getMyNuriterListCount(Connection con, String userNum) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectMyNuriterListCount");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userNum);
			rset = pstmt.executeQuery();

			if(rset.next()){
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}

		return listCount;
	}


	public ArrayList<Nuriter> selectMyNuriterList(Connection con, String userNum) {
		ArrayList<Nuriter> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Nuriter n = null;

		String query = prop.getProperty("selectMyNuriterList");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userNum);

			rset = pstmt.executeQuery();

			list = new ArrayList<Nuriter>();

			while(rset.next()){
				n = new Nuriter();

				n.setNuriNum(rset.getString("NURI_NUMBER"));
				n.setOwnerNum(rset.getString("OWNER_NUMBER"));
				n.setCategoryNum(rset.getString("CATEGORY_ID"));
				n.setNuriNum(rset.getString("NURI_NAME"));
				n.setContent(rset.getString("NCONTENT"));
				n.setStartDate(rset.getDate("START_DATE"));
				n.setEndDate(rset.getDate("END_DATE"));
				n.setStartTime(rset.getString("START_TIME"));
				n.setPlace(rset.getString("PLACE"));
				n.setPrice(rset.getString("PRICE"));
				n.setApplicationDate(rset.getDate("APPLICATION_DATE"));
				n.setPersonnel(rset.getString("PERSONNEL"));
				/*System.out.println(rset.getInt("REPORT_COUNT"));
				n.setReportCount(rset.getInt("REPORT_COUNT"));*/
				n.setProgress(rset.getString("PROGRESS"));
				n.setAttendCount(rset.getInt("ATTEND_COUNT"));

				list.add(n);
				System.out.println("누리터 DAO에서 list.add 성공");
			}

			System.out.println("selectMyNuriterList: " + list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}


	public ArrayList<HashMap<String, Object>> selectThumbnailList(Connection con, int currentPage, int limit, String category) {
		ArrayList<HashMap<String, Object>> pictureList = null;
		HashMap<String, Object> hmap = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = prop.getProperty("selectNuriterThumbnailMap");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();

			pictureList = new ArrayList<HashMap<String, Object>>();

			while(rset.next()){
				hmap = new HashMap<String, Object>();

				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("owner_number", rset.getString("owner_number"));
				hmap.put("nickname", rset.getString("nickname"));
				hmap.put("nuri_name", rset.getString("nuri_name"));
				hmap.put("category_name", rset.getString("category_name"));
				hmap.put("ncontent", rset.getString("ncontent"));
				hmap.put("start_date", rset.getDate("start_date"));
				hmap.put("end_date", rset.getString("end_date"));
				hmap.put("start_time", rset.getString("start_time"));
				hmap.put("place", rset.getString("place"));
				hmap.put("price", rset.getInt("price"));
				hmap.put("application_date", rset.getDate("application_date"));
				hmap.put("personnel", rset.getInt("personnel"));
				/*hmap.put("progress", rset.getString("PROGRESS"));*/
				/*hmap.put("attend", rset.getShort("attend_count"));*/
				hmap.put("fid", rset.getString("fid"));
				hmap.put("origin_name", rset.getString("origin_name"));
				hmap.put("change_name", rset.getString("change_name"));
				hmap.put("file_path", rset.getString("file_path"));
				hmap.put("upload_date", rset.getDate("upload_date"));

				pictureList.add(hmap);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return pictureList;
	}


	public ArrayList<Nuriter> selectDoneNuriList(Connection con, int currentPage, int limit, String userNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Nuriter> list = null;

		String query = prop.getProperty("selectDoneNuriList");
		System.out.println(query);
		try {
			//stmt = con.createStatement();
			//rset = stmt.executeQuery(query);
			pstmt = con.prepareStatement(query);

			//조회 시작 할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, userNum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();

			if(rset != null){
				list = new ArrayList<Nuriter>();
				while(rset.next()){
					Nuriter n = new Nuriter();
					n.setNuriTitle(rset.getString("nuri_name"));
					System.out.println(n.getNuriTitle());
					n.setOwnerNum(rset.getString("nickname"));
					System.out.println(n.getOwnerNum());
					n.setStartDate(rset.getDate("start_date"));
					System.out.println(n.getStartDate());
					n.setEndDate(rset.getDate("end_date"));
					System.out.println(n.getEndDate());
					n.setPlace(rset.getString("place"));
					System.out.println(n.getPlace());
					n.setPrice(rset.getString("price"));
					System.out.println(n.getPrice());
					n.setApplicationDate(rset.getDate("application_date"));
					System.out.println(n.getApplicationDate());

					list.add(n);

				}
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//close(stmt);
			close(rset);
			close(pstmt);
		}



		return list;
	}


	public int getDoneNuriListCount(Connection con, String userNum) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("myDoneNuriListCount");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userNum);
			rset = pstmt.executeQuery();

			if(rset.next()){
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}

		return listCount;
	}


	public int deleteMyNuri(Connection con, String userNum, String nuriNum) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteMyNuri");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNum);
			pstmt.setString(2, nuriNum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}


		return result;
	}


	public int getNuribossListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("nuribossListCount");

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
	
	public int getNuribossListCount2(Connection con) {
		int listCount2 = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("nuribossListCount2");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				listCount2 = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}

		return listCount2;
	}


	public Nuriboss selectOneNuriboss(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Nuriboss nb = null;

		String query = prop.getProperty("selectOneNuriboss");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()){
				nb = new Nuriboss();

				nb.setApplyNum(rset.getString("apply_id"));
				nb.setUserNum(rset.getString("user_name"));
				nb.setCategoryNum(rset.getString("category_name"));
				nb.setBossContent(rset.getString("newnuri_content"));
				nb.setPotoPath(rset.getString("planfile_path"));
				nb.setPotoName(rset.getString("planfile_name"));
				nb.setApplyDate(rset.getDate("apply_date"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return nb;
	}

	public int insertNuriterHobby(Connection con, String userNum, String name) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertNuriterHobby");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name); 
			pstmt.setString(2, userNum); 

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		System.out.println("관심누리터 추가 성공");

		return result;
	}

	public int getMyTemptingListCount(Connection con, String userNum) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectMyTemptingListCount");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userNum);
			rset = pstmt.executeQuery();

			if(rset.next()){
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}

		return listCount;
	}


	public ArrayList<Nuriter> selectMyTemptingList(Connection con, String userNum) {
		ArrayList<Nuriter> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Nuriter n = null;

		String query = prop.getProperty("selectMyTemptingList");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userNum);

			rset = pstmt.executeQuery();

			list = new ArrayList<Nuriter>();

			while(rset.next()){
				n = new Nuriter();

				n.setNuriNum(rset.getString("NURI_NUMBER"));
				n.setOwnerNum(rset.getString("OWNER_NUMBER"));
				n.setCategoryNum(rset.getString("CATEGORY_ID"));
				n.setNuriNum(rset.getString("NURI_NAME"));
				n.setContent(rset.getString("NCONTENT"));
				n.setStartDate(rset.getDate("START_DATE"));
				n.setEndDate(rset.getDate("END_DATE"));
				n.setStartTime(rset.getString("START_TIME"));
				n.setPlace(rset.getString("PLACE"));
				n.setPrice(rset.getString("PRICE"));
				n.setApplicationDate(rset.getDate("APPLICATION_DATE"));
				n.setPersonnel(rset.getString("PERSONNEL"));
				/*System.out.println(rset.getInt("REPORT_COUNT"));
				n.setReportCount(rset.getInt("REPORT_COUNT"));*/
				n.setProgress(rset.getString("PROGRESS"));
				n.setAttendCount(rset.getInt("ATTEND_COUNT"));

				list.add(n);
				System.out.println("누리터 DAO에서 list.add 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("selectMyTemptingList: " + list);
		return list;
				
	}
		

	public int updateNuribossStatus(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateNuribossStatus");

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


	public ArrayList<HashMap<String, Object>> selectMyTemptingThumbnailList(Connection con, int currentPage, int limit,
			String userNum) {
		ArrayList<HashMap<String, Object>> pictureList = null;
		HashMap<String, Object> hmap = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectMyTemptingThumbnailMap");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, userNum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			pictureList = new ArrayList<HashMap<String, Object>>();

			while(rset.next()){
				hmap = new HashMap<String, Object>();

				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("owner_number", rset.getString("owner_number"));
				hmap.put("nickname", rset.getString("nickname"));
				hmap.put("nuri_name", rset.getString("nuri_name"));
				hmap.put("category_name", rset.getString("category_name"));
				hmap.put("ncontent", rset.getString("ncontent"));
				hmap.put("start_date", rset.getDate("start_date"));
				hmap.put("end_date", rset.getString("end_date"));
				hmap.put("start_time", rset.getString("start_time"));
				hmap.put("place", rset.getString("place"));
				hmap.put("price", rset.getInt("price"));
				hmap.put("application_date", rset.getDate("application_date"));
				hmap.put("personnel", rset.getInt("personnel"));
				/*hmap.put("progress", rset.getString("PROGRESS"));*/
				/*hmap.put("attend", rset.getShort("attend_count"));*/
				hmap.put("fid", rset.getString("fid"));
				hmap.put("origin_name", rset.getString("origin_name"));
				hmap.put("change_name", rset.getString("change_name"));
				hmap.put("file_path", rset.getString("file_path"));
				hmap.put("upload_date", rset.getDate("upload_date"));

				pictureList.add(hmap);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return pictureList;
	}

	//누리터 번호를 참조하는 BOARD 테이블의 번호 가져오는 기능
	public String selectBoardNumber(Connection con, String nuriNum) {
		ResultSet rset = null;
		String BoardNumber = " ";
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("selectBoardNumber_Park");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nuriNum);  
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				BoardNumber = rset.getString(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return BoardNumber;
	}


	public int insertNuriterComment(Connection con, String nuriNum, String content, String writer, String boardNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertNuriterComment_Park");
		
		try {
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
		
		System.out.println("댓글 추가 성공");
		
		return result;
	}

	//댓글 리스트 가져오기
	public ArrayList<HashMap<String, Object>> selectNuriterComment(Connection con, String nuriNum) {
		ArrayList<HashMap<String, Object>> commentList = null;
		HashMap<String, Object> hmap = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBoardComment_Park");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, nuriNum);
			
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

	public int interestCount(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int interestCount = 0;
		
		String query = prop.getProperty("interestCount_Park");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, num);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				interestCount = rset.getInt(1);
			}
			
			System.out.println(interestCount + "명이 관심을 가지고 있습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return interestCount;
	}


	public int enterCount(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int enterCount = 0;
		
		String query = prop.getProperty("enterCount_Park");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, num);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				enterCount = rset.getInt(1);
			}
			
			System.out.println(enterCount + "명이 신청을 했습니다.");
      
      } catch (SQLException e) {
			  e.printStackTrace();
		  } finally {
        close(rset);
			  close(pstmt);
		}
		
		return enterCount;

	}

	public int updateMemberGrade(Connection con, String num2) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateMemberGradeEB");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num2);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteNuriboss(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteNuribossEB");
		
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



	public ArrayList<Nuriter> selectEndedNuriterList(Connection con, int currentPage, int limit, String userNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Nuriter> list = null;
		Nuriter nu = null;
		
		String query = prop.getProperty("selectEndedNuriterList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, userNum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Nuriter>();
			
			while(rset.next()){
				nu = new Nuriter();
				nu.setNuriNum(rset.getString("nuri_number"));
				nu.setOwnerNum(rset.getString("owner_number"));
				nu.setOwnerName(rset.getString("user_name"));
				nu.setCategoryName(rset.getString("category_name"));
				nu.setNuriTitle(rset.getString("nuri_name"));
				nu.setContent(rset.getString("ncontent"));
				nu.setStartDate(rset.getDate("start_date"));
				nu.setEndDate(rset.getDate("end_date"));
				nu.setStartTime(rset.getString("start_time"));
				nu.setPlace(rset.getString("place"));
				nu.setPrice(rset.getString("price"));
				nu.setApplicationDate(rset.getDate("application_date"));
				nu.setPersonnel(rset.getString("personnel"));
				nu.setReportCount(rset.getInt("report_count"));
				nu.setProgress(rset.getString("progress"));
				nu.setAttendCount(rset.getInt("attend_count"));
				
				list.add(nu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
    }
		

	public int getSearchNuriterListCount(Connection con, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;

		String query = prop.getProperty("nuriterSearchListCount_Park");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, search);

			rset = pstmt.executeQuery();

			if(rset.next()){
				listCount = rset.getInt(1);
			}

			System.out.println("DAO의 listCount => " + listCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}


		return listCount;
	}


	public ArrayList<Nuriter> selectSearchNuriterList(Connection con, String search) {
		ArrayList<Nuriter> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Nuriter n = null;

		String query = prop.getProperty("selectSearchNuriterList_Park");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, search);

			rset = pstmt.executeQuery();

			list = new ArrayList<Nuriter>();

			while(rset.next()){
				n = new Nuriter();

				n.setNuriNum(rset.getString("NURI_NUMBER"));
				n.setOwnerNum(rset.getString("OWNER_NUMBER"));
				n.setCategoryNum(rset.getString("CATEGORY_ID"));
				n.setNuriNum(rset.getString("NURI_NAME"));
				n.setContent(rset.getString("NCONTENT"));
				n.setStartDate(rset.getDate("START_DATE"));
				n.setEndDate(rset.getDate("END_DATE"));
				n.setStartTime(rset.getString("START_TIME"));
				n.setPlace(rset.getString("PLACE"));
				n.setPrice(rset.getString("PRICE"));
				n.setApplicationDate(rset.getDate("APPLICATION_DATE"));
				n.setPersonnel(rset.getString("PERSONNEL"));
				/*System.out.println(rset.getInt("REPORT_COUNT"));*/
				n.setReportCount(rset.getInt("REPORT_COUNT"));
				n.setProgress(rset.getString("PROGRESS"));
				n.setAttendCount(rset.getInt("ATTEND_COUNT"));

				list.add(n);
				System.out.println("누리터 DAO에서 list.add 성공");
			}

			System.out.println("selectSearchNuriterList: " + list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}


	public ArrayList<HashMap<String, Object>> selectSearchThumbnailList(Connection con, int currentPage, int limit,
			String search) {
		ArrayList<HashMap<String, Object>> pictureList = null;
		HashMap<String, Object> hmap = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectSearchNuriterThumbnailMap_Park");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, search);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			pictureList = new ArrayList<HashMap<String, Object>>();

			while(rset.next()){
				hmap = new HashMap<String, Object>();

				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("owner_number", rset.getString("owner_number"));
				hmap.put("nickname", rset.getString("nickname"));
				hmap.put("nuri_name", rset.getString("nuri_name"));
				hmap.put("category_name", rset.getString("category_name"));
				hmap.put("ncontent", rset.getString("ncontent"));
				hmap.put("start_date", rset.getDate("start_date"));
				hmap.put("end_date", rset.getString("end_date"));
				hmap.put("start_time", rset.getString("start_time"));
				hmap.put("place", rset.getString("place"));
				hmap.put("price", rset.getInt("price"));
				hmap.put("application_date", rset.getDate("application_date"));
				hmap.put("personnel", rset.getInt("personnel"));
				/*hmap.put("progress", rset.getString("PROGRESS"));*/
				/*hmap.put("attend", rset.getShort("attend_count"));*/
				hmap.put("fid", rset.getString("fid"));
				hmap.put("origin_name", rset.getString("origin_name"));
				hmap.put("change_name", rset.getString("change_name"));
				hmap.put("file_path", rset.getString("file_path"));
				hmap.put("upload_date", rset.getDate("upload_date"));

				pictureList.add(hmap);
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return pictureList;
  }



	public int getNuriPrice(Connection con, String nuriNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("getNuriPrice");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nuriNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("가격 : " + result);
		return result;
	}

	public String getOwnerNum(Connection con, String nuriNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String name = "";
		
		String query = prop.getProperty("getOwnerNum");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nuriNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				name = rset.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return name;
	}

	public int updateNuriter(Connection con, String nuriNum, String title, String content) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateNuriter_Park");
		
		System.out.println(nuriNum);
		System.out.println(title);
		System.out.println(content);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, nuriNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateBoard(Connection con, String nuriNum, String title, String content) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateBoard_Park");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, nuriNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public ArrayList<HashMap<String, Object>> selectThumbnailList1(Connection con) {
		ArrayList<HashMap<String, Object>> pictureList = null;
		HashMap<String, Object> hmap = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = prop.getProperty("selectNuriterThumbnailMap1");

		try {
			pstmt = con.prepareStatement(query);

			/*int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);*/
			
			rset = pstmt.executeQuery();

			pictureList = new ArrayList<HashMap<String, Object>>();

			while(rset.next()){
				hmap = new HashMap<String, Object>();

				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("owner_number", rset.getString("owner_number"));
				hmap.put("nickname", rset.getString("nickname"));
				hmap.put("nuri_name", rset.getString("nuri_name"));
				hmap.put("category_name", rset.getString("category_name"));
				hmap.put("ncontent", rset.getString("ncontent"));
				hmap.put("start_date", rset.getDate("start_date"));
				hmap.put("end_date", rset.getString("end_date"));
				hmap.put("start_time", rset.getString("start_time"));
				hmap.put("place", rset.getString("place"));
				hmap.put("price", rset.getInt("price"));
				hmap.put("application_date", rset.getDate("application_date"));
				hmap.put("personnel", rset.getInt("personnel"));
				/*hmap.put("progress", rset.getString("PROGRESS"));*/
				/*hmap.put("attend", rset.getShort("attend_count"));*/
				hmap.put("fid", rset.getString("fid"));
				hmap.put("origin_name", rset.getString("origin_name"));
				hmap.put("change_name", rset.getString("change_name"));
				hmap.put("file_path", rset.getString("file_path"));
				hmap.put("upload_date", rset.getDate("upload_date"));

				pictureList.add(hmap);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return pictureList;
	}
	
	public ArrayList<HashMap<String, Object>> selectThumbnailList2(Connection con) {
		ArrayList<HashMap<String, Object>> pictureList2 = null;
		HashMap<String, Object> hmap = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = prop.getProperty("selectNuriterThumbnailMap2");

		try {
			pstmt = con.prepareStatement(query);

			/*int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);*/
			
			rset = pstmt.executeQuery();

			pictureList2 = new ArrayList<HashMap<String, Object>>();

			while(rset.next()){
				hmap = new HashMap<String, Object>();

				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("owner_number", rset.getString("owner_number"));
				hmap.put("nickname", rset.getString("nickname"));
				hmap.put("nuri_name", rset.getString("nuri_name"));
				hmap.put("category_name", rset.getString("category_name"));
				hmap.put("ncontent", rset.getString("ncontent"));
				hmap.put("start_date", rset.getDate("start_date"));
				hmap.put("end_date", rset.getString("end_date"));
				hmap.put("start_time", rset.getString("start_time"));
				hmap.put("place", rset.getString("place"));
				hmap.put("price", rset.getInt("price"));
				hmap.put("application_date", rset.getDate("application_date"));
				hmap.put("personnel", rset.getInt("personnel"));
				/*hmap.put("progress", rset.getString("PROGRESS"));*/
				/*hmap.put("attend", rset.getShort("attend_count"));*/
				hmap.put("fid", rset.getString("fid"));
				hmap.put("origin_name", rset.getString("origin_name"));
				hmap.put("change_name", rset.getString("change_name"));
				hmap.put("file_path", rset.getString("file_path"));
				hmap.put("upload_date", rset.getDate("upload_date"));

				pictureList2.add(hmap);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return pictureList2;
	}
	
	
	public ArrayList<HashMap<String, Object>> selectThumbnailList3(Connection con) {
		ArrayList<HashMap<String, Object>> pictureList3 = null;
		HashMap<String, Object> hmap = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = prop.getProperty("selectNuriterThumbnailMap3");

		try {
			pstmt = con.prepareStatement(query);

			/*int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);*/
			
			rset = pstmt.executeQuery();

			pictureList3 = new ArrayList<HashMap<String, Object>>();

			while(rset.next()){
				hmap = new HashMap<String, Object>();

				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("owner_number", rset.getString("owner_number"));
				hmap.put("nickname", rset.getString("nickname"));
				hmap.put("nuri_name", rset.getString("nuri_name"));
				hmap.put("category_name", rset.getString("category_name"));
				hmap.put("ncontent", rset.getString("ncontent"));
				hmap.put("start_date", rset.getDate("start_date"));
				hmap.put("end_date", rset.getString("end_date"));
				hmap.put("start_time", rset.getString("start_time"));
				hmap.put("place", rset.getString("place"));
				hmap.put("price", rset.getInt("price"));
				hmap.put("application_date", rset.getDate("application_date"));
				hmap.put("personnel", rset.getInt("personnel"));
				/*hmap.put("progress", rset.getString("PROGRESS"));*/
				/*hmap.put("attend", rset.getShort("attend_count"));*/
				hmap.put("fid", rset.getString("fid"));
				hmap.put("origin_name", rset.getString("origin_name"));
				hmap.put("change_name", rset.getString("change_name"));
				hmap.put("file_path", rset.getString("file_path"));
				hmap.put("upload_date", rset.getDate("upload_date"));

				pictureList3.add(hmap);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return pictureList3;
	}


	public int getNuriterChildListCount(Connection con, String category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;

		String query = prop.getProperty("nuriterChildListCount_Park");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, category);

			rset = pstmt.executeQuery();

			if(rset.next()){
				listCount = rset.getInt(1);
			}

			System.out.println("DAO의 listCount => " + listCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}


		return listCount;
	}


	public ArrayList<Nuriter> selectNuriterChildList(Connection con, String category) {
		ArrayList<Nuriter> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Nuriter n = null;

		String query = prop.getProperty("selectNuriterChildList_Park");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, category);

			rset = pstmt.executeQuery();

			list = new ArrayList<Nuriter>();

			while(rset.next()){
				n = new Nuriter();

				n.setNuriNum(rset.getString("NURI_NUMBER"));
				n.setOwnerNum(rset.getString("OWNER_NUMBER"));
				n.setCategoryNum(rset.getString("CATEGORY_ID"));
				n.setNuriNum(rset.getString("NURI_NAME"));
				n.setContent(rset.getString("NCONTENT"));
				n.setStartDate(rset.getDate("START_DATE"));
				n.setEndDate(rset.getDate("END_DATE"));
				n.setStartTime(rset.getString("START_TIME"));
				n.setPlace(rset.getString("PLACE"));
				n.setPrice(rset.getString("PRICE"));
				n.setApplicationDate(rset.getDate("APPLICATION_DATE"));
				n.setPersonnel(rset.getString("PERSONNEL"));
				/*System.out.println(rset.getInt("REPORT_COUNT"));
				n.setReportCount(rset.getInt("REPORT_COUNT"));*/
				n.setProgress(rset.getString("PROGRESS"));
				n.setAttendCount(rset.getInt("ATTEND_COUNT"));

				list.add(n);
				System.out.println("누리터 DAO에서 list.add 성공");
			}

			System.out.println("selectNuriterList: " + list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}


	public ArrayList<HashMap<String, Object>> selectChildThumbnailList(Connection con, int currentPage, int limit,
			String category) {
		ArrayList<HashMap<String, Object>> pictureList = null;
		HashMap<String, Object> hmap = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectNuriterChildThumbnailMap_Park");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			pictureList = new ArrayList<HashMap<String, Object>>();

			while(rset.next()){
				hmap = new HashMap<String, Object>();

				hmap.put("nuri_number", rset.getString("nuri_number"));
				hmap.put("owner_number", rset.getString("owner_number"));
				hmap.put("nickname", rset.getString("nickname"));
				hmap.put("nuri_name", rset.getString("nuri_name"));
				hmap.put("category_name", rset.getString("category_name"));
				hmap.put("ncontent", rset.getString("ncontent"));
				hmap.put("start_date", rset.getDate("start_date"));
				hmap.put("end_date", rset.getString("end_date"));
				hmap.put("start_time", rset.getString("start_time"));
				hmap.put("place", rset.getString("place"));
				hmap.put("price", rset.getInt("price"));
				hmap.put("application_date", rset.getDate("application_date"));
				hmap.put("personnel", rset.getInt("personnel"));
				/*hmap.put("progress", rset.getString("PROGRESS"));*/
				/*hmap.put("attend", rset.getShort("attend_count"));*/
				hmap.put("fid", rset.getString("fid"));
				hmap.put("origin_name", rset.getString("origin_name"));
				hmap.put("change_name", rset.getString("change_name"));
				hmap.put("file_path", rset.getString("file_path"));
				hmap.put("upload_date", rset.getDate("upload_date"));

				pictureList.add(hmap);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return pictureList;
	}


	public int updateNuriterPayStatus(Connection con, String nuriNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateNuriterPayStatus");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nuriNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public String selectNuriterPayStatus(Connection con, String nuriNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = null;
		
		String query = prop.getProperty("getNuriterPayStatus");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nuriNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = rset.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return result;
	}


	public Nuriter selectOneNuriterEB(Connection con, String nuriNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Nuriter nu = null;
		
		String query = prop.getProperty("selectOneNuriterEB");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nuriNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				nu = new Nuriter();
				
				nu.setNuriNum(rset.getString("nuri_number"));
				nu.setOwnerNum(rset.getString("owner_number"));
				nu.setNuriTitle(rset.getString("nuri_name"));
				nu.setPayStatus(rset.getString("pay_status"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return nu;
	}


	public int updateNuribossApproveToN(Connection con, String userNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("changeNuribossApproveToN");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int updateMemberGrade2(Connection con, String userNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMemberGrade2EB");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

}
