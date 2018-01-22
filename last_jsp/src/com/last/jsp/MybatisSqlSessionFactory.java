package com.last.jsp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
       
public class MybatisSqlSessionFactory {
	private static SqlSessionFactory ssf;
	static {
		try(InputStream is = Resources.getResourceAsStream("conf/mybatis-config.xml")) {
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSSF() {
		return ssf;
	}
	
	public static SqlSession getSS() {
		return ssf.openSession();
	}

	public static void main(String[] args) {
		try(SqlSession ss = MybatisSqlSessionFactory.getSS()) {
			List<Map> list = ss.selectList("menu.selectMenu");
		    for(Map<String, String> m : list) {
		    	System.out.println(m);
		    }
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
