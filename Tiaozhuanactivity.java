package test.bwie.com.recyclerview_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import test.bwie.com.recyclerview_.adapter.ListAdapter;
import test.bwie.com.recyclerview_.bean.JavaBean;

public class Tiaozhuanactivity extends AppCompatActivity {
    ArrayList<JavaBean> listSure;
    private Button all, opposite;
    private RecyclerView rv;
   // private MyRecyclerViewAdapter adapter;
    private Button sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        rv.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter adapter = new ListAdapter(listSure, this);
        rv.setAdapter(adapter);
    }
    private void initData() {
        Intent intent=getIntent();
        listSure= (ArrayList<JavaBean>) intent.getSerializableExtra("name");
    }

    private void initView() {
        all = (Button) findViewById(R.id.all);
        opposite = (Button) findViewById(R.id.no_all);
        sure = (Button) findViewById(R.id.commit);
//        all.setVisibility(View.GONE);
//        opposite.setVisibility(View.GONE);
        sure.setVisibility(View.GONE);
        rv = (RecyclerView) findViewById(R.id.list);
    }

}
