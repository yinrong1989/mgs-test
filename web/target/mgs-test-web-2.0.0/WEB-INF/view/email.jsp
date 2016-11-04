<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="jumbotron">

	<form class="form-horizontal" role="form" id="iForm" action="<c:url value="/remoteService.json"/>">
		<div class="form-group">
			<div class="col-md-2 col-md-offset-3">
				<button type="button" class="btn btn-default" id="signBut">签　　名</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default" id="submitBut">提　　交</button>
			</div>
		</div>

		<div class="form-group">
			<label for="identity_no" class="col-md-3 control-label">会员标识号</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="identity_no" name="identity_no">
			</div>
			<span class="help-block">identity_no</span>
		</div>

		<div class="form-group">
			<label for="identity_type" class="col-md-3 control-label">标识类型</label>
			<div class="col-md-6">
				<select id="identity_type" name="identity_type"
					class="form-control">
					<c:forEach var="item" items="${identity_type}" varStatus="status">
						<option value="${item}">${item}</option>
					</c:forEach>
				</select>
			</div>
			<span class="help-block">identity_type</span>
		</div>
		
		<div class="form-group">
			<label for="email" class="col-md-3 control-label">新邮箱</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="email" name="email">
			</div>
			<span class="help-block">email</span>
		</div>

		<div class="form-group">
			<label for="service" class="col-md-3 control-label">接口名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="service" name="service"
					value="modify_email">
			</div>
			<span class="help-block">service</span>
		</div>
		<jsp:include page="common-footer.jsp"></jsp:include>
	</form>

</div>
