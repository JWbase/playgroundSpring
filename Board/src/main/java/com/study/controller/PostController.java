package com.study.controller;


import com.study.common.dto.MessageDto;
import com.study.common.dto.SearchDto;
import com.study.common.paging.PagingResponse;
import com.study.domain.post.PostRequest;
import com.study.domain.post.PostResponse;
import com.study.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String postWrite(final PostRequest params, Model model) {
        postService.savePost(params);
        MessageDto message = new MessageDto("야 글 작성 잘됐어", "/post/posts", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시판 리스트
    @GetMapping("/posts")
    public String postList(@ModelAttribute("params") final SearchDto params, Model model) {
        PagingResponse<PostResponse> response = postService.findAllPost(params);
        model.addAttribute("response", response);
        return "post/postList";
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
    public String updatePost(final PostRequest params, Model model) {
        postService.updatePost(params);
        MessageDto message = new MessageDto("수정 됐을까?", "/post/posts", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 삭제
    @PostMapping("/delete")
    public String deletePost(@RequestParam final Long id, Model model) {
        postService.deletePost(id);
        MessageDto message = new MessageDto("너글지워짐", "/post/posts", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 메시지 전달 후 redirect
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}