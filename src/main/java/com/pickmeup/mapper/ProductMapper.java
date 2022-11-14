package com.pickmeup.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import com.pickmeup.model.Auction;
import com.pickmeup.model.Product;

@Mapper
public interface ProductMapper {

	// 상품등록
	public int addPro(Map<String, Object> pro);

	public int addAuc(Map<String, Object> pro);

	// 메인에 상품 나열
//		@Select("select pro_num, mem_id, pro_deadline, pro_name, pro_photo from t_product where to_char(pro_deadline, 'yyyymmdd') > to_char(localtimestamp, 'yyyymmdd')")
	@Select("select p.pro_num, p.mem_id, p.pro_deadline, p.pro_name, p.pro_photo, (SELECT max(auc_Price) as auc_Price from t_auction a WHERE p.PRO_NUM = a.PRO_NUM) AS auc_price from t_product p where to_char(pro_deadline, 'yyyymmdd') > to_char(localtimestamp, 'yyyymmdd')")
	public List<Product> proList();

	// 클릭한 상품과 동일한 상품 상세 페이지로 이동
	@Select("select pro_num, mem_id, pro_name, pro_min_price, PRO_DEADLINE, pro_desc, pro_brand, pro_category, pro_status, pro_photo from t_product where pro_num=#{pro_Num}")
	public Product detailPro(Product pro_Num);

	// 클릭한 상품 현재 입찰가
	@Select("select max(auc_Price) as auc_Price, max(auc_Deposit) as AUC_DEPOSIT  from t_auction where pro_num=#{pro_Num}")
	public Auction maxPrice(Product pro_Num);

	// 메뉴바 클릭 시 해당 상품 나열
	@Select("select p.pro_num, p.mem_id, p.pro_brand, p.pro_name, p.pro_photo, (SELECT max(auc_Price) as auc_Price from t_auction a WHERE p.PRO_NUM = a.PRO_NUM) as auc_Price from t_product p where pro_brand=#{pro_Brand} and to_char(pro_deadline, 'yyyymmdd') > to_char(localtimestamp, 'yyyymmdd')")
	public List<Product> selectProB(String pro_Brand);

	@Select("select p.pro_num, p.mem_id, p.pro_category, p.pro_name, p.pro_photo, (SELECT max(auc_Price) as auc_Price from t_auction a WHERE p.PRO_NUM = a.PRO_NUM) as auc_Price from t_product p where pro_category=#{pro_Category} and to_char(pro_deadline, 'yyyymmdd') > to_char(localtimestamp, 'yyyymmdd')")
	public List<Product> selectProC(String pro_Category);

}
