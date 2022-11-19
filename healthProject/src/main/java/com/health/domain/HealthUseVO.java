package com.health.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthUseVO {
	
	private int healthUseNo;
	private String name;
	private String startDate;
	private String endDate;
	private int usingHealth;
	private String memId;

}
