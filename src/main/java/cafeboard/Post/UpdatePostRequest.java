package cafeboard.Post;

public record UpdatePostRequest(
        String content,
        String title,
        Long PostId
) {

}
