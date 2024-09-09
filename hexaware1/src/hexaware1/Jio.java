package hexaware1;

public class Jio extends Sim {

    @Override
    public void calling() {
        double rate = 10;
        bill = (int) (calls * rate);
    }

    @Override
    public void msg() {
        double rate1 = 2;
        bill += (int) (msgs * rate1);
    }
}
