package hexaware1;



public class Bills {

    public static void main(String[] args) {

        Calculate jioCall = (calls, rate) -> calls * rate;
        Calculate jioMsg = (msgs, rate) -> msgs * rate;

        int jioCallRate = 3;
        int jioMsgRate = 1;

        int jioCalls = 10;
        int jioMsgs = 5;
        int jioBill = jioCall.operate(jioCalls, jioCallRate) +
                      jioMsg.operate(jioMsgs, jioMsgRate);

        System.out.println("Jio Total Bill: " + jioBill);

        Calculate airtelCall = (calls, rate) -> calls * rate;
        Calculate airtelMsg = (msgs, rate) -> msgs * rate;

        int airtelCallRate = 4;
        int airtelMsgRate = 1;

        int airtelCalls = 8;
        int airtelMsgs = 3;
        int airtelBill = airtelCall.operate(airtelCalls, airtelCallRate) +
                         airtelMsg.operate(airtelMsgs, airtelMsgRate);

        System.out.println("Airtel Total Bill: " + airtelBill);

    }
}
