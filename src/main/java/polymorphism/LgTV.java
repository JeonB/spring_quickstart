package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//따로 이름 지정 안 하면 클래스 이름의 첫 대문자를 소문자로 변경한 것이 이름임
public class LgTV implements TV{
    @Autowired //자동으로 SonySpeaker 객체를 speaker변수에 할당
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
