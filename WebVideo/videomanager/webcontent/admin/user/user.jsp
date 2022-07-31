<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
                      <div class="col mt-4">
                      <jsp:include page="/common/inform.jsp"></jsp:include>
                    <ul class="nav nav-tabs" id="myTab" role="tablist"> 
                        <li class="nav-item" role="presentation">
                            <a class="nav-link active" id="videoEditing-tab" data-toggle="tab"
                                href="#videoEditing" role="tab" aria-controls="videoEditing"
                                aria-selected="true">User Editing</a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" id="videoList-tab" data-toggle="tab" href="#videoList"
                               role="tab" aria-controls="videoList" aria-selected="false">User
                                List</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="videoEditing" role="tabpanel"
                            aria-labelledby="videoEditing-tab">
                            <form action="" method="post">
                                <div class="card">
                                    <div class="card-body">
                                   
                                             <div class="row">
                                  <div class="col">
                                      <div class="form-group">
                                        <label for="username">Tên Đăng Nhập</label>
                                        <input type="text" class="form-control" name="username" id="username" value="${user.username }" aria-describedby="usernameHId" placeholder="Tên đăng nhập">
                                        <small id="helpId" class="form-text text-muted">Cần nhập tên Đăng Nhập</small>
                                      </div>
                                      <div class="form-group">
                                        <label for="fullname">Họ Và Tên</label>
                                        <input type="text" class="form-control" name="fullname" id="fullname" value="${user.fullname }" aria-describedby="helpId" placeholder="Họ và Tên">
                                        <small id="fullnameId" class="form-text text-muted">Cần Nhập Họ Và Tên</small>
                                      </div>
                                  </div>
                                  <div class="col">
                                    <div class="form-group">
                                      <label for="password">mật khẩu</label>
                                      <input type="password" class="form-control" name="password" id="password" value="${user.password }" aria-describedby="helpId" placeholder="Mật Khẩu">
                                    </div>
                                    <br>
                                    <div class="form-group">
                                      <label for="email">Email</label>
                                      <input type="text" class="form-control" name="email" id="email" value="${user.email }" aria-describedby="helpId" placeholder="Nhập Email">
                                      <small id="emialId" class="form-text text-muted">Cần Nhập Email</small>
                                    </div>
                                  </div>
                                    <div class="form-check form-check-inline">
                                                    <label> <input type="radio" class="form-check-input" value="true"
                                                            name="admin" id="active" ${user.admin? 'checked':'' }>admin</label>
                                                    <label> <input type="radio" class="form-check-input" value="false"
                                                            name="admin" id="active" ${! user.admin? 'checked':'' }>user</label>
                                                </div>
                              </div>
                                  
                           
                                    </div>
                                  <div class="card-footer text-muted">
                                        <button class="btn btn-primary" formaction="admin/UsersMangement/create">Create</button>
                                        <button class="btn btn-warning" formaction="admin/UsersMangement/update">Update</button>
                                        <button class="btn btn-danger" formaction="admin/UsersMangement/delete">Delete</button>
                                        <button class="btn btn-info" formaction="admin/UsersMangement/reset">Reset</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="tab-pane fade" id="videoList" role="tabpane1" aria-labelledby="videoList-tab">
                            <table class="table table-stripe">
                                <tr>
                                    <td>Youtube ID</td>
                                    <td>Video Title</td>
                                    <td>View Count</td>
                                    <td>Status</td>
                                </tr>
                               <c:forEach var="item" items="${users }">
                                <tr>
                                    <td>${item.username }</td>
                                    <td>${item.fullname }</td>
                                    <td>${item.email }</td>
                                    <td>${item.admin? 'admin':'user' }</td>
                                    <td>
                                        <a href="admin/UsersMangement/edit?username=${item.username }"><i class="fa fa-edit" aria-hidden="true"></i>Edit</a>
                                        <a href="admin/UsersMangement/delete?username=${item.username}"><i class="fa fa-trash" aria-hidden="true"></i>Delete</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>

                </div>