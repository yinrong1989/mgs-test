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
			<div class="col-md-2">
				<button type="button" class="btn btn-default" id="autoBut">一键提交</button>
			</div>
		</div>

		<div class="form-group">
			<label for="login_name" class="col-md-3 control-label">登录名</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="login_name" name="login_name">
			</div>
			<span class="help-block">login_name</span>
		</div>

		<div class="form-group">
			<label for="uid" class="col-md-3 control-label">外部系统用户ID</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="uid" name="uid">
			</div>
			<span class="help-block">uid</span>
		</div>

		<div class="form-group">
			<label for="enterprise_name" class="col-md-3 control-label">企业名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="enterprise_name"
					name="enterprise_name">
			</div>
			<span class="help-block">enterprise_name</span>
		</div>

		<div class="form-group">
			<label for="member_name" class="col-md-3 control-label">会员名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="member_name"
					name="member_name">
			</div>
			<span class="help-block">member_name</span>
		</div>
		
		<div class="form-group">
			<label for="login_pwd" class="col-md-3 control-label">登陆密码</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="login_pwd"
					name="login_pwd">
			</div>
			<span class="help-block">login_pwd</span>
		</div>
		
		<div class="form-group">
			<label for="legal_person" class="col-md-3 control-label">企业法人</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="legal_person"
					name="legal_person">
			</div>
			<span class="help-block">legal_person</span>
		</div>
		<div class="form-group">
			<label for="legal_person_phone" class="col-md-3 control-label">法人手机号码</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="legal_person_phone"
					name="legal_person_phone">
			</div>
			<span class="help-block">legal_person_phone</span>
		</div>
		<div class="form-group">
			<label for="website" class="col-md-3 control-label">企业网址</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="website"
					name="website">
			</div>
			<span class="help-block">website</span>
		</div>
		<div class="form-group">
			<label for="address" class="col-md-3 control-label">企业地址</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="address"
					name="address">
			</div>
			<span class="help-block">address</span>
		</div>
		<div class="form-group">
			<label for="license_no" class="col-md-3 control-label">执照号</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="license_no"
					name="license_no">
			</div>
			<span class="help-block">license_no</span>
		</div>
		<div class="form-group">
			<label for="license_address" class="col-md-3 control-label">营业执照所在地</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="license_address"
					name="license_address">
			</div>
			<span class="help-block">license_address</span>
		</div>
		<div class="form-group">
			<label for="license_expire_date" class="col-md-3 control-label">执照过期日(yyyymmdd)</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="license_expire_date"
					name="license_expire_date">
			</div>
			<span class="help-block">license_expire_date</span>
		</div>
		<div class="form-group">
			<label for="business_scope" class="col-md-3 control-label">营业范围</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="business_scope"
					name="business_scope">
			</div>
			<span class="help-block">business_scope</span>
		</div>
		<div class="form-group">
			<label for="telephone" class="col-md-3 control-label">联系电话</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="telephone"
					name="telephone">
			</div>
			<span class="help-block">telephone</span>
		</div>
		<div class="form-group">
			<label for="organization_no" class="col-md-3 control-label">组织机构代码</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="organization_no"
					name="organization_no">
			</div>
			<span class="help-block">organization_no</span>
		</div>
		<div class="form-group">
			<label for="summary" class="col-md-3 control-label">企业简介</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="summary"
					name="summary">
			</div>
			<span class="help-block">summary</span>
		</div>
		<div class="form-group">
			<label for="trade_limit" class="col-md-3 control-label">免密额度</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="trade_limit"value="0"
					   name="trade_limit">
			</div>
			<span class="help-block">trade_limit</span>
		</div>
		
<%--		<div class="form-group">
			<label for="is_active" class="col-md-3 control-label">是否激活会员</label>
			<div class="col-md-6">
				<select id="is_active" name="is_active" class="form-control">
					<option value="T" selected>True</option>
					<option value="F">False</option>
				</select>
			</div>
			<span class="help-block">is_active</span>
		</div>--%>
		
		<div class="form-group">
			<label for="service" class="col-md-3 control-label">接口名称</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="service" name="service"
					value="create_enterprise_member">
			</div>
			<span class="help-block">service</span>
		</div>
		<jsp:include page="common-footer.jsp"></jsp:include>
	</form>

</div>
