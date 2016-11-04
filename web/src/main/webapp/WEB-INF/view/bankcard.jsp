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
			<label for="bank_code" class="col-md-3 control-label">银行编号</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="bank_code" name="bank_code" >
			</div>
			<span class="help-block">bank_code</span>
		</div>
		<div class="form-group">
			<label for="bank_name" class="col-md-3 control-label">银行名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="bank_name" name="bank_name" >
			</div>
			<span class="help-block">bank_name</span>
		</div>
		<div class="form-group">
			<label for="bank_branch" class="col-md-3 control-label">支行名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="bank_branch" name="bank_branch" >
			</div>
			<span class="help-block">bank_branch</span>
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
			<label for="account_name_src" class="col-md-3 control-label">户名</label>
			<div class="col-md-3">
				<input type="text" class="form-control" id="account_name_src" name="account_name_src" placeholder="请输入户名明文，然后点击加密!">
			</div>
			<div class="col-md-3">
				<input type="text" class="form-control" id="account_name" name="account_name" readonly="readonly">
			</div>
			<span class="help-block">account_name</span>
		</div>
		<div class="form-group">
			<label for="province" class="col-md-3 control-label">省份</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="province" name="province" >
			</div>
			<span class="help-block">province</span>
		</div>
		<div class="form-group">
			<label for="city" class="col-md-3 control-label">城市</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="city" name="city" >
			</div>
			<span class="help-block">city</span>
		</div>
		<div class="form-group">
			<label for="card_type" class="col-md-3 control-label">卡类型</label>
			<div class="col-md-6">
				<select id="card_type" name="card_type"
					class="form-control">
					<option value="DEBIT">借记</option>
					<option value="CREDIT">贷记（信用卡）</option>
					<option value="PASSBOOK">存折</option>
					<option value="OTHER">其它</option>
					<option value=""></option>
				</select>
			</div>
			<span class="help-block">card_type</span>
		</div>
		<div class="form-group">
			<label for="card_attribute" class="col-md-3 control-label">卡属性</label>
			<div class="col-md-6">
				<select id="card_attribute" name="card_attribute"
					class="form-control">
					<option value="C">对私</option>
					<option value="B">对公</option>
					<option value=""></option>
				</select>
			</div>
			<span class="help-block">card_attribute</span>
		</div>


		<div class="form-group">
			<label for="service" class="col-md-3 control-label">接口名称</label>
			<div class="col-md-6">
			<input type="text" class="form-control" id="service" name="service"
					value="create_bank_card">
<!-- 				<select id="service" name="service" -->
<!-- 					class="form-control"> -->
<!-- 					<option value="create_bank_card">创建银行卡</option> -->
<!-- 					<option value="update_bank_card">修改银行卡</option> -->
<!-- 					<option value=""></option> -->
<!-- 				</select> -->
			</div>
			<span class="help-block">service</span>
		</div>
		<jsp:include page="common-footer.jsp"></jsp:include>
		<div class="form-group">
			<p class="text-center">修改银行卡接口不可以修改银行卡号</p>
		</div>
	</form>

</div>
