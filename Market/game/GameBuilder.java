package Market.game;

public class GameBuilder {
    private int buyers_amount = 20;
    private int sellers_amount = 10;
    private int bank_target = 20000;
    private int days = 30;
    private int months = 12;

    public GameBuilder setBuyers_amount(int buyers_amount) {
        this.buyers_amount = buyers_amount;
        return this;
    }

    public GameBuilder setSellers_amount(int sellers_amount) {
        this.sellers_amount = sellers_amount;
        return this;
    }

    public GameBuilder setBank_target(int bank_target) {
        this.bank_target = bank_target;
        return this;
    }

    public GameBuilder setDays(int days) {
        this.days = days;
        return this;
    }

    public GameBuilder setMonths(int months) {
        this.months = months;
        return this;
    }

    public Game createGame() {
        return new Game(buyers_amount, sellers_amount, bank_target, days, months);
    }
}