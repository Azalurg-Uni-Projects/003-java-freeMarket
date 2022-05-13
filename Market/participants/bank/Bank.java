package Market.participants.bank;

public class Bank {
    private final double target;
    public double taxes; // in %

    public Bank(double target){
        this.target = target;
        this.taxes = 0.005;
    }

}
