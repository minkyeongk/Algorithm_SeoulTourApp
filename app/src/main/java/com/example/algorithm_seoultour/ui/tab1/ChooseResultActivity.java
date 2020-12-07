/**
 * ChooseActivity의 결과 페이지
 */

package com.example.algorithm_seoultour.ui.tab1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.example.algorithm_seoultour.R;
import com.example.algorithm_seoultour.ui.SpotInfoActivity;
import com.example.algorithm_seoultour.data.spot_info;
import com.example.algorithm_seoultour.model.find_code;
import com.opencsv.CSVReader;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChooseResultActivity extends AppCompatActivity {
    List<spot_info> g_object = new ArrayList<spot_info>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int[] category = bundle.getIntArray("category");
        Context context = getApplicationContext();

        find_code Find_Code = new find_code(category[0],category[1],category[2],category[3],context);

        TextView text = findViewById(R.id.explanation);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/SeoulNamsanL.ttf");
        text.setTypeface(typeFace);

        List<String> LIST_MENU = new ArrayList<String>();
        List<spot_info> object = new ArrayList<spot_info>();
        final Class<?>[] ACTIVITIES = {SpotInfoActivity.class};
        try {
            spot_info[] spot_data = get_exe1();
            try {
                Find_Code.find_code_main();
            }catch(IOException ignored){
            }

            if(Find_Code.ans1 == null){
                LIST_MENU.add("[결과 없음]");
                LIST_MENU.add("지역내 선택한 테마의 관광지가 없습니다.");
                ArrayAdapter Adapter = new ArrayAdapter(this, R.layout.selection_list, LIST_MENU);
                ListView listView = findViewById(R.id.resultlist);
                listView.setAdapter(Adapter);
            }
            else {
                for (int i = 0; i < 167; i++) {
                    if (Find_Code.ans1.name.equals(spot_data[i].name)) {
                        g_object.add(spot_data[i]);
                    }
                }

                for (int i = 0; i < 167; i++) {
                    if (Find_Code.ans2.name.equals(spot_data[i].name)) {
                        g_object.add(spot_data[i]);
                    }
                }

                for (int i = 0; i < 167; i++) {
                    if (Find_Code.ans3.name.equals(spot_data[i].name)) {
                        g_object.add(spot_data[i]);
                    }
                }

                LIST_MENU.add(Find_Code.ans1.name);
                LIST_MENU.add(Find_Code.ans2.name);
                LIST_MENU.add(Find_Code.ans3.name);

                ArrayAdapter Adapter = new ArrayAdapter(this, R.layout.selection_list, LIST_MENU);
                ListView listView = findViewById(R.id.resultlist);
                listView.setAdapter(Adapter);
                listView.setClickable(true);
                listView.setOnItemClickListener((parent, view, position, id) -> {
                    Intent intent1 = new Intent(ChooseResultActivity.this, ACTIVITIES[0]);
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("where", g_object.get(position));
                    intent1.putExtras(bundle1);
                    startActivity(intent1);
                });
            }
        }catch(IOException ignored){}
    }

    public spot_info[] get_exe1() throws IOException {
        spot_info[] data_arr = new spot_info[167];
        int ln = 0;
        try {
            CSVReader file0 = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.spot_info)));
            List<String[]> line = file0.readAll();

            while (ln < 168) {
                String[] sArrays = line.get(ln);
                if (sArrays == null) break;
                if(ln!=0)
                    data_arr[ln-1] = new spot_info(Integer.parseInt(sArrays[1]),Double.parseDouble(sArrays[4]),Double.parseDouble(sArrays[5]), sArrays[6], sArrays[7], sArrays[8],sArrays[9]);
                ln++;
            }

        }catch (IOException ignored){
        }
        return data_arr;
    }
}
