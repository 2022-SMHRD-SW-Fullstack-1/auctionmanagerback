package com.pickmeup.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.pickmeup.mapper.MypageMapper;
import com.pickmeup.model.Product;
import com.pickmeup.model.Winning_bid;

@Service
public class MypageService {
	@Autowired
	MypageMapper mypageMapper;

	// id에 대한 낙찰정보 전부 가져오기
	public List<Winning_bid> selectAllBid(String id) {
		return mypageMapper.selectAllBid(id);
	}

	//
	public List<Winning_bid> selectSequence(String id) {
		return mypageMapper.selectSequence(id);
	}

	// 낙찰정보에 대한 선택정보
	public List<Winning_bid> selectBidInfo(int num) {
		return mypageMapper.selectBidInfo(num);
	}

	// id에 대한 판매중인 상품 전부 가져오기
	public List<Product> selectAllPro(String id) {
		return mypageMapper.selectAllPro(id);
	}

	// 결제여부 확인
	public String selectPayCheck(int num) {
		return mypageMapper.selectPayCheck(num);
	}

	// 배송보내야 할 주소 확인
	public String selectDeliveryAddr(int num) {
		return mypageMapper.selectDeliveryAddr(num);
	}

	// 구매확정 여부 확인
	public String selectDeliveryCheck(int num) {
		return mypageMapper.selectDeliveryCheck(num);
	}

	// 결제 여부 변경
	public void setPayCheck(@RequestParam int num) {
		mypageMapper.setPayCheck(num);
	}

	// 정산금 정산
	public int setCalculate(String id, @RequestParam int num) {
		mypageMapper.setCalculate(id, num);
		
		return 1;
	}
	
	public void CalculateSuccess(int num) {
		mypageMapper.CalculateSuccess(num);
	}
	
	//경매정보 불러오기
	public List<Product> selectDeadlineList(){
		return mypageMapper.selectDeadlineList();
	}
	
	//마감기한으로 검색
	public List<Winning_bid> selectDeadPro(String dateList) {
		return mypageMapper.selectDeadPro(dateList);
	}
	
	
	//낙찰등록
	public void setBidList(Winning_bid Winning_bid) {
		mypageMapper.setBidList(Winning_bid);
	}

	public int selectBidCheck(int num) {
		return mypageMapper.selectBidCheck(num);
	}
}
