//$(function() {
//	$('#login_123').click(sendAjax);
//});

function sendAjax () {
	var username = $("#username").val();
	var password = $("#password").val();
	let user = {};
	user.name = username;
	user.password = password;
	var vcode = $("#vcode").val();
	var rememberMe = $('#rememberMe').is(':checked')

	let json = JSON.stringify(user);
	$.ajax({
		url : "/login",
		// data:{"username":username,"password":password,"vcode":vcode,"rememberMe":rememberMe},
		data : json,
		type : "post",
		headers : {'Content-Type' : 'application/json;charset=utf-8'},
		dataType : "json",
		success : function(data) {
			if (data.status == 200) {

				location.href = "/index";
			} else {
				$("#erro").html(data.message);
			}

		},
		error : function() {
			$("#erro").html("登录失败");
		}
	});
}
	 
function change() {
	$("#codePic").attr("src", "/getGifCode?flag=" + Math.random());
}