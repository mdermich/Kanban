package org.tse.tdspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.tse.tdspring.domain.Developer;
import org.tse.tdspring.domain.Task;
import org.tse.tdspring.service.DeveloperService;
import org.tse.tdspring.service.TaskService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DeveloperService devService;

    @Autowired
    private TaskService taskService;

    @Test
    public void testFindAllTasks() throws Exception {
        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Tests")))
                .andExpect(jsonPath("$[0].nbHoursForecast", is(5)))
                .andExpect(jsonPath("$[0].nbHoursReal", is(4)))
                .andExpect(jsonPath("$[0].status.id", is(0)))
                .andExpect(jsonPath("$[0].type.id", is(0)))
                .andExpect(jsonPath("$[0].developers[0].firstname", is("Manal")))
                .andExpect(jsonPath("$[0].developers[0].lastname", is("DERMICH")));
    }

    @Test
    public void testCreateTask() throws Exception {
        Set<Developer> devs = new HashSet<>();
        Developer dev = this.devService.findDeveloperById(1);
        devs.add(dev);
        Task task = new Task("Conception", 4, 4, LocalDate.now(), devs, this.taskService.getTaskType(0L), this.taskService.getTaskStatus(0L));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        byte[] taskBytes = objectMapper.writeValueAsBytes(task);
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(taskBytes))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        Assertions.assertEquals(4, this.taskService.findAllTasks().size());
    }

}
