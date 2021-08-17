/**
 * 设置导入按钮的disabled属性
 * @param disabledAttr
 * @returns
 */
function setImportButton(disabledAttr) {
	$('.import-buttons').each(function() {
		$(this).linkbutton({
			disabled : disabledAttr
		});
	});
}

/**
 * 点击上传
 * 
 * @returns {Boolean}
 */
function uploadExcel() {
	let formData = new FormData();
	let f = $("input[type='file']")[0].files;
	$.each(f, function(i, file) {
		formData.append('upload-file', file);
	});
	formData.append("fileToUploadId", 'fileToUpload');
	formData.append('name', 'i22222d');
	$.ajax({
		url : getHttpRequestPath("/main/uploadFile"),
		secureuri : false,
//		fileElementId : 'fileToUpload',
		method : "post",
		data : formData,
		processData : false,
		contentType : false,
//		data : {
//			fileToUploadId : 'fileToUpload',
//			name : 'i22222d',
//			upload-file : JSON.stringify(formData)
//		},
		success : function(data, status) {
			var msg = JSON.parse(data);

			if (msg.STATE == "NotFolder") {
				alert("服务器未指定路径!请联系管理员");
			}
			if (msg.STATE == "empty") {
				alert("不能上传空文件");
			}
			if (msg.STATE == "error") {
				alert("上传失败");
			}
			if (msg.STATE == "success") {
				$('#uploadMsg').html('上传成功,点击"导入"按钮 开始执行');
				$('#filePathId').val(msg.FILEPATH);
				$('#InductionButtons').linkbutton({
					disabled : false
				});
			}
		},
		error : function(data, status, e) {
			alert("is error");
		}
	}).done(function(res) {
		let ret = JSON.parse(res);
		if (ret.STATE == "success") {
//			$("#message").text(res.message + res.files);
//			$("#message").addClass("green")
//			$("#message").removeClass("red")
			console.log("success");
		} else {
//			$("#message").text("cannot upload files, reason: " + res.message)
//			$("#message").addClass("red")
//			$("#message").removeClass("green")
			console.log("error");
		}
	}).fail(function(res) {
		alert("is error");
	});
	return false;
}

/**
 * 验证文件类型是否为xls文件
 * 
 * @returns {Boolean}
 */
function checkType() {
	var file = $('#fileInput');
	var val = file.val();
	if (val) {
		var suffix = val.substring(val.lastIndexOf("."));
		if (suffix != ".xls" && suffix != ".xlsx") {
			$.messager.alert('系统提示', '格式不 正确,请选择xls或xlsx文件！');
			file.after(file.clone().val(""));
			file.remove();
			return false;
		}
		return true;
	} else if (val == "") {
		return true;
	}
}

/**
 * 打开错误消息窗口
 */
function openMsgDlg() {
	$('#msgDlg').dialog({
		modal : true
	}).dialog('open').dialog('setTitle', '错误记录');
}

/**
 * 模板下载
 */
function downloadTemplate(downloadTemplateUrl) {
	var url = getHttpRequestPath(downloadTemplateUrl);
	$("#exportForm").attr("action", url);
	$("#exportForm").submit();
}

/**
 * 一般的导入
 */
function saveBatchUpload(url) {
	checkType();
	var filePath = $('#filePathId').val();
	if (filePath == "") {
		$.messager.alert('系统提示', '请先上传数据文件');
		return;
	}
	$('#recordMsg').html('<img src="images/loading.gif"/>请不要关闭窗口，正在处理中...');
	$.post(getHttpRequestPath(url), {
		filePath : filePath
	}, function(response) {
		var msg = JSON.parse(response, function(key, value) {
			return value;
		});

		if (msg.status.toLowerCase() == "success") {
			$.messager.alert('系统提示', '保存成功！');
			$('#uploadMsg').html("上传成功！");

			var resultMsg = '总共' + msg.totalCount + '条 成功: ' + msg.successCount
					+ ' 失败:' + msg.errorCount;
			resultMsg += '<a href="#" onclick="openMsgDlg()" > 查看</a>';

			$('#resultMsg').html(resultMsg);
			$('#recordMsg').html(msg.recordMsg);
			$('#filePathId').val(null);
			$('#dg').datagrid('reload');
			$('#InductionButtons').linkbutton({
				disabled : true
			});
		} else {
			$.messager.alert('导入出错', msg.errorMsg);
		}
	});
}