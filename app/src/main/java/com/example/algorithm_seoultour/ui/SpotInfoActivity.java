/**
 * 상세 관광지 정보를 나타내는 페이지
 * ChooseResult Activity와 SpotList Activity를 통해 접근 가능
 */

package com.example.algorithm_seoultour.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.algorithm_seoultour.R;
import com.example.algorithm_seoultour.data.spot_info;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SpotInfoActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    Double g_lati = 0.0;
    Double g_longi = 0.0;
    String g_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_infomation);
        Intent intent = getIntent();
        final spot_info where = (spot_info)intent.getSerializableExtra("where");
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/SeoulNamsanL.ttf");

        g_lati = where.lati;
        g_longi = where.longi;
        g_name = where.name;

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); //getMapAsync must be called on the main thread.

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView wv = findViewById(R.id.ID_IMG);
        wv.setFocusable(false);
        if (wv != null) wv.loadUrl(where.url);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);

        TextView editText = findViewById(R.id.editText);
        TextView editText2 = findViewById(R.id.editText2);
        TextView editText3 = findViewById(R.id.editText3);
        TextView editText4 = findViewById(R.id.editText4);

        editText.setTypeface(typeFace);
        editText2.setTypeface(typeFace);
        editText3.setTypeface(typeFace);
        editText4.setTypeface(typeFace);

        TextView name = findViewById(R.id.spotname);
        name.setTypeface(typeFace);
        name.setText(where.name) ;

        TextView address = findViewById(R.id.spotadd);
        address.setTypeface(typeFace);
        address.setText(where.adr) ;

        if(where.link.equals("NULL")) {
            TextView link = (TextView) findViewById(R.id.spotinfo);
            link.setTypeface(typeFace);
            link.setText("없음");
        }
        else{
            TextView link = findViewById(R.id.spotinfo);
            link.setTypeface(typeFace);
            link.setText(where.link);
            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(where.link));
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        mMap = map;

        // 해당 장소에 대한 위치 설정
        LatLng seoul = new LatLng(g_lati, g_longi);

        // 구글 맵에 표시할 마커에 대한 옵션 설정
        MarkerOptions makerOptions = new MarkerOptions();
        makerOptions
                .position(seoul)
                .title(g_name);

        mMap.addMarker(makerOptions);       // 마커 생성
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, (float)14.5));
    }
}
