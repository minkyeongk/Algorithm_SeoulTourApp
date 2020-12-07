/**
 * 지역별 관광지 리스트 액티비티
 * 관광지 리스트 탭의 리스트 아이템 클릭시 호출
 */

package com.example.algorithm_seoultour.ui.tab2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import com.example.algorithm_seoultour.R;
import com.example.algorithm_seoultour.ui.SpotInfoActivity;
import com.example.algorithm_seoultour.data.spot_info;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;


public class SpotListActivity extends AppCompatActivity {

    List<spot_info> g_object = new ArrayList<spot_info>();

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try{
            spot_info[] spot_data = get_exe1();//총 167개
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            int where = bundle.getInt("where")+1;
            Drawable drawable;
            ImageView where_image;

             List<String> LIST_MENU = new ArrayList<String>();
             List<spot_info> object = new ArrayList<spot_info>();
             final Class<?>[] ACTIVITIES = {SpotInfoActivity.class};

            switch (where){
                case 1:
                    drawable = getResources().getDrawable(R.drawable.jongno);
                    where_image = findViewById(R.id.where);
                    where_image.setImageDrawable(drawable);
                    for(int i=1;i<168;i++){
                        if(spot_data[i-1].area == 4 ){

                            LIST_MENU.add(spot_data[i-1].name);
                            g_object.add(spot_data[i-1]);
                        }
                    }

                    break;

                case 2:
                    drawable = getResources().getDrawable(
                            R.drawable.gangnam);
                    where_image = (ImageView)findViewById(R.id.where);
                    where_image.setImageDrawable(drawable);
                    for(int i=1;i<168;i++){
                        if(spot_data[i-1].area == 3 ){

                            LIST_MENU.add(spot_data[i-1].name);
                            g_object.add(spot_data[i-1]);
                        }
                    }
                    break;

                case 3:
                    drawable = getResources().getDrawable(
                            R.drawable.mapo);
                    where_image = (ImageView)findViewById(R.id.where);
                    where_image.setImageDrawable(drawable);
                    for(int i=1;i<168;i++){
                        if(spot_data[i-1].area == 2 ){

                            LIST_MENU.add(spot_data[i-1].name);
                            g_object.add(spot_data[i-1]);
                        }
                    }
                    break;

                case 4:
                    drawable = getResources().getDrawable(
                            R.drawable.gangdong);
                    where_image = (ImageView)findViewById(R.id.where);
                    where_image.setImageDrawable(drawable);
                    for(int i=1;i<168;i++){
                        if(spot_data[i-1].area == 1 ){

                            LIST_MENU.add(spot_data[i-1].name);
                            g_object.add(spot_data[i-1]);
                        }
                    }
                    break;

            }

            ArrayAdapter Adapter = new ArrayAdapter(this,R.layout.selection_list, LIST_MENU);
            ListView listView = (ListView)findViewById(R.id.spot_list);
            listView.setAdapter(Adapter);
            listView.setClickable(true);
            listView.setAdapter(Adapter);
            listView.setClickable(true);

            listView.setOnItemClickListener((parent, view, position, id) -> {
                Intent intent1 = new Intent(SpotListActivity.this, ACTIVITIES[0]);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("where", g_object.get(position));
                intent1.putExtras(bundle1);
                startActivity(intent1);
            });


        }
        catch(IOException e){
        }

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

                //data_arr[ln].print(data_arr[ln]);
                ln++;
            }

        }catch (IOException e){

        }


        return data_arr;
    }
}
