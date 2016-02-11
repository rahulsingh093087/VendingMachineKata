import java.util.ArrayList;

/**
 * Created by rahul on 2/11/2016.
 */
public class VendingMachineBrain {

    public enum Coins {
        nickels (.05) ,
        dimes (.1),
        quaters(.25),
        pennies(.01);

        public final double coinValue;
        Coins(double coinValue){
            this.coinValue = coinValue;
        }
    }

    public enum Items {
        cola (1.0, 0),
        chips (.5, 0),
        candy (.65, 0);

        public double itemCost;
        public int itemCount;
        Items(double itemCost, int itemCount){
            this.itemCost = itemCost;
            this.itemCount = itemCount;
        }

        public void setItemCount(int count){
            this.itemCount = count;
        }
    }


    public static void main(String args[]){
        VendingMachineBrain vmb = new VendingMachineBrain();
        System.out.println("hello");
        System.out.println(Coins.dimes.coinValue);
        System.out.println(vmb.calculateAmountInserted(Coins.nickels, Coins.quaters));
        System.out.println(vmb.selectItemAndpayMoney(Items.candy, Coins.quaters, Coins.quaters, Coins.quaters, Coins.quaters));
        System.out.println("cola count = "+ Items.cola.itemCount);
        Items.cola.setItemCount(2);
        System.out.println("Cola Count = "+ Items.cola.itemCount);
        System.out.println("Chips count = "+ Items.candy.itemCount);

    }


    public String insert(Coins coins) {

        switch (coins){
            case nickels:
                return "accepted";
            case dimes:
                return "accepted";
            case quaters:
                return "accepted";
            case pennies:
                return "not accepted";
            default:
                return "not accepted";
        }
    }

    public String selectItemAndpayMoney(Items item, Coins... coins){
        double paidAmount = calculateAmountInserted(coins);
        if(item.itemCount <1)
            return "Sold Out";
        if(paidAmount >= item.itemCost){
            item.setItemCount(--item.itemCount);
            returnbalanceToCustomer(paidAmount, item.itemCost);
            return "THANK YOU";
        }
        return "Please insert $"+ (item.itemCost - paidAmount) +" more";
    }

    public double calculateAmountInserted(Coins... coins){
        double totalValue = 0.0;
        for (Coins coin : coins){
            totalValue = totalValue + coin.coinValue;
        }
        return totalValue;
    }

    public double returnbalanceToCustomer(double paidAmount, double itemCost){
        double balance = paidAmount - itemCost;
        return balance;
    }
}
