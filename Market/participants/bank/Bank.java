package Market.participants.bank;

public class Bank {
    private final double target;
    private String lastAction;
    private double lastIncome;
    public double taxes; // in %
    public double income;

    public Bank(double target){
        this.target = target;
        this.taxes = 0.005;
        this.lastAction = "Nothing";
        this.lastIncome = 0;
        this.income = 0;
    }

    public double collectTaxes(double volume){
        this.income = this.income + volume * taxes;
        return volume - volume * taxes;
    }

    public void matchTaxes() {
        if (income > target){
           taxes = taxes - 0.001;
           lastAction = "Reduction";
           lastIncome = income;
           return;
        }
        if(income < target && income > lastIncome){
            taxes = taxes + 0.005;
            lastAction = "Increase";
            lastIncome = income;
            return;
        }
        if (income < target && income < lastIncome){
            taxes = taxes - 0.001;
            lastAction = "Reduction";
            lastIncome = income;
        }



    }
}
