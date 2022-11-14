package com.pickmeup.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// 회원 정보 
@RequiredArgsConstructor
@Data
@NoArgsConstructor
public class Member {

	 // 회원 아이디 
    private String mem_Id;

    // 회원 비밀번호 
    private String mem_Pw;

    // 회원 이름 
    private String mem_Name;

    // 회원 닉네임 
    @NonNull
    private String mem_Nick;

    // 회원 생년월일 
    private String mem_Birthdate;

    // 회원 성별 
    private String mem_Gender;

    // 회원 주소 
    @NonNull
    private String mem_Addr;

    // 회원 픽머니 
    @NonNull
    private int mem_Pickmoney;

    // 참여중인 경매 
    private String mem_Ing_Aution;

    // 구매한 상품 
    private String mem_Get_Product;

    // 판매중인 상품 
    private String mem_Ing_Sell;

    // 회원 가입일자 
    private Date mem_Joindate;

    // 회원 유형 
    private String mem_Type;
    
    // 회원 전화번호
    private String mem_Phone;
}

