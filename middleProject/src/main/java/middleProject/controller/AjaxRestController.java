package middleProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import middleProject.domain.CartRowVO;
import middleProject.domain.GoodsTypeVO;
import middleProject.domain.GoodsVO;
import middleProject.domain.LoginVO;
import middleProject.service.JudaService;

@RestController
public class AjaxRestController {
	
	@Autowired
	private JudaService judaService;


//***************************************************************************************************
	
	//**** 로그인/회원가입 ****//
	
	// 로그인 중복 체크
	@PostMapping(value="checkId.do") //, produces = "application/text; charset=UTF-8")
	public Integer checkId(LoginVO vo) {
		System.out.println(">>>> "+vo);
		return 1;
	}
	
//***************************************************************************************************

	//**** 상품상세 페이지 (장바구니 추가/확인) ****//
	
	// 같은 상품을 또 넣을지 확인
	@GetMapping("checkCart.do")
	public String checkCart(CartRowVO vo) {
		return judaService.checkCart(vo);
	}
	
	// 장바구니 추가
	@PostMapping("insertCart.do")
	public void insertCart(CartRowVO vo) {
		judaService.insertCart(vo);
	}
	
	// 장바구니의 상품의 수량만 바꾸기	(장바구니창에도 사용)
	@PostMapping("updateCart.do")
	public void updateCart(CartRowVO vo) {
		judaService.updateCart(vo);
	}
	
//=====================================================================================================
	
	//**** 장바구니 ****//
	
	/*
	// 장바구니 행 삭제
	@DeleteMapping("deleteCart.do")
	public void deleteCart(CartRowVO vo) {
		judaService.deleteCart(vo);
	}
	*/
	
	
	
//=====================================================================================================
	
	//=== 배제된 메소드 ===//
	
	/*
	// 상품목록 나열 (ajax 버전)
	@GetMapping(value="goodsList", produces = "application/text; charset=UTF-8")
	public List<GoodsVO> getGoodsList(GoodsTypeVO vo) {
		List<GoodsVO> goodsList = judaService.getGoodsList(vo);
		System.out.println(goodsList.toString());
		return goodsList;
	}
	*/

}
