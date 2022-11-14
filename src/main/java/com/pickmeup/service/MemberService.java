package com.pickmeup.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickmeup.mapper.MemberMapper;
import com.pickmeup.model.Member;

@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;

	// 회원가입
	// 아이디 중복 체크
	public String idCheck(String id) {
		return memberMapper.idCheck(id);
	}

	// 회원가입
	public int joinMember(String id, String pw, String name, String nick, String birthday, String gender, String phone,
			String addr) {
		return memberMapper.joinMember(id, pw, name, nick, birthday, gender, phone, addr);
	}
//		public int joinMember(Member member) {
//			return memberMapper.joinMember(member.getMem_Id(), member.getMem_Pw(), member.getMem_Name(), member.getMem_Nick(), member.getMem_Birthdate(), member.getMem_Gender(), member.getMem_Addr(), member.getMem_Phone());
//		}

	// 로그인
	public String loginMember(String id, String pw) {
		return memberMapper.loginMember(id, pw);
	}

	// 마이페이지 조회
	public Member viewMyPage(String id) {
		return memberMapper.viewMyPage(id);
	}

	// 판매자에게 보낼 주소 저장
	public void insertAddr(String memId, int num) {
		memberMapper.insertAddr(memId, num);
	}

	// 각 요소들의 정보를 보내주기 위한 서비스 ~ getDepo
	public int getPickMoney(String memId) {
		return memberMapper.getPickMoney(memId);
	}

	public String getNick(String memId) {
		return memberMapper.getNick(memId);
	}

	public String getAddr(String memId) {
		return memberMapper.getAddr(memId);
	}

	public String getPhoto(int pronum) {
		return memberMapper.getPhoto(pronum);
	}

	public String getName(int pronum) {
		return memberMapper.getName(pronum);
	}

	public String getMem(int pronum) {
		return memberMapper.getMem(pronum);
	}

	public int getPay(int pronum) {
		return memberMapper.getPay(pronum);
	}

	public int getDepo(int pronum) {
		return memberMapper.getDepo(pronum);
	}

	// 결제와 동시에 정산금액 수정
	public void updateSettle(int num, int money) {
		memberMapper.updateSettle(num, money);
	}

	// 물품 구매
	public void PayMoney(String memId, int money) {
		memberMapper.PayMoney(memId, money);
	}

	// 픽머니 충전
	public void setPickMoney(String memId, int money) {
		memberMapper.setPickMoney(memId, money);
	}

	// 주소 수정
	public void setAddr(String memId, String Addr) {
		memberMapper.setAddr(memId, Addr);
	}

	// 회원정보 수정
	public void changeInfo(String memId, Member member) {
		memberMapper.changeInfo(memId, member);
	}
}
