<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">My App</a>
</nav>

<div class="container mt-5">
    <div class="jumbotron">
        <h1 class="display-4">Welcome to My App!</h1>
        <p class="lead">Welcome</p>
        <hr class="my-4">
        <a class="btn btn-secondary btn-lg mt-2" href="/customer/viewCustomerList" role="button">View All Customers</a>
        <a class="btn btn-success btn-lg mt-2" href="/user/reg" role="button">User Registration</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
