package com.newgen.course.socialMedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newgen.course.socialMedia.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
