package cn.edu.sdwu.android.home.sn170507180106;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.edu.sdwu.android.home.sn170507180207.homework.R.id.parent;

public class ProduceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_produce);

        final String[] pro_name=this.getResources().getStringArray(R.array.prodArr);
        //获取spinner列表
        final String[] pro_kind=this.getResources().getStringArray(R.array.catArr);

        //全部产品名称
        final String[] total_proname = new String[pro_name.length];
        System.arraycopy(pro_name, 0, total_proname, 0, pro_name.length);
        //全部种类名称
        final String[] total_kindname = new String[pro_kind.length];
        System.arraycopy(pro_kind, 0, total_kindname, 0, pro_kind.length);



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,pro_kind);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner=(Spinner)findViewById(R.id.pro_spinner);
        spinner.setAdapter(adapter);

        final EditText editText = (EditText) findViewById(R.id.select);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                String selectname = "";
                String selectkind="";
                for (int n = 0; n < total_proname.length; n++) {
                    if(total_proname[n].contains(s) ){
                        selectname+=total_proname[n]+",";
                        selectkind+=total_kindname[n]+",";
                    }else if(total_kindname[n].contains(s)){
                        selectname+=total_proname[n]+",";
                        selectkind+=total_kindname[n]+",";
                    }
                }
                String[] selname = selectname.split(",");
                String[] selkind = selectkind.split(",");

                List lists = new ArrayList<>();

                for (int i = 0; i < selname.length; i++) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("selname", selname[i]);
                    map.put("selkind", selkind[i]);
                    map.put("img", R.drawable.sample_thumb_2);
                    lists.add(map);
                }
                //适配器指定应用自己定义的xml格式
                if(lists.isEmpty()){
                    SimpleAdapter sadapter = new SimpleAdapter(ProduceActivity.this, lists,R.layout.layout_show, null, null);
                    ListView listView = (ListView) findViewById(R.id.pro_show);
                    listView.setAdapter(sadapter);
                }else{
                SimpleAdapter sadapter = new SimpleAdapter(ProduceActivity.this, lists,R.layout.layout_show, new String[]{"selname", "selkind", "img"}, new int[]{ R.id.produce_tv, R.id.pro_kind,R.id.produce_img});
                ListView listView = (ListView) findViewById(R.id.pro_show);
                listView.setAdapter(sadapter);
                }

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                List lists = new ArrayList<>();
                Map<String, Object> map = new HashMap<>();
                map.put("proname", pro_name[position]);
                map.put("prokind", pro_kind[position]);
                map.put("pmovie", R.drawable.sample_thumb_2);
                lists.add(map);
                SimpleAdapter sadapter = new SimpleAdapter(ProduceActivity.this, lists,R.layout.layout_show, new String[]{"proname", "prokind", "pmovie"}, new int[]{ R.id.produce_tv, R.id.pro_kind,R.id.produce_img});
                ListView listView = (ListView) findViewById(R.id.pro_show);
                listView.setAdapter(sadapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
