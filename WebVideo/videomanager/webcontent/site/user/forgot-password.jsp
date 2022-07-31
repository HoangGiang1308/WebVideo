
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

              <div class="offset-4 col-4">
                  <form action="ForgotPassword" method="post">
                      <div class="card mt-5">
                          <div class="card-header">
                            <b>Quên Mật Khẩu</b>
                          </div>
                          <div class="card-body">
                          		<jsp:include page="/common/inform.jsp"></jsp:include>
                          		<div Class="row">
                          		<div class="col">
                          		  <div class="form-group">
                                <label for="username">Tên Đăng Nhập</label>
                                <input type="text" class="form-control" name="username" id="username" aria-describedby="usernameId" placeholder="Tên Đăng Nhập">
                                <small id="usernameId" class="form-text text-muted">Cần Nhập Tên Đăng nhập</small>
                              </div>
                          		
                          		   <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" id="email" aria-describedby="emailId" placeholder="Email">
                                <small id="emailId" class="form-text text-muted">Cần Nhập Email</small>
                              </div>
                          		</div>	
                            </div>
                           
                          </div>
                          <div class="card-footer text-muted">
                              <button class="btn btn-success">Lấy Lại Mật Khẩu</button>
                          </div>
                      </div>
                  </form>
              </div>
       