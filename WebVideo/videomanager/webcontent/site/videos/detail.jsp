
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="col-7">
	<div class="card text-center mt-3">
		<div class="card-body">
			<div class="row">
			<iframe width="560" height="315" src="${video.decription }" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

			</div>
			<div class="row p-2">
				<b>${video.title }</b>
			</div>
			

		</div>
		<div class="card-footer text-right">
			<a href="" class="btn btn-success">like</a> <a href=""
				class="btn btn-info">share</a>
		</div>
	</div>
</div>
<div class="col-5">
		<c:forEach var="item" items="${videos }">
		<a href="Details?videoid=${item.videoid}">
	<div class="row border mt-3 mb-3">
		<div class="col-2">
			<img
				src="${empty item.poster ? 'images/daonhat.jpg' :item.poster }"
				alt="" class="img-fluid">
		</div>
		<div class="col-10 border-left">${item.title }</div>
	</div>
	</a>
		</c:forEach>
</div>
