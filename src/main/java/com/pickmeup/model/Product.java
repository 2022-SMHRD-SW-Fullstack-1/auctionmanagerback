package com.pickmeup.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//상품 목록 
@RequiredArgsConstructor
@Data
@NoArgsConstructor
public class Product {
	
	 // 상품 번호 
    private int pro_Num;

    // 회원 아이디 
    private String mem_Id; 

    // 상품 명 
    private String pro_Name;

    // 입찰 시작가 
    private int pro_Min_Price;

    // 상품 마감기한 
    private String pro_Deadline;
    
    // 상품 설명 
    private String pro_Desc;

    // 상품 브랜드 
    private String pro_Brand;

    // 상품 카테고리 
    private String pro_Category;

    // 상품 상태 
    private String pro_Status;

    // 상품 사진 
    private String pro_Photo;
    
    // 다른 테이블의 조인을 위한 요소
	
    // 입찰 참여자수
    private int pro_Participants;
    
    // 현재 입찰가 
    private int auc_Price;
    
    //결제여부 체크
	@NonNull
    private String pay_Check;
    
    //낙찰자 배송 주소
    @NonNull
    private String wb_Delivery_Addr;
    
    //정산 버튼 생성을 위한 구매확정 여부 체크
    @NonNull
    private String delivery_Check;
    
    // 날짜용 데이터
    private Date Deadline;
    
    // 나의 입찰가
    private int my_auc_Price;
    
}