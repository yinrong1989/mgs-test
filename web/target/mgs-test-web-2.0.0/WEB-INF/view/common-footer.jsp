<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<div class="form-group">
			<label for="memo" class="col-md-3 control-label">请求数据</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="linkString">
			</div>
			<span class="help-block">linkString</span>
		</div>