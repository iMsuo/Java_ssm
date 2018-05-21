<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

	<script type="text/javascript">
		$(function(){
			$("#testAjax").click(function(){
				alert("1");
				var booId=$("#bookID").text();
			var url="localhost:8080${pageContext.request.contextPath}/book/"+booId+"/appoint";
				alert(url);
				$.ajax({
					type:"POST",
					url:"http://localhost:8080${pageContext.request.contextPath}/book/"+booId+"/appoint",
					data: "studentId="+'<%=(int)(Math.random()*1000) %>',
					async:false,
					success:function(data){
						//alert("2");
						var jsonReturn = JSON.parse(data.data);
						alert(jsonReturn.success)
					}
				})
			}
			)
		}
		)
	</script>

  </head>
  
  <body>
     <p id="bookID">${book.bookId}</p>
    <hr/>
      书名：${book.name} 剩余:<p id="number">${book.number}</p>
     <hr/>
     <button id="testAjax" >预约</button>
     <p id="result"></p>
  </body>
</html>
