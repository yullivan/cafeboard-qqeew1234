package cafeboard.Comments;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void createComment(CreateCommentReqeust reqeust) {
        commentRepository.save(new Comment(reqeust.PostId(), reqeust.contnet()));

    }

    @Transactional
    public void updateComment(Long commentId, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new IllegalArgumentException("없는댓글임"));
        comment.setContent(request.content());
    }


    public void deleteByCommentId(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
