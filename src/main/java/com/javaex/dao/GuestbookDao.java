package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<GuestbookVo> getList(){
		System.out.println("getList");
		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.getList");
		
		return guestbookList; 
	}
	
	public int addGuest(GuestbookVo gvo) {
		
		int count = sqlSession.insert("guestbook.insert", gvo);
		return count;
	}
	
	
	
	public int deleteGuest(int no, String password) {
		
		GuestbookVo gvo = new GuestbookVo(no, password);//no, password 생성자vo에 만들어줌 xml에 넘겨줄 정보 두개라서 vo로묶음
		int count = sqlSession.delete("guestbook.delete", gvo);
		return count;
	}
	
	/*만들 필요 없었음
	//번호가 __인 사람의 정보 가져오기
	public GuestbookVo selectPerson(int no) {
			
		GuestbookVo gvo = sqlSession.selectOne("guestbook.selectPerson", no);
		return gvo;
	}*/
	
}
