<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="jumbotron">
	<h2>会员网关说明</h2>
	<ol>
		<li>外部系统通过会员网关调用MA接口，创建、激活、修改会员以及查询会员余额等。</li>
		<li>外部系统使用商户自己的私钥对提交的信息进行签名。</li>
		<li>会员网关通过外部系统提交的partner_id 获得商户公钥，使用公钥验证商户提交的数据。</li>
		<li>签名验证通过后会员网关调用MA接口，并对返回的信息使用私钥签名。</li>
		<li>外部系统收到网关响应后，先使用钱包公钥验证签名。验证通过后解析数据作后续处理。</li>
		<li>请核对下列环境配置，如果配置有误请修改/opt/pay/config/basis/mgs-test/mgs-test-resource.xml文件。</li>
	</ol>
	<pre>平台商户memberId:${partner_id}</pre>
	<pre>平台商户私钥:${merchant_private_key}</pre>
	<pre>平台商户MD5:${md5_key}</pre>
	<pre>钱包公钥:${wallet_public_key}</pre>
	<p>
		<a class="btn btn-lg btn-primary" href="<c:url value="/doc/api.docx" />" role="button">View api docs &raquo;</a>
	</p>
</div>