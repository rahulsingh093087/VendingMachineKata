import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rahul on 2/11/2016.
 */
public class VendingMachineBrainTest {

    VendingMachineBrain vendingMachineBrain;

    @Before
    public void setUpTest(){
        vendingMachineBrain = new VendingMachineBrain();
    }
    @Test
    public void whenInsertedNickelsmachineWillAccept(){
        assertEquals("accepted", vendingMachineBrain.insert(VendingMachineBrain.Coins.nickels));
    }

    @Test
    public void whenInsertedDimesmachineWillAccept(){
        assertEquals("accepted", vendingMachineBrain.insert(VendingMachineBrain.Coins.dimes));
    }

    @Test
    public void whenInsertedQuartersmachineWillAccept(){
        assertEquals("accepted", vendingMachineBrain.insert(VendingMachineBrain.Coins.quaters));
    }

    @Test
    public void whenInsertedPenniesmachineWillNotAccept(){
        assertEquals("not accepted", vendingMachineBrain.insert(VendingMachineBrain.Coins.pennies));
    }

    @Test
    public void whenItemIsColaAndPaidAmountIsLessThanCostMachineWillDisplayRemainingAmount(){
        assertEquals("Please insert $0.4 more", vendingMachineBrain.selectItemAndpayMoney(VendingMachineBrain.Items.cola,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.dimes));
    }

    @Test
    public void whenItemIsChipsAndPaidAmountIsLessThanCostMachineWillDisplayRemainingAmount(){
        assertEquals("Please insert $0.25 more", vendingMachineBrain.selectItemAndpayMoney(VendingMachineBrain.Items.chips,
                VendingMachineBrain.Coins.quaters));
    }

    @Test
    public void whenItemIsCandyAndPaidAmountIsLessThanCostMachineWillDisplayRemainingAmount(){
        assertEquals("Please insert $0.4 more", vendingMachineBrain.selectItemAndpayMoney(VendingMachineBrain.Items.candy,
                VendingMachineBrain.Coins.quaters));
    }

    @Test
    public void whenItemIsColaAndPaidAmountIsMoreThanCostMachineWillDisplayThankYou(){
        assertEquals("THANK YOU", vendingMachineBrain.selectItemAndpayMoney(VendingMachineBrain.Items.cola,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.dimes,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.dimes,
                VendingMachineBrain.Coins.nickels,
                VendingMachineBrain.Coins.quaters));
    }

    @Test
    public void whenItemIsChipsAndPaidAmountIsMoreThanCostMachineWillDisplayThankYou(){
        assertEquals("THANK YOU", vendingMachineBrain.selectItemAndpayMoney(VendingMachineBrain.Items.chips,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.nickels,
                VendingMachineBrain.Coins.dimes));
    }

    @Test
    public void whenItemIsCandyAndPaidAmountIsMoreThanCostMachineWillDisplayThankYou(){
        assertEquals("THANK YOU", vendingMachineBrain.selectItemAndpayMoney(VendingMachineBrain.Items.candy,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.nickels,
                VendingMachineBrain.Coins.dimes));
    }

    @Test
    public void whenItemIsColaAndPaidAmountIsEqualtoCostMachineWillDisplayThankYou(){
        assertEquals("THANK YOU", vendingMachineBrain.selectItemAndpayMoney(VendingMachineBrain.Items.cola,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters));
    }

    @Test
    public void whenItemIsChipsAndPaidAmountIsEqualtoCostMachineWillDisplayThankYou(){
        assertEquals("THANK YOU", vendingMachineBrain.selectItemAndpayMoney(VendingMachineBrain.Items.chips,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters));
    }

    @Test
    public void whenItemIsCandyAndPaidAmountIsEqualtoCostMachineWillDisplayThankYou(){
        assertEquals("THANK YOU", vendingMachineBrain.selectItemAndpayMoney(VendingMachineBrain.Items.candy,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters,
                VendingMachineBrain.Coins.quaters));
    }

    @Test
    public void whenPaidAmountIsmoreThannItemCostMachineWillReturenTheBalanceTest1(){
        double expected = .50;
        double actual = vendingMachineBrain.returnbalanceToCustomer(1, .50);
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void whenPaidAmountIsmoreThannItemCostMachineWillReturenTheBalanceTest2(){
        double expected = .50;
        double actual = vendingMachineBrain.returnbalanceToCustomer(.65, .15);
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void whenPaidAmountIsmoreThannItemCostMachineWillReturenTheBalanceTest3(){
        double expected = .25;
        double actual = vendingMachineBrain.returnbalanceToCustomer(.50, .25);
        assertEquals(expected, actual, 0.0);
    }

}