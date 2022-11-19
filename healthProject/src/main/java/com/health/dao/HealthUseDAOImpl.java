package com.health.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.health.domain.HealthUseVO;

import lombok.extern.log4j.Log4j;

@Repository("healthUseDAO")
@Log4j
public class HealthUseDAOImpl implements HealthUseDAO {
	
	ArrayList<HealthUseVO> hDB = new ArrayList<>();

	@Override
	public boolean insert(HealthUseVO hvo) {
		boolean result = false;
		
		result = hDB.add(hvo);
		
		return result;
	}

	@Override
	public int updateUse(int healthUseNo) {
		int result = 0;
		
		for (HealthUseVO hvo:hDB) {
			if(hvo.getHealthUseNo() == healthUseNo) {
				int use = hvo.getUsingHealth();
				hvo.setUsingHealth(use-1);
				if(hvo.getUsingHealth()+ 1 == use) {
					result = 1;
				}
			}
		}
		
		return result;
	}

	@Override
	public boolean delete(int healthUseNo) {
		boolean result = false;
		
		for (HealthUseVO hvo: hDB) {
			if (hvo.getHealthUseNo() == healthUseNo) {
				result = hDB.remove(hvo);
			}
		}
		
		return result;
	}

}
