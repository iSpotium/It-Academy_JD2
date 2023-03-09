<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Update Name form</title>
</head>


<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        background: linear-gradient(120deg, #120113, #611332);
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
        border-bottom: 2px solid purple;
    }

    .center form {
        padding: 0px 40px;
        box-sizing: border-box;
    }

    form .txt_field {
        position: sticky;
        border-bottom: 2px solid purple;
        margin: 20px 0px;
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
        background: #611332;
        transition: .5s;
    }

    .txt_field input:focus~label,
    .txt_field input:valid~label {
        top: -3px;
        color: #611332;
    }

    .txt_field input:focus~span::before,
    .txt_field input:valid~span::before {
        width: 100%;
    }

    input[type="submit"] {
        width: 100%;
        height: 30px;
        border: 3px solid #611332;
        background: #611332;
        border-radius: 15px;
        font-size: 15px;
        color: black;
        font-weight: 580;
        cursor: pointer;
        outline: none;
        transition: .5s;
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
    }

    .signup_link a {
        color: #911f7e;
        text-decoration: none;
    }

    .signup_link a:hover {
        text-decoration: underline;
    }
</style>

<body>
    <div class="center">
        <h1>Change username</h1>
        <form action="${pageContext.request.contextPath}/updateName" method="post">
            <div class="txt_field">
                <input type=" text" name="newName" required="required">
                <span></span>
                <label>New username</label>
            </div>
            <div class="txt_field">
                <input type="password" name="acceptPassword" required="required">
                <span></span>
                <label>Accept password</label>
            </div>
            <input type="submit" value="Change">
            <span></span>
            <div class="signup_link">
                <a href="${pageContext.request.contextPath}/welcome">Back to Home page</a>
            </div>
        </form>
    </div>
</body>

</html>>