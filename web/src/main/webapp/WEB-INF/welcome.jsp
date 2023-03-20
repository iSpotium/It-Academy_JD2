<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Welcome form</title>
</head>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        background: linear-gradient(120deg, black, #c70f0f);
        height: 100vh;
        overflow: hidden;
    }

    .wrapper {
        background-color: #ffff;
        max-width: 380px;
        border-radius: 20px;
        margin: 0 auto;
        position: absolute;
        top: 40%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 400px;
        background: whitesmoke;
        border-radius: 15px;


    }

    .title {
        text-align: center;
        padding-top: 20px;
        margin-bottom: 40px;
    }

    .title::after {
        content: '';
        width: 380px;
        height: 3px;
        margin: auto;
        margin-top: 34px;
        margin-bottom: 34px;
        border-bottom: 2px solid #c70f0f;
        display: block;

    }


    .text_table {
        text-align: center;
        margin-bottom: 60px;
        font-size: 20px;
    }

    .buttons_wrapper {
        display: flex;
        justify-content: space-around;
        padding-bottom: 30px;
    }

    .buttons_wrapper2 {
        display: flex;
        justify-content: space-around;
        padding-bottom: 30px;
    }

    .btn {
        width: 100px;
        height: 40px;
        border: 3px solid #c70f0f;
        background: #c70f0f;
        border-radius: 5px;
        font-size: 14px;
        color: black;
        font-weight: 700;
        cursor: pointer;
        outline: none;
        transition: .5s;
    }

    .btn:hover {
        border-color: black;
        transition: .5s;
    }
</style>

<body>
    <div class="wrapper">
        <div class="about">
            <h1 class='title'>Home Page</h1>

            <p class="text_table">
                Hello
                <c:out value="${loggedInUserName}" />
            </p>

            <div class="buttons_wrapper">
                <button class="btn" onclick="location.href='${pageContext.request.contextPath}/viewMyData'">My
                   data</button>
                <button class="btn" onclick="location.href='${pageContext.request.contextPath}/updateData'"
                    method="post">Settings</button>
                <button class="btn" onclick="location.href='${pageContext.request.contextPath}/logout'"
                    method="post">Logout</button>
            </div>
            <div class="buttons_wrapper2">
                <button class="btn" onclick="location.href='${pageContext.request.contextPath}/viewPosts'">
                My Posts</button>
                <button class="btn" onclick="location.href='${pageContext.request.contextPath}/addPost'"
                    method="post">Add post</button>
            </div>
        </div>
    </div>
</body>
</html>