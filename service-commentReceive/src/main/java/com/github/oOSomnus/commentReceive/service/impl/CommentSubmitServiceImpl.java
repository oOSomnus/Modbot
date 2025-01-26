package com.github.oOSomnus.commentReceive.service.impl;

import com.github.oOSomnus.commentReceive.model.dto.Comment;
import com.github.oOSomnus.commentReceive.service.CommentSubmitService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentSubmitServiceImpl implements CommentSubmitService {

    private KafkaTemplate<String, Comment> kafkaTemplate;

    @Override
    public void submitComments(List<Comment> comments) {
        for (Comment comment : comments) {
            kafkaTemplate.send("comment-submit", comment.getUserId(), comment);
        }
    }
}
