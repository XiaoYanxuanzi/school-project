package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class TeacherPageRequest extends BaseRequest{
    private String nickname;
}
