package com.study.domain.post;

import com.study.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
//@Transactional
class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    @DisplayName("게시글 저장 서비스")
    public void save() throws Exception {
        //given
        PostRequest params = new PostRequest();
        params.setTitle("제목1");
        params.setContent("내용1");
        params.setWriter("글쓴이1");
        params.setNoticeYn(false);
        //when
        Long idA = postService.savePost(params);
        //then
//        assertThat(idA).isEqualTo(25L);
        log.info("saveId = {}", idA);
    }

//    @Test
//    @DisplayName("게시글 상세보기 서비스")
//    public void findById() throws Exception {
//        //given
//        //when
//        PostResponse findId = postService.findPostById(9L);
//        //then
//        assertThat(findId.getId()).isEqualTo(9L);
//    }

//    @Test
//    @DisplayName("게시글 삭제 서비스")
//    public void delete() throws Exception {
//        //given
//        Long deleteId = postService.deletePost(9L);
//        //when
//
//        //then
//        assertThat(deleteId).isEqualTo(9L);
//    }

//    @Test
//    @DisplayName("게시글 전체 조회 서비스")
//    public void findAllPost() throws Exception {
//        //given
//
//        //when
//        List<PostResponse> allPost = postService.findAllPost();
//
//        //then
//        assertThat(allPost.size()).isEqualTo(4);
//    }

    @Test
    public void saveByForeach() {
        for (int i = 1; i <= 1000; i++) {
            PostRequest params = new PostRequest();
            params.setTitle(i + "번 게시글");
            params.setContent(i + "번 내용");
            params.setWriter("테스터" + i);
            params.setNoticeYn(false);
            postService.savePost(params);
        }
    }
}