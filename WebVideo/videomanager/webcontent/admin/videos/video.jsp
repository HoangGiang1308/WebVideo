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
                                aria-selected="true">Video Editing</a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" id="videoList-tab" data-toggle="tab" href="#videoList"
                               role="tab" aria-controls="videoList" aria-selected="false">Video
                                List</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="videoEditing" role="tabpanel"
                            aria-labelledby="videoEditing-tab">
                            <form action="" method="post" enctype="multipart/form-data">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-3">
                                                <div class="border p-3">
                                                    <img src="${video.poster != null?video.poster: 'images/daonhat.jpg' }" alt="" class="img-fluid">
                                                    <div class="input-group mb-3 mt-3">
                                                    	<div class="input-group-prepend">
                                                    		<span class="input-group-text">Upload</span>
                                                    	</div>
                                                    	<div class="custom-file">
                                                    		<input type="file" class="custom-file-input" id="cover" name="cover"/>
                                                    		<label for="cover">Choose File</label>
                                                    	</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-9">
                                                <div class="form-group">
                                                    <label for="youtubeId">Youtube ID</label>
                                                    <input type="text" class="form-control" name="videoid" value="${video.videoid }"
                                                        id="youtubeHId" aria-describedby="youtubeIdHId"
                                                        placeholder="Youtube ID">
                                                    <small id="youtubeHId" class="form-text text-muted">youtube id is
                                                        requied</small>
                                                </div>
                                                <div class="form-group">
                                                    <label for="videoTitle">Video Title</label>
                                                    <input type="text" class="form-control" name="title" value="${video.title }"
                                                        id="videoTitle" aria-describedby="videoTitle"
                                                        placeholder="Video Title">
                                                    <small id="videoTitle" class="form-text text-muted">Video Title is
                                                        requied</small>
                                                </div>
                                                <div class="form-group">
                                                    <label for="videoCount">Video Count</label>
                                                    <input type="text" class="form-control" name="views" value="${video.views }"
                                                        id="videoCount" aria-describedby="videoCountHId"
                                                        placeholder="Video Count">
                                                    <small id="videoCountHId" class="form-text text-muted">Video Count
                                                        is
                                                        requied</small>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <label> <input type="radio" class="form-check-input" value="true"
                                                            name="active" id="active" ${video.active? 'checked':'' }>Active</label>
                                                    <label> <input type="radio" class="form-check-input" value="false"
                                                            name="active" id="active" ${! video.active? 'checked':'' }>Inactive</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <label for="decription">link</label>
                                                <textarea name="decription" id="decription" cols="30" rows="4"
                                                    class="form-control">${video.decription }</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-footer text-muted">
                                        <button class="btn btn-primary" formaction="admin/VideoManagement/create">Create</button>
                                        <button class="btn btn-warning" formaction="admin/VideoManagement/update">Update</button>
                                        <button class="btn btn-danger" formaction="admin/VideoManagement/delete">Delete</button>
                                        <button class="btn btn-info" formaction="admin/VideoManagement/reset">Reset</button>
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
                                <c:forEach var="item" items="${videos }">
                                <tr>
                                    <td>${item.videoid }</td>
                                    <td>${item.title }</td>
                                    <td>${item.views }</td>
                                    <td>${item.active? 'active':'Deactive' }</td>
                                    <td>
                                        <a href="admin/VideoManagement/edit?videoid=${item.videoid }"><i class="fa fa-edit" aria-hidden="true"></i>Edit</a>
                                        <a href="admin/VideoManagement/delete?videoid=${item.videoid}"><i class="fa fa-trash" aria-hidden="true"></i>Delete</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>

                </div>