package com.study.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@AllArgsConstructor
@Getter
public class MessageDto {

    private String message;
    private String redirectUri;
    private RequestMethod method;
    private Map<String, Object> data; //view로 전달한 데이터

}
