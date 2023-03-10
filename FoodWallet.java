
public class FoodWallet {

    private int foodPrice;
    private int money;

    
    public FoodWallet(){
        foodPrice = 33;
        money = 0;
    }

    //constructor
    public FoodWallet(int initialMoney) {
        money = initialMoney;
    }

    
    public void depositMoney(int depositAmount) {
        money += depositAmount;
    }

    
    public boolean eat(){
        if(money >= foodPrice) {
            money -= foodPrice;
            return true;
        }
        else {
            return false;
        }
    }

    //accessors
    public int getFoodPrice() {
        return foodPrice;
    }
    public int getMoney() {
        return money;
    }

    //setter
    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    
    @Override
    public String toString(){
        return "There is " + money + " TL in the food wallet.";
    }

}

