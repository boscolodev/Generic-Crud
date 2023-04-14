package br.com.gbs.financal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String mensage;
    private String path;


}
