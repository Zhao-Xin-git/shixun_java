package com.chinalsoft.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.junit.Test;

import com.chinalsoft.util.SessionUtil;
import com.chinalsoft.util.UserDao;
import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;

public class UserMapperTest {
	
	//全局变量
	public SqlSessionFactory factory = SessionUtil.getSession();
	
	//需要时创建session
	@Test
	public void addUserNoPar() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.addUserNoPar();
		session.commit();
		session.close();
	}
	
	public void addUserByPar() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User(15,"777","123456","13546548648","chengdu","1231565@qq.com",0);
		mapper.addUserByPar(user);
		session.commit();
		session.close();
	}
	
	@Test
	public void selectOneUser() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selectOneUser(5);
		System.out.println(user);
		
		//一级缓存
		/*
		session.clearCache();
		User user1 = mapper.selectOneUser(5);
		System.out.println(user1);
		session.close();
		*/
	}
	
	public void selectAllUser() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> user = mapper.selectAllUser();
		for(User user2:user) {
			System.out.println(user2);
			}
		session.close();
	}
	
	public void selectLogin() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("777");
		user.setPassword("123456");
		User user1 = mapper.selectLogin(user);
		System.out.println(user1);
		session.close();
	}
	//Junit启动测试
	@Test
	public void selectOrderBy() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = mapper.selectOrderBy("id");
		for(User user:users) {
			System.out.println(user);
			}
	}	
	@Test
	public void findUserWithIf(){
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("lol");
		User users =mapper.findUserWith_if(user);
		System.out.println(users);
		session.close();
	
	}
	
	//动态sql_foreach
	//用id范围查找user
	@Test
	public void findUsersWithId(){
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	    list.add(2);
	    list.add(3);
	    List<User> users = mapper.findUsersWithId(list);
	    for(User user:users) {
			System.out.println(user);
			}
	}
	
	//分页功能
	@Test
	public void getAllPage() throws IOException {
		UserDao userDao = new UserDao();
        //这个传进来的第一个参数是你要显示第几页的数据，第二是你需要没页显示几条记录
        List<User> users = userDao.getAll(2, 3);
        for (User user : users) {
            System.out.println(user.toString());
        }
	}
	
	//动态添加用户
	@Test
	public void addUserDynamic() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		Scanner in=new Scanner(System.in);
		System.out.println("请输入用户信息，用逗号隔开：");
		String s=in.nextLine();
		String[] userInfom = s.split(",");
		user.setUsername(userInfom[0]);
		user.setPassword(userInfom[1]);
		user.setPhone(userInfom[2]);
		user.setAddress(userInfom[3]);
		user.setEmail(userInfom[4]);
		mapper.addUserDynamic(user);
		session.commit();
		session.close();
	}
	
	public static void main(String[] args) {
		//new UserMapperTest().addUserNoPar();
		//new UserMapperTest().addUserByPar();
		//new UserMapperTest().selectOneUser();
		//new UserMapperTest().selectLogin();
		//new UserMapperTest().selectOrderBy();
		new UserMapperTest().addUserDynamic();
		System.out.println("777");
	}
	
	}		


