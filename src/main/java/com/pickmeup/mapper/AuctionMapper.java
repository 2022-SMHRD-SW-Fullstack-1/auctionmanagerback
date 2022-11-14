package com.pickmeup.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pickmeup.model.Auction;
import com.pickmeup.model.Member;

@Mapper
public interface AuctionMapper {
	
	@Select("select mem_pickmoney from t_member where mem_id = #{mem_Id}")
	public int pickIsNull(String mem_id);
	
	//해당 상품에 경매 참여하고 있는지
	@Select("select mem_id from t_auction where pro_Num=#{pro_Num} and mem_id=#{mem_Id} ")
	public String proBid(int pro_Num, String mem_Id);
	
	@Insert("insert into t_auction values(null,#{mem_id},#{auc_price},localtimestamp,#{pro_num},#{auc_deposit})")
	public void newBid(String mem_id,int auc_price, int pro_num, int auc_deposit);

	@Update("update t_auction set auc_price=#{auc_price} where pro_num=#{pro_num} and mem_id=#{mem_id}")
	public void upDateBid(String mem_id,int auc_price, int pro_num, int auc_deposit);
	
//	@Update("update t_member set mem_pickmoney=#{mem_pickmoney}")
//	public void pickMoneyMinusDepo(String mem_id,int mem_pickmoney);
}
