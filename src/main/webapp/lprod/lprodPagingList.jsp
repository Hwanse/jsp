<%@page import="kr.or.ddit.lprod.model.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Lprod리스트</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>

</head>

<body>


	<!-- header -->
	<%@include file="/common/header.jsp" %>
	
	<div class="container-fluid">

		<div class="row">

			<!-- left -->
			<%@include file="/common/left.jsp" %>
			
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


			<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">Lprod</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>Lprod_ID</th>
									<th>Lprod_gu</th>
									<th>상품분류명</th>
								</tr>
							
								<%
									List<LprodVO> pagingList = (List<LprodVO>)request.getAttribute("lprodPagingList");
									
								
									for(int i=0; i < pagingList.size(); i++){	
										LprodVO tmp = pagingList.get(i);
									%>
										<tr>
											<td><%=tmp.getLprod_id() %></td>										
											<td><%=tmp.getLprod_gu() %></td>										
											<td><%=tmp.getLprod_nm() %></td>
										</tr>
								<% } %>

							</table>
						</div>

						<a class="btn btn-default pull-right">상품분류등록</a>

						<div class="text-center">
							<ul class="pagination" >
								<%
									PageVO pageVO = (PageVO)request.getAttribute("pageVO");
									
									if(pageVO.getPage() == 1){ %>
										<li class="previous disabled">
											<span>«</span>
										</li>
									<%
									}else{%>
										<li class="previous">
											<a href="${pageContext.request.contextPath}/lprodPagingList?page=<%=pageVO.getPage()-1 %>&pageSize=<%=pageVO.getPageSize() %>">«</a>
										</li>
								  <%} %>
								<% 
								
									int usersCnt = (Integer)request.getAttribute("lprodsCnt");
									
									int pageLength = (Integer)request.getAttribute("paginationSize");
									
									for(int i=1; i <= pageLength; i++){%>
										<% if( pageVO.getPage() == i ) {%>
												<li class = "active">
													<span><%=i %></span>
												</li>
										<% 		continue; 
											} %>
											
										<li><a href="${pageContext.request.contextPath}
										/lprodPagingList?page=<%=i %>&pageSize=<%=pageVO.getPageSize() %>"><%=i %></a></li>
								<% 	} %>
								
								<% if(pageVO.getPage() == pageLength){%>
									<li class="next disabled">
										<span>»</span>
									</li>	
								 <%} else{%>
								 	<li class="next">
								 		<a href="${pageContext.request.contextPath}/lprodPagingList?page=<%=pageVO.getPage() +1 %>&pageSize=<%=pageVO.getPageSize() %>">»</a>
								 	</li>
								 <%} %>		
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
