package com.windframework.shiro.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.windframework.shiro.demo.dao.ClientDao;
import com.windframework.shiro.demo.entity.Client;
import com.windframework.shiro.demo.service.ClientService;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-2-17
 * <p>
 * Version: 1.0
 */
@Transactional
@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;

	@Override
	public Client createClient(Client client) {

		client.setClientId(UUID.randomUUID().toString());
		client.setClientSecret(UUID.randomUUID().toString());
		return clientDao.save(client);
	}

	@Override
	public Client updateClient(Client client) {
		return clientDao.save(client);
	}

	@Override
	public void deleteClient(Long clientId) {
		clientDao.deleteById(clientId);
	}

	@Override
	public Client findOne(Long id) {
		return clientDao.findClientById(id);
	}

	@Override
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@Override
	public Client findByClientId(String clientId) {
		return clientDao.findByClientId(clientId);
	}

	@Override
	public Client findByClientSecret(String clientSecret) {
		return clientDao.findByClientSecret(clientSecret);
	}
}
