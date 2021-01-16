package Interfaces;

public interface ITelephone {

    // no need to define public or private in interfaces.

    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();

}
