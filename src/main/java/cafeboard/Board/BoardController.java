package cafeboard.Board;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/boards")
    void createBoard(@RequestBody CreateBoardRequest request){
        boardService.create(request);
    }

    @GetMapping("/boards")
    List<BoardResponse> find(){
        return boardService.findAll();
    }

    @PostMapping("/boards/{boardId}")
    public void updateBoard(@PathVariable Long boardId, @RequestBody UpdateBoardRequest request){
        boardService.updateBoard(boardId, request);
    }

    @DeleteMapping("boards/{boardId}")
    public void deleteByBoardId(@PathVariable Long boardId){
        boardService.deleteByBoardId(boardId);
    }

}
