package alkemy.challenge.Challenge.Alkemy.model;

import alkemy.challenge.Challenge.Alkemy.model.Roles;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String firstName;

    @NonNull
    @Column(nullable = false)
    private String lastName;

    @NonNull
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String photo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles;

    private Boolean deleted;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date create_at_register;

    public User(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, Set<Roles> roles, Date create_at_register) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.create_at_register = create_at_register;
    }

    @Override
    public String toString() {
        return "User{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", email='" + email + '\''
                + ", password='" + password + '\''
                + ", photo='" + photo + '\''
                + ", roles=" + roles
                + '}';
    }
}
