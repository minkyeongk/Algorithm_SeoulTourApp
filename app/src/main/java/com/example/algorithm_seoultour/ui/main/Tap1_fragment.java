/**
 * 최단거리 추천 탭 프래그먼트
 */

package com.example.algorithm_seoultour.ui.main;

import android.os.Bundle;
import android.content.Intent;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.widget.ImageButton;

import com.example.algorithm_seoultour.R;
import com.example.algorithm_seoultour.ui.tab1.ChooseActivity;

import org.jetbrains.annotations.Nullable;

public class Tap1_fragment extends Fragment {
    private static  final String TAG = "Tap1_fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1,container,false);
        ImageButton jongno = view.findViewById(R.id.jongno);
        ImageButton gangnam = view.findViewById(R.id.gangnam);
        ImageButton mapo = view.findViewById(R.id.mapo);
        ImageButton gangdong = view.findViewById(R.id.gangdong);

        Intent intent = new Intent(getActivity(), ChooseActivity.class);
        Bundle bundle = new Bundle();

        jongno.setOnClickListener(v -> {
            bundle.putInt("where", 4);
            intent.putExtras(bundle);
            startActivity(intent); });

        gangnam.setOnClickListener(v -> {
            bundle.putInt("where", 3);
            intent.putExtras(bundle);
            startActivity(intent); });

        mapo.setOnClickListener(v -> {
            bundle.putInt("where", 2);
            intent.putExtras(bundle);
            startActivity(intent); });

        gangdong.setOnClickListener(v -> {
            bundle.putInt("where", 1);
            intent.putExtras(bundle);
            startActivity(intent);
        });
        return view;
    }
}
