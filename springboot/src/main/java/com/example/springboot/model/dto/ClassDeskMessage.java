package com.example.springboot.model.dto;

import lombok.Data;

@Data
public class ClassDeskMessage {
    /**
     * id
     */
    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 学号
     */
    private String number;

}
