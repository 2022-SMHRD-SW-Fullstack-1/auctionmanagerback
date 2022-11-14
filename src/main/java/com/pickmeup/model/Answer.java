package com.pickmeup.model;

import java.sql.Date;

import lombok.Data;

//질답 응답 
@Data
public class Answer {
	
	// 응답 순번 
    private int ans_Seq;

    // 질답 순번 
    private int qna_Seq;

    // 응답 내용 
    private String ans_Content;

    // 응답 작성일자 
    private String ans_Date;

    // 회원 아이디 
    private String mem_Id;
}
