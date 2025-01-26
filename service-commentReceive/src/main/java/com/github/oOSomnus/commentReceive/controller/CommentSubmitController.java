package com.github.oOSomnus.commentReceive.controller;

import com.github.oOSomnus.commentReceive.model.dto.Comment;
import com.github.oOSomnus.commentReceive.model.dto.CommentSubmitResponse;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/submit")
@ComponentScan(basePackages = {"com.github.oOSomnus.common", "com.github.oOSomnus.commentFilter"})
public class CommentSubmitController {
    @PostMapping
    public CommentSubmitResponse submitComments(@RequestBody List<Comment> comments) {
        return null;
    }
}
