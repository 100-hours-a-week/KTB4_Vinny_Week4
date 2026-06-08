package com.vinny.project.comment;


import com.vinny.project.comment.dto.request.CommentCreateRequest;
import com.vinny.project.comment.dto.response.CommentResponse;
import com.vinny.project.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentRepository commentRepository, CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment createComment(@PathVariable String postId, @RequestBody CommentCreateRequest request){
        return commentService.createComment(postId, request);
    }

    @GetMapping
    public ApiResponse<List<CommentResponse>> getComments(@PathVariable String postId){
        return ApiResponse.success(commentService.getComments(postId));
    }

    @PatchMapping("/{commentId}")
    public ApiResponse<CommentResponse> updateComment(@PathVariable String commentId, @RequestBody CommentCreateRequest request){
        return ApiResponse.success(commentService.patch(commentId, request));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable String commentId, @PathVariable String postId){
        commentService.delete(commentId);
        return ResponseEntity.noContent().build();
    }




}
