package com.pickmeup.model;

import java.sql.Date;

import lombok.Data;

//경매 정보
@Data
public class Auction {

	 // 입찰 순번 
    private int auc_Seq;

    // 회원 아이디 
    private String mem_Id;

    // 입찰 가격 
    private int auc_Price;

    // 입찰 시간 
    private String auc_Time;

    // 상품 번호 
    private int pro_Num;

    // 입찰 보증금 
    private int auc_Deposit;
}

