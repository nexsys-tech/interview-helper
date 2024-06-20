package com.nexsystech.interview.helper.service.impl;


import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.result.Result;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class SpeechRecognitionService {


    public String transcribe(byte[] audioData) {
        Configuration configuration = new Configuration();
        // Set path to acoustic model, dictionary, and language model
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        try (InputStream inputStream = new ByteArrayInputStream(audioData)) {
            StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
            recognizer.startRecognition(inputStream);
            Result result;
            StringBuilder transcription = new StringBuilder();
            while ((result = recognizer.getResult().getResult()) != null) {
                if (result != null) {
                    transcription.append(result.getBestResultNoFiller()).append(" ");
                }
            }
            recognizer.stopRecognition();
            return transcription.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error during transcription: " + e.getMessage();
        }
    }
}
