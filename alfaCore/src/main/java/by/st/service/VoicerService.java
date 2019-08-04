package by.st.service;

import by.st.entity.Answer;
import by.st.entity.Voice;

import java.util.List;
import java.util.Optional;

public interface VoicerService {

    public Long createVoices(Voice voice);

    public Long openOrCloseVoices(Long voiceId, int status); //TODO переделать статусы на enum

    public boolean registrVoice(Long userId, Long ansId);

    public Voice getInformationVoice(Long voiceId);

    public Long addOrUpdateAnswer(Long voiceId, Answer answer);

    public void deleteAnswer(Long ansId);

    public List<Voice> getVoices();

    public Optional<Voice> getVoice(Long voiceId);

    public Voice updateVoice(Voice voice);

    public void deleteVoice(Voice voice);

}
