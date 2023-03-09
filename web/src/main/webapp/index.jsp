<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login form</title>
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
    border-bottom: 2px solid #c70f0f;
}
.center form {
    padding: 0px 40px;
    box-sizing: border-box;
}

form .txt_field{
    position: sticky;
    border-bottom: 2px solid #c70f0f;
    margin: 20px 0px;
}
.txt_field input{
    width: 100%;
    padding: 0px 5px;
    height: 40px;
    font-size: 16px;
    border: none;
    background: none;
    outline: none;
}

.txt_field label{
    position: absolute;
    top: 50%;
    left: 5px;
    color:#adadad;
    transform: translateY(-50%);
    font-size: 16px;
    pointer-events: none

}
.txt_field span::before{
    content: '';
    position: absolute;
    top: 40px;
    left: 0;
    width: 0%;
    height: 2px;
    background: #c70f0f;
    transition: .5s;
}

.txt_field input:focus ~ label,
.txt_field input:valid ~ label{
    top: -3px;
    color: #c70f0f;
}
.txt_field input:focus ~ span::before,
.txt_field input:valid ~ span::before{
    width: 100%;
}

input[type="submit"]{
    width: 100%;
    height: 30px;
    border: 3px solid #c70f0f;
    background: #c70f0f;
    border-radius: 15px;
    font-size: 15px;
    color: #1b242a;
    font-weight: 580;
    cursor: pointer;
    outline: none;
    transition: .5s;
}
input[type="submit"]:hover{
    border-color: black;
    transition: .5s;
}
.signup_link{
    margin: 30px 0;
    text-align: center;
    font-size: 16px;
    color: #666666;
}
.signup_link a{
    color: #c70f0f;
    text-decoration: none;
}
.signup_link a:hover{
    text-decoration: underline;
}

</style>
<body>
    <div class="center">
        <h1>Login</h1>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="txt_field">
                <input type=" text" name="userName" required="required">
                <span></span>
                <label>Username</label>
            </div>
            <div class="txt_field">
                <input type="password" name="userPassword" required="required">
                <span></span>
                <label>Password</label>
            </div>
            <input type="submit" value="Login">
            <span></span>
            <div class="signup_link">
                Not a member? <a href="${pageContext.request.contextPath}/registration">Signup</a>
            </div>
        </form>
    </div>
</body>
</html>