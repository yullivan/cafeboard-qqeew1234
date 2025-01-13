package cafeboard.Post;

import java.util.List;

public record PostDetailResponse(

         Long postId,
         String title,
         String content,
         List<Comment> comments



) {

    public record Comment(
            Long commentId,
            String content
    ){}

}
