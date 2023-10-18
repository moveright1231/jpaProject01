<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <title>학생 정보 등록</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <div class="col-md-offset-1 col-md-10">
    <h3 class="test-center">Spring Data JPA Project 1</h3>
    <br />
    <div>
      <div class = "text-center">
        <div class="panel-padding">
          <div class="fs-4">학생 정보 등록</div>
        </div>
        <div class ="panel-body">
          <form:form action="saveStudent" cssClass="horizental" method="post" modelAttribute="student">
            <div class="form-group">
              <form:hidden path="id"/>
              <label for="name" class="col-md-3">이름</label>
              <div>
                <form:input path="name" class="form-control"/>
              </div>
              <label for="email" class="col-md-3">이메일</label>
              <div>
                <form:input path="email" class="form-control"/>
              </div>
              <label>주소</label>
              <div>
                <form:input path="address" class="form-control"/>
              </div>
            </div>
          <br />
          <div>
            <form:button class="btn btn-primary">등록</form:button>
          </div>
          </form:form>
      </div>
      </div>
      </div>
</div>
</div>
<br />
<br />
<div class="footer">
  <p>🏫Semyung University</p>
</div>
</body>
</html>
