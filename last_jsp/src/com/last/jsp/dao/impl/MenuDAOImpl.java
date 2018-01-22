package com.last.jsp.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.last.jsp.MybatisSqlSessionFactory;

public class MenuDAOImpl implements MenuDAO {
	private static Logger log = Logger.getLogger(MenuDAOImpl.class);
	
	public List<Map<String,String>> selectMenuList() {
		try(SqlSession ss = MybatisSqlSessionFactory.getSS()) {
			return ss.selectList("menu.selectMenu");
			
		}catch(Exception e){
			log.error("err=> {}",e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		MenuDAO mdao = new MenuDAOImpl();
		List<Map<String,String>> list = mdao.selectMenuList();
		for(Map<String,String> m:list) {
			log.info("test m=>" + m);
		}
	}

}
