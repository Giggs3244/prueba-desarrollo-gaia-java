package com.prueba.desarrollo.gaia;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.desarrollo.gaia.model.TipoHeladoRegisterDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaDesarrolloJavaApplicationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void getTiposHeladoList() throws Exception {
        ResultActions resultActions = this.mvc.perform(get("/api/v1/tiposhelados").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        resultActions.andDo(print());
    }

    @Test
    public void createTipoHelado() throws Exception {
        TipoHeladoRegisterDto tipoHeladoDto = new TipoHeladoRegisterDto();
        tipoHeladoDto.setNombre("Nuevo Tipo Helado delicioso");
        tipoHeladoDto.setIdSabor(1L);

        String request = objectMapper.writeValueAsString(tipoHeladoDto);

        ResultActions resultActions = this.mvc
                .perform(post("/api/v1/tiposhelados").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status().isOk());
        resultActions.andDo(print());
    }

}
