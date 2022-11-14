package com.pickmeup.model;

import java.sql.Date;

import lombok.Data;

//낙찰 정보 
@Data
public class Winning_bid {

	// 낙찰 순번
	private int wb_Seq;

	// 상품 번호
	private int pro_Num;

	// 최종 낙찰가
	private int wb_Price;

	// 회원 아이디
	private String mem_Id;

	// 배송 주소
	private String wb_Delivery_Addr;

	// 물품 수령 여부
	private String delivery_Check;

	// 구매기한
	private String Pay_Deadline;

	// 정산금액
	private int Pay_Settlement;

	// 결제여부
	private String Pay_Check;

	// 다른 테이블 조인을 위한 요소

	// 상품 명
	private String pro_Name;

	// 상품 낙찰일자( = 경매 마감일)
	private String pro_Deadline;

	// 시퀀스
	private int sequence;
}