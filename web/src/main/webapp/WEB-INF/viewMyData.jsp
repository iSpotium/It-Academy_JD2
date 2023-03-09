<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <html lang="en">

        <head>
            <meta charset="UTF=8">
            <title>ViewMyData form</title>
        </head>

        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                background: linear-gradient(120deg, #17191c, #c23c72);
                height: 100vh;
                overflow: hidden;
            }

            .wrapper {
                background-color: whitesmoke;
                max-width: 380px;
                border-radius: 20px;
                margin: 0 auto;
                position: absolute;
                top: 40%;
                left: 50%;
                transform: translate(-50%, -50%);
                width: 380px;
                background: linear-gradient(rgb(54, 10, 43), rgb(18, 50, 168));
                border-radius: 15px;
            }

            .title {
                text-align: center;
                padding-top: 15px;
                margin-bottom: 100px;
                color: #c23c72;

            }


            .title::after {
                content: '';
                width: 380px;
                height: 3px;
                margin: auto;
                margin-top: 10px;
                margin-bottom: 34px;
                border-bottom: 2px solid #c84cc8;
                display: block;

            }


            .field {
                width: 250px;
                background: #17191c;
                border-radius: 5px;
                border: 2px solid #c23c72;
                font-family: cursive;
                transform: translate(25%, -350%);
                color: #c23c72;
                margin-bottom: 10px;
            }

            .buttons_wrapper {
                display: flex;
                justify-content: space-around;
                padding-bottom: 30px;
            }

            .btn {
                width: 130px;
                height: 40px;
                border: 2px solid #c23c72;
                background: #17191c;
                border-radius: 5px;
                font-size: 13px;
                color: #c23c72;
            }

            .btn:hover {
                border-color: black;
                transition: .5s;
            }
        </style>

        <body>
            <div class="wrapper">
                <div class="about">
                    <h1 class="title">My Data</h1>
                    <p class="field">Name -
                        <c:out value="${viewUserName}" />
                    </p>
                    <p class="field">Email -
                        <c:out value="${viewUserEmail}" />
                    </p>
                    <p class="field">Role -
                        <c:out value="${viewUserRole}" />
                    </p>
                    <p class="field">ID -
                        <c:out value="${viewUserId}" />
                    </p>
                    <p class="field">Password -
                        <c:out value="${viewUserPassword}" />
                    </p>
                    <div class="buttons_wrapper">
                        <button class="btn" onclick="location.href='${pageContext.request.contextPath}/welcome'"> Back
                            to
                            Welcome
                            page
                        </button>
                        <button class="btn" onclick="location.href='${pageContext.request.contextPath}/logout'"
                            method="post">Logout</button>
                    </div>
                </div>
            </div>
        </body>

</html>