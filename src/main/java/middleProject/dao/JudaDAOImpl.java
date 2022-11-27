package middleProject.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import middleProject.domain.BoardVO;
import middleProject.domain.CartRowVO;
import middleProject.domain.CartVO;
import middleProject.domain.GoodsTypeVO;
import middleProject.domain.GoodsVO;
import middleProject.domain.LoginVO;
import middleProject.domain.MemberVO;
import middleProject.domain.PayListVO;

@Repository("judaDAO")
public class JudaDAOImpl implements JudaDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

// =======================================================		
	/* [ 로그인 및 회원가입] */
	
	// 로그인
	public Integer selectLogin(LoginVO vo) {
		return mybatis.selectOne("JudaMap.selectLogin", vo);
	}
		
	// 회원가입
	public Integer insertMember(MemberVO vo) {
		return mybatis.insert("JudaMap.insertMember", vo);
	}

	// 아이디 중복 확인
	public Integer checkId(LoginVO vo) {
		return mybatis.selectOne("JudaMap.checkId", vo);
	}
	
// =======================================================		
	/* [상품 목록 페이지] */
		
	// 상품 목록 띄우기
	public List<GoodsVO> getGoodsList(GoodsTypeVO vo) {
		return mybatis.selectList("JudaMap.getGoodsList", vo);
	}
	
	// 상품 상세 페이지 띄우기
	public GoodsVO getGoods(Integer goods_id) {
		return mybatis.selectOne("JudaMap.getGoods", goods_id);
	}	

// =======================================================		
	/* [상품 상세 페이지] */
	
	// 같은 상품을 또 넣을지 확인
	public String checkCart(CartRowVO vo) {
		System.out.println(">>"+vo);
		String result = mybatis.selectOne("JudaMap.checkCart", vo);
		System.out.println(">>>"+result);
		return result;
	}
	
	// 장바구니에 넣기
	public void insertCart(CartRowVO vo) {
		mybatis.insert("JudaMap.insertCart", vo);
	}
	
	// 장바구니의 상품의 수량만 바꾸기
	public void updateCart(CartRowVO vo) {
		mybatis.update("JudaMap.updateCart", vo);
	}
	
	// 장바구니를 띄우기
	public List<CartVO> getCart(Integer member_id) {
		return mybatis.selectList("JudaMap.getCart", member_id);
	}

	// 구매하기
	public void insertOrder(PayListVO payVo) {
		mybatis.insert("JudaMap.insertDelivery", payVo);
		mybatis.insert("JudaMap.insertOrderList", payVo);
	}
	
// =======================================================		
	/* [ 장바구니 ] */
	
	// 장바구니 행 삭제
	public void deleteCart(CartRowVO vo) {
		mybatis.delete("JudaMap.deleteCart", vo);
	}

// =======================================================		
	/* [ 결제창 ] */

	// 카트의 상품 목록을 결제창에 띄우기
	public List<CartVO> getPayCart(Integer member_id) {
		return mybatis.selectList("JudaMap.getPayCart", member_id);
	}

	// 결제할 상품을 바로 결제창에 띄우기
	public CartVO getPayOne(Integer member_id) {
		return mybatis.selectOne("JudaMap.getPayOne", member_id);
	}

	// 회원 정보를 결제창에 올리기
	public HashMap<String, String> getMember(Integer member_id) {
		return mybatis.selectOne("JudaMap.getMember", member_id);
	}

}
