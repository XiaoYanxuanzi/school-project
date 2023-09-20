package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class StudentPageRequest extends BaseRequest{
    private String nickname;
    private String address;
    private String email;
}
