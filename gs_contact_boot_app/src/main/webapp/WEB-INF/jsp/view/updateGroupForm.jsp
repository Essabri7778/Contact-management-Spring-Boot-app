<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update group form</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
          crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Concert+One&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <style>
        body{
            font-family:'Poppins', sans-serif;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <div class="row my-4">
        <div class="col-md-10 mx-auto ">
            <div class="card rounded-3 shadow-lg">
                <h3 class="card-header text-center display-6 fw-normal">Update Group</h3>
                <div class="card-body bg-light">
                    <c:if test="${infoMsg!=null}">
                        <div class="alert alert-success" role="alert">${infoMsg}</div>
                    </c:if>
                    <c:if test="${errorMsg!=null}">
                        <div class="alert alert-danger" role="alert">${errorMsg}</div>
                    </c:if>

                    <!--Form-->
                    <f:form action="${pageContext.request.contextPath}/updateGroup"
                            method="POST" modelAttribute="groupModel"> <f:hidden path="idGroupe"/>
                        <div class="row mt-1">
                            <div class="col mb-3">
                                <label>Group Name</label>
                                <f:input path="groupeName" type="text" class="form-control"
                                         placeholder="Group Name" />
                                <f:errors path="groupeName" class="text-danger" />
                            </div>
                        </div>

                        <legend class="col-form-label col-sm-2 pt-0">Contacts</legend>
                        <div class="row mt-1">
                            <div class="col-12">
                                <c:forEach items="${contactList}" var="option">
                                    <c:set var="action" value="" />
                                    <c:forEach items="${groupModel.getContacts()}" var="elem">
                                        <c:if test="${elem.getIdContact() eq option.getIdContact()}">
                                            <c:set var="action" value="true" />
                                        </c:if>
                                    </c:forEach>
                                    <div class="form-check form-check-inline col-3">
                                        <f:checkbox path="Contacts" value="${option.getIdContact()}"
                                                    class="form-check-input" checked="${action}" />
                                        <label class="form-check-label">${option.getLastName()} ${option.getFirstName()} </label>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <div style="text-align: right" class="mt-1">
                            <button type="submit" class="btn" style="background-color: #fd788a; color: white">Register</button>
                            <button type="reset" class="btn" style="background-color: transparent; color: #fd788a;border-color: #fd788a;">Reset</button>
                        </div>

                    </f:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>