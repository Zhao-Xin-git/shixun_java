package com.chinasoft.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chinasoft.pojo.Gender;
public interface GenderMapper {

	//��ѯĳ���༶������ѧ��
	Gender selectGenderWithUser(int id);
}
