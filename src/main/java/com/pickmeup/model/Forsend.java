package com.pickmeup.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@NoArgsConstructor
public class Forsend {

    // 판매자 아이디
	@NonNull
    private String mem_Id; 

    // 상품 명
	@NonNull
    private String pro_Name;
    
    // 상품 사진 
	@NonNull
    private String pro_Photo;
    
    // 최종 낙찰가 
	@NonNull
    private int wb_Price;
    
    // 입찰 보증금 
	@NonNull
    private int auc_Deposit;
    
    
}
