package com.health.domain;

import lombok.Data;

@Data
public class HealthProVO {
	private int pid;
	private String name;
	private String date;
	private int times;
	private int totalPerson;
}
