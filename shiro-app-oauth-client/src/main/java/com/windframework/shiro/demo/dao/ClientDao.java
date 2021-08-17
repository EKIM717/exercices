package com.windframework.shiro.demo.dao;


import java.util.List;

import com.windframework.shiro.demo.base.dao.BaseDao;
import com.windframework.shiro.demo.entity.Client;


/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface ClientDao extends BaseDao<Client, Long> {

    public Client save(Client client);
    public void deleteById(Long id);

	Client findClientById(Long id);

    List<Client> findAll();

    Client findByClientId(String clientId);
    Client findByClientSecret(String clientSecret);

}
