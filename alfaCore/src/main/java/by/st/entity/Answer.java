package by.st.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="answer")
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ansId;

    @NotNull
    private String ans;

    @ManyToOne
    @JoinColumn(name = "voiceId", insertable = false, updatable = false)
    private Voice voice;

    private int count;

}
