package cafeboard.Post;


import cafeboard.Comments.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public void createPost(@RequestBody CreatePostRequest request){
        postService.createPost(request);
    }

    @PostMapping("/posts/{postId}")
    public void updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest request){
        postService.updatePost(postId, request);
    }

    @GetMapping("/posts")
    public List<PostResponse> findPost(){

        return postService.findPosts();
    }

    @GetMapping("/posts/{postId}")
    public PostDetailResponse findPostDetail(@PathVariable Long postId){
        return postService.findPostDetail(postId);
    }

    @DeleteMapping("/posts/{postId}")
    public void deleteByPostId(@PathVariable Long postId){
        postService.deleteByPostId(postId);
    }

    //특정 게시판의 게시글 목록 조회
    @GetMapping("/boards/{boardId}/posts")
    public List<PostResponse> findPostsByBoardId(@PathVariable Long boardId){
        return postService.findPostsByBoardId(boardId);
    }


    //특정 게시글의 댓글 목록 조회
    @GetMapping("/posts/{postId}/comments")
    public List<Comment> findCommentsByPostId(@PathVariable Long postId){
        return postService.findCommentsByPostId(postId);
    }


}
