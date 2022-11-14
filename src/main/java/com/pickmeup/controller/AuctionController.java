package com.pickmeup.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pickmeup.model.Auction;
import com.pickmeup.model.Member;
import com.pickmeup.model.Product;
import com.pickmeup.service.AuctionService;

@RestController
@CrossOrigin(origins = "*")
public class AuctionController {

Gson gson = new Gson();
	
	@Autowired
	AuctionService auctionService;
	
	@PostMapping("/detail/auc")
	public String aucStart(@RequestBody HashMap<String,Object> auction ){
		System.out.println("입찰 : " + auction);
		String jsonStr=gson.toJson(auction);
		System.out.println("제이슨입찰 :"+jsonStr);
		
		
		Auction user=gson.fromJson(jsonStr,Auction.class);
		System.out.println(user.toString());
		
		Member mem=gson.fromJson(jsonStr, Member.class);
		
		
		int aucM=auctionService.pickIsNull(mem.getMem_Id());
		System.out.println("해쉬맵 입찰머니"+aucM);
		
		String pb=auctionService.proBid(user.getPro_Num(), user.getMem_Id());
		System.out.println("머가 넘어오지?"+pb);
		

		
		if(aucM!=0) {
			if(pb==null) {
				auctionService.newBid(user.getMem_Id(),user.getAuc_Price(),user.getPro_Num(),user.getAuc_Deposit());
//				auctionService.pickMoneyMinusDepo(mem.getMem_Id(),mem.getMem_Pickmoney());
				return "yes";
			}else {
				auctionService.upDateBid(user.getMem_Id(),user.getAuc_Price(),user.getPro_Num(),user.getAuc_Deposit());
				return "yes";
			}
		}else{
			return "no";
		}
		
		
		
	}
	
	}

