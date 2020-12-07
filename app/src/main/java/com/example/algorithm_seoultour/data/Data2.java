package com.example.algorithm_seoultour.data;

public class Data2 {

    // 두번째 기능을 위한 클래스
    int area;  // 지역 번호 (강동, 강북 등)
    int cate;  // 카테고리 번호 (엔터, 먹거리)
    int rank;   // 지역에서 분류 별 순위
    int dnum;  // 식별 번호
    double lati;  // 위도 정보
    double longti;  // 경도 정보
    String name;  // 장소 이름
    String adr;   // 주소
    String link;  // 사이트 링크

    public Data2(int are, int cat, int ran, int dnu, double lat, double longt, String nam, String ad, String lin) {
        this.area = are;
        this.cate = cat;
        this.rank = ran;
        this.dnum = dnu;
        this.lati = lat;
        this.longti = longt;
        this.name = nam;
        this.adr = ad;
        this.link = lin;
    }
}
