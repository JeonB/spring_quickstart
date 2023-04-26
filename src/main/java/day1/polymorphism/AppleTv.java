package day1.polymorphism;

public class AppleTv implements TV {

    private Speaker speaker;

    public AppleTv(Speaker speaker) {
        System.out.println("애플티비 객체 생성");
        this.speaker = speaker;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

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
