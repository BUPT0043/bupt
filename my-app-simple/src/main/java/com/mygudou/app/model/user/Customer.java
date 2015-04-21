package com.mygudou.app.model.user;

import java.util.List;

/**
 * 普通用户身份
 */
public class Customer extends IUser{


	private static final long serialVersionUID = 4291424906554030847L;
	private List<Integer> lawyer;

	public List<Integer> getLawyer() {
		return lawyer;
	}

	public void setLawyer(List<Integer> lawyer) {
		this.lawyer = lawyer;
	}

}
