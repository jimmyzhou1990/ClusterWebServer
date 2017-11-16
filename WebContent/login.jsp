<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
<title>智能集群监控系统</title>

<style>
body {
	margin-top: 0px;
	margin: 0 auto;
	height: 100%;
}

.login_title{
	color: blue;
	font-size: 60px;
	font-weight: normal;
	text-align:center;
}

.form-group {
  margin-left: 200px;
}

.form-control{
	height: 40px;

}


</style>
</head>
<body>

	<div class="container" style="width: 100%; height: 100%; background: url('images/loginbg.jpg'); background-repeat:no-repeat; background-size:100% 100%;">
				<div
					style="position:absolute; top:50%; left:50%; width: 800px; height: 500px; border: 5px solid #E7E7E7; 
					       padding: 20px 0 20px 30px; border-radius: 5px; 
					       margin-left:-400px; margin-top: -250px; background: #fff;">
					
					<div class="login_title">       
						<font >管理员登录</font>
					</div>
					
					<div>&nbsp;</div>
					<form class="form-horizontal">
						<div class="form-group">	
							<div>&nbsp;</div>
							<label for="username"><font size="15" color='blue'>用户名</font></label>
							<input type="text" class="form-control" id="username"
									placeholder="请输入用户名">
						</div>
						<div class="form-group">
							<div>&nbsp;</div>
							<label for="inputPassword"><font size="15" color='blue'>密码</font></label>
							<input type="password" class="form-control" id="inputPassword3"
									placeholder="请输入密码">
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="登录" name="submit"
									style="background: url('./images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
							</div>
						</div>
					</form>
				</div>
	</div>

</body>
</html>