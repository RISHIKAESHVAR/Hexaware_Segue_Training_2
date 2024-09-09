package hexaware1;

public class Main1 {

    public static void main(String[] args) {
        Sim s1 = new Airtel();
        s1.calls = 27;
        s1.msgs = 97;
        s1.calling();
        s1.msg();
        s1.show();

        Sim s2 = new Jio();
        s2.calls = 11;
        s2.msgs = 88;
        s2.calling();
        s2.msg();
        s2.show();
    }
}
