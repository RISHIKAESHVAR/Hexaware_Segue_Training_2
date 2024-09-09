package hexaware1;

public abstract class Sim {
    protected int calls;
    protected int msgs;
    protected int bill;

    public Sim() {
        calls = 0;
        msgs = 0;
        bill = 0;
    }

    public abstract void calling();
    public abstract void msg();

    public void show() {
        System.out.println("Total Bill: " + bill);
    }
}
