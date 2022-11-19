package com.health.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.health.dao.ProgramDAO;
import com.health.domain.HealthProVO;

@Repository("programService")
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramDAO programDAO;
	
	@Override
	public boolean createProgram(HealthProVO vo) {
		return programDAO.insert(vo);
	}

	@Override
	public HealthProVO search(int pid) {
		return programDAO.selectOne(pid);
	}

	@Override
	public ArrayList<HealthProVO> getList() {
		return programDAO.selectAll();
	}

	@Override
	public boolean modify(HealthProVO vo) {
		return programDAO.update(vo);
	}

	@Override
	public void removeProgram(int pid) {
		programDAO.delete(pid);
	}

}
