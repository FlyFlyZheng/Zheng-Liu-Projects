<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="resources/css/main.css" />
<style>
.hidden {
	visibility: hidden;
}
</style>
</head>


<body>
<div id="wrapper" class="divided">
    <section class="wrapper style1 align-center" id="reference">
        <div class="inner">
            <div class="index align-left">
                <section>
                    <header>
                        <h2>Login</h2>
                    </header>
                    <div class="content">

                        <form method="post" action="loginpost.htm">
                            <div class="field half first">
                                <label for="name">Name</label>
                                <input type="text" name="username" id="name" value="liuzheng" required/>
                            </div>
                            <div class="hidden">
                            <div class="field half first">
                                <label >Name</label>
                                <input type="text"  value="" />
                                <label>error message</label>
                            </div>
                            </div>
                            <div class="field half first">
                                <label for="password">Password</label>
                                <input type="password" name="password" id="password" value="123" required/>                     
                            </div>                              
                            <ul class="actions">
                                <li></li>
                                <li><input type="submit" name="submit" id="submit" value="Login" /></li>
                            </ul>
                        </form>
                        
                        <p style="color:red;">${errorMessage}</p>
              
                        <a href="forgotpassword.htm">Forget password</a>

                    </div>
                </section>
            </div>
        </div>
    </section>
</div>
</body>
</html>