package dk.Optimaxx.OptimaxxBackend.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    private long id;
    private String mail;
    private String name;
    private String phonenumber;
}
