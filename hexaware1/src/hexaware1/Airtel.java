package hexaware1;

public class Airtel extends Sim {

    @Override
    public void calling() {
        double rate = 15;
        bill = (int) (calls * rate);
    }

    @Override
    public void msg() {
        double rate1 = 3;
        bill += (int) (msgs * rate1);
    }
}
