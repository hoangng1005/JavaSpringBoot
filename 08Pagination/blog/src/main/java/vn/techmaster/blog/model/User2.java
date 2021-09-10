package vn.techmaster.blog.model;

import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User2 implements UserDetails {
    private static final long serialVersionUID = -726614191956956687L;
    @Column(nullable = false, length = 64)
    private String username;
    @NaturalId
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    private final List<GrantedAuthority> authorities = new ArrayList<>();

    public void setAuthority(String... stringAuthorities) {
        for (String authority : stringAuthorities) {
            //this.authorities.add(new Authority(authority)); cách này cũng được
            this.authorities.add(() -> authority);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
        post.setUser(this);

    }
    public void removePost(Post post) {
        posts.remove(post);
        post.setUser(null);
    }

    //Một User viết nhiều Comment
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private List<Comment> comments = new ArrayList<>();
    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setUser(null);
    }
}
