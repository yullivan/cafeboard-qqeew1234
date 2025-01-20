package cafeboard.Board;

import cafeboard.Post.Post;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "board")
    private List<Post> posts;

    public Board() {
    }

    public Board(String title) {
        this.title = title;
    }

    public Board(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
