package com.chinalsoft.test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.chinalsoft.util.SessionUtil;
import com.chinasoft.mapper.StudentMapper;
import com.chinasoft.pojo.Gender;
import com.chinasoft.pojo.Student;
public class StudentMapperTest {

	//全局变量
		public SqlSessionFactory factory = SessionUtil.getSession();
	
		@Test
		public void selectAllStudent() {
			SqlSession session = factory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			List<Student> students = mapper.selectAllStudent();
			for(Student student:students) {
				System.out.println(student);
				}
			session.close();
		}
		
		@Test
		public void selectOneAll() {
			SqlSession session = factory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student =mapper.selectOneAll(5);
			System.out.println(student);
			session.close();
		}
	    @Test
		public void selectOAll() {
			SqlSession session = factory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student =mapper.selectOneAll(5);
			System.out.println(student);
			session.close();
		}
	    
	    //1对多查询：查找某个班的所有学生
	    @Test
  		public void selectStudent() {
  			SqlSession session = factory.openSession();
  			StudentMapper mapper = session.getMapper(StudentMapper.class);
  			List<Student> students =mapper.selectStudent(1);
  			
  			for(Student student:students) {
  			System.out.println(student);
  			}
  			session.close();
  		}
	    
	public static void main(String[] args) {

		//new StudentMapperTest().selectAllStudent();
		//new StudentMapperTest().selectOneAll();
		//new StudentMapperTest().selectOAll();
		new StudentMapperTest().selectStudent();
	}

}
