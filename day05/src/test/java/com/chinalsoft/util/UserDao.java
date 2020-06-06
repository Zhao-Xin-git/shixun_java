package com.chinalsoft.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;

public class UserDao {

	public SqlSessionFactory factory = SessionUtil.getSession();
	public List<User> getAll(int currentPage,int pageSize) throws IOException {
        SqlSession  session = factory.openSession();
        Map<String,Integer> map = new HashMap<String, Integer>();

        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.getAllMap(map);
        session.close();
        return list;
    }

}
