package day1.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("LgTV") //반드시 스프링 컨테이너에 bean을 등록하는 주석처리를 해야만 멤버변수에 @Autowired 같은 주석처리가 가능하다
public class LgTV implements TV {

    @Autowired //자동으로 SonySpeaker 객체를 speaker변수에 할당
    @Qualifier("LgSpeaker") //컨테이너에 Speaker타입의 객체가 2개 이상 존재하면 Autowired만으로는 식별 불가하므로 Qualifer가 필요함
    private Speaker speaker;

    private int price;

    public LgTV() {
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
    public void soundUp() {
        speaker.volumeUp();
    }

    @Override
    public void soundDown() {
        speaker.volumeDown();
    }
}
