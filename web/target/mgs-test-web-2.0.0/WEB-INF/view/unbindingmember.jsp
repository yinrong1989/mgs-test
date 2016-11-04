<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="jumbotron">

	<form class="form-horizontal" role="form" id="iForm" action="<c:url value="/remoteService.json"/>">
		<div class="form-group">
			<div class="col-md-2 col-md-offset-2">
				<button type="button" class="btn btn-default" id="fillBut">自动填充</button>
			</div>
			<div class="col-md-2">
			    <button type="button" class="btn btn-default" id="signBut">签　　名</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default" id="submitBut">提　　交</button>
			</div>
		</div>

		<div class="form-group">
			<label for="uid" class="col-md-3 control-label">业务系统用户唯一id</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="uid" name="uid">
			</div>
			<span class="help-block">uid</span>
		</div>
		
	<div class="form-group">
			<label for="member_unbinding" class="col-md-3 control-label">业务系统平台ID</label>
			<div class="col-md-6">
				<select id="pid" name="pid" class="form-control">
					<option value="1" selected>UID1</option>
					<option value="11">UID11</option>
					<option value="12">UID12</option>
					<option value="13">UID13</option>
					<option value="14">UID14</option>
				</select>
			</div>
			<span class="help-block">pid</span>
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
					<option value="UID">UID</option>
					<option value="MEMBER_ID">MEMBER_ID</option>
					<option value="EMAIL">EMAIL</option>
					<option value="MOBILE">MOBILE</option>
					<option value="LOGIN_NAME">LOGIN_NAME</option>
					<option value="COMPANY_ID">COMPANY_ID</option>
				</select>
			</div>
			<span class="help-block">identity_type</span>
		</div>

		<div class="form-group">
			<label for="service" class="col-md-3 control-label">接口名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="service" name="service"
					value="member_unbinding">
			</div>
			<span class="help-block">service</span>
		</div>
		
		<div class="form-group">
			<label for="version" class="col-md-3 control-label">版本</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="version" name="version"
					value="1.0">
			</div>
			<span class="help-block">version</span>
		</div>
		
		<div class="form-group">
			<label for="partner_id" class="col-md-3 control-label">合作者身份ID</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="partner_id"
					name="partner_id" value="${partner_id}" placeholder="平台商户memberId">
			</div>
			<span class="help-block">partner_id</span>
		</div>
		<div class="form-group">
			<label for="_input_charset" class="col-md-3 control-label">参数编码字符集</label>
			<div class="col-md-6">
				<select id="_input_charset" name="_input_charset"
					class="form-control">
					<option value="UTF-8">UTF-8</option>
					<option value="GBK">GBK</option>
					<option value="GB2312">GB2312</option>
				</select>
			</div>
			<span class="help-block">_input_charset</span>
		</div>
		<div class="form-group">
			<label for="sign" class="col-md-3 control-label">签名</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="sign" name="sign">
			</div>
			<span class="help-block">sign</span>
		</div>
		<div class="form-group">
			<label for="sign_type" class="col-md-3 control-label">签名方式</label>
			<div class="col-md-6">
				<select id="sign_type" name="sign_type" class="form-control">
					<option value="RSA">RSA</option>
					<option value="MD5">MD5</option>
				</select>
			</div>
			<span class="help-block">sign_type</span>
		</div>
		<div class="form-group">
			<label for="memo" class="col-md-3 control-label">备注</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="memo" name="memo">
			</div>
			<span class="help-block">memo</span>
		</div>
	</form>

</div>
