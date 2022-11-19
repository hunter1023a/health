package com.health.service;

import java.util.ArrayList;

import com.health.domain.HealthProVO;

public interface ProgramService {
	public boolean createProgram(HealthProVO vo);
	
	public HealthProVO search(int pid);
	
	public ArrayList<HealthProVO> getList();
	
	public boolean modify(HealthProVO vo);
	
	public void removeProgram(int pid);
}
