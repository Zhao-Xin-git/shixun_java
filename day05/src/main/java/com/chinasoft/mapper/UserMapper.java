package com.chinasoft.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.chinasoft.pojo.User;

public interface UserMapper {

	//û�в��������
	void addUserNoPar();
	
	//�в�������û�
	void addUserByPar(User user);
	
	//�в����ͷ���ֵ�Ĳ�ѯһ���û�
	User selectOneUser(int id);
	
	//��ע��ķ�����ѯ�����û�
	@Select("select * from user") 
	List <User> selectAllUser();
	
	//��½�������������ʱ��#{��߲�����������}
	User selectLogin(User user);
	
	//���ֶ����򡪡��ַ���ƴ��${column}һ��Ҫ����ע�⣬�����Ǹ��ַ�����ʲô
	List<User> selectOrderBy(@Param("column")String column);

   //��̬sql_if
	User findUserWith_if(User user);
	
	//��ѯid��ĳ����Χ��user
	List<User> findUsersWithId(List<Integer> list);
	
	//��ҳ����
	List<User> getAllMap(Map<String,Integer> map);
	
	//��̬����û�
	void addUserDynamic(User user);
}
