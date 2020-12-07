package com.example.algorithm_seoultour.data;

public class Data {
    public int area;  // 지역 번호 (강동, 강북 등)
    public int cate;  // 카테고리 번호 (엔터, 먹거리)
    public int dnum;  // 식별 번호
    public double lati;  // 위도 정보
    public double longti;  // 경도 정보
    public String name;  // 장소 이름
    public String adr;   // 주소
    public String link;  // 사이트 링크

    public Data(int are, int cat, int dnu, double lat, double longt, String nam, String ad, String lin) {
        this.area = are;
        this.cate = cat;
        this.dnum = dnu;
        this.lati = lat;
        this.longti = longt;
        this.name = nam;
        this.adr = ad;
        this.link = lin;
    }
}
