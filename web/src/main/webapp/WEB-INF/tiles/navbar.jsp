<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<!-- <div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="javascript:;">会员网关测试</a>
	</div> -->
	<div class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<li <c:if test="${page=='index'}">class="active"</c:if>><a href="<c:url value="/index.htm" />">会员网关测试</a></li>
			<li <c:if test="${page=='personal'}">class="active"</c:if>><a href="<c:url value="/personal.htm"/>">创建个人会员</a></li>
<%-- 			<li <c:if test="${page=='personalmerchant'}">class="active"</c:if>><a href="<c:url value="/personalmerchant.htm"/>">创建个人会员及商户</a></li> --%>
<%-- 			<li <c:if test="${page=='merchant'}">class="active"</c:if>><a href="<c:url value="/merchant.htm"/>">创建商户</a></li> --%>
			<li <c:if test="${page=='enterprise'}">class="active"</c:if>><a href="<c:url value="/enterprise.htm"/>">创建企业会员</a></li>
<%--	    <li <c:if test="${page=='active'}">class="active"</c:if>><a href="<c:url value="/active.htm"/>">激活会员</a></li>--%>
			<li <c:if test="${page=='enterpriseinfo'}">class="active"</c:if>><a href="<c:url value="/enterpriseinfo.htm"/>">修改企业会员</a></li>
			<li <c:if test="${page=='mobile'}">class="active"</c:if>><a href="<c:url value="/mobile.htm"/>">修改手机号</a></li>
			<li <c:if test="${page=='email'}">class="active"</c:if>><a href="<c:url value="/email.htm"/>">修改邮箱</a></li>
			<li <c:if test="${page=='balance'}">class="active"</c:if>><a href="<c:url value="/balance.htm"/>">查询余额</a></li>
			<!-- <li <c:if test="${page=='personal2'}">class="active"</c:if>><a href="<c:url value="/personal2.htm"/>">创建并激活个人会员</a></li>  -->
			<li <c:if test="${page=='personalinfo'}">class="active"</c:if>><a href="<c:url value="/personalinfo.htm"/>">修改个人会员信息</a></li>
<%-- 			<li <c:if test="${page=='bankcard'}">class="active"</c:if>><a href="<c:url value="/bankcard.htm"/>">添加银行卡</a></li> --%>
<%-- 			<li <c:if test="${page=='unbundlingbankcard'}">class="active"</c:if>><a href="<c:url value="/unbundlingbankcard.htm"/>">解绑银行卡</a></li> --%>
<%-- 			<li <c:if test="${page=='querycardbin'}">class="active"</c:if>><a href="<c:url value="/querycardbin.htm"/>">查询卡Bin</a></li> --%>
<%-- 			<li <c:if test="${page=='bindingemail'}">class="active"</c:if>><a href="<c:url value="/bindingemail.htm"/>">绑定邮箱</a></li> --%>
<%-- 			<li <c:if test="${page=='updateaccountstatus'}">class="active"</c:if>><a href="<c:url value="/updateaccountstatus.htm"/>">更新账户状态</a></li> --%>
<%-- 		    <li <c:if test="${page=='userinfo'}">class="active"</c:if>><a href="<c:url value="/userinfo.htm"/>">会员信息</a></li> --%>
 		    <li <c:if test="${page=='openaccount'}">class="active"</c:if>><a href="<c:url value="/openaccount.htm"/>">会员开户</a></li>
   		    <li <c:if test="${page=='bindingmember'}">class="active"</c:if>><a href="<c:url value="/bindingmember.htm"/>">会员绑定</a></li>
            <li <c:if test="${page=='unbindingmember'}">class="active"</c:if>><a href="<c:url value="/unbindingmember.htm"/>">会员解绑</a></li>
            <li <c:if test="${page=='memberInfoUpload'}">class="active"</c:if>><a href="<c:url value="/memberInfoUpload.htm"/>">会员上传</a></li>
		</ul>
	</div>
</div>