/**
 * 저장된 csv 값에서 입력으로 들어온 경우(테마 분류가 같은 경우) 찾아주는 코드
 */

package com.example.algorithm_seoultour.model;

import android.content.Context;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.example.algorithm_seoultour.R;
import com.example.algorithm_seoultour.data.Data;
import com.example.algorithm_seoultour.data.Data2;
import com.opencsv.CSVReader;

public class find_code {
    int area;
    int sort1;
    int sort2;
    int sort3;

    public Data ans1;
    public Data ans2;
    public Data ans3;

    Boolean Is_there = true;
    Boolean Error = false;

    Context context;

    public find_code(int area, int sort1, int sort2, int sort3, Context context) {
        this.area = area;
        this.sort1 = sort1;
        this.sort2 = sort2;
        this.sort3 = sort3;
        this.context = context;
    }

    public void find_code_main() throws IOException {

        Data[] func1 = get_exe1();

        int find[] = new int[3];
        // 강동 1, 강서 2, 강남 3, 강북 4
        int[][] arr1 = new int[336][7];
        int[][] arr2 = new int[120][7];
        int[][] arr3 = new int[210][7];
        int[][] arr4 = new int[336][7];

        // 이 부분 코드 줄이고 싶게 생겼네
        int ln = 0;
        try{
            BufferedReader file1 = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.gangdong)));
            while (true) {
                String line = file1.readLine();
                if (line == null) break;

                String splitline[] = line.split(" ");

                for (int i = 0; i < 7; i++)
                    arr1[ln][i] = Integer.parseInt(splitline[i]);
                ln++;
            }
        }catch (IOException e){
            Error = true;
        }

        int ln2 = 0;
        try{
        BufferedReader file2 = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.gangseo)));
        while (true) {
            String line2 = file2.readLine();
            if (line2 == null) break;

            String splitline2[] = line2.split(" ");

            for (int i = 0; i < 7; i++)
                arr2[ln2][i] = Integer.parseInt(splitline2[i]);
            ln2++;
        }}catch (IOException e){
            Error = true;
        }

        int ln3 = 0;
        try{
        BufferedReader file3 = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.gangnam)));
        while (true) {
            String line3 = file3.readLine();
            if (line3 == null) break;

            String splitline3[] = line3.split(" ");

            for (int i = 0; i < 7; i++)
                arr3[ln3][i] = Integer.parseInt(splitline3[i]);
            ln3++;
        }}catch (IOException e){
            Error = true;
        }

        int ln4 = 0;
        try{
        BufferedReader file4 = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.gangbuk)));
        while (true) {
            String line4 = file4.readLine();
            if (line4 == null) break;

            String splitline4[] = line4.split(" ");

            for (int i = 0; i < 7; i++)
                arr4[ln4][i] = Integer.parseInt(splitline4[i]);
            ln4++;
        }
        }catch (IOException e){
            Error = true;
        }

        int i = 0;
        if (area == 1) {  // 강동, arr1
            for (i = 0; i < 336; i++) {
                if (arr1[i][1] == sort1) {
                    if (arr1[i][2] == sort2) {
                        if (arr1[i][3] == sort3) {
                            find[0] = arr1[i][4];
                            find[1] = arr1[i][5];
                            find[2] = arr1[i][6];  // find에 순서대로 해당 장소의 번호 들어감
                            break;
                        }
                    }
                }
            }
            if (i == 336){
                this.Is_there = false;
                return;

            }

        }

        int j = 0;
        if (area == 2) {  // 강서, arr2
            for (j = 0; j < 120; j++) {
                if (arr2[j][1] == sort1) {
                    if (arr2[j][2] == sort2) {
                        if (arr2[j][3] == sort3) {
                            find[0] = arr2[j][4];
                            find[1] = arr2[j][5];
                            find[2] = arr2[j][6];  // find에 순서대로 해당 장소의 번호 들어감
                            break;
                        }
                    }
                }
            }
            if (i == 120){
                this.Is_there = false;
                return;

            }
        }

        int k = 0;
        if (area == 3) {  // 강남, arr3
            for (k = 0; k < 210; k++) {
                if (arr3[k][1] == sort1) {
                    if (arr3[k][2] == sort2) {
                        if (arr3[k][3] == sort3) {
                            find[0] = arr3[k][4];
                            find[1] = arr3[k][5];
                            find[2] = arr3[k][6];  // find에 순서대로 해당 장소의 번호 들어감
                            break;
                        }
                    }
                }
            }
            if (i == 210){
                this.Is_there = false;
                return;

            }
        }

        int l = 0;
        if (area == 4) {  // 강북, arr4
            for (l = 0; l < 336; l++) {
                if (arr4[l][1] == sort1) {
                    if (arr4[l][2] == sort2) {
                        if (arr4[l][3] == sort3) {
                            find[0] = arr4[l][4];
                            find[1] = arr4[l][5];
                            find[2] = arr4[l][6];  // find에 순서대로 해당 장소의 번호 들어감
                            break;
                        }
                    }
                }
            }
            if (i == 336){
                this.Is_there = false;
                return;

            }
        }

        //find에 값 저장되어 있고 이제 찾아주면 됨
        for (i = 0; i < 167; i++) {
            if (find[0] == func1[i].dnum) {
                this.ans1 = func1[i];
            }

            if (find[1] == func1[i].dnum) {
                this.ans2 = func1[i];
            }

            if (find[2] == func1[i].dnum) {
                this.ans3 = func1[i];
            }
        }

        Data[] ans4 = new Data[18];
        //범주랑 장소 같나 체크하고 순위대로 ans4에 할당

    }

    public Data[] get_exe1() throws IOException{
        Data[] data_arr = new Data[167];
        int ln = 0;
        try {
            CSVReader file0 = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.third_info)));
            List<String[]> line = file0.readAll();
            while (ln < 168) {
                String[] sArrays = line.get(ln);
                if (sArrays == null) break;
                if(ln!=0)
                data_arr[ln-1] = new Data(Integer.parseInt(sArrays[0]), Integer.parseInt(sArrays[1]), Integer.parseInt(sArrays[2]), Double.parseDouble(sArrays[3]), Double.parseDouble(sArrays[4]), sArrays[5], sArrays[6], sArrays[7]);
                ln++;
            }

        }catch (IOException e){
            Error = true;
        }
        return data_arr;
    }

    public Data2[] get_exe2() throws IOException {
        Data2[] data_arr = new Data2[167];

        int ln = 0;

        try {
            CSVReader file0 = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.forth_info)));
            List<String[]> line = file0.readAll();

            while (ln < 168) {
                String[] sArrays = line.get(ln);
                if (sArrays == null) break;

                if(ln!=0)
                data_arr[ln-1] = new Data2(Integer.parseInt(sArrays[0]), Integer.parseInt(sArrays[1]), Integer.parseInt(sArrays[2]), Integer.parseInt(sArrays[3]), Double.parseDouble(sArrays[4]), Double.parseDouble(sArrays[5]), sArrays[6], sArrays[7], sArrays[8]);
                ln++;
            }

        } catch (IOException e) {
            Error = true;
        }
        return data_arr;
    }

    public String[] test() throws IOException{
        CSVReader file0 = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.forth_info)));
        List<String[]> line = file0.readAll();
        String[] sArrays = line.get(0);
        return sArrays;
    }

}






