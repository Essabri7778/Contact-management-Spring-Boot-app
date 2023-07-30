<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
	<html>
		<head>
			<title>Manage contact</title>
			<link rel="stylesheet"
				  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
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
				<div class="col-md-12 mx-auto ">
					<div class="card rounded-3 shadow-lg">
						<h3 class="card-header text-center display-6 fw-normal">List of Contacts</h3>
						<div class="card-body bg-light pt-4">
							<c:if test="${infoMsg!=null}">
								<div class="alert alert-success" role="alert">${infoMsg}</div>
							</c:if>
							<c:if test="${errorMsg!=null}">
								<div class="alert alert-danger" role="alert">${errorMsg}</div>
							</c:if>
							<div class="d-flex flex-row justify-content-around align-items-center">
									<form action="${pageContext.request.contextPath}/searchContactByPhoneNbr"
											class="d-flex" method="POST">
										<input name="phoneId" class="form-control me-2" type="search"
											   placeholder="Phone Numbre" aria-label="Search" style="border-color: #fd788a">
										<button class="btn" type="submit" style="background-color: #fd788a; color: white;">Search</button>
									</form>


									<form action="${pageContext.request.contextPath}/searchContactByLastName"
											class="d-flex" method="POST">
										<input name="nameId" class="form-control me-2" type="search"
											   placeholder="Last Name" aria-label="Search" style="border-color: #fd788a">
										<button class="btn " type="submit" style="background-color: #fd788a; color: white;">Search</button>
									</form>


									<a class="nav-link" href="${pageContext.request.contextPath}/orderContactByLastName" >
										<button class="btn " type="submit" style="background-color: #fd788a; color: white;" >Order By Last Name</button>
									</a>
							</div>

							<div class="table-responsive mt-4">
								<table class="table ">
									<thead>
										<tr>
											<th scope="col">First Name</th>
											<th scope="col">Last Name</th>
											<th scope="col">Pro Phone N°</th>
											<th scope="col">Personal Phone Number</th>
											<th scope="col">Professional Email</th>
											<th scope="col">Personal Email</th>
											<th scope="col">Address</th>
											<th scope="col">Gender</th>
											<th scope="col">Action</th>
										</tr>
									</thead>
									<c:forEach items="${contactList}" var="c">
										<tr>
											<td><c:out value="${c.firstName}" /></td>
											<td><c:out value="${c.lastName}" /></td>
											<td><c:out value="${c.professionalPhoneNbr}" /></td>
											<td><c:out value="${c.personalPhoneNbr}" /></td>
											<td><c:out value="${c.professionalEmail}" /></td>
											<td><c:out value="${c.personalEmail}" /></td>
											<td><c:out value="${c.address}" /></td>
											<td><c:out value="${c.gender}" /></td>
											<td>
												<div classe="button-container" style="display: flex">
														<a href="${pageContext.request.contextPath}/updateContactForm/${c.idContact}" style="text-decoration:none; ">
															<button  class="btn btn-outline-success" style="margin: 5px;background-color: #fead9a;color: white;border: none" type="submit">Update</button>
														</a>

														<a href="${pageContext.request.contextPath}/deleteContact/${c.idContact}" style="text-decoration:none; margin: 5px" >
															<button class="btn"  style="background-color: #fd788a; color: white;" type="submit">Delete</button>
														</a>
												</div>

											</td>
											<%--<td>
												<ul>
													<li><a href="${pageContext.request.contextPath}/deleteContact/${c.idContact}" style="text-decoration:none">Delete</a></li>

													<li><a href="${pageContext.request.contextPath}/updateContactForm/${c.idContact}" style="text-decoration:none">Update</a></li>
												</ul>
											</td>--%>
										</tr>

									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>