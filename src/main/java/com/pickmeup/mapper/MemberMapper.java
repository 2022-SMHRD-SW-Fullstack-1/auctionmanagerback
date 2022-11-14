package com.pickmeup.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.pickmeup.model.Member;

@Mapper
public interface MemberMapper {

	// 회원가입
	// 아이디 중복 체크
	public String idCheck(String id);

	// 회원가입
	public int joinMember(String id, String pw, String name, String nick, String birthday, String gender, String phone,
			String addr);
//public int joinMember(Member member, member.getMem_Id(), member.getMem_Pw(), member.getMem_Name(), member.getMem_Nick(), member.getMem_Birthdate(), member.getMem_Gender(), member.getMem_Addr(), member.getMem_Phone());

//로그인
	@Select("select mem_id, mem_pw from t_member where mem_id=#{id} and mem_pw=#{pw}")
	public String loginMember(String id, String pw);

//마이페이지
	public Member viewMyPage(String id);

//판매자에게 보낼 주소 저장
	public void insertAddr(String memId, int num);

//아래 모두 정보 불러오는 목적(픽머니~판매자)
	public int getPickMoney(String memId);

	public String getNick(String memId);

	public String getAddr(String memId);

	public String getPhoto(int pronum);

	public String getName(int pronum);

	public int getPay(int pronum);

	public int getDepo(int pronum);

	public String getMem(int pronum);

	// 픽머니 충전
	public void setPickMoney(String memId, int money);

	// 주소지 변경
	public void setAddr(String memId, String Addr);

	// 결제와 동시에 정산금액 수정
	public void updateSettle(int num, int money);

	// 픽머니 결제
	public void PayMoney(String memId, int money);

	// 회원정보 수정
	public void changeInfo(String memId, Member member);
}
