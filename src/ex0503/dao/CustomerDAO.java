package ex0503.dao;

import java.util.List;

import ex0503.dto.CustomerDTO;

public interface CustomerDAO {
	/*
	 * 아이디 중복체크
	 * @return : "중복입니다" or "사용가능합니다"
	 */
	String idCheck(String id);
	/**
	 * Customer 등록
	 */
	int insert(CustomerDTO customerDTO);
	
	/**
	 * 전체검색
	 */
	List<CustomerDTO> selectAll();
	
	/**
	 * Customer 수정
	 */
	int update(CustomerDTO customerDTO);
	
	/**
	 * Customer 삭제
	 */
	int delete(String id);
}