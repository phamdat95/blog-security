package com.codegym.cms.model;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;

@Entity
@Table(name="user_011")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String title;
    private String email;
    private String type;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User() {
    }

    public User(String title, String email, String type) {
        this.title = title;
        this.email = email;
        this.type = type;
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
        try {
            this.title = new String(title.getBytes("UTF-16"), "UTF-16");
        }
        catch (UnsupportedEncodingException ex) {
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
