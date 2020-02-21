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

    public String[] getTeam(){
        return Myteam;
    }

    public int getScore(){
        return Score;
    }

    public String getNickname(){
        return Nickname;
    }

    public String getRank(){
        return Rank;
    }


    public void setScore(int Score){
       this.Score = Score;
    }

    public void setNickname(String Nickname){
        this.Nickname = Nickname;
    }

    public void setRank(String Rank){
        this.Rank=Rank;
    }

    public void setMyteam(String[] Myteam){
        this.Myteam=Myteam;
    }

}
