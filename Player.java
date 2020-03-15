public class Player {
    private char name;
    private int money;
    private int where;
    private String color;

    public Player( char name, String color ){
        this.money = 1500;
        this.name = name;
        this.where = 0;
        this.color = color;
    }

    char getName(){
        return name;
    }

    int getMoney(){
        return money;
    }

    int getWhere(){
        return where;
    }

    String getColor(){
        return color;
    }

    void setName( char name ){
        this.name = name;
    }

    void setMoney( int money ){
        this.money = money;
    } 

    void setWhere( int where ){
        this.where = where;
    }

    void setColor(String color){
        this.color = color;
    }
}