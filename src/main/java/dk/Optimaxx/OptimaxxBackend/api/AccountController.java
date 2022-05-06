package dk.Optimaxx.OptimaxxBackend.api;

import dk.Optimaxx.OptimaxxBackend.DTO.AccountResponse;
import dk.Optimaxx.OptimaxxBackend.service.AccountService;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountResponse> getAccounts(Pageable pageable){
        return accountService.getAllAccounts(pageable);
    }

    @GetMapping("/{id}")
    public AccountResponse getAccounts(@PathVariable Long id){
        return accountService.getAccountById(id);
    }
}
