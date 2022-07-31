
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

              <div class="col">
               			<div class="row p-2">
				<c:forEach var="item" items="${videos }">
					<div class="col-4 mt-3">
				<div class="card text-center">
					<div class="card-body">
						<img src="${empty item.poster ? 'images/daonhat.jpg' :item.poster }" class="card-img-top" alt="..."
							height="300" width="100%">
						<div class="row border-top mt-2">
							<b class="card-title-align">${item.title }</b>
							<br>
							<p class="card-text">${item.decription }</p>
						</div>
						<div class="card-footer">
						<br>
							<a href="LikeVideo?videoid=${item.videoid }" class="btn btn-primary">like </a> 
							<a href="ShareVideo?videoid=${item.videoid }"
								class="btn btn-primary">share</a>
						</div>

					</div>
				</div>
				
			</div>
			</c:forEach>
				</div>
                  </div>
                  <div class="row">
                      <div class="col">
                          <nav aria-label="Page navigation">
                            <ul class="pagination justify-content-center">
                              <li class="page-item disabled">
                                <a class="page-link" href="#" aria-label="Previous">
                                  <span aria-hidden="true">&laquo;</span>
                                  <span class="sr-only">Previous</span>
                                </a>
                              </li>
                              <li class="page-item active"><a class="page-link" href="#">&lt;</a></li>
                              <li class="page-item"><a class="page-link" href="#">&gt;</a></li>
                              <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                  <span aria-hidden="true">&raquo;</span>
                                  <span class="sr-only">Next</span>
                                </a>
                              </li>
                            </ul>
                          </nav>
                      </div>
                  </div>
              </div>
             