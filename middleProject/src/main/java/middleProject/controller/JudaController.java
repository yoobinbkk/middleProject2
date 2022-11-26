package middleProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import middleProject.domain.CartRowVO;
import middleProject.domain.CartVO;
import middleProject.domain.GoodsTypeVO;
import middleProject.domain.GoodsVO;
import middleProject.domain.LoginVO;
import middleProject.domain.MemberVO;
import middleProject.domain.PayVO;
import middleProject.service.JudaService;

@Controller
public class JudaController {
	
	@Autowired
	private JudaService judaService;

	// 페이지 여는 용도
	@RequestMapping("{url}.do")
	public String viewPage(@PathVariable String url) {
		System.out.println("페이지만");
		return url;
	}
	
//***************************************************************************************************
	
	//**** 로그인/회원가입 ****//
	
	// 로그인
    @RequestMapping("login_check.do")
    public String selectLogin(LoginVO vo, HttpSession session) {
       
       Integer result = judaService.selectLogin(vo);
       
       if(result == 1) {		// 로그인 성공 시
          session.setAttribute("id",  vo.getMember_id() );
          return "index";
       }else { 					// 로그인 실패 시
          return "loginForm";
       } // end of else() 
       
    } // end of selectLogin()
    
    // 로그아웃
    @RequestMapping("logOut.do")
    public String logOut(HttpSession session) {
    	session.invalidate();
    	return "index";
    }
	
	// 회원가입
	@RequestMapping("joinSuccess.do")
	public void insertMember(MemberVO vo, Model m) {
		vo.setTel(vo.getP_num1()+"-"+vo.getP_num2()+"-"+vo.getP_num3());
		vo.setBirth(vo.getYy()+"-"+vo.getMm()+"-"+vo.getDd());
		
		m.addAttribute("result", judaService.insertMember(vo));
		m.addAttribute("member_id", vo.getMember_id());
	}
	
	
//***************************************************************************************************
	
	//**** 상품 페이지 ****//
	
	// 상품목록
	@RequestMapping("shop.do")
	public void getGoodsList(GoodsTypeVO vo, Model m) {
		m.addAttribute("goodsList", judaService.getGoodsList(vo));
	}
	
	// 상품상세 페이지
	@RequestMapping("sangse.do")
	public void getGoods(String goods_id, Model m) {
		m.addAttribute("vo", judaService.getGoods(goods_id));
	}
	
	// 구매하기 (상품상세)
	@RequestMapping("pay.do")
	public void insertOrder(PayVO payVo) {
		payVo.setDelivery_tel(payVo.getP_num1()+"-"+payVo.getP_num2()+"-"+payVo.getP_num3());
		judaService.insertOrder(payVo);
	}
	
	// 장바구니 내용을 가져오기 (장바구니창 띄우기용)
	@RequestMapping("cart.do")
	public void getCart(Model m, HttpSession session) {
		String member_id = (String)session.getAttribute("id");
		System.out.println(">"+member_id);
		List<CartVO> result = judaService.getCart(member_id);
		System.out.println(result);
		m.addAttribute("cartList", result);
	}
	
//***************************************************************************************************

	//**** 장바구니 ****//
	
	// 장바구니 행 삭제
	@RequestMapping("deleteCart.do")
	public String deleteCart(CartRowVO vo) {
		judaService.deleteCart(vo);
		return "redirect:/cart.do";
	}
	
}
