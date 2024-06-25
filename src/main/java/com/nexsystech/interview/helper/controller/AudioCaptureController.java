package com.nexsystech.interview.helper.controller;

import com.nexsystech.interview.helper.service.impl.SpeechRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class AudioCaptureController {
    @Autowired
    private SpeechRecognitionService speechRecognitionService;

//    @Autowired
//    private NLPService nlpService;

    @MessageMapping("/audio")
    @SendTo("/topic/transcription")
    public String handleAudioMessage(byte[] audioData) {
        String question = speechRecognitionService.transcribe(audioData);
        //String answer = nlpService.getAnswer(question);
        return "Q: " + question;
    }
}
