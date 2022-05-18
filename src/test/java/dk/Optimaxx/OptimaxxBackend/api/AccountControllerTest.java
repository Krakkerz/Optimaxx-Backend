package dk.Optimaxx.OptimaxxBackend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.Optimaxx.OptimaxxBackend.entity.Account;
import dk.Optimaxx.OptimaxxBackend.entity.Reservation;
import dk.Optimaxx.OptimaxxBackend.entity.Seat;
import dk.Optimaxx.OptimaxxBackend.repository.AccountRepository;
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

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Transactional

class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @BeforeAll
    public static void setUp(@Autowired AccountRepository accountRepository){
        Account account = Account.builder()
                .name("bo")
                .email("bo@bo.dk")
                .phoneNumber("12345678")
                .build();

        accountRepository.save(account);
    }

    @AfterAll
    public static void teardown(@Autowired AccountRepository accountRepository){
        accountRepository.deleteAll();
    }


    @Test
    void GetAccounts() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/accounts")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
    }
    @Test
    void testGetAccounts() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/accounts/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("bo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mail").value("bo@bo.dk"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phonenumber").value("12345678"));
    }

    @Test
    void testDeleteAccount() {

        accountRepository.deleteAll();
        assertEquals(0, accountRepository.count());

    }
}