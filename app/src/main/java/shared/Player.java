package shared;

import java.io.Serializable;

public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    String teamname,name,position,a;
    int season,power,Condition,speed,health,Control,ballspeed;


    public Player(String teamname , String name , String position ,int season , int power ,int Condition ,int speed , int health, int Control ,int ballspeed,String a ){
        this.teamname = teamname;
        this.name = name;
        this.position=position;
        this.season=season;
        this.power=power;
        this.Condition=Condition;
        this.speed=speed;
        this.health=health;
        this.Control=Control;
        this.ballspeed=ballspeed;
        this.a=a;
    }

}
