package com.groupshop.dao;

import com.groupshop.entity.Opt;

public interface Login {
	public String checkUser(Opt opt);
	public Opt getUserInfoByName(String uName);
}
