package com.example.fccallersvc;

import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.File;

public class AudioInfoDemo {
    public static MultimediaInfo getMediaInfo(String add) throws EncoderException {
        File source = new File(add);
        //创建媒体对象
        MultimediaObject multimediaObject = new MultimediaObject(source);
        //创建媒体信息对象
        return multimediaObject.getInfo();
    }

    public static void main(String[] args) throws EncoderException {
        MultimediaInfo info = getMediaInfo("/tmp/10s_sample.mp3");
        //得到时间
        long time = info.getDuration();
        System.out.println(info.getDuration());
    }
}
