package com.pickmeup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.pickmeup.model.Product;
import com.pickmeup.model.QnA;

@Mapper
public interface QnAMapper {

	@Insert("insert into T_QNA values(null,#{pro_Num},#{qna_Content},localtimestamp,#{mem_Id})")
	public void newComment(int pro_Num, String qna_Content,String mem_Id);

	//해당 게시글 QnA 불러오기
	@Select("select * from T_QnA where pro_Num=#{pro_Num}")
	public List<QnA> commentView(Product pro_Num);
		
}