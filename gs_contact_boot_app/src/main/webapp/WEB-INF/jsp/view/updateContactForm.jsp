<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update contact form</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
            rel="stylesheet"
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
                    <h3 class="card-header text-center display-6 fw-normal">Update Contact</h3>
                    <div class="card-body bg-light">

            <c:if test="${infoMsg!=null}">
                <div class="alert alert-success" role="alert">${infoMsg}</div>
            </c:if>
            <c:if test="${errorMsg!=null}">
                <div class="alert alert-danger" role="alert">${errorMsg}</div>
            </c:if>

            <f:form action="${pageContext.request.contextPath}/updateContact" method="POST" modelAttribute="contactModel">
                <f:hidden path="idContact" />
                <div class="row mt-1">
                    <div class="col mb-3">
                        <label>First Name</label>
                        <f:input path="firstName" type="text" class="form-control"
                                 placeholder="First Name" />
                        <f:errors path="firstName" class="text-danger" />
                    </div>

                    <div class="col mb-3">
                        <label>Last Name</label>
                        <f:input path="lastName" type="text" class="form-control"
                                 placeholder="Last Name" />
                        <f:errors path="lastName" class="text-danger" />
                    </div>

                </div>


                <div class="row mt-1">
                    <div class="col mb-3">
                        <label>Professional Phone Number</label>
                        <f:input path="professionalPhoneNbr"  class="form-control"
                                 placeholder="Professional Phone Number" />
                        <f:errors path="professionalPhoneNbr" class="text-danger" />
                    </div>

                    <div class="col mb-3">
                        <label>Personal Phone Number</label>
                        <f:input path="personalPhoneNbr" class="form-control"
                                 placeholder="Personal Phone Number" />
                        <f:errors path="personalPhoneNbr" class="text-danger" />
                    </div>
                </div>


                <div class="row mt-1">
                    <div class="col mb-3">
                        <label>Professional Email</label>
                        <f:input path="professionalEmail"  class="form-control"
                                 placeholder="Professional Email" />
                        <f:errors path="professionalEmail" class="text-danger" />
                    </div>

                    <div class="col mb-3">
                        <label >Personal Email</label>
                        <f:input path="personalEmail"  class="form-control"
                                 placeholder="personalEmail" />
                        <f:errors path="personalEmail" class="text-danger" />
                    </div>
                </div>



                <div class="row mt-1">
                    <div class="col mb-3">
                        <label>Address</label>
                        <f:input path="address" type="text" class="form-control"
                                 placeholder="...., Morocco" />
                        <f:errors path="address" class="text-danger" />
                    </div>

                    <div class="col mb-3">
                        <fieldset class="form-group">
                            <legend class="col-form-label">Gender</legend>
                            <div class="form-check form-check-inline">
                                <f:radiobutton path="gender" class="form-check-input"
                                               value="Female" />
                                <label class="form-check-label">Female </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <f:radiobutton path="gender" class="form-check-input"
                                               value="Male " />
                                <label class="form-check-label">Male </label>
                            </div>
                        </fieldset>
                    </div>
                    <f:errors path="gender" class="text-danger" />

                </div>
                <div style="text-align: right" class="mt-1">
                    <button type="submit" class="btn" style="background-color: #fd788a; color: white">Update</button>
                    <button type="reset" class="btn" style="background-color: transparent; color: #fd788a;border-color: #fd788a;">Reset</button>
                </div>
            </f:form>
        </div>
    </div>
</body>
</html>
