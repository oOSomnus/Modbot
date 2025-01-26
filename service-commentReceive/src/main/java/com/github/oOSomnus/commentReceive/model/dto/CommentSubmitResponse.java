package com.github.oOSomnus.commentReceive.model.dto;

import lombok.Data;

@Data
public class CommentSubmitResponse {
    private String code;
    private String message;
    private String error;
}
