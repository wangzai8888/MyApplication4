package cn.edu.sdwu.android.home.sn170507180106;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class operation  extends AppCompatActivity implements View.OnClickListener{
    EditText num_1,num_2;
    TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_operation);

        num_1=(EditText)findViewById(R.id.home_num1);
        num_2=(EditText)findViewById(R.id.home_num2);
        textView=(TextView)findViewById(R.id.home_res);

        Button button_add=(Button)findViewById(R.id.home_add);
        button_add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String et1=num_1.getText().toString();
                String et2=num_2.getText().toString();
                float num1=Integer.valueOf(et1).floatValue();
                float num2=Integer.valueOf(et2).floatValue();
                num1=num1+num2;
                et1=String.valueOf(num1);
                textView.setText(et1);
            }
        });
        Button button_sub=(Button)findViewById(R.id.home_sub);
        button_sub.setOnClickListener(new MyClickListener());

        Button button_mul=(Button)findViewById(R.id.home_mul);
        button_mul.setOnClickListener(this);


    }
    public void onClick(View v){
        num_1=(EditText)findViewById(R.id.home_num1);
        num_2=(EditText)findViewById(R.id.home_num2);
        textView=(TextView)findViewById(R.id.home_res);
        String et1=num_1.getText().toString();
        String et2=num_2.getText().toString();
        float num1=Integer.valueOf(et1).floatValue();
        float num2=Integer.valueOf(et2).floatValue();
        num1=num1*num2;
        et1=String.valueOf(num1);
        textView.setText(et1);
    }
    public class MyClickListener implements View.OnClickListener{
        public void onClick(View view){
            num_1=(EditText)findViewById(R.id.home_num1);
            num_2=(EditText)findViewById(R.id.home_num2);
            textView=(TextView)findViewById(R.id.home_res);
            String et1=num_1.getText().toString();
            String et2=num_2.getText().toString();
            float num1=Integer.valueOf(et1).floatValue();
            float num2=Integer.valueOf(et2).floatValue();
            num1=num1-num2;
            et1=String.valueOf(num1);
            textView.setText(et1);
        }
    }
    public void divNum(View view){
        num_1=(EditText)findViewById(R.id.home_num1);
        num_2=(EditText)findViewById(R.id.home_num2);
        textView=(TextView)findViewById(R.id.home_res);
        String et1=num_1.getText().toString();
        String et2=num_2.getText().toString();
        float num1=Integer.valueOf(et1).floatValue();
        float num2=Integer.valueOf(et2).floatValue();
        num1=num1/num2;
        et1=String.valueOf(num1);
        textView.setText(et1);
    }
}
