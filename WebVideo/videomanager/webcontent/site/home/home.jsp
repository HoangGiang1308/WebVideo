
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="col-9">
	<div class="row p-2">

		<c:forEach var="item" items="${videos }">
			<a href="Details?videoid=${item.videoid}">
				<div class="col-3 mt-2">
					<div class="card text-center">
						<div class="card-body">
							<img
								src="${empty item.poster ? 'images/daonhat.jpg' :item.poster }"
								class="card-img-top" alt="..." height="300" width="100%">
							<div class="row p-2">
								<b class="card-title-align">${item.title }</b>
							</div>
							
						</div>
						<div class="card-footer">
								<a href="LikeVideo?videoid=${item.videoid }" class="btn btn-success"> like</a>
								<a href="ShareVideo?videoid=${item.videoid }" class="btn btn-success"> share</a>
								
						</div>
					</div>
				</div>


			</a>
		</c:forEach>

	</div>
	<div class="row mt-3">
		<div class="col">
			<nav aria-label="Page navigation">
						<ul class="pagination justify-content-center">
							<li class="page-item"><a class="page-link"
								href="Homepage?page=<%=(request.getParameter("page") == null
		? 1
		: Integer.valueOf(request.getParameter("page")) > 1
				? Integer.valueOf(request.getParameter("page")) - 1
				: request.getParameter("page"))%>&title=<%=(request.getParameter("title") == null ? "%%" : request.getParameter("title"))%>"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
							</a></li>
							<%
							Object size = request.getAttribute("size");
							int i = 0;
							do {
							%>
							<li class="page-item"><a class="page-link"
								href="Homepage?page=<%=i + 1%>&title=<%=(request.getParameter("title") == null ? "%%" : request.getParameter("title"))%>"><%=i + 1%></a></li>
							<%
							i++;
							} while (i < Math.ceil((double) size));
							%>
							<li class="page-item"><a class="page-link"
								href="Homepage?page=<%=(request.getParameter("page") == null
		? 2
		: Integer.valueOf(request.getParameter("page")) < (Math.ceil((double) request.getAttribute("size")))
				? Integer.valueOf(request.getParameter("page")) + 1
				: request.getParameter("page"))%>&title=<%=(request.getParameter("title") == null ? "%%" : request.getParameter("title"))%>"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
									class="sr-only">Next</span>
							</a></li>
						</ul>
					</nav>
		</div>
	</div>
</div>

<div class="col-md-3">

	<div class="card">
		<div class="card-header">
			<i class="fa fa-align-right" aria-hidden="true"></i> &nbsp;loại sản
			phẩm
		</div>
		  <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="LibaryVideoServlet?videoid=Hanh" class="dropdown-item">Hành
                    động</a></li>
                <li class="list-group-item"><a href="LibaryVideoServlet?videoid=lang" class="dropdown-item">Lãng
                    mạn</a></li>
                <li class="list-group-item"><a href="LibaryVideoServlet?videoid=Kinh" class="dropdown-item">Kinh
                    dị</a></li>
                <li class="list-group-item"><a href="LibaryVideoServlet?videoid=Vo" class="dropdown-item">Võ
                    Thuật</a></li>
                <li class="list-group-item"><a href="LibaryVideoServlet?videoid=Hai" class="dropdown-item">Hài
                    hước</a></li>
            </ul>
	</div>
</div>