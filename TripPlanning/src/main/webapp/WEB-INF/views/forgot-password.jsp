<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forgot password</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="resources/css/main.css" />
</head>
<body>
<div id="wrapper" class="divided">
    <section class="wrapper style1 align-center" id="reference">
        <div class="inner">
            <div class="index align-left">
                <section>
                    <header>
                        <h2>Forgot Password</h2>
                    </header>
                    <div class="content">
                        <form method="post" action="forgotpassword.htm">
                            <div class="field half first">
                                <label for="name">Email</label>
                                <input type="email" name="email" id="email" value="" required/>
                            </div>
                            <ul class="actions">
                                <li></li>
                                <li><input type="submit" name="submit" id="submit" value="Resend email" /></li>
                            </ul>
                        </form>
                    </div>
                </section>
            </div>
        </div>
    </section>
</div>
</body>
</html>