package com.pickmeup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pickmeup.model.Auction;
import com.pickmeup.model.Member;
import com.pickmeup.model.Product;
import com.pickmeup.service.ProductService;
import com.pickmeup.service.QnAService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

	Gson gson = new Gson();

	@Autowired
	ProductService productService;
	
	@Autowired
	QnAService qnaService;

	// 상품 등록하기
		@RequestMapping(value = "/addpro", method = RequestMethod.POST, produces = "application/json; charset=utf8")
		public void view(@RequestBody Map<String, Object> pro) {
			System.out.println(pro);

			productService.addPro(pro);

		}

		// 메인에 상품 나열
		@GetMapping("/main")
		public List<Product> proList() {

			System.out.println("나열하는 상품" + productService.proList());

			return productService.proList();
		}

		//상품 상세내역 불러오기
		// 클릭한 상품과 동일한 상품 상세 페이지로 이동
		@PostMapping("/detail")
		public String detailPro(@RequestBody Product pro_Num) {
			
			System.out.println("넘어오는 값" + pro_Num);

			Map<String, Object> result = (productService.detailPro(pro_Num));
			System.out.println(result);
			System.out.println("detailPro Service");
			result.put("commentView", qnaService.commentView(pro_Num));
			System.out.println("commentView Service");
			System.out.println("넘겨주는 comments값 : " + result);
			
			return gson.toJson(result);
		}
		

		// 메뉴바 클릭 시 해당 상품 나열
		@PostMapping("/selectItem")
		public List<Product> selectPro(@RequestBody Product product) {

			System.out.println("클릭한 상품: " + product);

			System.out.println("받아오는 브랜드" + product.getPro_Brand());
			System.out.println("받아오는 카테고리" + product.getPro_Category());

			if (product.getPro_Brand() != null) {
				String jsonStr = gson.toJson(product);
				System.out.println("선택한 목록 :" + jsonStr);

				Product pro = gson.fromJson(jsonStr, Product.class);
				System.out.println(pro.toString());
				List<Product> selectB = productService.selectB(pro.getPro_Brand());
				return selectB;
			} else {
				String jsonStr = gson.toJson(product);
				System.out.println("선택한 목록 :" + jsonStr);

				Product pro = gson.fromJson(jsonStr, Product.class);
				System.out.println(pro.toString());
				List<Product> selectC = productService.selectC(pro.getPro_Category());

				return selectC;
			}

		}

	}