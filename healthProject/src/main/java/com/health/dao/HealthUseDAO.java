package com.health.dao;

import com.health.domain.HealthUseVO;

public interface HealthUseDAO {
	
	public boolean insert(HealthUseVO hvo);  //이용권 생성
	public int updateUse(int healthUseNo);   //이용권 고유 번호를 이용하여 차감
	public boolean delete(int healthUseNo);  //이용권 번호를 이용하여 소멸... 
	

}
