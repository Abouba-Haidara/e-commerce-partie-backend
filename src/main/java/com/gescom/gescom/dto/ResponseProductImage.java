package com.gescom.gescom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductImage {
    private String name;
    private String url;
    private String type;
    private long size;
}
