package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Feedback {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	private String comments;
	private int rating;
	private String user;

	public Integer getID() {
        return id;
    }
	public void setID(Integer id) {
        this.id = id;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public String getComments() {
        return comments;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    @Override
    public String toString() {
    	return (user + " " + rating + " " + comments);
    }
}