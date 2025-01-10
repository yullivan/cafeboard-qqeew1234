package cafeboard.Comments;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comment")
    void createComment(@PathVariable Long postId, @RequestBody CreateCommentReqeust reqeust){
        commentService.createComment(reqeust);
    }

    @PostMapping("/posts/{postId}/comment/{commentId}")
    public void updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody UpdateCommentRequest request){
        commentService.updateComment(commentId, request);
    }


    @DeleteMapping("comments/{commentId}")
    public void deleteByCommentId(@PathVariable Long commentId){
        commentService.deleteByCommentId(commentId);
    }


}

