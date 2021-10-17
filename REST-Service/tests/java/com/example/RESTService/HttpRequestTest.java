package com.example.RESTService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void studentShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student?name=Will&age=22",
                String.class)).contains("""
                                       {"name":"Will","age":22,"id":1}""");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student?name=Nicole&age=22",
                String.class)).contains("""
                                       {"name":"Nicole","age":22,"id":2}""");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student?name=&age=",
                String.class)).contains("""
                                       {"name":"student","age":0,"id":3}""");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student?name=Newt&age=",
                String.class)).contains("""
                                       {"name":"Newt","age":0,"id":4}""");
    }
}
