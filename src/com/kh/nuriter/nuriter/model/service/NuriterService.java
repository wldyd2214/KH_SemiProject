package com.kh.nuriter.nuriter.model.service;

import static com.kh.nuriter.common.JDBCTemplate.close;
import static com.kh.nuriter.common.JDBCTemplate.commit;
import static com.kh.nuriter.common.JDBCTemplate.getConnection;
import static com.kh.nuriter.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.nuriter.member.model.vo.Member;
import com.kh.nuriter.nuriter.model.dao.NuriterDao;
import com.kh.nuriter.nuriter.model.vo.Attachment;
import com.kh.nuriter.nuriter.model.vo.Category;
import com.kh.nuriter.nuriter.model.vo.Nuriboss;
import com.kh.nuriter.nuriter.model.vo.Nuriter;


public class NuriterService {

   public int insertNuriter(Nuriter n, ArrayList<Attachment> fileList) {
      Connection con = getConnection();
      
      int result1 = new NuriterDao().insertNuriter(con, n); //누리터 개설
      
      String nuriNum = new NuriterDao().selectCurrval(con);//현재 누리터 번호 가져오기
      
      n.setNuriNum("N" + nuriNum);
      
      System.out.println("누리터 번호 => " + n.getNuriNum());
      
      int result2 = new NuriterDao().insertNuriterBoard(con, n); //Board 테이블에 누리터 개설
      
      String BoardNum = new NuriterDao().selectBoardCurrval(con);//현재 게시판 번호 가져오기
      
      String BoardId = "B" + BoardNum;
      
      int result3 = new NuriterDao().insertNuriterAttachment(con, n, fileList, BoardId);
      
      if(result3 > 0) {
         commit(con);
      }
      else {
         rollback(con);
      }
      
      close(con);
      
      return result1;
   }

   public ArrayList<Category> selectCategoryList(String name) {
      Connection con = getConnection();
      
      ArrayList<Category> list = new NuriterDao().selectCategoryList(con, name);
      
      close(con);
      
      return list;
   }

   public int insertNuriBoss(Nuriboss n) {
      Connection con = getConnection();
      
      int result = new NuriterDao().insertNuriBoss(con, n);
      
      if(result > 0) {
         commit(con);
      }
      else {
         rollback(con);
      }
      
      close(con);
      
      return result;
   }

   /*public int insertNuriterPoto(Nuriter n, ArrayList<Attachment> fileList) {
      Connection con = getConnection();
      
      int result = new NuriterDao().insertNuriPoto(con, n, fileList);
     
      if(result > 0) {
         commit(con);
      }
      else {
         rollback(con);
      }
      close(con);
      
      return result;
   }*/

   public int getListCount(String userNum) {
      Connection con = getConnection();        
       int listCount = new NuriterDao().getListCount(con, userNum);
         
         close(con);
         
         return listCount;
   }

   public ArrayList<Nuriter> selectOpenList(int currentPage, int limit, String userNum) {
      Connection con = getConnection();
         
       ArrayList<Nuriter> list = new NuriterDao().selectOpenList(con, currentPage, limit, userNum);
         
       close(con);
         
         
         
       return list;
   }

   public ArrayList<Nuriter> selectNuriterList(String category) {
      Connection con = getConnection();
      
       ArrayList<Nuriter> list = new NuriterDao().selectNuriterList(con, category);
      
       close(con);
       
      return list;
   }

   public ArrayList<HashMap<String, Object>> selectThumbnailList(int currentPage, int limit, String category) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> pictureList = new NuriterDao().selectThumbnailList(con, currentPage, limit, category);
		
		close(con);

