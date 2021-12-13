package com.vocera.rock_paper_scissor.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tokens")
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String token;

    @Column(name = "created_date")
    private Date createdDate;

    public AuthenticationToken() {
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
    }

    public AuthenticationToken(Integer id, String token, Date createdDate) {
        this.id = id;
        this.token=token;
        this.createdDate=createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
