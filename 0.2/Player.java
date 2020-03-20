public class Player {
    private char name;
    private int money;
    private int where;
    private String color;
    private boolean bankrupt;

    public Player( char name, String color ){
        this.money = 1500;
        this.name = name;
        this.where = 0;
        this.color = color;
        this.bankrupt = false;
    }

    public char getName(){
        return name;
    }

    public int getMoney(){
        return money;
    }

    public int getWhere(){
        return where;
    }

    public String getColor(){
        return color;
    }

    public boolean getBankrupt(){
        return bankrupt;
    }

    public void setName( char name ){
        this.name = name;
    }

    public void setMoney( int money ){
        this.money = money;
    } 

    public void setWhere( int where ){
        this.where = where;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setBankrupt( boolean bankrupt ){
        this.bankrupt = bankrupt;
    }
}