package com.example.RESTService;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)
public class WebMockTest {

    private String name;
    private int age;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService service;

    @Test
    public void studentShouldReturnMessageFromService() throws Exception {
        when(service.student(name,age)).thenReturn("""
                        {"name":Will,"age":22,"id":1}""");
        this.mockMvc.perform(get("/student?name=Will&age=22")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("""
                        {"name":Will,"age":22,"id":1}""")));
        when(service.student(name,age)).thenReturn("""
                        {"name":Nicole,"age":22,"id":2}""");
        this.mockMvc.perform(get("/student?name=Nicole&age=22")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("""
                        {"name":Nicole,"age":22,"id":2}""")));
        when(service.student(name,age)).thenReturn("""
                        {"name":student,"age":0,"id":3}""");
        this.mockMvc.perform(get("/student?name=&age=")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("""
                        {"name":student,"age":0,"id":3}""")));
        when(service.student(name,age)).thenReturn("""
                        {"name":Newt,"age":0,"id":4}""");
        this.mockMvc.perform(get("/student?name=Newt&age=")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("""
                        {"name":Newt,"age":0,"id":4}""")));
    }
}