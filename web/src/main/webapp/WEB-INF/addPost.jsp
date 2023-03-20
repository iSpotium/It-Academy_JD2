<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Add post form</title>
</head>


<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        background: linear-gradient(120deg, #404cb7, #3b3232);
        height: 100vh;
        overflow: hidden;
    }

    .center {
        position: absolute;
        top: 40%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 400px;
        background: whitesmoke;
        border-radius: 15px;
    }

    .center h1 {
        text-align: center;
        padding: 7px 0px 10px 0px;
        border-bottom: 2px solid #404cb7;
        color: #404cb7;
    }

    .center form {
        padding: 25px 60px;
        box-sizing: border-box;
    }

    form .txt_field {
        position: sticky;
        border-bottom: 2px solid #404cb7;
        margin: 25px 0px;
    }

    form .txt_field {
        position: sticky;
        border-bottom: 2px solid #404cb7;
        margin: 25px 0px;
    }

    .txt_field input {
        width: 100%;
        padding: 0px 5px;
        height: 40px;
        font-size: 16px;
        border: none;
        background: none;
        outline: none;
    }



    .txt_field label {
        position: absolute;
        top: 50%;
        left: 5px;
        color: #adadad;
        transform: translateY(-50%);
        font-size: 16px;
        pointer-events: none
    }

    .txt_field span::before {
        content: '';
        position: absolute;
        top: 40px;
        left: 0;
        width: 0%;
        height: 2px;
        background: #404cb7;
        transition: .5s;
    }

    .text_area {
        border-color: #404cb7;
        width: 100%;
        height: 55px;
        transform: translateY(45%);

    }

    .txt_field2 label {
        position: absolute;
        top: 55%;
        left: 65px;
        color: #adadad;
        transform: translateY(-50%);
        font-size: 16px;
        pointer-events: none
    }

    .txt_field input:focus~label,
    .txt_field input:valid~label {
        top: -3px;
        color: #404cb7;
    }

    .txt_field input:focus~span::before,
    .txt_field input:valid~span::before {
        width: 100%;
    }

    input[type="submit"] {
        position: relative;
        width: 30%;
        height: 25x;
        border: 2px solid #404cb7;
        background: #404cb7;
        border-radius: 15px;
        font-size: 15px;
        color: #1b242a;
        font-weight: 580;
        cursor: pointer;
        outline: none;
        transition: .5s;
        transform: translate(0%, 150%);
    }

    input[type="submit"]:hover {
        border-color: black;
        transition: .5s;
    }

    .signup_link {
        margin: 30px 0;
        text-align: center;
        font-size: 16px;
        color: #666666;
        transform: translate(0%, 150%);
    }

    .signup_link a {
        color: #404cb7;
        text-decoration: none;
    }

    .signup_link a:hover {
        text-decoration: underline;
    }
</style>

<body>
    <div class="center">
        <h1>Create new post</h1>
        <form action="${pageContext.request.contextPath}/addPost" method="post">
            <div class="txt_field">
                <input type="text" name="postName" required="required">
                <span></span>
                <label>Title</label>
            </div>
            <div class="txt_field2">
                <textarea class="text_area" type="text" name="postText" required="required">
                </textarea>
                <label>Text</label>
                <span></span>
            </div>
            <input type="submit" value="Add">
            <div class="signup_link">
                <a href="${pageContext.request.contextPath}/welcome">Back to Home page</a>
            </div>
        </form>
    </div>
</body>

</html>