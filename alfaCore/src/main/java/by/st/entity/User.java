package by.st.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

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
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "voice_id"))
    private Set<Voice> voices;
}
