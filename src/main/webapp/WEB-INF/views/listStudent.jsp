<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Data JPA</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<button type="button" class="btn">List</button>
<div class="container">
  <div class="col-md-offset-1 col-md-10">
    <h3 class="text-center">Spring Data JPA Project 1</h3>
    <hr />
    <input type="button" value="학생 등록" onclick="window.location.href='showForm'; return false;" class="btn btn-primary"/>
    <br />
    <br />
    <div class="text-center">
      <div class="panel-heading">
        <div class="fs-2">학생 목록</div>
      </div>
      <div class="panel-body"></div>
        <table class="table table-striped">
          <hr />
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>주소</th>
            <th>비고</th>
          </tr>
          <c:forEach var ="tempStudent" items="${students}">
            <%-- update url--%>
            <c:url var="updateLink" value="/student/updateForm">
              <c:param name="studentId" value="${tempStudent.id}"/>
            </c:url>
            <%-- delete url--%>
            <c:url var="deleteLink" value="/student/delete">
              <c:param name="studentId" value="${tempStudent.id}"/>
            </c:url>
           <tr>
             <td>${tempStudent.id}</td>
             <td>${tempStudent.name}</td>
             <td>${tempStudent.email}</td>
             <td>${tempStudent.address}</td>
             <td>
               <a href="${updateLink}">수정</a> |
               <a href="${deleteLink}" onclick="if(!(confirm('선택한 학생을 삭제하시겠습니까?'))) return false;">삭제</a>
             </td>
           </tr>
          </c:forEach>
        </table>
    </div>
  </div>
</div>
</body>
</html>
