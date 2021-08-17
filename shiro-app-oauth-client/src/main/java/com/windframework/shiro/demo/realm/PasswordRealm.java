package com.windframework.shiro.demo.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.windframework.shiro.demo.dao.RoleDao;
import com.windframework.shiro.demo.dao.UserDao;
import com.windframework.shiro.demo.entity.Role;
import com.windframework.shiro.demo.entity.User;
import com.windframework.shiro.demo.util.ShiroUtil;

public class PasswordRealm extends AuthorizingRealm {

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserDao userDao;
//	@Autowired
//	private AuthorityDao authorityMapper;

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		User user = (User) principalCollection.getPrimaryPrincipal();
		System.out.println(user.getName() + "进行授权操作");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		Long roleId = user.getRoleId();
//		Role role = roleDao.findRoleByIdWithStatus(roleId, (short) 1);
//		if (role == null) {
//			return null;
//		}
//		info.addRole(role.getRoleName());
//		List<Authority> authorities = authorityMapper.findAuthoritiesByRoleId(roleId);
//		if (authorities.size() == 0) {
//			return null;
//		}
		return info;
	}

	/**
	 * 认证回调函数，登录信息和用户验证信息验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// toke强转
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
		String username = usernamePasswordToken.getUsername();
		// 根据用户名查询密码，由安全管理器负责对比查询出的数据库中的密码和页面输入的密码是否一致
		User user = userDao.findByName(username);
		if (user == null) {
			throw new AuthenticationException("用户不存在");
		}

		// 查询角色
//		Role role = roleDao.findRoleByIdWithStatus(user.getRoleId(), (short) 1);
//		if (role == null) {
//			throw new AuthenticationException("该用户暂无角色或角色不可用");
//		}

		String password = user.getPassword();
		// 单用户登录
		ShiroUtil.kickOutUser(username, true);

		// 最后的比对需要交给安全管理器,三个参数进行初步的简单认证信息对象的包装,由安全管理器进行包装运行
		return new SimpleAuthenticationInfo(user, password, getName());
	}

}
