package cafeboard.Board;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void create(CreateBoardRequest request) {
        boardRepository.save(new Board(request.title()));
    }


    @Transactional
    public void updateBoard(Long boardId, UpdateBoardRequest request) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("있는것이냐?"));
        board.setTitle(request.title());
//        boardRepository.save(board); // 생략 가능
    }

    public List<BoardResponse> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(
                        board -> new BoardResponse(
                                board.getId(),
                                board.getTitle()
                        )
                ).toList();
    }

    public void deleteByBoardId(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
