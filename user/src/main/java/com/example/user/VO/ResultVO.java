package com.example.user.VO;

import lombok.Data;

@Data
public class ResultVO<T> {
    private Integer code;
    private String meg;
    private T data;
}
