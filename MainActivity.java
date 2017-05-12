package test.bwie.com.recyclerview_;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import test.bwie.com.recyclerview_.adapter.ListAdapter;
import test.bwie.com.recyclerview_.bean.JavaBean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //private List<String> list;
    private ListAdapter adapter;
    private Button commit;
    List<JavaBean> list = new ArrayList<>();
    ArrayList<JavaBean> listSure = new ArrayList<>();
    private Map<Integer, Boolean> map;
    private Map<Integer, Boolean> map1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        findViewById(R.id.commit).setOnClickListener(this);
        commit = (Button) findViewById(R.id.commit);

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (JavaBean jb : list) {
                    if (jb.isCheck()) {
                        listSure.add(jb);
                        ///Log.d("v-----------",listSure.toString());
                    }
                }
               Intent intent= new Intent(MainActivity.this,Tiaozhuanactivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("name",listSure);
                intent.putExtras(bundle);
                startActivity(intent);
                listSure.clear();
            }
//            adapter.notifyDataSetChanged();

        });

        initData();
        //布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        adapter = new ListAdapter(list, this);
        recyclerView.setAdapter(adapter);
        //添加分割线
        recyclerView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
        adapter.setRecyclerViewOnItemClickListener(new ListAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                //设置选中的项
                adapter.setSelectItem(position);
            }

            @Override
            public boolean onItemLongClickListener(View view, int position) {
                adapter.setShowBox();
                //设置选中的项
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        //获取你选中的item
        map1 = adapter.getMap();
        for (int i = 0; i < map1.size(); i++) {
            if (map1.get(i)) {
                Log.d("TAG", "你选了第：" + i + "项");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //全选
            case R.id.all:
//                Map<Integer, Boolean> map =  adapter.getMap();
//                for (int i = 0; i < map.size(); i++) {
//                    map.put(i, true);
//                    adapter.notifyDataSetChanged();
//                }
                for (JavaBean jb : list) {
                    jb.setCheck(true);
                    adapter.notifyDataSetChanged();
                }
                break;
            //全不选
            case R.id.no_all:
//                Map<Integer, Boolean> m = adapter.getMap();
//                for (int i = 0; i < m.size(); i++) {
//                    m.put(i, false);
//                    adapter.notifyDataSetChanged();
//                }
                for (JavaBean jb : list) {
                    if (jb.isCheck()) {
                        jb.setCheck(false);
                    } else {
                        jb.setCheck(true);
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 为列表添加测试数据
     */
    private void initData() {
//        File directory = Environment.getExternalStorageDirectory();
//        File[] files = directory.listFiles();
       // list = new ArrayList<>();
//        for (File file : files) {
//            list.add(file.getName());


//        list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            list.add("条目"+i);
//        }
        for (int i = 0; i < 20; i++) {
            list.add(new JavaBean("条目" + i, false));
        }
        }
    }
//}

