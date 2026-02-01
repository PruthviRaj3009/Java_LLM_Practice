interface TaxCalculator {
    double calculateTax(double amount);
}

class USATaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.07; // 7% tax
    }
}

class UKTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.20; // 20% tax
    }
}

class Indian implements TaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.30; // 30% tax
    }
}

class calculateTax {
    private final TaxCalculator taxCalculator;
    private final double amount;

    public calculateTax(double amount, TaxCalculator taxCalculator) {
        this.amount = amount;
        this.taxCalculator = taxCalculator;
    }

    public double getToatalTax() {
        return amount + taxCalculator.calculateTax(amount);
    }
}

public class Main {
    public static void main(String[] args) {

        calculateTax tax1 = new calculateTax(20000, new Indian());
        System.out.println(tax1.getToatalTax());
        System.out.println("-------------------");

        calculateTax tax2 = new calculateTax(210000, new UKTaxCalculator());
        System.out.println(tax2.getToatalTax());
        System.out.println("-------------------");

        calculateTax tax3 = new calculateTax(234000, new USATaxCalculator());
        System.out.println(tax3.getToatalTax());
    }
}