		return pictureList;
	}


	public ArrayList<Nuriboss> selectNuribossList2(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Nuriboss> bossList2 = new NuriterDao().selectNuribossList2(con, currentPage, limit);

		close(con);

		return bossList2;
	}

   public int getNuriterListCount(String category) {
      Connection con = getConnection();
      
      int listCount = new NuriterDao().getNuriterListCount(con, category);
      
      close(con);
      
      return listCount;
   }

   public ArrayList<Nuriter> selectEndList(int currentPage, int limit, String userNum) {
      Connection con = getConnection();
         
       ArrayList<Nuriter> list = new NuriterDao().selectEndList(con, currentPage, limit, userNum);
         
       close(con);
         
         
         
       return list;
   }

   
   
   public Nuriter selectOne(String num) {
      System.out.println("서비스 실행 시작");
      Connection con = getConnection();
      
      int result = 0;
      
      result = new NuriterDao().updateCount(con, num);
      
      if(result > 0) { 
         commit(con);
      } else { 
         rollback(con);
      }
      
      int interest = new NuriterDao().interestCount(con, num); //관심 누리터 인원 가져오기
      
      int enterCount = new NuriterDao().enterCount(con, num); //관심 누리터 인원 가져오기
      
      Nuriter n = new NuriterDao().selectOne(con, num, interest, enterCount);
      
      close(con);
      
      return n;

   }
   
   public int getMyNuriListCount(String userNum) {
         Connection con = getConnection();
            
          int listCount = new NuriterDao().getMyNuriListCount(con, userNum);
            
            close(con);
            
            return listCount;
      }

      public ArrayList<Nuriter> selectMyNuriList(int currentPage, int limit, String userNum) {
         Connection con = getConnection();
            
          ArrayList<Nuriter> list = new NuriterDao().selectMyNuriList(con, currentPage, limit, userNum);
            
          close(con);
            
            
            
          return list;
      }

   public ArrayList<Nuriter> selectOpenList1(int currentPage, int limit, String userNum) {
      Connection con = getConnection();
         
       ArrayList<Nuriter> list = new NuriterDao().selectOpenList1(con, currentPage, limit, userNum);
         
       close(con);
         
         
         
       return list;
   }
   
    public ArrayList<Nuriter> selectMyNuriList1(int currentPage, int limit, String userNum) {
         Connection con = getConnection();
            
          ArrayList<Nuriter> list1 = new NuriterDao().selectMyNuriList1(con, currentPage, limit, userNum);
            
          close(con);
            
            
            
          return list1;
      }


   public ArrayList<Nuriboss> selectNuribossList(int currentPage, int limit) {
      Connection con = getConnection();
      ArrayList<Nuriboss> bossList = new NuriterDao().selectNuribossList(con, currentPage, limit);
      
      close(con);
      
      return bossList;
   }

   

   public int getMyNuriterListCount(String userNum) {
       Connection con = getConnection();
         
          int listCount = new NuriterDao().getMyNuriterListCount(con, userNum);
            
            close(con);
            
            return listCount;
   }

   public ArrayList<Nuriter> selectMyNuriterList(String userNum) {
      Connection con = getConnection();
      
       ArrayList<Nuriter> list = new NuriterDao().selectMyNuriterList(con, userNum);
      
       close(con);
       
      return list;
   }

   public ArrayList<HashMap<String, Object>> selectMyThumbnailList(int currentPage, int limit, String userNum) {
      Connection con = getConnection();
      
      ArrayList<HashMap<String, Object>> pictureList = new NuriterDao().selectMyThumbnailList(con, currentPage, limit, userNum);
      
      close(con);
      
      return pictureList;
   }

   public int getDoneNuriListCount(String userNum) {
      Connection con = getConnection();
        
       int listCount = new NuriterDao().getDoneNuriListCount(con, userNum);
            
       close(con);
            
       return listCount;
   }

   public ArrayList<Nuriter> selectDoneNuriList(int currentPage, int limit, String userNum) {
       Connection con = getConnection();
         
        ArrayList<Nuriter> list = new NuriterDao().selectDoneNuriList(con, currentPage, limit, userNum);
            
        close(con);
            
            
            
          return list;
   }

   public int deleteMyNuri(String userNum, String nuriNum) {
      Connection con = getConnection();
      
      int result = new NuriterDao().deleteMyNuri(con, userNum, nuriNum);
      
      if(result > 0){
         commit(con);
      }else{
         rollback(con);
      }
      
      close(con);
      
      return result;
   }


   public int getNuribossListCount() {
      Connection con = getConnection();
      
      int listCount = new NuriterDao().getNuribossListCount(con);
      
      close(con);
      
      return listCount;
   }

   public Nuriboss selectOneNuriboss(String num) {
      Connection con = getConnection();
      
      Nuriboss nb = new NuriterDao().selectOneNuriboss(con, num);
      
      close(con);
      
      return nb;
   }

   public int insertNuriterHobby(String userNum, String name) {
      Connection con = getConnection();
      
      int result = new NuriterDao().insertNuriterHobby(con, userNum, name);
      
      if(result > 0) {
         commit(con);
      }
      else {
         rollback(con);
      }
      
      close(con);
      
      return result;

   }


   public int getMyTemptingListCount(String userNum) {
      Connection con = getConnection();
        
       int listCount = new NuriterDao().getMyTemptingListCount(con, userNum);
            
       close(con);
            
       return listCount;
   }

   public ArrayList<Nuriter> selectMyTemptingList(String userNum) {
      Connection con = getConnection();
      
       ArrayList<Nuriter> list = new NuriterDao().selectMyTemptingList(con, userNum);
      
       close(con);
       
      return list;
   }

   public ArrayList<HashMap<String, Object>> selectMyTemptingThumbnailList(int currentPage, int limit,
         String userNum) {
      Connection con = getConnection();
      
      ArrayList<HashMap<String, Object>> pictureList = new NuriterDao().selectMyTemptingThumbnailList(con, currentPage, limit, userNum);
      
      close(con);
      
      return pictureList;
   }
   public int updateNuribossStatus(String num) {
      Connection con = getConnection();
      
      int result = new NuriterDao().updateNuribossStatus(con, num);
      
      if(result > 0){
         commit(con);
      }else{
         rollback(con);
      }
      
      close(con);
      
      return result;

   }

