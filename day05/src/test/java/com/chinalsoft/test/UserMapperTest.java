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
	
	//鍏ㄥ眬鍙橀噺
	public SqlSessionFactory factory = SessionUtil.getSession();
	
	//闇�瑕佹椂鍒涘缓session
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
		
		//涓�绾х紦瀛�
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
	//Junit鍚姩娴嬭瘯
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
	
	//鍔ㄦ�乻ql_foreach
	//鐢╥d鑼冨洿鏌ユ壘user
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
	
	//鍒嗛〉鍔熻兘
	@Test
	public void getAllPage() throws IOException {
		UserDao userDao = new UserDao();
        //杩欎釜浼犺繘鏉ョ殑绗竴涓弬鏁版槸浣犺鏄剧ず绗嚑椤电殑鏁版嵁锛岀浜屾槸浣犻渶瑕佹病椤垫樉绀哄嚑鏉¤褰�
        List<User> users = userDao.getAll(2, 3);
        for (User user : users) {
            System.out.println(user.toString());
        }
	}
	
	//鍔ㄦ�佹坊鍔犵敤鎴�
	@Test
	public void addUserDynamic() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		Scanner in=new Scanner(System.in);
		System.out.println("璇疯緭鍏ョ敤鎴蜂俊鎭紝鐢ㄩ�楀彿闅斿紑锛�");
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
		System.out.println("达成共识");

	}
	
	}		


