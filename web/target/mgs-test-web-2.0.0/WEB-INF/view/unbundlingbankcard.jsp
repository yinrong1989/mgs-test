<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="jumbotron">

	<form class="form-horizontal" role="form" id="iForm" action="<c:url value="/remoteService.json"/>">
		<div class="form-group">
			<div class="col-md-2 col-md-offset-3">
				<button type="button" class="btn btn-default" id="encryptBut">加　　密</button>
			</div>
			<div class="col-md-2">
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
			<label for="bank_account_no_src" class="col-md-3 control-label">银行卡号</label>
			<div class="col-md-3">
				<input type="text" class="form-control" id="bank_account_no_src" name="bank_account_no_src" placeholder="请输入卡号明文，然后点击加密!">
			</div>
			<div class="col-md-3">
				<input type="text" class="form-control" id="bank_account_no" name="bank_account_no" readonly="readonly">
			</div>
			<span class="help-block">bank_account_no</span>
		</div>

<!-- 		<div class="form-group"> -->
<!-- 			<label for="pay_attribute" class="col-md-3 control-label">支付属性</label> -->
<!-- 			<div class="col-md-6"> -->
<!-- 				<select id="pay_attribute" name="pay_attribute" -->
<!-- 					class="form-control"> -->
<!-- 					<option value="normal">提现卡</option> -->
<!-- 					<option value="qpay">快捷卡</option> -->
<!-- 				</select> -->
<!-- 			</div> -->
<!-- 			<span class="help-block">pay_attribute</span> -->
<!-- 		</div> -->

		<div class="form-group">
			<label for="service" class="col-md-3 control-label">接口名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="service" name="service"
					value="unbundling_bank_card">
			</div>
			<span class="help-block">service</span>
		</div>
		<jsp:include page="common-footer.jsp"></jsp:include>
	</form>

</div>
