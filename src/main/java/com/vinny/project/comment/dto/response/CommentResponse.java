package com.vinny.project.comment.dto.response;

import com.vinny.project.user.dto.response.UserResponse;
import com.vinny.project.user.dto.response.UserSummary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private String commentId;
    private String content;
    private LocalDateTime createdAt;
    private UserSummary writer;
}
