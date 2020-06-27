<%--
  Created by IntelliJ IDEA.
  User: arnab
  Date: 26/06/20
  Time: 12:08 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Customer</title>

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

    <h1>Add Customer Form</h1>

    <form:form action="addCustomer" modelAttribute="customer" method="post">

        <div class="border rounded p-3 w-50">

            <form:hidden path="id"/>

            <div class="form-group">
                <label for="firstNameInput">First Name</label>
                <form:input path="firstName" id="firstNameInput" placeholder="Enter First Name"
                            cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="firstName" cssClass="invalid-feedback"/>
            </div>

            <div class="form-group">
                <label for="lastNameInput">Last Name</label>
                <form:input path="lastName" id="lastNameInput" placeholder="Enter Last Name"
                            cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="lastName" cssClass="invalid-feedback"/>
            </div>

            <div class="form-group">
                <label for="emailInput">Email</label>
                <form:input path="email" id="emailInput" placeholder="Enter Email"
                            cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="email" cssClass="invalid-feedback"/>
            </div>

            <button type="submit" class="btn btn-primary">Save</button>

        </div>

    </form:form>

</div>

</body>
</html>
