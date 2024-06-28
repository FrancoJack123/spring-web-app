package com.services.product.product_service.service;

import com.services.product.product_service.exceptions.ClientNotFoundException;
import com.services.product.product_service.mapper.ClientMapper;
import com.services.product.product_service.model.dto.ClientResponse;
import com.services.product.product_service.model.dto.CreateClientRequest;
import com.services.product.product_service.model.entity.Client;
import com.services.product.product_service.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponse findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toClientResponse)
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public List<ClientResponse> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toClientResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse save(CreateClientRequest request) {
        Client client = new Client();
        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        client.setStatus(Boolean.TRUE);
        return clientMapper.toClientResponse(clientRepository.save(client));
    }

    @Override
    public ClientResponse update(Long id, CreateClientRequest request) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(request.getName());
                    client.setEmail(request.getEmail());
                    client.setPhone(request.getPhone());
                    return clientMapper.toClientResponse(clientRepository.save(client));
                })
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(clientRepository.findById(id).isEmpty()) {
            throw new ClientNotFoundException();
        }

        clientRepository.deleteById(id);
    }
}
