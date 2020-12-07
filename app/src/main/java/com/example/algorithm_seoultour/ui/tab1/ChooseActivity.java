/**
 * 최단거리 추천 탭에서 아이템 클릭시 호출되는 액티비티
 */

package com.example.algorithm_seoultour.ui.tab1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.algorithm_seoultour.R;

public class ChooseActivity extends AppCompatActivity {
    int category[] = {0,0,0,0};
    // 맨 앞은 지역 - 인덱스 1번 부터 1번선택 , 2번선택, 3번선택
    int choice_order; // 선택순서 초기 1

    Typeface typeFace;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1choose);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        typeFace = Typeface.createFromAsset(getAssets(), "fonts/SeoulNamsanL.ttf");
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int where = bundle.getInt("where");
        Drawable drawable;
        ImageView where_image;

        choice_order = 1; // 선택순서 초기 1

        switch (where){     // 클릭된 아이템의 종류에 따라 상단 이미지 설정
            case 1:
                drawable = getResources().getDrawable(
                        R.drawable.gangdong);
                where_image = findViewById(R.id.where);
                where_image.setImageDrawable(drawable);
                break;
            case 2:
                drawable = getResources().getDrawable(
                        R.drawable.mapo);
                where_image = findViewById(R.id.where);
                where_image.setImageDrawable(drawable);
                break;
            case 3:
                drawable = getResources().getDrawable(
                        R.drawable.gangnam);
                where_image = findViewById(R.id.where);
                where_image.setImageDrawable(drawable);
                break;
            case 4:
                drawable = getResources().getDrawable(
                        R.drawable.jongno);
                where_image = findViewById(R.id.where);
                where_image.setImageDrawable(drawable);
                break;
        }

        // 카테고리 선택버튼
        ImageButton palace = findViewById(R.id.palace);
        ImageButton food = findViewById(R.id.food);
        ImageButton shop = findViewById(R.id.shop);
        ImageButton landmark = findViewById(R.id.landmark);
        ImageButton museum = findViewById(R.id.museum);
        ImageButton mount = findViewById(R.id.mount);
        ImageButton ent = findViewById(R.id.ent);
        ImageButton park = findViewById(R.id.park);
        ImageButton cancel = findViewById(R.id.cancel);
        ImageButton button_ok = findViewById(R.id.button_ok);

        TextView c_1 = findViewById(R.id.c_1);
        TextView c_2 = findViewById(R.id.c_2);
        TextView c_3 = findViewById(R.id.c_3);
        c_1.setTypeface(typeFace);
        c_2.setTypeface(typeFace);
        c_3.setTypeface(typeFace);

        category[0] = where;

        palace.setOnClickListener(v -> {
            if(choice_order<4){
                switch(choice_order){
                    case 1:
                        c_1.setText("전통유산") ;
                        break;
                    case 2:
                        c_2.setText("전통유산") ;
                        break;
                    case 3:
                        c_3.setText("전통유산") ;
                        break;
                }
                category[choice_order] = 8;
                if(choice_order<=2){
                    choice_order++;
                }

            }

        });
        food.setOnClickListener(v -> {
            if(choice_order<4){
                switch(choice_order){
                    case 1:
                        c_1.setText("먹거리") ;
                        break;
                    case 2:
                        c_2.setText("먹거리") ;
                        break;
                    case 3:
                        c_3.setText("먹거리") ;
                        break;
                }
                category[choice_order] = 3;
                if(choice_order<=2){
                    choice_order++;
                }
            }
        });
        landmark.setOnClickListener(v -> {
            switch(choice_order){
                case 1:
                    c_1.setText("랜드마크") ;
                    break;
                case 2:
                    c_2.setText("랜드마크") ;
                    break;
                case 3:
                    c_3.setText("랜드마크") ;
                    break;
            }
            if(choice_order<4){
                category[choice_order] = 2;
                if(choice_order<=2){
                    choice_order++;
                }
            }});
        museum.setOnClickListener(v -> {
            switch(choice_order){
                case 1:
                    c_1.setText("박물관") ;
                    break;
                case 2:
                    c_2.setText("박물관") ;
                    break;
                case 3:
                    c_3.setText("박물관") ;
                    break;
            }
            if(choice_order<4){
                category[choice_order] = 4;
                if(choice_order<=2){
                    choice_order++;
                }
            }
        });
        mount.setOnClickListener(v -> {
            if(choice_order<4){
                switch(choice_order){
                    case 1:
                        c_1.setText("자연") ;
                        break;
                    case 2:
                        c_2.setText("자연") ;
                        break;
                    case 3:
                        c_3.setText("자연") ;
                        break;
                }
                category[choice_order] = 7;
                if(choice_order<=2){
                    choice_order++;
                }
            }
        });
        ent.setOnClickListener(v -> {
            if(choice_order<4){
                switch(choice_order){
                    case 1:
                        c_1.setText("엔터테인먼트") ;
                        break;
                    case 2:
                        c_2.setText("엔터테인먼트") ;
                        break;
                    case 3:
                        c_3.setText("엔터테인먼트") ;
                        break;
                }
                category[choice_order] = 6;
                if(choice_order<=2){
                    choice_order++;
                }
            }
        });
        park.setOnClickListener(v -> {
            if(choice_order<4){
                switch(choice_order){
                    case 1:
                        c_1.setText("공원") ;
                        break;
                    case 2:
                        c_2.setText("공원") ;
                        break;
                    case 3:
                        c_3.setText("공원") ;
                        break;
                }
                category[choice_order] = 1;
                if(choice_order<=2){
                    choice_order++;
                }
            }
        });
        shop.setOnClickListener(v -> {
            if(choice_order<4){
                switch(choice_order){
                    case 1:
                        c_1.setText("쇼핑") ;
                        break;
                    case 2:
                        c_2.setText("쇼핑") ;
                        break;

                    case 3:
                        c_3.setText("쇼핑") ;
                        break;
                }
                category[choice_order] = 5;
                if(choice_order<=2){
                    choice_order++;
                }
            }
        });
        cancel.setOnClickListener((View.OnClickListener) v -> {
            if(choice_order > 0){
                // 단순 취소와 누적 취소를 비교해야해
                switch(choice_order){
                    case 1:
                        c_1.setText("  ") ;
                        break;
                    case 2:
                        if(c_2.getText() == "  "){
                            c_1.setText("  ");
                            choice_order--;}
                        else
                            c_2.setText("  ") ;
                        break;
                    case 3:
                        if(c_3.getText() == "  "){
                            c_2.setText("  ");
                            choice_order--;}
                        else
                            c_3.setText("  ") ;
                        break;
                }
                category[choice_order] = 0;
                Log.d("*", String.valueOf(choice_order));
            }
        });
        button_ok.setOnClickListener(v -> {
            if(category[1]==0 || category[2]==0 || category[3]==0){
                Toast.makeText(getApplicationContext(),
                        "테마를 세 가지 모두 선택하십시오.", Toast.LENGTH_SHORT).show();
            }
            else if((category[1]!=category[2])&&(category[2]!=category[3])&&(category[1]!=category[3])){
                Intent intent1 = new Intent(ChooseActivity.this, ChooseResultActivity.class);
                Bundle bundle1 = new Bundle();

                bundle1.putIntArray("category", category);
                intent1.putExtras(bundle1);
                startActivity(intent1);
            }
            else{
                Toast.makeText(getApplicationContext(),
                        "중복되는 테마가 있습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        choice_order = 1;
        TextView c_1 = findViewById(R.id.c_1);
        TextView c_2 = findViewById(R.id.c_2);
        TextView c_3 = findViewById(R.id.c_3);

        c_1.setText("  ") ;
        c_2.setText("  ") ;
        c_3.setText("  ") ;
    }
}



