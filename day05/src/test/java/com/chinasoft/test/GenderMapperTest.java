package com.chinasoft.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.chinalsoft.util.SessionUtil;
import com.chinasoft.mapper.GenderMapper;
import com.chinasoft.pojo.Gender;

public class GenderMapperTest {

	public SqlSessionFactory factory = SessionUtil.getSession();
	
	@Test
	public void selectGenderWithUser() {
		SqlSession session = factory.openSession();
		GenderMapper mapper = session.getMapper(GenderMapper.class);
		Gender gender = mapper.selectGenderWithUser(1);
		System.out.print(gender);
		session.close();
	}

}
