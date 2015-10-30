<%--
  Created by IntelliJ IDEA.
  User: Infected
  Date: 24.10.2015
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
  <head>
    <title></title>
    <link href="css/corners.css" rel="stylesheet" media="all"/>
  </head>
  <body>
    <img src="img/Desc.jpg"/>
    <img class="black" src="img/Black.png"/>
    <img class="white" src="img/White.png"/>
    <img class="green" src="img/Green.png"/>
    <c:forEach items="${cells}" var="cell">
      Test
    </c:forEach>
  </body>
</html>
