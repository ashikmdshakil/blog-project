package com.ashik.tourblogs.repositories;

import java.util.List;

import com.ashik.tourblogs.entities.Blog;

public interface BlogRepo {
	 List<Blog> getBlogs();

	 List<Blog> getMyBlogs(int id);
	 
	 void deleteBlog(int id) ;

}
