package by.st.service;

import by.st.entity.Answer;
import by.st.entity.User;
import by.st.entity.Voice;
import by.st.repository.AnswerRepository;
import by.st.repository.UserRepository;
import by.st.repository.VoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class VoicerServiceImpl implements VoicerService{

    @Autowired
    private VoiceRepository voiceRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long createVoices(Voice voice) {
        return voiceRepository.save(voice).getVoiceId();
    }

    @Override
    public Long openOrCloseVoices(Long voiceId, int status) {
        Voice voice = voiceRepository.getOne(voiceId);
        voice.setStatus(status);
        return voiceRepository.saveAndFlush(voice).getVoiceId();
    }

    @Override
    public boolean registrVoice(Long userId, Long ansId) {
        Answer answer = answerRepository.getOne(ansId);
        answer.setCount(answer.getCount()+1);
        User user = userRepository.getOne(userId);
        Voice voice = answer.getVoice();
        Set<User> users = voice.getUsers();
        if (users.add(user)){
            voice.setUsers(users);
            return true;
        }
        return false;
    }

    @Override
    public Voice getInformationVoice(Long voiceId) {
        return voiceRepository.getOne(voiceId);
    }

    @Override
    public Long addOrUpdateAnswer(Long voiceId, Answer answer) {
        Voice voice = voiceRepository.getOne(voiceId);
        answer.setVoice(voice);
        return answerRepository.save(answer).getAnsId();
    }

    @Override
    public void deleteAnswer(Long ansId) {
        Answer answer = answerRepository.getOne(ansId);
        answerRepository.delete(answer);
    }

    @Override
    public List<Voice> getVoices() {
        return voiceRepository.findAll();
    }

}
