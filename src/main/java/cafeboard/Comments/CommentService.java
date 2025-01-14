package cafeboard.Comments;

import cafeboard.Post.Post;
import cafeboard.Post.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void createComment(CreateCommentRequest request) {
        Post post = postRepository.findById(request.postId())
                .orElseThrow(() -> new IllegalArgumentException("없는포스트아이디"));
        commentRepository.save(new Comment(request.content(), post));
    }

    @Transactional
    public void updateComment(Long commentId, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("없는댓글임"));
        comment.setContent(request.content());
    }


    @DeleteMapping("/comment/{id}")
    public void deleteByCommentId(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
