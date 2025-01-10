package cafeboard.Comments;

public record UpdateCommentRequest(
        String content,
        Long boardId,
        Long postId
) {
}
