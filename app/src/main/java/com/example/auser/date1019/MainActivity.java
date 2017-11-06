package com.example.auser.date1019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //先定義會跟使用者互到的部份
    Button btn_prev, btn_next;
    ImageView img_show;
    TextView show_location, show_date;
    EditText edt_show;
    int[] imgId = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6};
    String[] locationId={"台北","新竹","台南","台中","彰化","高雄"};
    int p = 0; //存放照片的索弔值
    int count = imgId.length;

    //    --------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_prev=(Button)findViewById(R.id.btnPre);
        btn_next=(Button)findViewById(R.id.btnNext);

        show_location=(TextView)findViewById(R.id.showLocation);
        show_date=(TextView)findViewById(R.id.showDate);
        edt_show=(EditText)findViewById(R.id.editShow);
        img_show=(ImageView)findViewById(R.id.imageShow);
//        btn_prev.setOnClickListener(btnprelistener);
//        btn_next.setOnClickListener(btnnextlistener);
        //改良呼叫同一個方法
        btn_prev.setOnClickListener(listener);
        btn_next.setOnClickListener(listener);



    }
        private Button.OnClickListener listener= new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId()){
                    case R.id.btnPre:
                        p--;
                        if (p==0 ) {
                            Toast toast=Toast.makeText(getApplicationContext()
                                    ,"你好,目前已經到第一張",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,100);
                            toast.show();

                        }
//                            Toast.makeText(MainActivity.this,"你好,目前已經到第一張",Toast.LENGTH_SHORT).show();

                        if (p<0) p=count-1;//回到最後一張

                        break;
                    case R.id.btnNext:
                            p++;
                        if (p==count-1)  {
                            Toast toast=Toast.makeText(getApplicationContext()
                                    ,"你好,目前已經到最後一張",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,130);
                            toast.show();
                        }

                        if (p==count)          p=0;
                        break;
                }
                img_show.setImageResource(imgId[p]);
                show_location.setText(locationId[p]);
                edt_show.setText("說明: 在" +locationId[p]+"這裏玩");


            }
        };
//
//    private Button.OnClickListener btnprelistener= new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            p--;
//            if (p<0) p=count-1;//回到最後一張
//
//            img_show.setImageResource(imgId[p]);
//            show_location.setText(locationId[p]);
//            edt_show.setText("說明: 在" +locationId[p]+"這裏玩");
//
//        }
//    };
//
//    private Button.OnClickListener btnnextlistener= new Button.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            p++;
//            if (p==count)  p=0;
//            img_show.setImageResource(imgId[p]);
//            show_location.setText(locationId[p]);
//            edt_show.setText("說明: 在" +locationId[p]+"這裏玩");
//        }
//    };
}
