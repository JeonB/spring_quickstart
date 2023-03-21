package polymorphism;

public class LgTV implements TV{

    private Speaker speaker;

    private int price;

    public void setPrice(int price) {
        System.out.println("==> setPrice 호출`");
        this.price = price;
    }

    public void setSpeaker(Speaker speaker) {
        System.out.println("==> setSpeaker 호출");
        this.speaker = speaker;
    }
    

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
        System.out.println("LgTV---소리 올린다.");
    }
    @Override
    public void soundDown(){
        System.out.println("LgTV---소리 내린다.");
    }
}
