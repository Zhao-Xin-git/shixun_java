package com.chinasoft.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chinasoft.pojo.Gender;
import com.chinasoft.pojo.Student;
public interface StudentMapper {

	//取所有学生
	List<Student> selectAllStudent();
	
	//查看某个学生的所有信息
	Student selectOneAll(int id);
	
	//查看某个学生的所有信息另一种形式
	Student selectOAll(int id);
		
	//查看某个班的所有学生
	List<Student> selectStudent(int id);
}
