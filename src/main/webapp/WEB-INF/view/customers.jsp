<%--
  Created by IntelliJ IDEA.
  User: arnab
  Date: 25/06/20
  Time: 8:32 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Customers</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-expand-sm bg-success navbar-dark">
    <a href="#" class="navbar-brand ml-3"><h3>Customer Relationship Management</h3></a>

</nav>

<div class="container m-3">
    <h1>Customers</h1>

    <%--show add customer button if user is an admin--%>
    <security:authorize access="hasRole('ADMIN')">
        <button type="button" class="btn btn-primary mb-3" onclick="window.location.href='addCustomer'">
            Add Customer
        </button>
    </security:authorize>

    <table class="table table-striped table-bordered">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>

            <security:authorize access="hasRole('ADMIN')">
                <th>Action</th>
            </security:authorize>
        </tr>
        <c:forEach var="customer" items="${customers}">

            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>

                    <%--show customer update and action link if user is an admin--%>
                <security:authorize access="hasRole('ADMIN')">

                    <%--Construct an update link with customer id--%>
                    <c:url var="updateLink" value="/customers/updateCustomer">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>

                    <%--Construct an delete link with customer id--%>
                    <c:url var="deleteLink" value="/customers/deleteCustomer">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>

                    <td class="text-center">
                        <a href="${updateLink}">Update</a> | <a href="${deleteLink}" class="confirmation">Delete</a>
                    </td>

                </security:authorize>

            </tr>
        </c:forEach>
    </table>

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <button class="btn btn-primary mb-3" type="submit">Log out</button>
    </form:form>

</div>

<script type="text/javascript">

    $('.confirmation').on('click', function () {
        return confirm('Are you sure?');
    });

</script>
</body>
</html>
