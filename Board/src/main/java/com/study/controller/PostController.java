package com.study.controller;


import com.study.domain.post.PostRequest;
import com.study.domain.post.PostResponse;
import com.study.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    //게시글 작성 페이지
    @GetMapping("/write")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "post/write";
    }

    // 게시글 작성
    @PostMapping("/write")
    public String postWrite(final PostRequest params) {
        postService.savePost(params);
        return "redirect:/post/posts";
    }

    // 게시판 리스트
    @GetMapping("/posts")
    public String postList(Model model) {
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post/posts";
    }

    // 게시판 상세
    @GetMapping("/post")
    public String post(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post/post";
    }

    // 게시글 수정
    @PostMapping("/update")
    public String updatePost(final PostRequest params) {
        postService.updatePost(params);
        return "redirect:/post/posts";
    }

    // 게시글 삭제
    @PostMapping("/delete")
    public String deletePost(@RequestParam final Long id) {
        postService.deletePost(id);
        return "redirect:/post/posts";
    }

}