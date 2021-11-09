package com.example.dictionary;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Speaker {
    // chuyển từ vựng thành âm thanh
    public static void getVoice(String word) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");

        Voice[]voicelist = VoiceManager.getInstance().getVoices();

        if(voice != null) {
            voice.allocate();
            boolean status = voice.speak(word);
            // chọn âm phát ra
            voice.deallocate();
        }
        else{
            System.out.println("error voice");
        }
    }

}
