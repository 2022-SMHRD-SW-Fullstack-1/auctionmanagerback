package com.pickmeup.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickmeup.model.Product;
import com.pickmeup.model.Winning_bid;
import com.pickmeup.service.MypageService;

import java.text.SimpleDateFormat;
import java.util.Collections;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MypageController {

	@Autowired
	MypageService mypageService;
	
	//입찰참여중인 정보들에 대해 리스트로 만들어 프론트로 리턴
		@GetMapping("/mypage/biding/{memid}")
		public List<Product> bidingList(@PathVariable("memid")String id){
			List<Product> mybidingList = mypageService.selectAllBiding(id);
			
			return mybidingList;
		}



	// 낙찰 정보들에 대해 리스트로 만들어 프론트로 리턴한다.
	@GetMapping("/mypage/bid/{memid}")
	public List<Winning_bid> bidList(@PathVariable("memid") String id) {

		List<Winning_bid> bidList = mypageService.selectAllBid(id);

		/*
		 * 리스트의 인덱스의 원하는 요소에 추가하는 방식. ArrayList<String> proname = new ArrayList<>();
		 * for(int i=0; i<=list.size(); i++) { proname.add(i,
		 * mypageService.selectProName(list.get(i).getPro_Num()));
		 * list.get(i).setPro_Name(proname.get(i)); }
		 */

		return bidList;
	}

	// 체크 정보 수정
	@GetMapping("/payCk")
	public void setPayCheck(@RequestParam int num) {
		mypageService.setPayCheck(num);
	}
	
	// 정산금 정산
	@GetMapping("/calculate/{memid}")
	public void setCalculate(@PathVariable("memid") String id,@RequestParam int num) {
	if(mypageService.setCalculate(id,num)==1) {
	mypageService.CalculateSuccess(num);
	}
	}
	
	//진행중인 경매정보
	@GetMapping("/auctionList")
	public List<Date> selectDeadlineList(){
		List<Date> datelist = new ArrayList<Date>();
		
		List<Product> list = mypageService.selectDeadlineList();
		System.out.println(list);
		
		for(int i=0; i<list.size(); i++) {
		datelist.add(list.get(i).getDeadline());
		}
		
		System.out.println(datelist);
		
		return datelist;
	}
	
	//마감기한 지날시 낙찰리스트로 만들어주기.
	@RequestMapping(value = "/setbid", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String setBidList(@RequestBody ArrayList<Date> date) {
				
		//받아온 날짜를 sql로 넘겨주기 위한 형식으로 변환한다.
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(date);
		
		//형변환 해준 날짜를 새로운 ArrayList에 추가한다.
		ArrayList<String> dateList = new ArrayList<>();
		for(int a=0; a<date.size(); a++) {
			if(date.get(a)!=null) {
				dateList.add(simpleDateFormat.format(date.get(a)));
			}
		}
		System.out.println(dateList);
		
		
		//날짜가 제일 늦은날짜가 인덱스 맨뒤에 온다.
		List<Winning_bid> bidList = mypageService.selectDeadPro(dateList.get(dateList.size()-1));
		System.out.println(bidList);
		
		System.out.println("bidlist: "+bidList.get(0));
		
		for(int b=0; b<bidList.size(); b++) {//마감기한 조건 검색 후 낙찰시킬 데이터를 검색
			
			int bidck = mypageService.selectBidCheck(bidList.get(b).getPro_Num());
			
			if(bidck==0) {
				mypageService.setBidList(bidList.get(b));
				System.out.println("succees");
			}else {
				System.out.println("이미 있습니다.");
			}
				
		}

		return "success";
	}
}
