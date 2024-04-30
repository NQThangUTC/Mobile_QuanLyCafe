package com.example.qlquancaffee.Object;
public class Account{
    private String DisplayName;
    private String UserName;
    private String PassWord;
    private int Type;

    public Account(String userName, String displayName, String passWord, int type) {
        DisplayName = displayName;
        UserName = userName;
        PassWord = passWord;
        Type = type;
    }
    public Account(String userName,String passWord){
        UserName = userName;
        PassWord = passWord;
    }
    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }
}
