package com.nttdata.bootcamp.project1.accounts.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

	private String number;
	private Integer userId;
	private String accountType;
	private String currencyName;
	private BigDecimal amount;

}
