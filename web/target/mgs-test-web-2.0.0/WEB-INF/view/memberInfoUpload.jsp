<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.min.css"/>">
    <%-- <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap-theme.min.css"/>" > --%>
    <link rel="stylesheet" href="<c:url value="/css/app.css"/>">
    <!--[if lt IE 9]>
    <script src="<c:url value="/bootstrap/js/html5shiv.min.js"/>"></script>
    <![endif]-->
    <script src="<c:url value="/bootstrap/js/jquery-1.10.2.min.js"/>"></script>
    <script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/bootstrap/js/bootbox.min.js"/>"></script>
    <script src="<c:url value="/js/app.js"/>"></script>
    <script type="text/javascript">
        function validdateFile() {

            var inputFIlename= $("#file").val();
            if(inputFIlename){
                $("#importMemberInfo").submit();
            }else{
                $("#myModal").modal('show');
            }
        }
        function downLoadFile() {


        }
    </script>
    <title>Please upload a file</title>
</head>
<body>

<div class="container">
    <h1>Please upload a file</h1>
    <form role="form" id="importMemberInfo" method="post"  enctype="multipart/form-data" action="<c:url value="/importMemberInfo.json"/>">

        <div class="form-group">
            <label for="inputFile">File input</label>
            <input type="file" id="file" name="file">
            <p class="help-block">请选择批量上传会员类型</p>
        </div>
        <div class="form-group">
            <label>
                <select name="service" class="form-control">
                    <option value="create_personal_member">个人会员</option>
                    <option value="create_enterprise_member">企业会员</option>
                </select>
            </label>

        </div>

    </form>
    <div>
    <input type="button"   class="btn btn-primary btn-lg" onclick="validdateFile()" value="上传">
     <c:if test="${!empty filePath}">
         <a class="btn btn-primary btn-lg" href="<c:url value="/file/${filePath}"/>">下载</a></c:if>

    </div>
    <%--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>--%>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">提示</h4>
                </div>
                <div class="modal-body"><p class="lead">上传文件不能为空</p></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
</body>

</html>
