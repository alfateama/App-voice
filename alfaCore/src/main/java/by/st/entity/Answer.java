package by.st.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="answer")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ansId;

    @NotNull
    private String ans;

    @ManyToOne
    @JoinColumn(name = "voiceId")
    private Voice voice;

    private int count;

}
