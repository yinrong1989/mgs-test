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
			<label for="bank_account_no_src" class="col-md-3 control-label">银行卡号</label>
			<div class="col-md-3">
				<input type="text" class="form-control" id="bank_account_no_src" name="bank_account_no_src" placeholder="请输入卡号明文，然后点击加密!">
			</div>
			<div class="col-md-3">
				<input type="text" class="form-control" id="bank_account_no" name="bank_account_no" readonly="readonly">
			</div>
			<span class="help-block">bank_account_no</span>
		</div>

		<div class="form-group">
			<label for="service" class="col-md-3 control-label">接口名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="service" name="service"
					value="query_cardbin">
			</div>
			<span class="help-block">service</span>
		</div>
		<jsp:include page="common-footer.jsp"></jsp:include>
	</form>

</div>
