package cafeboard.Board;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    public void setId(Long id) {
        Id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Board(String title) {
        this.title = title;
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public Board(Long id, String title) {
        Id = id;
        this.title = title;
    }
}
