package com.pickmeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pickmeup.mapper.ReviewMapper;
import com.pickmeup.model.Review;

@Service
public class ReviewService {

	@Autowired
	ReviewMapper reviewMapper;

	public String addComment(String mem_Id, String rv_Content) {
		return reviewMapper.addComment(mem_Id, rv_Content);

	}

	// 리뷰삽입
	public void insertReview(String id, Review review) {
		reviewMapper.insertReview(id, review);
	}

	// 나에 대한 리뷰 리스트 불러오기(평가받는관점)
	public List<Review> selectOtherReview(String id) {
		return reviewMapper.selectOtherReview(id);
	}

	// 내가 쓴 리뷰 리스트 불러오기(작성자관점)
	public List<Review> selectMyReview(String id) {
		return reviewMapper.selectMyReview(id);
	}

	// 평균 리뷰점수 구하기
	public float selectSumRating(String id) {
		return reviewMapper.selectSumRating(id);
	}

}
