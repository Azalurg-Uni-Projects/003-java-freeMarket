package Market.bank;

import Market.participants.seller.Seller;
import Market.publisher.TaxesPublisher;

public class Bank {
    private final double target;
    private double lastIncome;
    public double taxes; // in %
    public double income;
    private final TaxesPublisher taxesPublisher;

    public Bank(double target, TaxesPublisher taxesPublisher) {
        this.target = target;
        this.taxes = 0.05;
        this.lastIncome = 0;
        this.income = 0;
        this.taxesPublisher = taxesPublisher;
    }

    public void collectTaxes(Seller seller) {
        this.income += seller.getEarnedMoney() * taxes;
    }

    public void matchTaxes() {
        if (income > target) {
            taxes = taxes - 0.001;
        } else if (income < target && income <= lastIncome) {
            taxes = taxes + 0.002;
        } else if (income < target && income < lastIncome) {
            taxes = taxes - 0.001;
        }
        if (taxes < 0) {
            taxes = 0;
        }
        lastIncome = income;
        taxes = Math.round(taxes * 10000.0) / 10000.0;
    }

    public void propagateTaxes() {
        taxesPublisher.notify(taxes);
    }

    public void monthEnd() {
        System.out.println("This month I collected " + Math.round(income) + " $, tax level " + taxes);
        this.income = 0;
    }
}
