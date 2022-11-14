package com.pickmeup.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pickmeup.model.QnA;
import com.pickmeup.service.QnAService;

@RestController
@CrossOrigin(origins = "*")
public class QnAController {

	Gson gson=new Gson();
	
	@Autowired
	QnAService qnaService;
	
	//리뷰등록
	@PostMapping("/detail/comment")
	public void newComment(@RequestBody HashMap<String,Object> comment) {
		System.out.println("댓글?:   " +comment);
		
		String jsonStr=gson.toJson(comment);
		
		System.out.println("제이슨 댓글"+jsonStr);
		
		QnA qna=gson.fromJson(jsonStr,QnA.class);
		System.out.println("정체는?"+qna.toString());
//		
		qnaService.newComment(qna.getPro_Num(),qna.getQna_Content(),qna.getMem_Id());
		
	}
	
	
	
	
	
	
	
}
