package com.kh.nuriter.member.model.dao;

import static com.kh.nuriter.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.nuriter.member.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao(){
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		//System.out.println(fileName);
		
		try {
			prop.load(new FileReader(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Member loginCheck(Connection con, String userEmail, String password) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("loginCheck");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userEmail);
			pstmt.setString(2, password);
			
			System.out.println(pstmt);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				loginUser = new Member();
				
				loginUser.setUserNumber(Integer.parseInt(rset.getString("user_number")));
				loginUser.setUserEmail(rset.getString("user_email"));
				loginUser.setPassword(rset.getString("user_pwd"));
				loginUser.setUserName(rset.getString("user_name"));
				loginUser.setNickName(rset.getString("nickname"));
				loginUser.setAddress(rset.getString("address"));
				loginUser.setPhone(rset.getString("phone"));
				loginUser.setHobby(rset.getString("hobby"));
				loginUser.setBirthDate(rset.getDate("birth_date"));
				loginUser.setEnrollDate(rset.getDate("enroll_date"));
				loginUser.setGrade(rset.getString("grade"));
				loginUser.setGradeDate(rset.getDate("grade_date"));
				loginUser.setBankName(rset.getString("bank_name"));
				loginUser.setBankNumber(rset.getString("bank_number"));
				loginUser.setAccountSort(rset.getString("account_sort"));
				loginUser.setToken(rset.getString("token"));
				loginUser.setReportedUser(rset.getString("reported_user"));
				loginUser.setActivated(rset.getString("activated"));
				loginUser.setActivatedDate(rset.getDate("activated_date"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		
		
		return loginUser;
	}

	public int insertMember(Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getUserEmail());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getNickName());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getHobby());
			pstmt.setDate(8, m.getBirthDate());
			pstmt.setString(9, m.getBankName());
			pstmt.setString(10, m.getBankNumber());
			
			
			result = pstmt.executeUpdate();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		
		return result;
	}

	public int idCheck(Connection con, String userEmail) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("idCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userEmail);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			
			
		}
		return result;
	}

	/*public int snsloginMember(Member m, Connection con) {
		int result=0;
		int sw=0;
		Member m1=null;
		ArrayList<Member> list=new ArrayList<Member>();
		Statement st=null;
		PreparedStatement pst=null;
		ResultSet rset=null;
		String query="";
		query=prop.getProperty("checkMember");
		String checkQuery=prop.getProperty("checkMember");
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
			while(rset.next()){
				m1=new Member();
				m1.setUserEmail(rset.getString("user_email"));
				
				list.add(m1);
			}
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getUserEmail().equals(m.getUserEmail())){
					sw=1;
					break;
				}
			}
			
			
			
			if(sw==1){
				query=prop.getProperty("loginMember");
				
				pst=con.prepareStatement(query);
				pst.setString(1, m.getUserEmail());
				
				result=pst.executeUpdate();
				
				if(result>0){
					result=99;
				}
				else{
					result=0;
				}
				
			}
			else{
				query=prop.getProperty("insertMember2");
				
				pst=con.prepareStatement(query);
				pst.setString(1, m.getUserEmail());
				pst.setString(2, m.getNickName());
				pst.setString(3, m.getToken());
				
				result=pst.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(st);
			close(rset);
			close(pst);
		}
		
		return result;
	}*/

	public int deleteMember(Connection con, Member m) {
	      PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String query = prop.getProperty("deleteMember");
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, m.getUserEmail());
	         pstmt.setString(2, m.getPassword());
	         
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally{
	         close(pstmt);
	         
	      }
	      
	      return result;
	   }

	   public int updateMember(Connection con, Member m) {
	      PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String query = prop.getProperty("updateMember");
	      //String query2 = prop.getProperty("updateMemberNoPwd");
	      System.out.println(query);
	      
	      try {
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, m.getPassword());            
	            pstmt.setString(2, m.getNickName());
	            pstmt.setString(3, m.getAddress());
	            pstmt.setString(4, m.getPhone());
	            pstmt.setString(5, m.getHobby());
	            pstmt.setString(6, m.getUserEmail());
	            pstmt.setString(7, String.valueOf(m.getUserNumber()));
	         
	            result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }
	   /*

	   public int deleteMember(Connection con, Member m) {
	      PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String query = prop.getProperty("deleteMember");
	      System.out.println(query);
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, m.getUserEail());
	         pstmt.setString(2, m.getPassword());
	         
	         result = pstmt.executeUpdate();
	         
	         System.out.println(result);
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

	   public ArrayList<Member> selectAll(Connection con) {
	      ArrayList<Member> list = null;
	      Statement stmt = null;
	      ResultSet rset = null;
	      
	      String query = prop.getProperty("selectAll");
	      
	      try {
	         stmt = con.createStatement();
	         
	         rset = stmt.executeQuery(query);
	         
	         list = new ArrayList<Member>();
	         
	         while(rset.next()){
	            Member m = new Member();
	            m.setUserId(rset.getString("user_id"));
	            m.setPassword(rset.getString("user_pwd"));
	            m.setUserName(rset.getString("user_name"));
	            m.setGender(rset.getString("gender"));
	            m.setAge(rset.getInt("age"));
	            m.setEmail(rset.getString("email"));
	            m.setPhone(rset.getString("phone"));
	            m.setAddress(rset.getString("address"));
	            m.setHobby(rset.getString("hobby"));
	            m.setEnrollDate(rset.getDate("enroll_date"));
	            
	         
	            list.add(m);
	         }
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(stmt);
	         close(rset);
	      }
	      
	   
	      return list;
	   }

	   public ArrayList<Member> searchId(Connection con, String userId){
	      ArrayList<Member> list = null;
	      Statement stmt = null;
	      ResultSet rset = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = prop.getProperty("searchId");
	      System.out.println(query);
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         
	         pstmt.setString(1, userId);
	         
	         rset = pstmt.executeQuery();
	         
	         
	         if(rset != null){
	            list = new ArrayList<Member>();
	            
	            while(rset.next()){
	               Member m = new Member();
	               
	               m.setUserId(rset.getString("user_id"));
	               m.setPassword(rset.getString("user_pwd"));
	               m.setUserName(rset.getString("user_name"));
	               m.setGender(rset.getString("gender"));
	               m.setAge(rset.getInt("age"));
	               m.setEmail(rset.getString("email"));
	               m.setPhone(rset.getString("phone"));
	               m.setAddress(rset.getString("address"));
	               m.setHobby(rset.getString("hobby"));
	               m.setEnrollDate(rset.getDate("enroll_date"));

	               list.add(m);
	            }
	            System.out.println(list);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally{
	         close(pstmt);
	         close(rset);
	      }
	      
	      
	      return list;
	   }*/
	   public Member snsloginMember(Connection con, String userEmail) {
		   Member loginUser = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = prop.getProperty("loginMember");
			System.out.println(query);
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, userEmail);
				
				System.out.println(pstmt);
				rset = pstmt.executeQuery();
				
				if(rset.next()){
					loginUser = new Member();
					
					loginUser.setUserNumber(Integer.parseInt(rset.getString("user_number")));
					loginUser.setUserEmail(rset.getString("user_email"));
					loginUser.setPassword(rset.getString("user_pwd"));
					loginUser.setUserName(rset.getString("user_name"));
					loginUser.setNickName(rset.getString("nickname"));
					loginUser.setAddress(rset.getString("address"));
					loginUser.setPhone(rset.getString("phone"));
					loginUser.setHobby(rset.getString("hobby"));
					loginUser.setBirthDate(rset.getDate("birth_date"));
					loginUser.setEnrollDate(rset.getDate("enroll_date"));
					loginUser.setGrade(rset.getString("grade"));
					loginUser.setGradeDate(rset.getDate("grade_date"));
					loginUser.setBankName(rset.getString("bank_name"));
					loginUser.setBankNumber(rset.getString("bank_number"));
					loginUser.setAccountSort(rset.getString("account_sort"));
					loginUser.setToken(rset.getString("token"));
					loginUser.setReportedUser(rset.getString("reported_user"));
					loginUser.setActivated(rset.getString("activated"));
					loginUser.setActivatedDate(rset.getDate("activated_date"));
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
				
			}
			
			
			return loginUser;
		   
		   
	   }
	   
	   
	   
	/*public Member snsloginMember(Connection con, String userEmail) {
		Member loginUser = null;	

		int result=0;
		int sw=0;
		Member m1=null;
		ArrayList<Member> list=new ArrayList<Member>();
		Statement st=null;
		PreparedStatement pst=null;
		ResultSet rset=null;
		String query="";
		query=prop.getProperty("checkMember");
		String checkQuery=prop.getProperty("checkMember");
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			while(rset.next()){
				m1=new Member();
				m1.setUserEmail(rset.getString("user_email"));
				
				list.add(m1);
				loginUser = new Member();
				
				loginUser.setUserNumber(rset.getInt("user_number"));
				loginUser.setUserEmail(rset.getString("user_email"));
				loginUser.setPassword(rset.getString("user_pwd"));
				loginUser.setUserName(rset.getString("user_name"));
				loginUser.setNickName(rset.getString("nickname"));
				loginUser.setAddress(rset.getString("address"));
				loginUser.setPhone(rset.getString("phone"));
				loginUser.setHobby(rset.getString("hobby"));
				loginUser.setBirthDate(rset.getDate("birth_date"));
				loginUser.setEnrollDate(rset.getDate("enroll_date"));
				loginUser.setGrade(rset.getString("grade"));
				loginUser.setGradeDate(rset.getDate("grade_date"));
				loginUser.setBankName(rset.getString("bank_name"));
				loginUser.setBankNumber(rset.getString("bank_number"));
				loginUser.setAccountSort(rset.getString("account_sort"));
				loginUser.setToken(rset.getString("token"));
				loginUser.setReportedUser(rset.getString("reported_user"));
				loginUser.setActivated(rset.getString("activated"));
				loginUser.setActivatedDate(rset.getDate("activated_date"));
			}*/
			
			/*for(int i=0;i<list.size();i++){
				if(list.get(i).getUserEmail().equals(m.getUserEmail())){
					sw=1;
					break;
				}
			}*/
			
			/*if(sw==1){
				query=prop.getProperty("loginMember");
				
				pst=con.prepareStatement(query);
				pst.setString(1, m.getUserEmail());
				
				result=pst.executeUpdate();
				
				if(result>0){
					result=99;
				}
				else{
					result=0;
				}
				
			}*/
			/*else{
				query=prop.getProperty("insertMember2");
				
				pst=con.prepareStatement(query);
				pst.setString(1, m.getUserEmail());
				pst.setString(2, m.getNickName());
				pst.setString(3, m.getToken());
				
				result=pst.executeUpdate();
			}*/
			
			
		/*} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(st);
			close(rset);
			close(pst);
		}
		
		return loginUser;
	}*/

	public int snsMember(Member m, Connection con) {
		int result=0;
		int sw=0;
		Member m1=null;
		ArrayList<Member> list=new ArrayList<Member>();
		Statement st=null;
		PreparedStatement pst=null;
		ResultSet rset=null;
		String query="";
		query=prop.getProperty("checkMember");
		/*String checkQuery=prop.getProperty("checkMember");*/
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
			while(rset.next()){
				m1=new Member();
				m1.setUserEmail(rset.getString("user_email"));
				
				list.add(m1);
				
			}
			
			System.out.println("dao list:" + list);
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getUserEmail().equals(m.getUserEmail())){
					sw=1;
					break;
				}
			}
			
			
			System.out.println("sw: " + sw);
			if(sw==1){
				query=prop.getProperty("loginMember");
				
				pst=con.prepareStatement(query);
				pst.setString(1, m.getUserEmail());
				
				result=pst.executeUpdate();
				
				if(result>0){
					result=99;
				}
				else{
					result=0;
				}	
			}
			else{
				query=prop.getProperty("insertMember2");
				
				pst=con.prepareStatement(query);
				pst.setString(1, m.getUserEmail());
				pst.setString(2, m.getNickName());
				/*pst.setString(3, m.getToken());*/
				
				result=pst.executeUpdate();
				
				/*result=99;	*/
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(st);
			close(rset);
			close(pst);
		}
		
		System.out.println("memberdaoresult: " + result);
		return result;
	}

	public Member finid(Connection con, String userName, String phone) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("findId");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, phone);
			
			System.out.println(pstmt);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				loginUser = new Member();
				
				loginUser.setUserNumber(Integer.parseInt(rset.getString("user_number")));
				loginUser.setUserEmail(rset.getString("user_email"));
				loginUser.setPassword(rset.getString("user_pwd"));
				loginUser.setUserName(rset.getString("user_name"));
				loginUser.setNickName(rset.getString("nickname"));
				loginUser.setAddress(rset.getString("address"));
				loginUser.setPhone(rset.getString("phone"));
				loginUser.setHobby(rset.getString("hobby"));
				loginUser.setBirthDate(rset.getDate("birth_date"));
				loginUser.setEnrollDate(rset.getDate("enroll_date"));
				loginUser.setGrade(rset.getString("grade"));
				loginUser.setGradeDate(rset.getDate("grade_date"));
				loginUser.setBankName(rset.getString("bank_name"));
				loginUser.setBankNumber(rset.getString("bank_number"));
				loginUser.setAccountSort(rset.getString("account_sort"));
				loginUser.setToken(rset.getString("token"));
				loginUser.setReportedUser(rset.getString("reported_user"));
				loginUser.setActivated(rset.getString("activated"));
				loginUser.setActivatedDate(rset.getDate("activated_date"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		
		
		return loginUser;
	}

	public Member checkEmail(Connection con, String userEmail) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("idCheck");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userEmail);
			
			System.out.println(pstmt);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				loginUser = new Member();
				
				loginUser.setUserNumber(Integer.parseInt(rset.getString("user_number")));
				loginUser.setUserEmail(rset.getString("user_email"));
				loginUser.setPassword(rset.getString("user_pwd"));
				loginUser.setUserName(rset.getString("user_name"));
				loginUser.setNickName(rset.getString("nickname"));
				loginUser.setAddress(rset.getString("address"));
				loginUser.setPhone(rset.getString("phone"));
				loginUser.setHobby(rset.getString("hobby"));
				loginUser.setBirthDate(rset.getDate("birth_date"));
				loginUser.setEnrollDate(rset.getDate("enroll_date"));
				loginUser.setGrade(rset.getString("grade"));
				loginUser.setGradeDate(rset.getDate("grade_date"));
				loginUser.setBankName(rset.getString("bank_name"));
				loginUser.setBankNumber(rset.getString("bank_number"));
				loginUser.setAccountSort(rset.getString("account_sort"));
				loginUser.setToken(rset.getString("token"));
				loginUser.setReportedUser(rset.getString("reported_user"));
				loginUser.setActivated(rset.getString("activated"));
				loginUser.setActivatedDate(rset.getDate("activated_date"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		
		
		return loginUser;
	}

	public int passwordUpdate(Connection con, Member m) {
		 PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String query = prop.getProperty("passwordUpdate");
	      //String query2 = prop.getProperty("updateMemberNoPwd");
	      System.out.println(query);
	      
	      try {
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, m.getPassword());            
	            pstmt.setString(2, m.getUserEmail());
	            
	         
	            result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	}

	public Member selectNuriBossInfo(Connection con, String ownerNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String query = prop.getProperty("selectNuriBossInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ownerNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				m = new Member();
				m.setUserNumber(Integer.parseInt(rset.getString("user_number")));
				m.setUserName(rset.getString("user_name"));
				m.setPhone(rset.getString("phone"));
				m.setBankName(rset.getString("bank_name"));
				m.setBankNumber(rset.getString("bank_number"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(m);
		
		return m;
	}

	public int getGoneMemberListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("goneMemberListCount");

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

	public ArrayList<Member> selectGoneMemberList(Connection con, int currentPage, int limit) {
		ArrayList<Member> list = null;
        PreparedStatement pstmt = null;
        /*Statement stmt = null;*/
        ResultSet rset = null;
        Member m = null;
        
        String query = prop.getProperty("selectGoneMemberList");
        
        try {
           /*stmt = con.createStatement();
           rset = stmt.executeQuery(query);*/
           
           pstmt = con.prepareStatement(query);
           
           int startRow = (currentPage - 1) * limit + 1;
           int endRow = startRow + limit - 1;
           
           pstmt.setInt(1, startRow);
           pstmt.setInt(2, endRow);
           
           rset = pstmt.executeQuery();
           
           list = new ArrayList<Member>();
           
           while(rset.next()){
              m = new Member();
              
              m.setUserNumber(rset.getInt("user_number"));
              m.setUserEmail(rset.getString("user_email"));
              m.setUserName(rset.getString("user_name"));
              m.setNickName(rset.getString("nickname"));
              m.setAddress(rset.getString("address"));
              m.setPhone(rset.getString("phone"));
              m.setEnrollDate(rset.getDate("enroll_date"));
              m.setActivatedDate(rset.getDate("activated_date"));
              
              list.add(m);
           }
           
           System.out.println(list);
           
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           close(rset);
           close(pstmt);
        }
        
        return list;
	}

	public ArrayList<Member> selectAll(Connection con) {
		ArrayList<Member> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectAll");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Member>();
			
			while(rset.next()){
				Member m = new Member();
				
				m.setUserNumber(Integer.parseInt(rset.getString("user_number")));
				m.setUserEmail(rset.getString("user_email"));
				m.setPassword(rset.getString("user_pwd"));
				m.setUserName(rset.getString("user_name"));
				m.setNickName(rset.getString("nickname"));
				m.setAddress(rset.getString("address"));
				m.setPhone(rset.getString("phone"));
				m.setHobby(rset.getString("hobby"));
				m.setBirthDate(rset.getDate("birth_date"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setGrade(rset.getString("grade"));
				m.setGradeDate(rset.getDate("grade_date"));
				m.setBankName(rset.getString("bank_name"));
				m.setBankNumber(rset.getString("bank_number"));
				m.setAccountSort(rset.getString("account_sort"));
				m.setToken(rset.getString("token"));
				m.setReportedUser(rset.getString("reported_user"));
				m.setActivated(rset.getString("activated"));
				m.setActivatedDate(rset.getDate("activated_date"));
				
			
				list.add(m);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		
	
		return list;
	}

	
	public ArrayList<Member> selectRefundNuriMember(Connection con, int currentPage, int limit) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<Member> refundList = null;
	      Member m = null;
	      
	      String query = prop.getProperty("selectRefundMember");
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         
	         int startRow = (currentPage - 1) * limit + 1;
	         int endRow = startRow + limit - 1;
	            
	         pstmt.setInt(1, startRow);
	         pstmt.setInt(2, endRow);
	         
	         rset = pstmt.executeQuery();
	         
	         refundList = new ArrayList<Member>();
	         
	         while(rset.next()){
	            m = new Member();
	            
	            m.setUserNumber(Integer.parseInt(rset.getString("user_number")));
	            m.setUserEmail(rset.getString("user_email"));
	            m.setUserName(rset.getString("user_name"));
	            m.setRefundNuriterName(rset.getString("nuri_name"));
	            m.setNickName(rset.getString("nickname"));
	            m.setPhone(rset.getString("phone"));
	            m.setGrade(rset.getString("grade"));
	            m.setBankName(rset.getString("bank_name"));
	            m.setBankNumber(rset.getString("bank_number"));
	            m.setRefundNuriterPrice(rset.getInt("price"));
	            
	            refundList.add(m);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	         close(rset);
	      }
	      return refundList;
	   }

	   public ArrayList<Member> selectRefundNuriMember2(Connection con, int currentPage2, int limit) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<Member> refundList2 = null;
	      Member m = null;
	      
	      String query = prop.getProperty("selectRefundMember2");
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         
	         int startRow = (currentPage2 - 1) * limit + 1;
	            int endRow = startRow + limit - 1;
	            
	            pstmt.setInt(1, startRow);
	            pstmt.setInt(2, endRow);
	            
	            rset = pstmt.executeQuery();
	         
	         refundList2 = new ArrayList<Member>();
	         
	         while(rset.next()){
	            m = new Member();
	            
	            m.setUserNumber(Integer.parseInt(rset.getString("user_number")));
	            m.setUserEmail(rset.getString("user_email"));
	            m.setUserName(rset.getString("user_name"));
	            m.setRefundNuriterName(rset.getString("nuri_name"));
	            m.setNickName(rset.getString("nickname"));
	            m.setPhone(rset.getString("phone"));
	            m.setGrade(rset.getString("grade"));
	            m.setBankName(rset.getString("bank_name"));
	            m.setBankNumber(rset.getString("bank_number"));
	            m.setRefundNuriterPrice(rset.getInt("price"));
	            m.setRefundNuriterDate(rset.getDate("refund_date"));
	            
	            refundList2.add(m);
	         }
	            
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	         close(rset);
	      }
	      System.out.println(refundList2); 
	      
	      return refundList2;
	   }
	
	   
	   
	   public int getRefundMemberCount(Connection con) {
		      Statement stmt = null;
		      ResultSet rset = null;
		      int result = 0;
		      
		      String query = prop.getProperty("getRefundMemberCount");
		      
		      try {
		         stmt = con.createStatement();
		         rset = stmt.executeQuery(query);
		         
		         if(rset.next()){
		            result = rset.getInt(1);
		         }
		         
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rset);
		         close(stmt);
		      }
		      
		      System.out.println("환불된 회원 수 : " + result);
		      return result;
		   }

		   public int getRefundMemberCount2(Connection con) {
		      Statement stmt = null;
		      ResultSet rset = null;
		      int result = 0;
		      
		      String query = prop.getProperty("getRefundMemberCount2");
		      
		      try {
		         stmt = con.createStatement();
		         rset = stmt.executeQuery(query);
		         
		         if(rset.next()){
		            result = rset.getInt(1);
		         }
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      } finally {
		         close(rset);
		         close(stmt);
		      }
		      
		      System.out.println("환불 처리된 회원 수 : " + result);
		      return result;
		   }   

		   
		   
		   public int updateRefundNumber(Connection con, String num) {
			      PreparedStatement pstmt = null;
			      int result = 0;
			      
			      String query = prop.getProperty("updateRefundNumber");
			      
			      try {
			         pstmt = con.prepareStatement(query);
			         pstmt.setString(1, num);
			         pstmt.setString(2, num);
			         
			         result = pstmt.executeUpdate();
			         
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } finally {
			         close(pstmt);
			      }
			      
			      System.out.println("업데이트 완료 ? " + result);
			      return result;
			   }

		public ArrayList<Member> searchId(Connection con, String userId) {
			ArrayList<Member> list = null;
			/*Statement stmt = null;
			ResultSet rset = null;*/
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = prop.getProperty("searchId");
			/*System.out.println(query);*/
			
			try {
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, userId);
				
				rset = pstmt.executeQuery();
				
				
				if(rset != null){
					list = new ArrayList<Member>();
					
					while(rset.next()){
						Member m = new Member();
						
						m.setUserNumber(Integer.parseInt(rset.getString("user_number")));
						m.setUserEmail(rset.getString("user_email"));
						m.setPassword(rset.getString("user_pwd"));
						m.setUserName(rset.getString("user_name"));
						m.setNickName(rset.getString("nickname"));
						m.setAddress(rset.getString("address"));
						m.setPhone(rset.getString("phone"));
						m.setHobby(rset.getString("hobby"));
						m.setBirthDate(rset.getDate("birth_date"));
						m.setEnrollDate(rset.getDate("enroll_date"));
						m.setGrade(rset.getString("grade"));
						m.setGradeDate(rset.getDate("grade_date"));
						m.setBankName(rset.getString("bank_name"));
						m.setBankNumber(rset.getString("bank_number"));
						m.setAccountSort(rset.getString("account_sort"));
						m.setToken(rset.getString("token"));
						m.setReportedUser(rset.getString("reported_user"));
						m.setActivated(rset.getString("activated"));
						m.setActivatedDate(rset.getDate("activated_date"));
						list.add(m);
					}
					/*System.out.println(list);*/
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(pstmt);
				close(rset);
			}
			
			
			return list;
		}
	

		public ArrayList<Member> searchName(Connection con, String userName) {
			ArrayList<Member> list = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = prop.getProperty("searchName");
			System.out.println(userName);
			System.out.println(query);
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, userName);
				
				rset = pstmt.executeQuery();
				
				if(rset != null){
					list = new ArrayList<Member>();
					
					while(rset.next()){
						Member m = new Member();
						
						m.setUserNumber(Integer.parseInt(rset.getString("user_number")));
						m.setUserEmail(rset.getString("user_email"));
						m.setPassword(rset.getString("user_pwd"));
						m.setUserName(rset.getString("user_name"));
						m.setNickName(rset.getString("nickname"));
						m.setAddress(rset.getString("address"));
						m.setPhone(rset.getString("phone"));
						m.setHobby(rset.getString("hobby"));
						m.setBirthDate(rset.getDate("birth_date"));
						m.setEnrollDate(rset.getDate("enroll_date"));
						m.setGrade(rset.getString("grade"));
						m.setGradeDate(rset.getDate("grade_date"));
						m.setBankName(rset.getString("bank_name"));
						m.setBankNumber(rset.getString("bank_number"));
						m.setAccountSort(rset.getString("account_sort"));
						m.setToken(rset.getString("token"));
						m.setReportedUser(rset.getString("reported_user"));
						m.setActivated(rset.getString("activated"));
						m.setActivatedDate(rset.getDate("activated_date"));
						list.add(m);
					}
					System.out.println(list);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(pstmt);
				close(rset);
			}
			
			
			return list;
		}

		public ArrayList<Member> searchNickname(Connection con, String userNickname) {
			ArrayList<Member> list = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = prop.getProperty("searchNickName");
			System.out.println(userNickname);
			System.out.println(query);
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, userNickname);
				
				rset = pstmt.executeQuery();
				
				if(rset != null){
					list = new ArrayList<Member>();
					
					while(rset.next()){
						Member m = new Member();
						
						m.setUserNumber(Integer.parseInt(rset.getString("user_number")));
						m.setUserEmail(rset.getString("user_email"));
						m.setPassword(rset.getString("user_pwd"));
						m.setUserName(rset.getString("user_name"));
						m.setNickName(rset.getString("nickname"));
						m.setAddress(rset.getString("address"));
						m.setPhone(rset.getString("phone"));
						m.setHobby(rset.getString("hobby"));
						m.setBirthDate(rset.getDate("birth_date"));
						m.setEnrollDate(rset.getDate("enroll_date"));
						m.setGrade(rset.getString("grade"));
						m.setGradeDate(rset.getDate("grade_date"));
						m.setBankName(rset.getString("bank_name"));
						m.setBankNumber(rset.getString("bank_number"));
						m.setAccountSort(rset.getString("account_sort"));
						m.setToken(rset.getString("token"));
						m.setReportedUser(rset.getString("reported_user"));
						m.setActivated(rset.getString("activated"));
						m.setActivatedDate(rset.getDate("activated_date"));
						list.add(m);
					}
					System.out.println(list);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(pstmt);
				close(rset);
			}
			
			
			return list;
		}

		public int snsMember1(Member m, Connection con) {
			int result=0;
			int sw=0;
			Member m1=null;
			ArrayList<Member> list=new ArrayList<Member>();
			Statement st=null;
			PreparedStatement pst=null;
			ResultSet rset=null;
			String query="";
			query=prop.getProperty("checkMember");
			/*String checkQuery=prop.getProperty("checkMember");*/
			try {
				st=con.createStatement();
				rset=st.executeQuery(query);
				
				while(rset.next()){
					m1=new Member();
					m1.setUserEmail(rset.getString("user_email"));
					
					list.add(m1);
					
				}
				
				System.out.println("dao list:" + list);
				
				for(int i=0;i<list.size();i++){
					if(list.get(i).getUserEmail().equals(m.getUserEmail())){
						sw=1;
						break;
					}
				}
				
				
				System.out.println("sw: " + sw);
				if(sw==1){
					query=prop.getProperty("loginMember");
					
					pst=con.prepareStatement(query);
					pst.setString(1, m.getUserEmail());
					
					result=pst.executeUpdate();
					
					if(result>0){
						result=99;
					}
					else{
						result=0;
					}	
				}
				else{
					query=prop.getProperty("insertMember3");
					
					pst=con.prepareStatement(query);
					pst.setString(1, m.getUserEmail());
					pst.setString(2, m.getUserName());
					pst.setString(3, m.getNickName());
					/*pst.setDate(4, m.getBirthDate());*/
					
					/*pst.setString(3, m.getToken());*/
					
					result=pst.executeUpdate();
					
					/*result=99;	*/
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(st);
				close(rset);
				close(pst);
			}
			
			System.out.println("memberdaoresult: " + result);
			return result;
		}

		public Member snsloginMember1(Connection con, String userEmail) {
			Member loginUser = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = prop.getProperty("loginMember1");
			System.out.println(query);
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, userEmail);
				
				System.out.println(pstmt);
				rset = pstmt.executeQuery();
				
				if(rset.next()){
					loginUser = new Member();
					
					loginUser.setUserNumber(Integer.parseInt(rset.getString("user_number")));
					loginUser.setUserEmail(rset.getString("user_email"));
					loginUser.setPassword(rset.getString("user_pwd"));
					loginUser.setUserName(rset.getString("user_name"));
					loginUser.setNickName(rset.getString("nickname"));
					loginUser.setAddress(rset.getString("address"));
					loginUser.setPhone(rset.getString("phone"));
					loginUser.setHobby(rset.getString("hobby"));
					loginUser.setBirthDate(rset.getDate("birth_date"));
					loginUser.setEnrollDate(rset.getDate("enroll_date"));
					loginUser.setGrade(rset.getString("grade"));
					loginUser.setGradeDate(rset.getDate("grade_date"));
					loginUser.setBankName(rset.getString("bank_name"));
					loginUser.setBankNumber(rset.getString("bank_number"));
					loginUser.setAccountSort(rset.getString("account_sort"));
					loginUser.setToken(rset.getString("token"));
					loginUser.setReportedUser(rset.getString("reported_user"));
					loginUser.setActivated(rset.getString("activated"));
					loginUser.setActivatedDate(rset.getDate("activated_date"));
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
				
			}
			
			
			return loginUser;
		}

		
}










