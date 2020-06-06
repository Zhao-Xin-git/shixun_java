package com.chinasoft.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chinasoft.pojo.Gender;
public interface GenderMapper {

	//查询某个班级的所有学生
	Gender selectGenderWithUser(int id);
}
