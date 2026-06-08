package com.vinny.project.post.dto.response;

import com.vinny.project.user.dto.response.UserSummary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostListResponse {
    private String postId;
    private String title;
    private LocalDateTime createdAt;
    private int likeCount;
    private int commentCount;
    private int viewCount;
    private UserSummary writer;
}
