/**
 * 기타 여행정보 탭 프래그먼트
 */

package com.example.algorithm_seoultour.ui.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.algorithm_seoultour.R;

import org.jetbrains.annotations.Nullable;

public class Tap3_fragment extends Fragment {
    private static  final String TAG = "Tap3_fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3,container,false);

        ImageButton seoul_site = view.findViewById(R.id.seoul_site);
        ImageButton korea_site = view.findViewById(R.id.korea_site);
        ImageButton metro_site = view.findViewById(R.id.metro_site);

        seoul_site.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://korean.visitseoul.net/"));
            startActivity(intent);
        });

        korea_site.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://korean.visitkorea.or.kr/main/main.html"));
            startActivity(intent);
        });

        metro_site.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/?region=1000&lng=53fca0c162bc0e35c7ba3a738ba82085&mapMode=0&lat=951f1b116c440d0145b14dcb45b78e55&dlevel=11&enc=b64&menu=subway"));
            startActivity(intent);
        });

        return view;
    }
}
