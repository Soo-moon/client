package shared;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Player implements Serializable , Parcelable {

    private static final long serialVersionUID = 1L;

    public String teamname, name, position, position_type;
    public int season, power, Condition, speed, health, Control, ballspeed;


    public Player(String teamname, String name, String position, int season, int power, int Condition, int speed, int health, int Control, int ballspeed, String position_type) {
        this.teamname = teamname;
        this.name = name;
        this.position = position;
        this.season = season;
        this.power = power;
        this.Condition = Condition;
        this.speed = speed;
        this.health = health;
        this.Control = Control;
        this.ballspeed = ballspeed;
        this.position_type = position_type;
    }

    public int stat() {
        return power + Condition + speed + health + Control + ballspeed;
    }

    public int astat() {
        return power + Condition + speed;
    }

    public int dstat() {
        return health + Control + ballspeed;
    }

    public String getType() {
        return position_type;
    }

    public void Success() {
        if (position_type.equals("타자") || position_type.equals("포수")) {
            power++;
            Condition++;
            speed++;
        } else {
            health++;
            Control++;
            ballspeed++;
        }
    }


    @Override
    public String toString() {
        return teamname + "//" + season + "//" + name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
