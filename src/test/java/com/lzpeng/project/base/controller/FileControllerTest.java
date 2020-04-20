package com.lzpeng.project.base.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @date: 2019/12/7
 * @time: 17:02
 * @author: 李志鹏
 */
@Slf4j
@EnableWebMvc
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void whenFileUploadSuccess() throws Exception {
        String result = mockMvc.perform(multipart("/file")
                .file(new MockMultipartFile(
                        "file", "test.txt",
                        MediaType.MULTIPART_FORM_DATA_VALUE, "Hello File".getBytes()))
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }
}