package cafeboard.Post;

public record CreatePostRequest(String title, Long boardId, String content) {
}
