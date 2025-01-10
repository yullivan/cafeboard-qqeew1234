package cafeboard.Post;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(CreatePostRequest request) {
        postRepository.save(new Post(request.brandId(), request.title(),request.content()));

    }

//    public List<PostResponse> findAll() {
//        return postRepository.findAll()
//                .stream()
//                .map(
//                        post -> new PostResponse(
//                                post.getId(),
//                                post.getTitle(),
//                                postRepository.commentCount,
//
//                        )
//                )
//    }
}
