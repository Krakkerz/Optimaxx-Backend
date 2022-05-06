package dk.Optimaxx.OptimaxxBackend.DTO;

import dk.Optimaxx.OptimaxxBackend.entity.Account;
import dk.Optimaxx.OptimaxxBackend.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponse {
    private String mail;
    private String name;
    private String phonenumber;

    private AccountResponse(Account account) {
        this.mail = account.getEmail();
        this.name = account.getName();
        this.phonenumber = account.getPhoneNumber();
    }

    public static List<AccountResponse> of(List<Account> entities) {
        return entities.stream().map(AccountResponse::new).toList();
    }

    public static AccountResponse of(Account entity) {
        return new AccountResponse(entity);
    }
}
