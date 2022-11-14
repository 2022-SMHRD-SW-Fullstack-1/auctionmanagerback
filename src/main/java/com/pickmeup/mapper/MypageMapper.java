package com.pickmeup.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pickmeup.model.Product;
import com.pickmeup.model.Winning_bid;

@Mapper
public interface MypageMapper {
	// 낙찰정보
	public List<Winning_bid> selectAllBid(String id);

	// 필요 낙찰정보
	public List<Winning_bid> selectBidInfo(int num);

	// 시퀀스
	public List<Winning_bid> selectSequence(String id);

	// 상품정보
	public List<Product> selectAllPro(String id);

	// 결제여부
	public String selectPayCheck(int num);

	// 배송주소
	public String selectDeliveryAddr(int num);

	// 구매확정여부
	public String selectDeliveryCheck(int num);

	// 납부여부 확인
	public void setPayCheck(int num);

	// 정산금 정산
	public void setCalculate(String id, int num);

	// 정산완료시 초기화
	public void CalculateSuccess(int num);
	
	// 경매정보 불러오기
	public List<Product> selectDeadlineList();
	
	// 마감정보로 검색
	public List<Winning_bid> selectDeadPro(String dateList);
	
	// 낙찰정보 등록
	public void setBidList(Winning_bid Winning_bid);
	
	public int selectBidCheck(int num);
	
}
