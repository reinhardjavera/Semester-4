package lab;

public class Credit extends Payment {
    private int installment;
    private int maxInstallmentAmount;

    public Credit(Item item, int maxInstallmentAmount) {
        super(item);
        this.maxInstallmentAmount = maxInstallmentAmount;
        this.installment = 0;
    }

    @Override
    public int pay() {
        if (isPaidOff) {
            return 0;
        }
        // Menghitung installment payment
        int amountToPay = item.getPrice() / maxInstallmentAmount;
        installment++;
        if (installment >= maxInstallmentAmount) {
            isPaidOff = true;
        }
        return amountToPay;
    }

    @Override
    public int getRemainingAmount() {
        if (isPaidOff) {
            return 0;
        }
        return (item.getPrice() / maxInstallmentAmount) * (maxInstallmentAmount - installment);
    }

    @Override
    public String getClassName() {
        return "CREDIT";
    }
    
    // Menghitung monthly payment amount
    public int calculateMonthlyPayment() {
        return item.getPrice() / maxInstallmentAmount;
    }
}
