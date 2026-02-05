package cat.itacademy.userapi;

import cat.itacademy.userapi.model.Message;
import cat.itacademy.userapi.service.MessageService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HealthControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private MessageService messageService;

    @Test
    void shouldReturnMessageOk() throws Exception {
        Mockito.when(messageService.getMessage("ok"))
                .thenReturn(new Message("ok"));

        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"));
    }

}
