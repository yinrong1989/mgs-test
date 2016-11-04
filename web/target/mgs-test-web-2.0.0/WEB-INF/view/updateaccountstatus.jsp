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
			<label for="account_type" class="col-md-3 control-label">账户类型</label>
			<div class="col-md-6">
				<select id="is_active" name="account_type" class="form-control">
					<option value="101" selected>基本户(101)</option>
					<option value="102">保证金户(102)</option>
					<option value="103">佣金户(103)</option>
				</select>
			</div>
			<span class="help-block">account_type</span>
		</div>

		<div class="form-group">
			<label for="status" class="col-md-3 control-label">账户状态</label>
			<div class="col-md-6">
				<select id="is_active" name="status" class="form-control">
					<option value="0" selected>未冻结(0)</option>
					<option value="1">止出(1)</option>
					<option value="2">止入(2)</option>
					<option value="3">双向冻结(3)</option>
				</select>
			</div>
			<span class="help-block">status</span>
		</div>

		<div class="form-group">
			<label for="service" class="col-md-3 control-label">接口名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="service" name="service"
					value="update_ account_freeze_status">
			</div>
			<span class="help-block">service</span>
		</div>
		<jsp:include page="common-footer.jsp"></jsp:include>
	</form>

</div>
