package cafeboard.Post;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/boards/{boardId}/posts")
    void createPost(@PathVariable Long boardId, @RequestBody CreatePostRequest request){
        postService.createPost(request);
    }

//    @GetMapping("/board/{boardId}/post/")
//    public List<PostResponse> find(){
//        return postService.findAll();
//    }

}
