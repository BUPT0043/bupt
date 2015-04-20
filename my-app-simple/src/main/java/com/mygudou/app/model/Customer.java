package com.mygudou.app.model;

import java.util.List;

/**
 * User信息 role:1--律师 0--用户 sex: 1--男 0--女
 */
public class Customer extends User{

    private List<Integer> lawyer;

	public List<Integer> getLawyer() {
		return lawyer;
	}

	public void setLawyer(List<Integer> lawyer) {
		this.lawyer = lawyer;
	}

}
