package dk.Optimaxx.OptimaxxBackend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.Optimaxx.OptimaxxBackend.entity.Account;
import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.repository.AccountRepository;
import dk.Optimaxx.OptimaxxBackend.repository.MovieRepository;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@NoArgsConstructor
@Transactional
class AccountControllerTest {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static Account account1;

    @BeforeAll
    public static void setup(@Autowired AccountRepository accountRepository){
        account1 = Account.builder()
                .email("e@mail.dk")
                .name("giga chad")
                .phoneNumber("12345678")
                .id(1L)
                .build();

        accountRepository.save(account1);
    }

    /*
    @AfterAll
    public static void teardown(AccountRepository accountRepository){
        accountRepository.deleteAll();
    }
 */

    @Test
    void testGetAccounts() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/accounts")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
    }
}
