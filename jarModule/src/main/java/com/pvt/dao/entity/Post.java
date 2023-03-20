package com.pvt.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Post.getPostByName", query = "SELECT p FROM Post p where p.postName = :postName"),
        @NamedQuery(name = "Post.getAllPosts", query = "SELECT p FROM Post p"),
        @NamedQuery(name = "Post.getPostsByUserId", query = "SELECT p FROM Post as p where p.user.userId = :userId")
})
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @Column(name = "postName", nullable = false, unique = false)
    private String postName;

    @Column(name = "postText", nullable = false)
    private String postText;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getPostId() == post.getPostId() && getPostName() == post.getPostName() && getPostText() == post.getPostText() && getUser() == post.getUser();

    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPostName(), getPostText(), getPostId());
    }

    @Override
    public String toString() {
        return "Post id: [" + postId + "], " + "Post name: [" + postName + "], " + "Post text: [" + postText + "], " + "UserId: [" + user.getUserId() + "]";
    }
}
