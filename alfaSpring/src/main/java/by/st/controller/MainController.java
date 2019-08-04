package by.st.controller;

import by.st.entity.Voice;
import by.st.exception.ResourceNotFoundException;
import by.st.service.VoicerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class MainController {

    @Autowired
    @Qualifier("ServiceImpl")
    private VoicerService voicerService;

    @PostMapping("/voice")
    public Long createVoice(@Valid @RequestBody Voice voice){
        return voicerService.createVoices(voice);
    }

    @GetMapping("/voice/{id}")
    public Voice getVoice(@PathVariable(value = "id") Long voiceId){
        return voicerService.getVoice(voiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Voice", "id", voiceId));

    }

    @PutMapping("voice/{id}")
    public Voice updateVoice(@PathVariable(value = "id") Long voiceId, @Valid @RequestBody Voice newVoice) {
        Voice voice = voicerService.getVoice(voiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Voice", "id", voiceId));
        voice.updateVoice(newVoice);
        return voicerService.updateVoice(voice);
    }

    @DeleteMapping("/voice/{id}")
    public ResponseEntity<?> deleteVoice(@PathVariable(value = "id") Long voiceId){
        Voice voice = voicerService.getVoice(voiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Voice", "id", voiceId));
        voicerService.deleteVoice(voice);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/voice")
    public List<Voice> allVoice(){
        return voicerService.getVoices();
    }

    @GetMapping("/voice/{id}/{status}")
    public Voice ChangeStatusVoice(@PathVariable(value = "id") Long voiceId,
                                          @PathVariable(value = "status") Integer status){
        Voice voice = voicerService.getVoice(voiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Voice", "id", voiceId));
        voice.setStatus(status);
        return voice;
    }


}
