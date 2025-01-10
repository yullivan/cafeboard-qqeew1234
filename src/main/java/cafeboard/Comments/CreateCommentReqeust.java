package cafeboard.Comments;

public record CreateCommentReqeust(
        String contnet,
        Long boardId,
        Long PostId
) {
}
