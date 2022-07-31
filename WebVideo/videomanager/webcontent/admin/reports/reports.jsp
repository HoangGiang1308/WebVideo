<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div class="col mt-4">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="favorites-tab" data-toggle="tab"
			href="#favorites" role="tab" aria-controls="favorites"
			aria-selected="true">Favorites</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="favoriteUsers-tab" data-toggle="tab" href="#favoriteUsers"
			role="tab" aria-controls="favoriteUsers" aria-selected="false">Favorite
				Users</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="shareFriends-tab" data-toggle="tab" href="#shareFriends"
			role="tab" aria-controls="shareFriends" aria-selected="false">Share
				Friends</a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="favorites" role="tabpanel"
			aria-labelledby="favorites-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<td>Tiêu đề video</td>
					<td>Lượt thích</td>
					<td>Mới Nhất</td>
					<td>Cũ Nhất</td>
				</tr>
				<c:forEach var="item" items="${favlist}">
					<tr>
						<td>${item.videoTitle }</td>
						<td>${item.favoriteCount }</td>
						<td>${item.newestdate }</td>
						<td>${item.oldestdate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="favoriteUsers" role="tabpane1"
			aria-labelledby="favoriteUsers-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group ml-3">
								<label>Tiêu Đề Video <select name="videoUserId"
									id="videoUserId" class="form-control">
										<c:forEach var="item" items="${vidlist }">
											<option value="${item.videoid }"
												${item.videoid == videoUserId?'selected':''
                                              }>${item.title }</option>
										</c:forEach>
								</select>
								</label>
								<button class="btn btn-info ml-2">Report</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Tên Đăng Nhập</td>
								<td>Họ Và Tên</td>
								<td>Email</td>
								<td>Ngày thích</td>
							</tr>
							<c:forEach var="item" items="${favUsers }">
								<tr>
									<td>${item.username }</td>
									<td>${item.fullname }</td>
									<td>${item.email }]</td>
									<td>${item.likeDate }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="shareFriends" role="tabpane1"
			aria-labelledby="shareFriends-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group ml-3">
								<label>Tiêu Đề Video <select name="videoUserId"
									id="videoUserId" class="form-control">
										<c:forEach var="item" items="${vidlist }">
											<option value="${item.videoid }"
												${item.videoid == videoUserId?'selected':''
                                              }>${item.title }</option>
										</c:forEach>
								</select>
								</label>
								<button class="btn btn-info ml-2">Report</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Tên Người Gửi</td>
								<td>Email Người Gửi</td>
								<td>Email Người Nhận</td>
								<td>Ngày Gửi</td>
							</tr>
							<c:forEach var="item" items="${shavUsers }">
								<tr>
									<td>${item.fullname }</td>
									<td>${item.emails }</td>
									<td>${item.email }]</td>
									<td>${item.shareDate }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>

</div>
