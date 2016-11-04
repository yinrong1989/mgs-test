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
			<label for="uid" class="col-md-3 control-label">外部系统用户ID</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="uid" name="uid">
			</div>
			<span class="help-block">uid</span>
		</div>

		<div class="form-group">
			<label for="real_name" class="col-md-3 control-label">真实姓名</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="real_name"
					name="real_name">
			</div>
			<span class="help-block">real_name</span>
		</div>

		<div class="form-group">
			<label for="mobile" class="col-md-3 control-label">手机号</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="mobile" name="mobile">
			</div>
			<span class="help-block">mobile</span>
		</div>

		<div class="form-group">
			<label for="email" class="col-md-3 control-label">邮箱</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="email" name="email">
			</div>
			<span class="help-block">email</span>
		</div>

		<div class="form-group">
			<label for="id_card_no" class="col-md-3 control-label">身份证号</label>
			<div class="col-md-6">
				<input type="text" class="form-control" id="id_card_no"
					name="id_card_no">
			</div>
			<span class="help-block">id_card_no</span>
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

		<%--<div class="form-group">
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
					value="create_personal_member">
			</div>
			<span class="help-block">service</span>
		</div>
		<jsp:include page="common-footer.jsp"></jsp:include>
	</form>

</div>
