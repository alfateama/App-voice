package by.st.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "voice")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Voice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voiceId;

    @NotNull
    private String topic;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @OneToMany(mappedBy = "voice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Answer> answerList;

    @ManyToMany
    @JoinTable(
            name = "user_voice",
            joinColumns = @JoinColumn(name = "voiceId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users;

    public void setAnswerList(Set<Answer> answerList) {
        this.answerList = answerList;
        this.answerList.forEach(x -> x.setVoice(this));
    }

    public void setStatus(int status){
        this.status = Status.inEnum(status);
    }

    public int getStatus(){
        return status.getCode();
    }

    public void updateVoice(Voice voice){
        this.setStatus(voice.getStatus());
        this.setTopic(voice.getTopic());
        this.setAnswerList(voice.getAnswerList());
    }
}
