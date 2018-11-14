<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="resources/css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script type="text/javascript">

    function OnInput (event) {
        if(event.target.value == document.getElementById("password").value){
            document.getElementById("password_error").innerText = "OK"
            document.getElementById("password_error").style.color = "green"
        }else{
            document.getElementById("password_error").innerText = "TWO PASSWORD NOT SAME"
            document.getElementById("password_error").style.color = "red"
        }
    }


    </script>
</head>

<body>

	<div id="wrapper" class="divided">
		<section class="wrapper style1 align-center" id="reference"">
		<div class="inner">
			<div class="index align-left">
				<section> <header>
				<h2>Register</h2>
				</header>
				<div class="content">

					<form method="post" action="register.htm" onsubmit="return toVaild()">
						<div class="field">
							<label for="name">Name</label>
							<input type="text" name="username" id="name"  value=""  required onkeyup="checkUserNameDuplicate()"/>
							<label><p style="color: red" id="username_error"></p></label>
						</div>

						<div class="field">
							<label for="email">Email</label>
							<input type="email" name="email"id="email" value="" required onkeyup="checkEmailDuplicate()"/>
							<label><p style="color: red" id="email_error"></p></label>
						</div>

						<div class="field">
							<label for="password">Password</label>
							<input type="password" name="password" id="password" value="" required/>
							<label><p style="color: red" id="input_password_error"></p></label>
						</div>

						<div class="field">
							<label for="confirmPassword">Confirm Password</label>
						    <input type="password" name="confirmPassword" id="confirmPassword" value=""  oninput="OnInput (event)" required/>
							<label><p style="color: red" id="password_error"></p></label>
						</div>

								<div class="field">
									<label for="captchaCode" class="prompt">Retype the
										characters from the picture:</label>
									<%
										// Adding BotDetect Captcha to the page
										Captcha captcha = Captcha.load(request, "CaptchaObject");
										captcha.setUserInputID("captchaCode");

										String captchaHtml = captcha.getHtml();
										out.write(captchaHtml);
									%>
									<input id="captchaCode" type="text" name="captchaCode" required="required" />
								</div>

						<div class="field">
							<input type="checkbox" id="human" name="human" />
							<label for="human">I am a human and not a robot</label>
							<label><p style="color: red" id="human_error"></p></label>
						</div>



						<ul class="actions">
							<li></li>
							<li><input type="submit" name="submit" id="submit" value="Register" /></li>
						</ul>
					</form>

				</div>
				</section>
			</div>
		</div>
		</section>
	</div>

	<script type="text/javascript">


		 function toVaild(){

	        var password = document.getElementById("password").value;
	        var confirmPassword = document.getElementById("confirmPassword").value;

	        if(password==confirmPassword){
	        	if(document.getElementById("human").checked){
	        		return true;
	        	}else{
	        		document.getElementById("human_error").innerHTML = "This field must be checked";
	        		return false;
	        	}
	        }else{
	        	document.getElementById("password_error").innerHTML = "two password mut be same";
	            return false;
	        }
	    }

		 checkUserNameDuplicate=function(){
			 var username = document.getElementById("name").value
	    	 var url = "checkUserName.htm?username="+username;
	         $.post(url,function(data){
				   if(data=="validate"){
					   document.getElementById("username_error").innerHTML = "username is validate"
					   document.getElementById("username_error").style.color = "green"
				   }else{
					   document.getElementById("username_error").innerHTML = "username is exist";
					   document.getElementById("username_error").style.color = "red"
				   }
				 });
		 }

		 checkEmailDuplicate=function(){
			 var email = document.getElementById("email").value
	    	 var url = "checkEmail.htm?email="+email;
	         $.post(url,function(data){
				   if(data=="validate"){
					   var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
					   if(re.test(String(email).toLowerCase())){
						   document.getElementById("email_error").innerHTML = "validate email, OK!"
						   document.getElementById("email_error").style.color = "green"
					   }else{
						   document.getElementById("email_error").innerHTML = "email is not in correct format";
						   document.getElementById("email_error").style.color = "red"
					   }
				   }else{
					   document.getElementById("email_error").innerHTML = "email is exist";
					   document.getElementById("email_error").style.color = "red"
				   }
				 });
		 }


	</script>
</body>
</html>
