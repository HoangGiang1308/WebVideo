
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div class="offset-4 col-4">
	<form action="" method="post">
		<div class="card">
			<div class="card-header">
				<b>Đăng Nhập Vào Hệ Thống</b>
			</div>
			<div class="card-body">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="form-group">
					<label for="username">Tên Đăng Nhập</label> <input type="text"
						class="form-control" name="username" id="username"
						aria-describedby="helpId" placeholder="Tên đăng nhập"> <small
						id="usernameId" class="form-text text-muted">cần nhập tên
						đăng nhập</small>
				</div>
				<div class="form-group">
					<label for="password">Mật Khẩu</label> <input type="password"
						class="form-control" name="password" id="password"
						aria-describedby="helpId" placeholder="Mật Khẩu"> <small
						id="passwordId" class="form-text text-muted">cần nhập mật
						khẩu</small>
				</div>
				<div class="form-check form-check-inline">
					<label><input type="checkbox" class="form-check-input"
						name="remember">lưu tài khoản </label>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Đăng Nhập</button>
			</div>
		</div>
	</form>
</div>
