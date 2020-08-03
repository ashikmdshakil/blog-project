package com.ashik.tourblogs.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.ashik.tourblogs.dao.CommentDao;
import com.ashik.tourblogs.entities.Blog;
import com.ashik.tourblogs.entities.Blogger;
import com.ashik.tourblogs.entities.Comment;
import com.ashik.tourblogs.repositories.CommentRepo;

@Component
public class CommentService implements CommentRepo{
	private CommentDao commentdao = CommentDao.getBean();
	private Comment comment = Comment.getBean();
	private Blogger blogger = Blogger.getBean();
	private Blog blog = Blog.getBean();

	public void postComment(int blogger_id, int blog_id, String ucomment) {
		comment.setComment(ucomment);
		//comment.getBlogger().setId(blogger_id);
		blogger.setId(blogger_id);
		//comment.getBlog().setId(blog_id);
		blog.setId(blog_id);
		comment.setBlogger(blogger);
		comment.setBlog(blog);
		commentdao.saveComment(comment);
	}
	public void deleteComment(int id) {
		commentdao.deleteComment(id);
	}

	public static CommentService getBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				com.ashik.tourblogs.services.CommentService.class);
		return context.getBean(CommentService.class);
	}
}
