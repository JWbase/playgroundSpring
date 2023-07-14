package com.study.domain.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    @Transactional
    @DisplayName("게시글 작성")
    public void save() throws Exception {

        //given
        PostRequest params = new PostRequest();
        params.setWriter("test");
        params.setContent("테스트");
        params.setTitle("게시글1");
        params.setNoticeYn(false);

        //when
        postMapper.save(params);

        //then
        assertThat(postMapper.findAll().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("게시글 조회")
    public void findById() throws Exception {
        //given
        //when
        PostResponse post = postMapper.findById(9L);
        //then
        assertThat(post.getWriter()).isEqualTo("test");
    }
    
    @Test
    @Transactional
    @DisplayName("게시글 수정")
    public void update() throws Exception {
        //given
        PostRequest updateParams = new PostRequest();
        updateParams.setId(9L);
        updateParams.setTitle("제목 수정");
        updateParams.setContent("내용 수정");
        updateParams.setWriter("test");
        updateParams.setNoticeYn(false);

        //when
        postMapper.update(updateParams);
        PostResponse updatePost = postMapper.findById(9L);

        //then
        assertThat(updatePost.getTitle()).isEqualTo("제목 수정");
        assertThat(updatePost.getContent()).isEqualTo("내용 수정");
    }
    
    @Test
    @Transactional
    @DisplayName("게시글 삭제")
    public void delete() throws Exception {
        //given
        //when
        postMapper.deleteById(9L);
        List<PostResponse> allPost = postMapper.findAll();

        //then
        assertThat(allPost.size()).isEqualTo(0);
    }

}