package lab;

public abstract class Payment implements ClassInfo {
    protected boolean isPaidOff;
    protected Item item;

    public Payment() {
        this.isPaidOff = false;
        this.item = null;
    }

    public Payment(Item item) {
        this.isPaidOff = false;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public String getItemName() {
        return item.getName();
    }

    public String getStatus() {
        return isPaidOff ? "FINISHED" : "ON PROGRESS";
    }

    public int getRemainingAmount() {
        return isPaidOff ? 0 : item.getPrice();
    }

    public boolean getPaidOff() {
        return isPaidOff;
    }

    public abstract int pay();
}
