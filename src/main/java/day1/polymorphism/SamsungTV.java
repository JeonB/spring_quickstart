package day1.polymorphism;

public class SamsungTV implements TV {

    private int price;
    private Speaker speaker;

    public SamsungTV() {
        System.out.println("===> SamsungTV(1) 객체 생성");
    }

    public void setSpeaker(Speaker speaker) {
        System.out.println("===> setSpeaker() 호출");
        this.speaker = speaker;
    }

    public void setPrice(int price) {
        System.out.println("===> setPrice() 호출");
        this.price = price;
    }

    public SamsungTV(Speaker speaker) {
        System.out.println("===> SamsungTV(2) 객체 새성");
        this.speaker = speaker;
    }

    /* public void initMethod(){
         System.out.println("객체 초기화 작업 처리..");
     }
     public void destroyMethod(){
         System.out.println("객체 삭제 전에 처리할 로직 처리..");
     }*/
    public SamsungTV(Speaker speaker, int price) {
        System.out.println("===> SamsungTV(3) 객체 생성");
        this.speaker = speaker;
        this.price = price;
    }

    @Override
    public void turnOn() {
        System.out.println("SamsungTv---전원 켠다.");
    }

    @Override
    public void turnOff() {
        System.out.println("SamsungTV---전원 끈다.");
    }

    public void soundUp() {
        speaker.volumeUp();
    }

    public void soundDown() {
        speaker.volumeDown();
    }
   /* @Override
    public void soundUp() {
        sonySpeaker = new SonySpeaker();
        sonySpeaker.volumeUp();
        System.out.println("SamsungTV---소리 올린다.");
    }

    @Override
    public void soundDown() {
        sonySpeaker = new SonySpeaker();
        sonySpeaker.volumeDown();
        System.out.println("SamsungTV---소리 내린다.");
    }*/
}
