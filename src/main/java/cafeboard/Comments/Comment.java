package cafeboard.Comments;


import cafeboard.Post.Post;
import jakarta.persistence.*;

@Entity
public class Comment {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn
    private Post post;


    private String content;

    public Comment() {
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }
}
