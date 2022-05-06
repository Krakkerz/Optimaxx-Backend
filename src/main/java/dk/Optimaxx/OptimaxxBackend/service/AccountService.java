package dk.Optimaxx.OptimaxxBackend.service;

import dk.Optimaxx.OptimaxxBackend.DTO.AccountResponse;
import dk.Optimaxx.OptimaxxBackend.DTO.MovieResponse;
import dk.Optimaxx.OptimaxxBackend.entity.Account;
import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import dk.Optimaxx.OptimaxxBackend.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<AccountResponse> getAllAccounts(Pageable pageable){
        List<Account> accounts = accountRepository.findAll();
        return AccountResponse.of(accounts);
    }

    public AccountResponse getAccountById(Long id) {
        boolean accountDoesNotExist = accountRepository.existsById(id);
        //error stuff here

        Account account = accountRepository.getById(id);
        return AccountResponse.of(account);
    }
}
