/**
 * 重定向
 * @param module
 * @returns
 */
function rpp(module) {
	let host_url = ''
	if (module == 'product') {
		window.location.href = 'http://192.168.1.208:8083/index'; // = 'http://127.0.0.1:8083';
	} else if (module == 'order') {
		window.location.href = 'http://192.168.1.208:8082/index';//  = 'http://127.0.0.1:8082';
	} else if (module == 'user') {
		window.location.href = 'http://192.168.1.208:8080/index';  //= 'http://127.0.0.1:8080';
	}
//	$.ajax({
//		url : host_url + '/index',
//		// data:{"username":username,"password":password,"vcode":vcode,"rememberMe":rememberMe},
//		data : {},
//		type : "get",
//		headers : {'Content-Type' : 'application/json;charset=utf-8'},
//		dataType : "jsonp",
//		crossDomain: true,
//		xhrFields: {
//		    withCredentials: true
//		},
//		success : function(data) {
//			if (data.status == 200) {
//
//				location.href = "/index";
//			} else {
//				$("#erro").html(data.message);
//			}
//
//		},
//		error : function() {
//			$("#erro").html("登录失败");
//		}
//	});
}