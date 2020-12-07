/**
 * 관광지 리스트 탭 프래그먼트
 */

package com.example.algorithm_seoultour.ui.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.algorithm_seoultour.R;
import com.example.algorithm_seoultour.ui.tab2.SpotListActivity;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Tap2_fragment extends Fragment {
    private static  final String TAG = "Tap2_fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2,container,false);
        Typeface typeFace = Typeface.createFromAsset(Objects.requireNonNull(getContext()).getAssets(), "fonts/SeoulNamsanL.ttf");
        final String[] LIST_MENU = {"종로·중구 지역", "강남·송파 지역", "마포·강서 지역","강동·광진 지역"};
        final Class<?>[] ACTIVITIES = { SpotListActivity.class , SpotListActivity.class, SpotListActivity.class, SpotListActivity.class};
        ArrayAdapter Adapter = new ArrayAdapter(getActivity(),R.layout.selection_list, LIST_MENU);
        ListView listView = (ListView) view.findViewById(R.id.listview1);

        listView.setAdapter(Adapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                Bundle bundle;

                switch(position){
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        bundle = new Bundle();
                        bundle.putInt("where", position);
                        intent = new Intent(getActivity(), ACTIVITIES[position]);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                }
            }
        });
        return view;
    }
}
