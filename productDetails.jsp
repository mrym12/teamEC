<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex, nofollow" />
<link rel="stylesheet" href="./css/i1810a.css">
<title>商品詳細画面</title>

</head>

<body>

	<jsp:include page="header.jsp" />
	<div class="main-contents">
		<div id="page-name">
			<h1>商品詳細画面</h1>
		</div>
		<s:form action="AddCartAction">

			<!-- 商品写真 -->

			<div class="left">
				<img src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>'
					class="item-image-box" /><br>
			</div>

			<!-- 商品詳細、sessionから取得 -->

			<div class="right">

				<table class="vertical-list-table-mini">
					<tr>
						<th scope="row"><s:label value="商品名" /></th>
						<td><s:property value="%{#session.productName}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="商品名ふりがな" /></th>
						<td><s:property value="%{#session.productNameKana}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="値段" /></th>
						<td><s:property value="%{#session.price}" />円</td>
					</tr>
					<tr>
						<th scope="row"><s:label value="購入個数" /></th>
						<td><s:select name="productCount"
								list="%{#session.productCountList}" />個</td>
					</tr>
					<tr>
						<th scope="row"><s:label value="発売会社名" /></th>
						<td><s:property value="%{#session.releaseCompany}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="発売年月日" /></th>
						<td><s:property value="%{#session.releaseDate}" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="商品詳細情報" /></th>
						<td><s:property value="%{#session.productDescription}" /></td>
					</tr>
				</table>

				<s:token/>
					<div class="submit-btn-box-all">
						<s:submit value="カートに追加" class="submit-btn-login" />
					</div>
			</div>

		</s:form>

		<!-- 関連商品、ランダムで同カテゴリから3件選択 -->

		<div class="main2">
			<h1>【関連商品】</h1>
			<ul>
				<s:iterator value="#session.productInfoDtoList">
					<li>
						<a href='<s:url action="ProductDetailsAction"><s:param name="productId" value="%{productId}"/></s:url>'>
							<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'class="item-image-box-100" />
						</a>
						<div class="productname">
							<s:property value="productName" />
						</div> <br>
					</li>
				</s:iterator>
			</ul>
		</div>

	</div>

	<s:include value="footer.jsp" />
</body>
</html>