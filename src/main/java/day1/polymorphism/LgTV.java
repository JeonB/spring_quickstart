package day1.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LgTV implements TV{
    @Autowired //자동으로 SonySpeaker 객체를 speaker변수에 할당
    @Qualifier("apple")
    private Speaker speaker;

    private int price;
    
    public LgTV(){
        System.out.println("===>LG tv 객체 생성");
    }
/*    public void setPrice(int price) {
        System.out.println("==> setPrice 호출");
        this.price = price;
    }

    public void setSpeaker(Speaker speaker) {
        System.out.println("==> setSpeaker 호출");
        this.speaker = speaker;
    }*/
    

    @Override
    public void turnOn() {
        System.out.println("LgTv---전원 켠다.");
    }

    @Override
    public void turnOff() {
        System.out.println("LgTv---전원 끈다.");
    }
    @Override
    public void soundUp(){
        speaker.volumeUp();
    }
    @Override
    public void soundDown(){
        speaker.volumeDown();
    }
}
