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
    private Long voiceId;

    @NotNull
    private String topic;

    private int status;

    private String link;

    @OneToMany
    @JoinColumn(name = "ansId")
    Set<Answer> answerList;

    @ManyToMany
    @JoinTable(
            name = "user_voice",
            joinColumns = @JoinColumn(name = "voiceId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users;

}
