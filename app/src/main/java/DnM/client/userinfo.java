package DnM.client;

public class userinfo {

    String [] Myteam = null;
    int Score = 0 ;
    String Rank = null;
    String Nickname = null;

    public userinfo(String[] Myteam , int Score , String Rank , String Nickname){
        this.Myteam = Myteam;
        this.Score = Score;
        this.Nickname = Nickname;
        this.Rank = Rank;
    }

    public String[] getteam(){
        return this.Myteam;
    }

    public int getScore(){
        return this.Score;
    }

    public String getNickname(){
        return this.Nickname;
    }

    public String getRank(){
        return this.Rank;
    }

}
