package com.chinasoft.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chinasoft.pojo.Gender;
import com.chinasoft.pojo.Student;
public interface StudentMapper {

	//ȡ����ѧ��
	List<Student> selectAllStudent();
	
	//�鿴ĳ��ѧ����������Ϣ
	Student selectOneAll(int id);
	
	//�鿴ĳ��ѧ����������Ϣ��һ����ʽ
	Student selectOAll(int id);
		
	//�鿴ĳ���������ѧ��
	List<Student> selectStudent(int id);
}
