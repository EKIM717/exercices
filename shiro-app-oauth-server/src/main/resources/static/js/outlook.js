var hpTitle = '欢迎使用';// 首页标题
var hpUrl = null;//getHttpRequestPath('/welcome'); // 首页URL

$(function() {
	getMemuURLList();
	$('#tabs').tabs('add', {
		title : hpTitle,
		content : createFrame(hpUrl)
	});
	tabClose();
	tabCloseEven();
});

var _menus = null;

// 得到菜单列表
function getMemuURLList() {
	$.post(getHttpRequestPath('/main/getMenuURL'), {}, function(typesString) {
		_menus = JSON.parse(typesString, function(key, value) {
			return value;
		});
		InitLeftMenu();
	})
//	.error(_error);
}

// 初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({
		animate : false
	});
	for ( var i = 0; i < _menus.length; i++) {
		if (_menus[i].parentId == 0) {
			var menulist = '';
			menulist += '<ul>';
			for ( var j = 0; j < _menus.length; j++) {
				if (_menus[j].parentId == _menus[i].id) {
					menulist += '<shiro:hasPermission="' + _menus[j].menuPermission +'">';
					menulist += '<li><div><a ref="' + _menus[j].id + '" href="#" rel="' + getHttpRequestPath("/" + _menus[j].menuPath) + '">'
//					+ '<span class="icon ' + _menus[j].icon + '">&nbsp;</span>' 
					+ '<span class="nav">' + _menus[j].name + '</span></a></div></li>';
					menulist += '</shiro:hasPermission=">';
				}
			}
			menulist += '</ul>';
			$('#nav').accordion('add', {
				title : _menus[i].name,
				content : menulist
//				,
//				iconCls : 'icon ' + _menus[i].icon
			});
		}
	}
	$('.easyui-accordion li a').click(function() {
		var tabTitle = $(this).children('.nav').text();
		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = getIcon(menuid);
		addTab(tabTitle, url, icon);
		$('.easyui-accordion li div').removeClass("selected");
		$(this).parent().addClass("selected");
	}).hover(function() {
		$(this).parent().addClass("hover");
	}, function() {
		$(this).parent().removeClass("hover");
	});
	// 选中第一个
	var panels = $('#nav').accordion('panels');
	var t = panels[0].panel('options').title;
	$('#nav').accordion('select', t);
}

// 获取左侧导航的图标
function getIcon(menuid) {
	var icon = 'icon ';
	for ( var i = 0; i < _menus.length; i++) {
		if (_menus[i].id == menuid) {
			icon += _menus[i].icon;
		}
	}
	return icon;
}

function addTab(subtitle, url, icon) {
	if (!$('#tabs').tabs('exists', subtitle)) {
		$('#tabs').tabs('add', {
			title : subtitle,
			content : createFrame(url),
			closable : true,
			icon : icon
		});
	} else {
		$('#tabs').tabs('select', subtitle);
		// $('#mm-tabupdate').click();
		var currTab = $('#tabs').tabs('getSelected');
		$('#tabs').tabs('update', {
			tab : currTab,
			options : {
				content : createFrame(url)
			}
		});
	}
	tabClose();
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0" src="' + url + '" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	});
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}

// 绑定右键菜单事件
function tabCloseEven() {
	// 刷新
	$('#mm-tabupdate').click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update', {
			tab : currTab,
			options : {
				content : createFrame(url)
			}
		});
	});
	// 关闭当前
	$('#mm-tabclose').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close', currtab_title);
	});
	// 全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			if (t != hpTitle) {
				$('#tabs').tabs('close', t);
			}
		});
	});
	// 关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	// 关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			// msgShow('系统提示','后边没有啦~~','error');
			return false;
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});
	// 关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 1) {
			return false;
		}
		prevall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			if (t != hpTitle) {
				$('#tabs').tabs('close', t);
			}
		});
		return false;
	});
	// 退出
	$("#mm-exit").click(function() {
		$('#mm').menu('hide');
	});
}

// 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}

function reloadTabGrid(title) {
	if ($("#tabs").tabs('exists', title)) {
		$('#tabs').tabs('select', title);
		window.top.reload_list_dg.call();
	}
}
