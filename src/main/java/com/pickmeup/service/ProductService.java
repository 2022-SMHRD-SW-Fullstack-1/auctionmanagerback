package com.pickmeup.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.pickmeup.mapper.ProductMapper;
import com.pickmeup.mapper.QnAMapper;
import com.pickmeup.model.Auction;
import com.pickmeup.model.Product;
import com.pickmeup.model.QnA;

@Service
public class ProductService {

	@Autowired
	ProductMapper productMapper;

	// 상품 등록
	public void addPro(Map<String, Object> pro) {
//		String price = Integer.toString(product.getPro_Min_Price());
//		int minPirce = Integer.parseInt(price);

		System.out.println("ser_addpro : " + productMapper.addPro(pro));
		System.out.println("ser_addquc : " + productMapper.addAuc(pro));

	}

	// 메인에 마감 임박상품 나열
	public List<Product> proList() {
		return productMapper.proList();
	}

	// 클릭한 상품과 동일한 상품 상세 페이지로 이동
	public HashMap<String, Object> detailPro(Product pro_Num) {
		Product product = productMapper.detailPro(pro_Num);
		Auction auction = productMapper.maxPrice(pro_Num);

		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("mem_Id", product.getMem_Id());
		result.put("pro_Num", product.getPro_Num());
		result.put("pro_Name", product.getPro_Name());
		result.put("pro_Brand", product.getPro_Brand());
		result.put("pro_Category", product.getPro_Category());
		result.put("pro_Min_Price", product.getPro_Min_Price());
		result.put("pro_Deadline", product.getPro_Deadline());
		result.put("pro_Desc", product.getPro_Desc());
		result.put("pro_Status", product.getPro_Status());
		result.put("pro_Photo", product.getPro_Photo());
		result.put("auc_Price", auction.getAuc_Price());
		result.put("auc_Deposit", auction.getAuc_Deposit());

		return result;
	}

	// 메뉴바 클릭 시 해당 상품 나열
	public List<Product> selectB(String pro_Brand) {

		return productMapper.selectProB(pro_Brand);
	}

	public List<Product> selectC(String pro_Category) {

		return productMapper.selectProC(pro_Category);
	}

}
