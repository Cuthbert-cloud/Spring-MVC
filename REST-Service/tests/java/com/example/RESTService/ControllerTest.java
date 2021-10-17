package com.example.RESTService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private StudentController scontroller;

    @Autowired
    private HomeController hcontroller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(scontroller).isNotNull();
        assertThat(hcontroller).isNotNull();
    }
}

