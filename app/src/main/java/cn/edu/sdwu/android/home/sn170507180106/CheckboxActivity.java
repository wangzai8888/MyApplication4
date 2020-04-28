package cn.edu.sdwu.android.home.sn170507180106;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CheckboxActivity extends AppCompatActivity {
    String content="";
    private ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        list=new ArrayList();
        //通过界面的容器，找到他所包含的所有子元素，再来注册监听器
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ckbox_ll);
        int count=linearLayout.getChildCount();
        for(int i=0;i<count;i++){
            View view=linearLayout.getChildAt(i);
            if(view instanceof CheckBox)//如果当前对象是checkbox的实例
            {
                final CheckBox checkBox=(CheckBox)view;
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        //参数b代表是否选中,第一个参数代表当前选中的checkbox
                        if(b){
                            list.add(compoundButton);
                        }else{
                            list.remove(compoundButton);
                        }
                        content="you select:";
                        for(int t=0;t<list.size();t++) {
                            CheckBox checkBox1 = (CheckBox) list.get(t);
                            String sel = checkBox1.getText().toString();
                            if (t != list.size() - 1) {
                                content += sel + ",";
                            } else {
                                content += sel;
                            }
                        }
                    }
                });
            }
        }
    }
    public void check(View view){
        Toast.makeText(getApplicationContext(),content,Toast.LENGTH_LONG).show();
    }

}
