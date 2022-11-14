package com.pickmeup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pickmeup.model.Review;

@Mapper
public interface ReviewMapper {

public String addComment(String mem_Id, String rv_Content);
	
	public void insertReview(String id, Review review);
	
	//남이 쓴 리뷰 리스트 불러오기(평가대상관점)
	public List<Review> selectOtherReview(String id);
	
	//내가 쓴 리뷰 리스트 불러오기(작성자관점)
	public List<Review> selectMyReview(String id);
	
	//평균 리뷰점수 구하기
	public float selectSumRating(String id);
}
