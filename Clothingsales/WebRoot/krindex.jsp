
<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>



<html>
<head>

<title></title>
<link href="css/styles.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>

 <div class="mainContent">
    <div class="blogitem">
      <article>
        <h2 class="title"><a href="/">������Ϣ</a></h2>
        <ul class="text">
        <center>
        <table border="1" width="300px" margin="center">
        <tr>�����¼��</tr>
        <tr>
        <td><div align="center">�·�</div></td>
        <td><div align="center">��������</div></td>  
        </tr>
        <c:forEach var="customer" items="${customer}" >
          <tr>
        <td><div align="center">${customer.item}</div></td>
        <td><div align="center">${customer.no}</div></td>
         </tr>
         </c:forEach>
        </table>
       </center>
        </ul>   
      </article>
       <c:if test="${imgnamebar!=null}">
       <div  align="center">
     <img  src="<%=basePath%>upload/${imgnamebar}" width="480" height="320" />   </c:if>
   <c:if test="${imgnamebar==null}">
         ͼ��û�����ݻ�δ��ȷ����
   </c:if>
    <c:if test="${imgnamepie!=null}">

     <img  src="<%=basePath%>upload/${imgnamepie}" width="480" height="320" />   </c:if>
   <c:if test="${imgnamepie==null}">
          ͼ��û�����ݻ�δ��ȷ����
   </c:if>
 </div>
</body>
</html>