package com.mygudou.app.model.user;
import java.util.List;

/**
 * 律师身份
 */
public class Lawyer extends IUser{


	private static final long serialVersionUID = 1558315475089553007L;
	private List<Integer> customer;

	public List<Integer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Integer> customer) {
		this.customer = customer;
	}

}