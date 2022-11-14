package com.pickmeup.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickmeup.mapper.AuctionMapper;
import com.pickmeup.model.Auction;
import com.pickmeup.model.Member;
import com.pickmeup.model.Product;

@Service
public class AuctionService {
	
	@Autowired
	AuctionMapper auctionMapper;
	
	//입찰 전 픽머니 조회
	public int pickIsNull(String mem_id){
		int mem= auctionMapper.pickIsNull(mem_id);

		return mem;
	}
	
	//해당 상품에 대한 입찰 참여 여부
	public String proBid(int pro_Num, String mem_Id) {
		String pb= auctionMapper.proBid(pro_Num, mem_Id);
		return pb;
	}
	public void newBid(String mem_id,int auc_price, int pro_num, int auc_deposit) {
		auctionMapper.newBid(mem_id,auc_price,pro_num,auc_deposit);
	}
	public void upDateBid(String mem_id,int auc_price, int pro_num, int auc_deposit) {
		auctionMapper.upDateBid(mem_id,auc_price,pro_num,auc_deposit);
	}
	
//	public void pickMoneyMinusDepo(String mem_id,int mem_pickmoney) {
//		auctionMapper.pickMoneyMinusDepo(mem_id,mem_pickmoney);
//	}

}
