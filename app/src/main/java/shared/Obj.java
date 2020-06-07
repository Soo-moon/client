package shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Obj implements Serializable {

    private static final long serialVersionUID = 1L;

    ArrayList<Player> arrayList = null;
    Object object;
    String Message = "";
    int code;
    String id;
    UserData userData;

    public Obj(Object object, int code) {
        this.object = object;
        this.code = code;
        //code 2
        if (object instanceof ArrayList)
            arrayList = (ArrayList<Player>) object;
        //code 1
        else if (object instanceof String)
            Message = (String) object;
        //code 0
        else if(object instanceof UserData)
            userData = (UserData) object;
    }


    //code 3 == 팀 검색
    //code 4 == 선수명 검색
    
    public UserData getUserData() {return userData;}
    
    public ArrayList<Player> getarray() {return arrayList;}
  
    public String getstr() {return Message;}

    public String getid() { return userData.getid();}

    public int getcode() {return code;}


}
