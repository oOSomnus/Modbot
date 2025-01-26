package com.github.oOSomnus.commentReceive.service;

import com.github.oOSomnus.commentReceive.model.dto.Comment;

import java.util.List;

public interface CommentSubmitService {
    void submitComments(List<Comment> comments);
}
