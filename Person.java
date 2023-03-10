

public class Person {

    private String name;
    private FoodWallet foodWallet;
    private int money = 0;

    public Person(String name){
        this(name, 0);
    }

    public Person(String name, int money){
        this.name = name;
        this.money = money;
        foodWallet = new FoodWallet();
    }

    public boolean goToLunch(){
        return foodWallet.eat();
    }

    public void gainMoney(int amount){
        money += amount;
    }

    public String getName(){
        return name;
    }

    public int getMoney(){
        return money;
    }

    //updades the food price
    public void updateFoodPrice(int price){
        foodWallet.setFoodPrice(price);
    }

    //add money to the wallet by the specified amount if possible
    public boolean chargeWallet(int amount){
        if(money >= amount){
            money -= amount;
            foodWallet.depositMoney(amount);
            return true;
        }
        return false;
    }

    //toString method for Person
    public String toString(){
        return "I am a person. My name is " + name + ".";
    }

}
