<%--
  ~ Copyright 1998-2009 Linux.org.ru
  ~    Licensed under the Apache License, Version 2.0 (the "License");
  ~    you may not use this file except in compliance with the License.
  ~    You may obtain a copy of the License at
  ~
  ~        http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~    Unless required by applicable law or agreed to in writing, software
  ~    distributed under the License is distributed on an "AS IS" BASIS,
  ~    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~    See the License for the specific language governing permissions and
  ~    limitations under the License.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: rsvato
  Date: May 5, 2009
  Time: 7:07:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/head.jsp"/>
<title>Конструктор страницы</title>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<h1>Конструктор страницы</h1>

<form action="/remove-box.jsp" method="post">
  <input type="hidden" name="pos" value="${pos}"/>
  <input type="hidden" name="tag" value="${tag}"/>

  Пароль <input type=password name=password><br/>
  <input type=submit value="Remove/Удалить">
</form>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>