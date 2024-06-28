package com.services.product.product_service.controller;

import com.services.product.product_service.model.dto.ClientResponse;
import com.services.product.product_service.model.dto.CreateClientRequest;
import com.services.product.product_service.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    List<ClientResponse> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientResponse findById(@PathVariable long id) {
        return clientService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<ClientResponse> save(@Valid @RequestBody CreateClientRequest request) {
        ClientResponse response = clientService.save(request);
        return ResponseEntity
                .created(URI.create("api/clients/" + response.getId()))
                .body(response);
    }

    @PutMapping("/{id}")
    public ClientResponse update(
            @PathVariable Long id, @Valid @RequestBody CreateClientRequest request) {
        return clientService.update(id, request);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        clientService.deleteById(id);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }
}

