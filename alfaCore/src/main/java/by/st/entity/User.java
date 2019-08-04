package by.st.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @ManyToMany
    @JoinTable(
            name = "user_voice",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "voiceId"))
    private Set<Voice> voices;
}
