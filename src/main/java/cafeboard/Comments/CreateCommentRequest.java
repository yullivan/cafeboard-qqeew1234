package cafeboard.Comments;

public record CreateCommentRequest(
        String content,
        Long boardId,
        Long postId
) {
}
