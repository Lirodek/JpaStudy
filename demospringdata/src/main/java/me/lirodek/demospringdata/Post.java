package me.lirodek.demospringdata;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@NamedQueries({
        @NamedQuery(name = "all_post", query = "SELECT p FROM Post AS p")
})
@Entity
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    public void addComment(Comment comment){
        this.getComments().add(comment);
        comment.setPost(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setCommnts(Set<Comment> commnts) {
        this.comments = commnts;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

