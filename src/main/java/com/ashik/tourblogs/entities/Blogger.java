package com.ashik.tourblogs.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.ashik.tourblogs.dao.BloggerDao;


@Entity
@Component
public class Blogger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private String mail;
	private String password;
	@OneToMany(mappedBy = "blogger")
	private List<Blog> blogs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Blogger [id=" + id + ", name=" + name + ", mail=" + mail + ", password=" + password + ", blogs=" + blogs
				+ "]";
	}
	public static Blogger getBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.ashik.tourblogs.entities.Blogger.class);
		return context.getBean(Blogger.class);
	}

}
