package by.st.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "voice")
@Getter
@Setter
public class Voice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voice_id;

    @NotNull
    private String topic;

    private int status;

    private String link;

    @OneToMany
    @JoinColumn(name = "ans_id")
    Set<Answer> answerList;

    @ManyToMany
    @JoinTable(
            name = "user_voice",
            joinColumns = @JoinColumn(name = "voice_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

}
