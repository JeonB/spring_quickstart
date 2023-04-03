package day2.common.aoptest;

public class AopTest {
    public int testMethod(){
        int testcode= 0;
        System.out.println("aop 테스트코드");
        testcode++;
        return testcode;
    }

    public void superWow(){
        System.out.println("configure 설정 먹나?");
    }
}
