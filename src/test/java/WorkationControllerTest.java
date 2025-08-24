import com.example.demo.controller.WorkationController;
import com.example.demo.dto.WorkationDto;
import com.example.demo.service.WorkationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = WorkationController.class)
@ContextConfiguration(classes = {WorkationController.class})
class WorkationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WorkationService service;

    @Test
    void save_ShouldReturnSavedWorkation() throws Exception {
        WorkationDto dto = new WorkationDto("1", "Bali");

        when(service.save(any(WorkationDto.class))).thenReturn(dto);

        mockMvc.perform(post("/workflex/workation/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"name\":\"Bali\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.workationId").value("1"))
                .andExpect(jsonPath("$.employee").value("Bali"));
    }

    @Test
    void getAll_ShouldReturnListOfWorkations() throws Exception {
        WorkationDto dto1 = new WorkationDto("1", "Bali");
        WorkationDto dto2 = new WorkationDto("2", "Lisbon");

        when(service.getAll()).thenReturn(Arrays.asList(dto1, dto2));

        mockMvc.perform(get("/workflex/workation/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].employee").value("Bali"))
                .andExpect(jsonPath("$[1].employee").value("Lisbon"));
    }

    @Test
    void getAll_ShouldReturnEmptyList() throws Exception {
        when(service.getAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/workflex/workation/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }
}