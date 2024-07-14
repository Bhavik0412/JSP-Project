<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List PAGE</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1200px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 18px;
        }

        th, td {
            padding: 5px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            display: inline-block;
            margin-right: 20px;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .add-link {
            display: block;
            text-align: right;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Customer List</h1>
        
        <div class="add-link">
            <a href="/customer/addCustomer">Add Customer</a>
        </div>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Date of Birth</th>
                <th>Address</th>
                <th>UID</th>
                <th>Proffesion</th>
                <th>Citizenship</th>
                <th>AccountNumber</th>
                <th>Opening Balance</th>
                <th>Actions</th>
            </tr>
            <!-- Iterate over the list of customers -->
            <c:forEach items="${allCustomers}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.dob}</td>
                    <td>${customer.address}</td>
                    <td>${customer.uid}</td>
                    <td>${customer.proffesion}</td>
                    <td>${customer.citizenship}</td>
                    <td>${customer.accountNumber}</td>
                    <td>${customer.openingBalance}</td>
                    <td>
                     <a href="editCustomer/${customer.id}">Edit</a>
                     <a href="deleteCustomer/${customer.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
