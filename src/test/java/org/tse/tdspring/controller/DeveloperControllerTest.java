package org.tse.tdspring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DeveloperControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindAllDevelopers() throws Exception {
        mockMvc.perform(get("/developers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstname", is("Manal")))
                .andExpect(jsonPath("$[0].lastname", is("DERMICH")))
                .andExpect(jsonPath("$[0].email", is("manal.dermich@gmail.com")))
                .andExpect(jsonPath("$[0].startContract", is("2021-09-01")))
                .andExpect(jsonPath("$[0].tasks[0].title", is("Tests")));
    }
}