//댓글 달기
public int insertNuriterComment(String nuriNum, String content, String writer) {
	Connection con = getConnection();
	
	String boardNum = new NuriterDao().selectBoardNumber(con, nuriNum);
	
	int result = new NuriterDao().insertNuriterComment(con, nuriNum, content, writer, boardNum);
	
	if(result > 0) {
		commit(con);
	}else {
		rollback(con);
	}
	
	close(con);
	
	return result;
}

	public Nuriter selectOpenOne(String nunum) {
		Connection con = getConnection();

		Nuriter n = new NuriterDao().selectOpenOne(con, nunum);

		commit(con);

		close(con);

		return n;
	}

  
	public int getNuribossListCount2() {
		Connection con = getConnection();

		int listCount2 = new NuriterDao().getNuribossListCount2(con);

		close(con);

		return listCount2;
	}
  
  
//댓글 리스트 가져오기
public ArrayList<HashMap<String, Object>> selectNuriterComment(String nuriNum) {
	Connection con = getConnection();
	
	ArrayList<HashMap<String, Object>> commentList = new NuriterDao().selectNuriterComment(con, nuriNum);
	
	close(con);
	
	return commentList;
}

public int updateMemberGrade(String num2) {
	Connection con = getConnection();
	
	int result = new NuriterDao().updateMemberGrade(con, num2);
	
	if(result > 0){
		commit(con);
	}else{
		rollback(con);
	}

	close(con);

	return result;
}

public int deleteNuriboss(String num) {
	Connection con = getConnection();
	
	int result = new NuriterDao().deleteNuriboss(con, num);
	
	if(result > 0){
		commit(con);
	}else{
		rollback(con);
	}

	close(con);

	return result;
}


public ArrayList<Nuriter> selectEndedNuriterList(int currentPage, int limit, String userNum) {
	Connection con = getConnection();
    
    ArrayList<Nuriter> list = new NuriterDao().selectEndedNuriterList(con, currentPage, limit, userNum);
    
    close(con);
    
    return list;
}
  
public int getSearchNuriterListCount(String search) {
	Connection con = getConnection();
    
    int listCount = new NuriterDao().getSearchNuriterListCount(con, search);
    
    close(con);
    
    return listCount;
}

public ArrayList<Nuriter> selectSearcgNuriterList(String search) {
	Connection con = getConnection();
    
    ArrayList<Nuriter> list = new NuriterDao().selectSearchNuriterList(con, search);
   
    close(con);
    
   return list;
}

