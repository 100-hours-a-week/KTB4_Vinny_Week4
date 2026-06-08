package com.vinny.project.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class Post {
    private String writerId;
    private String postId;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String postImageUrl;
    private LocalDateTime createdAt;
    @Setter
    private int likeCount;
    @Setter
    private int commentCount;
    @Setter
    private int viewCount;
}
