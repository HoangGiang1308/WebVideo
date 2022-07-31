
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div class="col-8 offset-2">
	<form action="" method="post">
		<div class="card">
			<div class="card-header">
				<b>Đăng kí</b>
			</div>
			<div></div>
			<div class="card-body">
				<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Tên Đăng Nhập</label> <input type="text"
								class="form-control" name="username" id="username"
								value="${user.username }" aria-describedby="usernameHId"
								placeholder="Tên đăng nhập"> <small id="usernameHId"
								class="form-text text-muted">Cần nhập tên Đăng Nhập</small>
						</div>
						<div class="form-group">
							<label for="fullname">Họ Và Tên</label> <input type="text"
								class="form-control" name="fullname" id="fullname"
								value="${user.fullname }" aria-describedby="fullnameId"
								placeholder="Họ và Tên"> <small id="fullnameId"
								class="form-text text-muted">Cần Nhập Họ Và Tên</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">mật khẩu</label> <input type="password"
								class="form-control" name="password" id=""
								" aria-describedby="helpId"
								placeholder="Mật Khẩu"> <small id="passwordId"
								class="form-text text-muted">Cần Nhập Mật Khẩu</small>
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="text"
								class="form-control" name="email" id="email"
								value="${user.email }" aria-describedby="helpId"
								placeholder="Nhập Email"> <small id="emialId"
								class="form-text text-muted">Cần Nhập Email</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Đăng Kí</button>
			</div>
		</div>
	</form>
</div>
