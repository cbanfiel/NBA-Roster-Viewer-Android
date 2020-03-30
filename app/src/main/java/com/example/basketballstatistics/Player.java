package com.example.basketballstatistics;

public class Player {

    private String name;
    private String url;
    private int positionId;
    private int number;


    public Player(String name, String url , int positionId, int number) {
        this.name = name;
        this.url = url;
        this.positionId = positionId;
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getPositionId() {
        return positionId;
    }

    public int getNumber() {
        return number;
    }


    public String getPosition(){
        switch (positionId){
            case 0:
                return "PG";
            case 1:
                return "SG";
            case 2:
                return "SF";
            case 3:
                return "PF";
            case 4:
                return "C";
                default:
                    return "";
        }
    }


}
