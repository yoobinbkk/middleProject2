<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link href="resources/css/tiny-slider.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/signin.css" rel="stylesheet">

<title>회원가입</title>
</head>
<body>

	<!-- Start Header/Navigation -->
		<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">
			<div class="container">
				<a class="navbar-brand" href="index.do"><img src="resources/images/로고1.png" alt="logo" style="width:100px; height:50px;"></a>

				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni" aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarsFurni">
					<ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
						<li class="nav-item "><a class="nav-link" href="intro.do">우리들의 이야기(소개)</a></li>
						<li class="active"><a class="nav-link" href="shop.do">구경하기</a></li>
						<li><a class="nav-link" href="community.do">우리들의 공간</a></li>
					</ul>
					<ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
						<li>
		                  <c:choose>
		                  	<c:when test="${empty sessionScope.id}"><a class="nav-link" href="loginForm.do">들어가기(로그인)</a></c:when>
		                  	<c:when test="${not empty sessionScope.id}"><a class="nav-link" href="logOut.do">나가기(로그아웃)</a></c:when>
		                  </c:choose>
		                </li>
						<li><a class="nav-link" href="join.do">함께하기(회원가입)</a></li>
						<li><a class="nav-link" href="cart.do"><img src="resources/images/cart24.png"></a></li>
						<li><a class="nav-link" href="myPage.do"><img src="resources/images/user24.png"></a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- End Header/Navigation -->
	
	
	<section class="bg-light">
        <div class="container py-4">
        
            <div class="row align-items-center justify-content-between">
                <a class="navbar-brand h1 text-center" href="index.do">
                    <span class="text-dark h4">회원</span> <span class="text-primary h4">가입</span>                 
                </a>
            </div>
            
            <div class="row">
            	<div class="col-md-4"></div>
            	<div class="col-md-4">
            		<form action="joinSuccess.do" method='post' id="usercheck">
		                <div class="form-group">
		               		<label for="member_id" class="form-label mt-4">아이디</label>
		                    <input type="text" class="form-control" id="member_id" name="member_id" required>
		                    <div class="eheck_font" id="id_check"></div>
		                </div>
						<div class="form-group has-success">
							<label class="form-label mt-4" for="password">비밀번호</label>
							<input type="password" class="form-control" id="password" name="password" required>
							<div class="valid-feedback"></div>
						</div>
		
						<div class="form-group has-danger">
							<label class="form-label mt-4" for="password2">비밀번호 재확인</label> 
							<input type="password" class="form-control" id="password2" required>
							<div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
						</div>
		                <div class="form-group">
		               		<label for="name" class="form-label mt-4">이름</label>
		                    <input type="text" class="form-control" id="name" name="name" required>
		                </div>
		                <div class ="form-group row">
		                	<label class="form-label mt-4">생년월일</label>
		                	<div class="col" id="bir_yy">
		                		<span class="ps_box">
		                			<input type="text" class="form-control" id="yy" placeholder="년(4자)" maxlength="4" name="yy" required>
		                		</span>
		                	</div>
		                	<div class="col" id="bir_mm">
		                		<span class="ps_box focus">
					                <select class="form-select" id="mm" name="mm">
								        <option>월</option>
								        <option>1</option>
								        <option>2</option>
								        <option>3</option>
								        <option>4</option>
								        <option>5</option>
								        <option>6</option>
								        <option>7</option>
								        <option>8</option>
								        <option>9</option>
								        <option>10</option>
								        <option>11</option>
								        <option>12</option>
								     </select>
		                		</span>
		                	</div>
		                	<div class="col" id="bir_dd">
		                		<span class="ps_box">
		                			<input type ="text" class="form-control" id ="dd" placeholder="일" maxlength="2" name="dd" required>
		                		</span>
		                	</div>
		                </div>
					    <div class="form-group">
					      <label for="gender" class="form-label mt-4">성별</label>
					      <select class="form-select" id="gender" name="gender">
					        <option>남자</option>
					        <option>여자</option>
					      </select>
					    </div>                
					    <div class ="form-group row">
					    	<label class="form-label mt-4">휴대폰 번호</label>
					    	<div class="col">
		                		<span class="ps_box focus">
					                <select class="form-select" id="phone_num1" name="p_num1">
								        <option>010</option>
								        <option>070</option>
								        <option>02</option>
								     </select>
		                		</span>
		                	</div>
		                	<div class="col">
		                		<span class="ps_box">
		                			<input type="text" class="form-control" id="phone_num2" maxlength="4" name="p_num2" required>
		                		</span>
		                	</div>
		                	<div class="col">
		                		<span class="ps_box">
		                			<input type="text" class="form-control" id="phone_num3" maxlength="4" name="p_num3" required>
		                		</span>
		                	</div>
					    </div>
					    
					    <div class="d-grid gap-5">
						    <div class="form-group">
				                <div class="form-group">
				               		<label for="email" class="form-label mt-4">이메일</label>
				                    <input type="email" class="form-control" id="email" placeholder="*****@***.com" name="email" required>
				                </div>
			                </div>
		                
			                <div class="form-group">
		                		<label>마케팅 수신 동의 (선택)</label>
		                		<hr/>
		                		<input type="checkbox" name="agree_email"> 이메일&nbsp;&nbsp;&nbsp;&nbsp;
		                		<input type="checkbox" name="agree_sns"> SNS <br/>
		                		<span>* 본 동의 사항은 선택사항으로 거부 할 수 있으며, 거부하시더라도 서비스 이용에 제한은 없습니다. 단, 이벤트 정보, 신제품 출시 등 맞춤형 서비스를 제공 받으실 수 없습니다.</span>
			                </div>
			                
			                <div class="text-center">
				            	<input class="btn btn-lg" type="submit" value="가입하기" />
				            </div>
		                </div>
		
		            </form>
            	</div>
            	<div class="col-md-4"></div>
            </div>
        </div>
    </section>
    
    
	<!-- Start Footer Section -->
	<footer class="footer-section">
		<div class="container relative">

			<!-- footer 정보 시작-->
			<div class="row footer-content">
				<div class="col-md-3" style="float: none; margin:0 auto;">
				   <h5>
				      <strong>(주)전통주 프로젝트</strong>
				   </h5>
				   <h6>사업자 번호 228-24-23029</h6>
				   <h7>대표이사 코스모 | 서울 금천구 가산디지털2로 101</h7>
				   <br />
				   <h7>전화 02-2025-8523 | 이메일 swkosmo@daum.net</h7>
				   <h5>
				      <strong>고객센터</strong>
				   </h5>
				   <h6>강원도 춘천시 퇴계로 89</h6>
				   <h6>전화 1588-8282</h6>
				   <h6>1:1 문의 바로 가기</h6>
				</div>
			</div>
			<!-- footer 정보 끝 -->

		</div>
	</footer>
	<!-- End Footer Section -->

	<!-- JavaScript -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/tiny-slider.js"></script>
	<script src="resources/js/custom.js"></script>
	<script src="resources/js/join.js"></script>

</body>
</html>