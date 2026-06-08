package com.vinny.project.comment;

import com.vinny.project.comment.dto.request.CommentCreateRequest;
import com.vinny.project.comment.dto.response.CommentResponse;
import com.vinny.project.comment.exception.CommentNotFoundException;
import com.vinny.project.post.Post;
import com.vinny.project.post.dto.response.PostDetailResponse;
import com.vinny.project.post.exception.PostNotFoundException;
import com.vinny.project.user.User;
import com.vinny.project.user.UserService;
import com.vinny.project.user.dto.response.UserSummary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    public Comment createComment(String postId, CommentCreateRequest request) {
        String id = UUID.randomUUID().toString();
        Comment comment = new Comment("1", postId, id, request.getContent(), LocalDateTime.now());
        commentRepository.save(id, comment);
        return comment;
    }

    public List<CommentResponse> getComments(String postId) {
        return commentRepository.findAll().stream()
                .map(this::convertToCommentResponse)
                .toList();
    }

    private CommentResponse convertToCommentResponse(Comment comment) {
        User writer = userService.findById(comment.getWriterId());
        UserSummary writerSummary = new UserSummary(writer.getNickname(), writer.getProfileImageUrl());
        return new CommentResponse(
                comment.getCommentId(),
                comment.getContent(),
                comment.getCreatedAt(),
                writerSummary
        );
    }


    public Comment findById(String commentId) {
        return commentRepository.findById(commentId);
    }

    public CommentResponse patch(String commentId, @RequestBody CommentCreateRequest request) {
        Comment comment = findById(commentId);
        User writer = userService.findById(comment.getWriterId());
        UserSummary writerSummary = new UserSummary(writer.getNickname(), writer.getProfileImageUrl());

        if(comment == null) {
            throw new CommentNotFoundException();
        }
        comment.setContent(request.getContent());
        return new CommentResponse(
                comment.getCommentId(),
                comment.getContent(),
                comment.getCreatedAt(),
                writerSummary
        );
    }

    public void delete(String commentId) {
        commentRepository.delete(commentId);
    }
}
