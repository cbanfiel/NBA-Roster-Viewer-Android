package com.example.basketballstatistics;

public class Player {

    private String name;
    private String url;
    private int positionId;
    private int number;
    private String height;
    private int age;
    private int salary;
    private int years;


    public Player(String name, String url, int positionId, int number, String height, int age, int salary, int years) {
        this.name = name;
        this.url = url;
        this.positionId = positionId;
        this.number = number;
        this.height = height;
        this.age = age;
        this.salary = salary;
        this.years = years;
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

    public String getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public int getYears() {
        return years;
    }

    public String getContract(){
        return years + " Yrs $" + Math.round((salary/1000000)*10) / 10.0 + " Mil";
    }
}
