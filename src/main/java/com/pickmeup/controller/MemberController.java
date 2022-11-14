package com.pickmeup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pickmeup.model.Forsend;
import com.pickmeup.model.Member;
import com.pickmeup.service.MemberService;

@RestController
@CrossOrigin(origins = "*")
public class MemberController {

	Gson gson = new Gson();

	@Autowired
	MemberService memberService;

	// 회원가입
	// 아이디 중복 확인

	@RequestMapping(value = "/join/idck", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String idCk(@RequestBody Member id) {

		System.out.println(id);
		String jsonStr = gson.toJson(id);

		Member user = gson.fromJson(jsonStr, Member.class);
		System.out.println(user);

		String idCk = memberService.idCheck(user.getMem_Id());
		System.out.println(memberService.idCheck(user.getMem_Id()));

		if (idCk != null) {
			return "fail";// 중복된다는 뜻
		} else {
			return "success";// 중복이 아니라는 뜻
		}

	}

	// 회원가입
	@PostMapping("/join")
	public int join(@RequestBody Member member) {
		System.out.println(member);

//		int joinM=memberService.joinMember(member.getMem_Id(), member.getMem_Pw(), member.getMem_Name(), member.getMem_Nick(), member.getMem_Birthdate(), member.getMem_Gender(), member.getMem_Addr(), member.getMem_Phone());

		String jsonStr = gson.toJson(member);
		System.out.println("회원가입: " + jsonStr);

		Member user = gson.fromJson(jsonStr, Member.class);
		System.out.println(user.toString());

		int joinM = memberService.joinMember(user.getMem_Id(), user.getMem_Pw(), user.getMem_Name(), user.getMem_Nick(),
				user.getMem_Birthdate(), user.getMem_Gender(), user.getMem_Phone(), user.getMem_Addr());

		return joinM;
	}

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String login(@RequestBody Member member) {
		System.out.println(member);
		System.out.println("받아오는 아이디" + member.getMem_Id());

		String jsonStr = gson.toJson(member);
		System.out.println("로그인 :" + jsonStr);

		Member user = gson.fromJson(jsonStr, Member.class);
		System.out.println(user.toString());

		String loginM = memberService.loginMember(user.getMem_Id(), user.getMem_Pw());
		System.out.println(loginM);

		if (loginM != null) {
			return "success";// 로그인 성공
		} else {
			return "fail";// 로그인 실패
		}
	}

	// 마이페이지 조회(연습)
	@PostMapping("/myPage/{user}")
	public Member viewMyPage(@PathVariable("user") String user) {

		return memberService.viewMyPage(user);
	}

	// 정보 보내주기.
	@GetMapping(value = { "/mypage/{memid}", "/purchase/addr/{memid}" })
	public Member setUserInfo1(@PathVariable("memid") String memId) {
		int money = memberService.getPickMoney(memId);
		String nick = memberService.getNick(memId);
		String addr = memberService.getAddr(memId);
		Member vo = new Member(nick, addr, money);

		return vo;
	}

	// 결제 제품 정보및 가격 보내주기.
	@GetMapping("/purchase/{memId}/{pronum}")
	public Forsend setPayInfo(@PathVariable("pronum") int pronum) {
		String proPhoto = memberService.getPhoto(pronum);
		String proName = memberService.getName(pronum);
		String proMem = memberService.getMem(pronum);
		int proPay = memberService.getPay(pronum);
		int proDepo = memberService.getDepo(pronum);
		Forsend pi = new Forsend(proPhoto, proName, proMem, proPay, proDepo);

		return pi;
	}

	// 픽머니 충전
	@GetMapping("/charge/{memid}")
	public void setPickMoney(@PathVariable("memid") String memId, @RequestParam int money) {
		memberService.setPickMoney(memId, money);
	}

	// 주소 수정
	@GetMapping("/purchase/{memid}/setaddr")
	public void setAddr(@PathVariable("memid") String memId, @RequestParam String addr) {
		memberService.setAddr(memId, addr);
	}

	// 픽머니 결제
	@GetMapping("/purchase/pay/{memid}/{pronum}")
	public String PayMoney(@PathVariable("memid") String memId, @PathVariable("pronum") int num,
			@RequestParam int money) {
		int pickmoney = memberService.getPickMoney(memId);
		if (pickmoney >= money) {
			memberService.PayMoney(memId, money);
			memberService.insertAddr(memId, num);
			memberService.updateSettle(num, money);
			return "success";
		} else {
			return "fail";
		}
	}

	// 회원정보 수정
	@RequestMapping(value = "/change/{memid}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void changeInfo(@PathVariable("memid") String memId, @RequestBody Member member) {
		memberService.changeInfo(memId, member);
	}
}
