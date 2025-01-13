package cafeboard.Comments;

import cafeboard.Post.Post;
import cafeboard.Post.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void createComment(CreateCommentReqeust reqeust) {
                commentRepository.save(new Comment(reqeust.contnet(), postRepository.findById(reqeust.PostId())
                        .orElseThrow(()->new IllegalArgumentException("없는포스트아이디"))
                ));

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
