package cafeboard.Post;

import cafeboard.Board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByBoardId(Long boardId);

    List<Post> findByBoard(Board board);


}
