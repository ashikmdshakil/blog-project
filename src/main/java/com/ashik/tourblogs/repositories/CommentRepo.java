package com.ashik.tourblogs.repositories;

public interface CommentRepo {
	void postComment(int blogger_id, int blog_id, String ucomment);
	void deleteComment(int id);

}
