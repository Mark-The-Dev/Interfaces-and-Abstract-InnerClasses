package Interfaces;

public class MobilePhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;
    private boolean isOn;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile Phone Powered on!");
    }

    @Override
    public void dial(int phoneNumber) {
        if (isOn){
            System.out.println("Now Ringing " + phoneNumber + " on Mobile Phone");
        } else {
            System.out.println("Phone is switched off.");
        }

    }

    @Override
    public void answer() {

        if (isRinging){
            System.out.println("Answering the Mobile Phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber && isOn){
            isRinging = true;
            System.out.println("Melody Ring");
        } else{
            isRinging = false;
            System.out.println("Mobile Phone is not on or is a different number!");
        }

        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }

}
