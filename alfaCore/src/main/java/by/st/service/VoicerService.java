package by.st.service;

import by.st.entity.Answer;
import by.st.entity.Voice;

public interface VoicerService {

    public Long createVoices(Voice voice);

    public Long openOrCloseVoices(Long voiceId, int status); //TODO переделать статусы на enum

    public void registrVoice(Long userId, Long voiceId);

    public Voice getInformationVoice(Long voiceId);

    public void addOrUpdateAnswer(Long voiceId, Answer answer);

    public void deleteAnswer(Long voiceId, Long ansId);

}
