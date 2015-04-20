package com.mygudou.app.model;
import java.util.List;

/**
 * User信息 role:1--律师 0--用户 sex: 1--男 0--女
 */
public class Lawyer extends User{

    
    private List<Integer> customer;

	public List<Integer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Integer> customer) {
		this.customer = customer;
	}

}