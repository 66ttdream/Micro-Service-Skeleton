package com.demo.chat.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;

/**
 * @author liuji
 *
 */
public class FormatUtil {
    @Value("${filepath}")
    public static String path;
    public static boolean audioToPcm(File source,File target) {
        boolean succeeded = true;
        try {
            //File source = new File("source/xinluyin.m4a");
            //File target = new File("source/xinluyin.pcm");
            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("pcm_s16le");
            audio.setBitRate(16000);
            audio.setChannels(1);
            audio.setBitRate(16000);
            audio.setSamplingRate(16000);

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            //attrs.setFormat("wav");
            attrs.setFormat("wav");
            attrs.setAudioAttributes(audio);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            ex.printStackTrace();
            succeeded = false;
        }
        return succeeded;
    }
}
