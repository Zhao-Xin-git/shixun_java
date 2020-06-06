package com.chinasoft.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.chinasoft.pojo.User;

public interface UserMapper {

	//没有参数的添加
	void addUserNoPar();
	
	//有参数添加用户
	void addUserByPar(User user);
	
	//有参数和返回值的查询一个用户
	User selectOneUser(int id);
	
	//用注解的方法查询所有用户
	@Select("select * from user") 
	List <User> selectAllUser();
	
	//登陆——当参数多的时候，#{里边不能随意命名}
	User selectLogin(User user);
	
	//按字段排序——字符串拼接${column}一定要加上注解，点名那个字符串是什么
	List<User> selectOrderBy(@Param("column")String column);

   //动态sql_if
	User findUserWith_if(User user);
	
	//查询id在某个范围的user
	List<User> findUsersWithId(List<Integer> list);
	
	//分页功能
	List<User> getAllMap(Map<String,Integer> map);
	
	//动态添加用户
	void addUserDynamic(User user);
}
