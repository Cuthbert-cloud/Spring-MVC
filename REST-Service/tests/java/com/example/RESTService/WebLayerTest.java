package com.example.RESTService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student?name=Will&age=22")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("""
                        {"name":"Will","age":22,"id":1}""")));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student?name=Nicole&age=22")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("""
                        {"name":"Nicole","age":22,"id":2}""")));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student?name=&age=")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("""
                        {"name":"student","age":0,"id":3}""")));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student?name=Newt&age=")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("""
                        {"name":"Newt","age":0,"id":4}""")));
    }
}
