package com.example.algorithm_seoultour.data;

import java.io.Serializable;

public class spot_info implements Serializable {

    public int area;
    public Double lati;
    public Double longi;
    public String name;  // 장소 이름
    public String adr;   // 주소
    public String link;  // 사이트 링크
    public String url;

    public spot_info(int area,Double lati,Double longi,String nam, String ad, String lin,String url) {

        this.area = area;
        this.lati = lati;
        this.longi = longi;
        this.name = nam;
        this.adr = ad;
        this.link = lin;
        this.url = url;
    }

}
