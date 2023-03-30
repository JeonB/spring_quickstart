package day1.polymorphism;

import org.springframework.stereotype.Component;

@Component("LgSpeaker")
public class LgSpeaker implements Speaker{
    @Override
    public void volumeUp() {
        System.out.println("LG 스피커 볼륨업");
    }

    @Override
    public void volumeDown() {
        System.out.println("LG 스피커 볼륨다운");
    }
}
