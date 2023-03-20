<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

        <head>
            <meta charset="UTF-8">
            <title>Change Data form</title>
        </head>


        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                background: linear-gradient(120deg, black, purple);
                height: 100vh;
                overflow: hidden;
            }

            .wrapper {
                background-color: rgb(171, 189, 186);
                max-width: 450px;
                border-radius: 3px;
                margin: 0 auto;
                position: absolute;
                top: 40%;
                left: 50%;
                transform: translate(-50%, -50%);
                width: 450px;
                background: rgb(65, 65, 88);
                border-radius: 3px;
            }

            .title {
                text-align: center;
                padding-top: 5px;
                margin-bottom: 25px;
                color: rgb(35, 9, 58);
            }

            .title::after {
                content: '';
                width: 450px;
                height: 3px;
                margin: auto;
                margin-top: 10px;
                margin-bottom: 70px;
                border-bottom: 2px solid rgb(35, 9, 58);
                display: block;

            }

            .buttons_wrapper {
                display: flex;
                justify-content: space-around;
                padding-bottom: 30px;

            }

            .btn {
                width: 120px;
                height: 30px;
                border: 2px solid #0a070a;
                background: #703e77;
                border-radius: 3px;
                font-size: 11px;
                color: black;
                font-weight: 700;
                cursor: pointer;
                outline: none;
                transition: .5s;
            }

            .btn:hover {
                border-color: #0a070a;
                transition: .5s;
            }
        </style>

        <body>
            <div class="wrapper">
                <div class="about">
                    <h1 class="title">Settings</h1>
                    <div class="buttons_wrapper">
                        <button class="btn" onclick="location.href='${pageContext.request.contextPath}/updateName'"
                            method="post">Change
                            my username</button>
                        <button class="btn" onclick="location.href='${pageContext.request.contextPath}/updateEmail'"
                            method="post">Change my email</button>
                        <button class="btn" onclick="location.href='${pageContext.request.contextPath}/updatePassword'"
                            method="post">Change my password</button>
                    </div>
                    <div class="buttons_wrapper">
                        <button class="btn" onclick="location.href='${pageContext.request.contextPath}/welcome'"
                            method="get">Back to
                            Home page</button>
                        <c:if test="${loggedInUserRole=='ADMIN'}">
                            <button class="btn" onclick="location.href='${pageContext.request.contextPath}/viewUsers'"
                                method="get">View users</button>
                        </c:if>
                        <button class="btn" onclick="location.href='${pageContext.request.contextPath}/logout'"
                            method="get">Logout</button>
                    </div>
                </div>
            </div>
        </body>

</html>>