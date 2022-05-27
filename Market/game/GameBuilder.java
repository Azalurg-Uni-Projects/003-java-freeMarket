package Market.game;

public class GameBuilder {
    private int buyers_amount = 1000;
    private int sellers_amount = 100;
    private int bank_target = 50000;
    private int days = 30;
    private int months = 12 * 10;

    public void setBuyers_amount(int buyers_amount) {
        this.buyers_amount = buyers_amount;
    }

    public void setSellers_amount(int sellers_amount) {
        this.sellers_amount = sellers_amount;
    }

    public void setBank_target(int bank_target) {
        this.bank_target = bank_target;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public Game createGame() {
        return new Game(buyers_amount, sellers_amount, bank_target, days, months);
    }
}