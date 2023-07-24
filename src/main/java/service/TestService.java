package service;

import java.util.ArrayList;

import dto.TestDto;

public class TestService {

	public ArrayList<TestDto> getBoardList() {
		// 1. select >> DB 접속 >> Dao 클래스 
		
		ArrayList<TestDto> list = new ArrayList<TestDto>();
		
		for(int i=0; i<10; i++) {
			TestDto tdto = new TestDto();
			tdto.setNum(i+1);
			tdto.setTitle("Title"+(i+1));
			tdto.setWriter("Writer"+(i+1));
			list.add(tdto);	
		}
		
		return list;
	}

}
