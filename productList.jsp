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
<title>商品一覧画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main-contents">
		<div id="page-name">
			<h1>商品一覧画面</h1>
		</div>

		<!-- エラーメッセージ -->

		<div class="center">
			<h3>
				<s:if test="#session.productInfoDtoList==null || !#session.keywordsErrorMessageList.isEmpty()">
					<div class="info">検索結果がありません。</div>
					<br>

					<div class="error">
						<div class="red">
							<s:iterator value="#session.keywordsErrorMessageList">
								<s:property />
								<br>
							</s:iterator>
						</div>
					</div>
				</s:if>
			</h3>
		</div>

				<!-- 商品一覧 session.productInfoDtoListをiteratorで順に表示 -->

				<s:else>
				<div id="product-list">
					<s:iterator value="#session.productInfoDtoList">
						<div class="product-list-box">
							<ul>
								<a href='<s:url action="ProductDetailsAction"><s:param name="productId" value="%{productId}"/></s:url>'>
									<li>
										<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'class="item-image-box-List" />
											<div class="item-name">
												<p>
													<s:property value="productName" />
												</p>
											</div>
											<div class="item-name-kana">
												<p>
													<s:property value="productNameKana" />
												</p>
											</div>
											<div class="item-price">
												<p>
													<s:property value="price" />
													円
												</p>
											</div>
											<br>
									</li>
								</a>
							</ul>
						</div>
					</s:iterator>
				</div>

				<!-- 別ページへのリンク -->

				<div class="pager">
					<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
						<s:if test="#session.currentPageNo == #pageNo.count">
							<s:property value="%{#pageNo.count}" />
						</s:if>
						<s:else>
							<a href="<s:url action='SearchItemAction'><s:param name='pageNo' value='%{#pageNo.count}'/><s:param name='categoryId' value='%{categoryId}'/>
							<s:param name='keywords' value='%{keywords}'/></s:url> ">
								<s:property value="%{#pageNo.count}" />
							</a>
						</s:else>
					</s:iterator>
				</div>

			</s:else>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>