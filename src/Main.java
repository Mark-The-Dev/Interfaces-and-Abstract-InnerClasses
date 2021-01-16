import Interfaces.DeskPhone;
import Interfaces.ITelephone;
import Interfaces.MobilePhone;

public class Main {
    public static void main(String[] args) {

        ITelephone marksPhone;

        marksPhone = new DeskPhone(1234445555);
//        marksPhone.powerOn();
//        marksPhone.callPhone(1234445555);
//        marksPhone.answer();

        // because marksPhone was initialized as Interface, it can mutate class type.

        marksPhone = new MobilePhone(1234445555);
        marksPhone.powerOn();
        marksPhone.callPhone(1234445555);
        marksPhone.answer();



    }
}
