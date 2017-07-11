<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
	<title></title>
	<link rel="stylesheet" href="/resources/css/bootstrap.css" />
	<style>
		.fileDrop {
			width: 100%;
			height:200px;
			border: 1px dotted blue;
			padding: 100px 0px;
		}

		.center-background-text {
			text-align: center;

			top: 50%;
			left: 50%;
			margin-top: -50px;
			margin-left: -60px;
			z-index: 99;
		}
	</style>
</head>
<body>
<div class="container">
	<jsp:include page="../header.jsp" />

	<br />
	<div class="well">

		<form role="form">
			<input type="hidden" name="page" value="${criteria.page}">
			<input type="hidden" name="perPageNum" value="${criteria.perPageNum}">
			<input type="hidden" name="searchType" value="${criteria.searchType}">
			<input type="hidden" name="keyword" value="${criteria.keyword}">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="csrf"/>

			<div class="form-group">
				<label for="no">No.</label>
				<input type="text" class="form-control" name="no" id="no" value="${board.no}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" name="title" id="title" value="${board.title}">
			</div>

			<div class="form-group">
				<%--<label for="content">Content</label>--%>
				<%--<textarea class="form-control" name="content" id="content" rows="5">${board.content}</textarea>--%>
				<textarea name="content" id="ckeditor" cols="60" rows="10"></textarea>
			</div>

			<div class="form-group">
				<label for="writer">Writer</label>
				<input type="text" class="form-control" name="writer" id="writer" value="${board.writer}" readonly="true">
			</div>
		</form>

		<div class="fileDrop form-group">
			<div class="center-background-text"><h1 style="color: gray;">이미지나 파일을 드레그 해서 넣어주세요.</h1></div>
		</div>

		<div class="attachFiles row">

		</div>

		<div align="right" class="list-group">
			<button class="btn btn-primary" type="submit" id="btnModify">수정</button>
			<button class="btn btn-warning" type="submit" id="btnCancel">취소</button>
		</div>
	</div>
</div>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script src="/resources/js/jquery-3.2.1.js" ></script>
<script src="/resources/js/bootstrap.js" ></script>
<script src="/static/bbs/modify.js" ></script>
<script src="/static/common/common-js.js"></script>
</body>
</html>