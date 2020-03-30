package com.example.basketballstatistics;

public class ExampleItem {
    private String title;
    private String subtitle;
    private String url;

    public ExampleItem(String url, String title, String subtitle){

        this.url = url;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getUrl(){
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

}
