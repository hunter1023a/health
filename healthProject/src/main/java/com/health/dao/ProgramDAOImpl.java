package com.health.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.health.domain.HealthProVO;

@Repository("programDAO")
public class ProgramDAOImpl implements ProgramDAO {
	// DB
	ArrayList<HealthProVO> programDB = new ArrayList<HealthProVO>();
	
	private int pid = 1; // seq
	
	@Override
	public boolean insert(HealthProVO vo) {
		boolean rv = false;
		
		vo.setPid(pid);
		rv = programDB.add(vo);
		if(rv) {
			pid++;
		}
		return rv;
	}

	@Override
	public HealthProVO selectOne(int pid) {
		for(HealthProVO target : programDB) {
			if(target.getPid() == pid) {
				return target;
			}
		}
		return null;
	}

	@Override
	public ArrayList<HealthProVO> selectAll() {
		return programDB;
	}

	@Override
	public boolean update(HealthProVO vo) {
		boolean rv = false;
		for(HealthProVO target : programDB) {
			if(target.getPid() == vo.getPid()) {
				target.setDate(vo.getDate());
				target.setTimes(vo.getTimes());
				target.setTotalPerson(vo.getTotalPerson());
				
				rv = true;
			}
		}
		return rv;
	}

	@Override
	public void delete(int pid) {
		int idx = 0;
		for(HealthProVO target : programDB) {
			if(target.getPid() == pid) {
				programDB.remove(idx);
				break;
			}
			idx++;
		}
	}
}
