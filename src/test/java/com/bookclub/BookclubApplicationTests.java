package com.bookclub;


import com.bookclub.model.Book;
import com.bookclub.service.impl.RestBookDao;
import com.bookclub.web.HomeController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookclubApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HomeController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void redirectToLoginTest() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is(302)).andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void showLoginTest() throws Exception {
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Username")));
    }

    @Test
    public void listRestBookDaoTest() {
        RestBookDao restBookDao = new RestBookDao();
        String isbnString = "9780593099322,9780261102361,9780261102378,9780590302715,9780316769532";
        Assert.assertTrue(restBookDao.list(isbnString).size() == 5);
    }

    @Test
    public void findRestBookDaoTest() {
        RestBookDao restBookDao = new RestBookDao();
        String isbnString = "9780593099322";
        Assert.assertTrue(restBookDao.find(isbnString).getClass() == Book.class);
    }
}