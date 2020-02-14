package edu.roadrunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FilmeConsultaApplicationTests {
	
	@Autowired
        private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}
	
	@Test
        public void getFilmesPorGenero() throws Exception {
	     this.mockMvc.perform(get("/filme/busca/genero/1")).andDo(print()).andExpect(status().isOk());	
        }
	
	@Test
        public void getFilmesMaisVistos() throws Exception {
	     this.mockMvc.perform(get("/filme/busca/maisvistoscategoria")).andDo(print()).andExpect(status().isOk());	
        }	
	
}
