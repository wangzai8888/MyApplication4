
package cn.edu.sdwu.android.home.sn170507180106;

import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {
    private int q=0;
    private String[] temp=null;
    private ArrayList<String[]> list=new ArrayList<String[]>();
    private long beg_time;
    private long end_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_question);
        Resources res = getResources();
        String[] question=this.getResources().getStringArray(R.array.testTitle);
        temp=question;
        String[] an1=this.getResources().getStringArray(R.array.testOption1);
        String[] an2=this.getResources().getStringArray(R.array.testOption2);
        String[] an3=this.getResources().getStringArray(R.array.testOption3);
        final int[] answer=this.getResources().getIntArray(R.array.anwser);
        TextView textView=(TextView) findViewById(R.id.que);//问题框
        final TextView notice=(TextView) findViewById(R.id.notic);//计数框
        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.answer_rg);
        RadioButton rb1=(RadioButton)findViewById(R.id.an1);
        RadioButton rb2=(RadioButton)findViewById(R.id.an2);
        RadioButton rb3=(RadioButton)findViewById(R.id.an3);
        RadioButton rb4=(RadioButton)findViewById(R.id.an4);
        list.add(an1);
        list.add(an2);
        list.add(an3);
        textView.setText(question[q]);
        rb1.setText(list.get(q)[0]);
        rb2.setText(list.get(q)[1]);
        rb3.setText(list.get(q)[2]);
        rb4.setText(list.get(q)[3]);


        textView.setVisibility(View.INVISIBLE);//隐藏
        notice.setVisibility(View.INVISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);
        Button button=(Button)findViewById(R.id.bt_begin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                beg_time= System.currentTimeMillis();
                beg_time/=1000;
                TextView textView=(TextView) findViewById(R.id.que);//问题框
              TextView notice=(TextView) findViewById(R.id.notic);//计数框
              RadioGroup radioGroup=(RadioGroup) findViewById(R.id.answer_rg);
              textView.setVisibility(View.VISIBLE);//显示
              notice.setVisibility(View.VISIBLE);
              radioGroup.setVisibility(View.VISIBLE);
                view.setEnabled(false);//按钮禁用
            }
        });




        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            TextView textView = (TextView) findViewById(R.id.que);//问题框
            RadioButton rb1 = (RadioButton) findViewById(R.id.an1);
            RadioButton rb2 = (RadioButton) findViewById(R.id.an2);
            RadioButton rb3 = (RadioButton) findViewById(R.id.an3);
            RadioButton rb4 = (RadioButton) findViewById(R.id.an4);
            int fina=0;
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                radioGroup.setOnCheckedChangeListener(null);//取消监听
                if(rb1.isChecked()) {
                    if(answer[q]==1){
                        fina++;
                    }
                    radioGroup.clearCheck();
                }else if(rb2.isChecked()) {
                    if(answer[q]==2){
                        fina++;
                    }
                    radioGroup.clearCheck();
                }else if(rb3.isChecked()) {
                    if(answer[q]==3){
                        fina++;
                    }
                    radioGroup.clearCheck();
                }else if(rb4.isChecked()) {
                    if(answer[q]==4){
                        fina++;
                    }
                    radioGroup.clearCheck();
                }
                radioGroup.setOnCheckedChangeListener(this);//开启监听

                Log.i(QuestionActivity.this.toString(),String.valueOf(fina));
                String res="";
                q++;
                TextView notic=(TextView)findViewById(R.id.notic);
                notic.setText(getString(R.string.get_current,q,3-q));
                if(q<3){
                    textView.setText(temp[q]);
                    rb1.setText(list.get(q)[0]);
                    rb2.setText(list.get(q)[1]);
                    rb3.setText(list.get(q)[2]);
                    rb4.setText(list.get(q)[3]);
                }
                if(q==3){
                    end_time= System.currentTimeMillis();
                    end_time/=1000;
                    long total=end_time-beg_time;
                    res+="用时共:"+total+"s"+"您答对了"+fina+"道题，"+"您答错了"+(3-fina)+"道题";
                    radioGroup.setVisibility(View.INVISIBLE);
                    Toast.makeText(QuestionActivity.this,res,Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}
