package com.test.oembed.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OembedControllerTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    void oembedControllerTestYoutube() throws Exception {
        mockMvc.perform(get("/search")
                .param("url","https://www.youtube.com/watch?v=dBD54EZIrZo"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("oembedData"))
                .andExpect(view().name("index"));

    }
    @Test
    void oembedControllerTestTwitter() throws Exception {
        mockMvc.perform(get("/search")
                        .param("url","https://twitter.com/hellopolicy/status/867177144815804416"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("oembedData"))
                .andExpect(view().name("index"));
    }

    @Test
    void oembedControllerTestVimeo() throws Exception {
        mockMvc.perform(get("/search")
                        .param("url","https://vimeo.com/20097015"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("oembedData"))
                .andExpect(view().name("index"));
    }

}
