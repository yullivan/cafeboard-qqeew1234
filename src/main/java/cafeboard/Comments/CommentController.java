package cafeboard.Comments;


import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comment")
    void createComment(@PathVariable Long postId, @RequestBody CreateCommentRequest request){
        commentService.createComment(request);
    }

    @PostMapping("/comment/{commentId}")
    public void updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest request){
        commentService.updateComment(commentId, request);
    }


    @DeleteMapping("/comment/{commentId}")
    public void deleteByCommentId(@PathVariable Long commentId){
        commentService.deleteByCommentId(commentId);
    }


}

