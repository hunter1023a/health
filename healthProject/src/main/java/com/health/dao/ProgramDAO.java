package com.health.dao;

import java.util.ArrayList;

import com.health.domain.HealthProVO;

public interface ProgramDAO {
	// 프로그램 등록
	public boolean insert(HealthProVO vo);
	// 등록 프로그램 조회(등록)
	public HealthProVO selectOne(int pid);
	// 등록 프로그램 전체 정보 조회
	public ArrayList<HealthProVO> selectAll();
	// 등록 프로그램 정보 수정
	public boolean update(HealthProVO vo);
	// 등록 프로그램 삭제
	public void delete(int pid);
}
