package cafeboard.Post;

import cafeboard.Board.Board;
import cafeboard.Board.BoardRepository;
import cafeboard.Comments.Comment;
import cafeboard.Comments.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    private final BoardRepository boardRepository;


    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, BoardRepository boardRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }

    public void createPost(CreatePostRequest request) {
        postRepository.save(new Post(request.boardId(), request.title(),request.content()));

    }



    public List<PostResponse> findPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream()
                .map(post -> new PostResponse(
                        post.getId(),
                        post.getTitle(),
                        post.getComments().size()
                ))
                .collect(Collectors.toList());

    }

    public PostDetailResponse findPostDetail(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("없는포스트id"));

        List<PostDetailResponse.Comment> commentList = commentRepository.findByPostId(postId)
                .stream()
                .map(comment -> new PostDetailResponse.Comment(
                        comment.getId(),
                        comment.getContent()
                        )
                ).collect(Collectors.toList());

        return new PostDetailResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                commentList
        );


    }

    public void deleteByPostId(Long postId) {
        postRepository.deleteById(postId);
    }

    @Transactional
    public void updatePost(Long postId, UpdatePostRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("없는포스트당"));
        post.setTitle(request.title());
        post.setContent(request.content());



    }

    public List<PostResponse> findPostsByBoardId(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(()->new IllegalArgumentException("없음"));

        return postRepository.findByBoard(board).stream().map(
                post -> new PostResponse(
                        post.getId(),
                        post.getTitle(),
                        post.getComments().size()
                )
        ).toList();


    }

    @Transactional
    public List<Comment> findCommentsByPostId(Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("없는 게시글"));
        return commentRepository.findByPost(post);
    }
}
