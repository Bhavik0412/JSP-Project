<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Customer</h1>
        
        <form action="/customer/editSaveCustomer" method="post">
            <input type="hidden" name="id" value="${customer.id}">
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${customer.name}" required>
            
            <label for="gender">Gender:</label>
            <input type="text" id="gender" name="gender" value="${customer.gender}" required>
            
            <label for="dob">Dob:</label>
            <input type="text" id="dob" name="dob" value="${customer.dob}" required>
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="${customer.address}" required>
            
            <label for="uid">Uid:</label>
            <input type="text" id="uid" name="uid" value="${customer.uid}" required>
            
            <label for="proffesion">Profession:</label>
            <input type="text" id="proffesion" name="proffesion" value="${customer.proffesion}" required>
            
            <label for="citizenship">Citizenship:</label>
            <input type="text" id="citizenship" name="citizenship" value="${customer.citizenship}" required>
            
            <label for="openingBalance">Opening Balance:</label>
            <input type="text" id="openingBalance" name="openingBalance" value="${customer.openingBalance}" required>
            
            <input type="submit" value="Update Customer">
        </form>
        
        <br>
        <a href="/customer/viewCustomerList">Back to Customer List</a>
    </div>
</body>
</html>
