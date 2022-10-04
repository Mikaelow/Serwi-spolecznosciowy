package demo.Domain;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor //ten kutas wszystko zmienił w tym path [] entity
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    Long id;
    @NonNull
    String username;
    @NonNull
    String password;

    public User(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }
}
