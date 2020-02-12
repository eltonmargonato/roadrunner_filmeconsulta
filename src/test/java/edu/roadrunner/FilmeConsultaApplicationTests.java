package edu.roadrunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        public void getFilmePorGenero() throws Exception {
             mvc.perform( MockMvcRequestBuilders
                .get("/filme/busca/genero/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idFilme").exists());
        }
}
