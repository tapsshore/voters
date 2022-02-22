package com.shoshore.voters.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ServiceResponse<T> {
    private String message;
    private T data;
}
