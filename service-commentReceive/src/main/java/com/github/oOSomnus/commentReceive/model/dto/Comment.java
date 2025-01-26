package com.github.oOSomnus.commentReceive.model.dto;


import lombok.Data;

@Data
public class Comment {
    private String userId;
    private String timestamp;
    private String content;
}
