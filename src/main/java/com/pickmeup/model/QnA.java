package com.pickmeup.model;

import java.sql.Date;

import lombok.Data;

//상품 질의 응답 
@Data
public class QnA {
	
	 // 질답 순번 
    private int qna_Seq;

    // 상품 순번 
    private int pro_Num;

    // 질문 
    private String qna_Content;

    // 질문 작성일자 
    private String qna_Date;

    // 회원 아이디 
    private String mem_Id;
    
}
