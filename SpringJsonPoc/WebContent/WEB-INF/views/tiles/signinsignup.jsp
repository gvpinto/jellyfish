<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div>        

			
		<div class="msg">
		  <h3>Please Sign In!</h3>
		</div>
   
		<form class="signin" action="<s:url value="/static/j_spring_security_check"/>" method="post">
		  <fieldset>
		    <div>
		      <label for="j_username">Username or Email</label>
		      <input id="email" type="text" name="j_username"/>
		    </div>
		    <div>
		      <label for="j_password">Password</label>
		      <input id="pass" type="password" name="j_password"/>
		    </div>
		    <input id="remember_me" type="checkbox" value="1" 
		           name="_spring_security_remember_me"/>
		    <label for="remember_me">Remember me</label>
		    <small>
		      <a href="/account/resend_password">Forgot?</a>
		    </small>
		    <input id="submit" type="submit" value="Sign In!" 
		           name="commit"/>
		  </fieldset>
		</form>
		<div class="notify">
		  Want an account?   
		  <br/>
		  <a class="join" href="<s:url value="/spitters?new"/>">Join for Free!</a>
		  <br/>
		  It's fast and easy!
		</div>

	

</div>