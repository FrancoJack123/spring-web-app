package com.services.product.product_service.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private String code;
    private HttpStatus status;
    private String message;
    private List<String> detailMessages;
    private LocalDateTime timeStamp;

}
