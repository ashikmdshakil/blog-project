package com.ashik.tourblogs.repositories;

import com.ashik.tourblogs.entities.Blog;
import com.ashik.tourblogs.entities.Blogger;

public interface BloggerRepo {
	void signup(String name, String mail, String password);

	boolean login(String mail, String password);

	void post(Blog blog);

	void comment();

	void showOwnPost();

	void logout();
	
	Blogger bloggerInfo(String mail);
}
