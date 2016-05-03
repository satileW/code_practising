package com.lenovo.snakemat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed =(EditText)findViewById(R.id.editText);
    }

    public void calculateSnakeMat(View view) {
        Integer N = Integer.parseInt(ed.getText().toString());
        int a[][]=new int[N][N];
        int top=0,left=0,bottom=N-1,right=N-1;
        int i,j,k=0;
        while ((bottom-top)>0&&(right-left)>0){
            i=top;j=left;
            for (;j<=right;j++){
                a[i][j]=k;
                k++;
            }
            top++;

            j=right;
            for(;i<bottom;){
                i++;
                a[i][j]=k;
                k++;
            }
            right--;

            i=bottom;
            for (;j>left;){
                j--;
                a[i][j]=k;
                k++;
            }
            bottom--;

            j=left;
            for (;i>top;){
                i--;
                a[i][j]=k;
                k++;
            }
            left++;

        }
        if (N%2==1){
            int center = (N-1)/2;
            a[center][center]=k;
        }
        StringBuffer aa =new StringBuffer();
        for (i=0;i<N;i++){
            for (j=0;j<N;j++){
               aa.append(a[i][j]+"_");
            }
        }
        Log.e("wmwm", String.valueOf(aa));
    }
}
