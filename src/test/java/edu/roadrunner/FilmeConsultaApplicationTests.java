package edu.roadrunner;

import edu.roadrunner.controller.FilmeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;



@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(FilmeController.class)
public class FilmeConsultaApplicationTests {
	
	@Autowired
        private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}
	
	@Test
        public void getFilmesPorGenero() throws Exception {
             mockMvc.perform(get("/filme/busca/genero/1").accept(MediaType.APPLICATION_JSON))
                                      .andDo(print())
		                      .andExpect(status().isOk())
                                      .andExpect(MockMvcResultMatchers.jsonPath("$.idFilme").exists());
        }
	
}
