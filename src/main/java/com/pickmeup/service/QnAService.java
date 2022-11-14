package com.pickmeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickmeup.mapper.QnAMapper;
import com.pickmeup.model.Product;
import com.pickmeup.model.QnA;

@Service
public class QnAService {

	@Autowired
	QnAMapper qnaMapper;

	public void newComment(int pro_Num, String qna_Content, String mem_Id) {
		qnaMapper.newComment(pro_Num, qna_Content, mem_Id);
	}

	// 해당 게시글에 대한 QnA댓글 불러오기
	public List<QnA> commentView(Product pro_Num) {
		return qnaMapper.commentView(pro_Num);
	}

}