public ArrayList<HashMap<String, Object>> selectSearchThumbnailList(int currentPage, int limit, String search) {
	Connection con = getConnection();
	
	ArrayList<HashMap<String, Object>> pictureList = new NuriterDao().selectSearchThumbnailList(con, currentPage, limit, search);
	
	close(con);

	return pictureList;
}

public int getNuriPrice(String nuriNum) {
	Connection con = getConnection();
	
	int result = new NuriterDao().getNuriPrice(con, nuriNum);
	
	if(result > 0) {
		commit(con);
	}
	else {
		rollback(con);
	}
	
	close(con);
	
	return result;
}

public int updateNuriter(String nuriNum, String title, String content) {
	Connection con = getConnection();
	
	int result = new NuriterDao().updateNuriter(con, nuriNum, title, content);
	
	close(con);
	
	return result;
}

public int updateBoard(String nuriNum, String title, String content) {
	Connection con = getConnection();
	
	int result = new NuriterDao().updateBoard(con, nuriNum, title, content);
	
	close(con);
	
	return result;
}

public String getOwnerNum(String nuriNum) {
	Connection con = getConnection();
	
	String ownerNum = new NuriterDao().getOwnerNum(con, nuriNum);
	
	close(con);
	
	return ownerNum;
}

public ArrayList<HashMap<String, Object>> selectThumbnailList1() {
	Connection con = getConnection();
	
	ArrayList<HashMap<String, Object>> pictureList = new NuriterDao().selectThumbnailList1(con);
	
	close(con);

	return pictureList;
}


public ArrayList<HashMap<String, Object>> selectThumbnailList2() {
	Connection con = getConnection();
	
	ArrayList<HashMap<String, Object>> pictureList2 = new NuriterDao().selectThumbnailList2(con);
	
	close(con);

	return pictureList2;
}

public ArrayList<HashMap<String, Object>> selectThumbnailList3() {
	Connection con = getConnection();
	
	ArrayList<HashMap<String, Object>> pictureList3 = new NuriterDao().selectThumbnailList3(con);
	
	close(con);

	return pictureList3;
}
  
public int getNuriterChildListCount(String category) {
	Connection con = getConnection();
    
    int listCount = new NuriterDao().getNuriterChildListCount(con, category);
    
    close(con);
    
    return listCount;
}

public ArrayList<Nuriter> selectNuriterChildList(String category) {
	Connection con = getConnection();
    
    ArrayList<Nuriter> list = new NuriterDao().selectNuriterChildList(con, category);
   
    close(con);
    
   return list;
}

public ArrayList<HashMap<String, Object>> selectChildThumbnailList(int currentPage, int limit, String category) {
	Connection con = getConnection();
	
	ArrayList<HashMap<String, Object>> pictureList = new NuriterDao().selectChildThumbnailList(con, currentPage, limit, category);
	
	close(con);

	return pictureList;

}

public int updateNuriterPayStatus(String nuriNum) {
	Connection con = getConnection();
	
	int result = new NuriterDao().updateNuriterPayStatus(con, nuriNum);
	
	if(result > 0) { 
        commit(con);
     } else { 
        rollback(con);
     }
	
	return result;
}

public String selectNuriterPayStatus(String nuriNum) {
	Connection con = getConnection();
	
	String result = new NuriterDao().selectNuriterPayStatus(con, nuriNum);
	
	close(con);
	
	return result;
}

public Nuriter selectOneNuriterEB(String nuriNum) {
	Connection con = getConnection();
	
	Nuriter nu = new NuriterDao().selectOneNuriterEB(con, nuriNum);
	
	close(con);
	
	return nu;
}

public int updateNuribossApproveToN(String userNum) {
	Connection con = getConnection();
	
	int result = new NuriterDao().updateNuribossApproveToN(con, userNum);
			
	if(result > 0) { 
        commit(con);
    } else { 
        rollback(con);
    }
	
	return result;
}

public int updateMemberGrade2(String userNum) {
	Connection con = getConnection();
	
	int result = new NuriterDao().updateMemberGrade2(con, userNum);
	
	if(result > 0) { 
        commit(con);
    } else { 
        rollback(con);
    }
	
	return result;
}


}