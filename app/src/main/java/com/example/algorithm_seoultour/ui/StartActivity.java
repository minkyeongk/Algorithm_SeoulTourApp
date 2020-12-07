/**
 * 앱 실행 시 호출되는 액티비티
 */

package com.example.algorithm_seoultour.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.example.algorithm_seoultour.R;
import com.example.algorithm_seoultour.ui.main.MainActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class StartActivity extends AppCompatActivity {
    Handler handler = new Handler();
    Runnable r = () -> {
        // 4초뒤에 다음화면(MainActivity)으로 넘어가기 Handler 사용
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);  // 다음화면으로 넘어가기
        finish();   // Activity 화면 제거
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);     // xml과 java코드 연결
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(r, 4000); // 4초 뒤에 Runnable 객체 수행
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 화면을 벗어나면, handler에 예약해놓은 작업 취소
        handler.removeCallbacks(r); // 예약 취소
    }
}
