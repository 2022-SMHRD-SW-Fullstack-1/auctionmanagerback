package com.pickmeup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pickmeup.model.Member;
import com.pickmeup.model.Review;
import com.pickmeup.service.ReviewService;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {

	Gson gson = new Gson();
	
	@Autowired
	ReviewService reviewService;

	@GetMapping("/detail/comm")
	public String addComment(@RequestBody Review review) {
		System.out.println(review);
		
		String jsonStr = gson.toJson(review);
		System.out.println("리뷰내용: " + jsonStr);

		Review rev = gson.fromJson(jsonStr, Review.class);
		System.out.println(rev.toString());

		String revC = reviewService.addComment(rev.getMem_Id(), rev.getRv_Content());

		return revC;
	}
	
	// 리뷰 등록
		@RequestMapping(value = "/review/{memid}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
		public String insertReview(@PathVariable("memid") String id, @RequestBody Review review) {
			if (review.getRv_Content() != null) {
				System.out.println(review);

				reviewService.insertReview(id, review);

				return "success";

			} else {

				return "fail";

			}

		}
		
		//나, 판매자에 대한 리뷰 리스트 불러오기(평가받는관점)
		@GetMapping("/otherReview/{memid}")
		public List<Review> selectOtherReview(@PathVariable("memid") String id){
			List<Review> reviewotherlist = reviewService.selectOtherReview(id);
			
			return reviewotherlist;
		}
		
		//내가 쓴 리뷰 리스트 불러오기(작성자관점)
		@GetMapping("/myReview/{memid}")
		public List<Review> selectMyReview(@PathVariable("memid") String id){
			List<Review> reviewmylist = reviewService.selectMyReview(id);
			
			return reviewmylist;
		}
		
		//판매자의 리뷰 평균점수
		@GetMapping("/otherReview/SumRating/{memid}")
		public float selectSumRating(@PathVariable("memid") String id){
			float sum = reviewService.selectSumRating(id);
			
			return sum;
		}


}
