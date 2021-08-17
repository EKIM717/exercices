package com.windframework.shiro.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.stereotype.Service;

import com.windframework.shiro.demo.filter.StatelessAuthcFilter;
import com.windframework.shiro.demo.service.ShiroService;

@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {

//    @Autowired
//    private AuthorityMapper authorityMapper;
//    @Autowired
//    private UserMapper userMapper;

    /**
     * 初始化权限
     */
    @Override
    public Map<String, String> loadFilterChainDefinitions() {
    	 Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
         // 登出
         filterChainDefinitionMap.put("/logout", "logout");
         // swagger
         filterChainDefinitionMap.put("/swagger**/**", "anon");
         filterChainDefinitionMap.put("/webjars/**", "anon");
         filterChainDefinitionMap.put("/v2/**", "anon");
         // 静态资源
         filterChainDefinitionMap.put("/static/**", "anon");
         // 对所有用户认证
         filterChainDefinitionMap.put("/**", "authc");
         return filterChainDefinitionMap;
    	
//        List<Authority> authorities = authorityMapper.findAuthorities();
//        // 权限控制map.从数据库获取
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        if (authorities.size() > 0) {
//            String uris;
//            String[] uriArr;
//            for (Authority authority : authorities) {
//                if (StringUtils.isEmpty(authority.getPermission())) {
//                    continue;
//                }
//                uris = authority.getUri();
//                uriArr = uris.split(",");
//                for (String uri : uriArr) {
//                    filterChainDefinitionMap.put(uri, authority.getPermission());
//                }
//            }
//        }
//        filterChainDefinitionMap.put("/user/login", "anon");
//        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/user/logout", "anon");
//        //拦截所有请求
//        filterChainDefinitionMap.put("/**", "authc");
//        return filterChainDefinitionMap;
    }

    /**
     * 在对角色进行增删改操作时，需要调用此方法进行动态刷新
     * @param shiroFilterFactoryBean
     */
    @Override
    public void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean, Long roleId, Boolean isRemoveSession) {
//        synchronized (this) {
//            AbstractShiroFilter shiroFilter;
//            try {
//                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
//            } catch (Exception e) {
//                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
//            }
//            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
//            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
//            // 清空老的权限控制
//            manager.getFilterChains().clear();
//            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
//            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());
//            // 重新构建生成
//            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
//            for (Map.Entry<String, String> entry : chains.entrySet()) {
//                String url = entry.getKey();
//                String chainDefinition = entry.getValue().trim().replace(" ", "");
//                manager.createChain(url, chainDefinition);
//            }
//
//            List<User> users = userMapper.findUsersByRoleId(roleId);
//
//            if (users.size() > 0) {
//                for (User user : users) {
//                    ShiroUtil.kickOutUser(user.getUsername(), isRemoveSession);
//                }
//            }
//        }
    }

	@Override
	public ShiroFilterFactoryBean getFilterBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setFilterChainDefinitionMap(this.loadFilterChainDefinitions());
		// 自定义角色过滤器，key需要跟数据库中的permission字段相对应，类似于：roles[admin]
		Map<String, Filter> roleFilterMap = new HashMap<>();
		roleFilterMap.put("authc", new StatelessAuthcFilter());
//	        shiroFilterFactoryBean.setFilters(roleFilterMap);

		// 登录
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 首页
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 错误页面，认证不通过跳转
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		return shiroFilterFactoryBean;
	}
}
