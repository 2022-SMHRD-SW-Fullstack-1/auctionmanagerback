package com.pickmeup.model;

import lombok.Data;

//구매자 리뷰 
@Data
public class Review {
	
	// 리뷰 순번 
    private int rv_Seq;

    // 리뷰 내용 
    private String rv_Content;

    // 평점 
    private Double rv_Rating;

    // 회원 아이디 
    private String mem_Id;

    // 상품 번호 
    private int pro_Num;
    
    //프론트에서 사용할 요소
    
    // 총 평점
    private double sum_rv_Rating;
    
    // 상품 이름
    private String pro_Name;
    
}
