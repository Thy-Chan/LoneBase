package com.mpqi.mylistviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SimpleAdapterDemoActivity extends Activity {
	private ListView myListView;
	private List<HashMap<String, Object>> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myListView  =  (ListView) findViewById(R.id.list);
		
		int[] to = new int[]{R.id.simple_img,R.id.simple_name,R.id.simple_sex};
		getData();
		String[] from = new String[]{"image","sex","name"};
	
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.simpleitem, from, to);
		
		myListView.setAdapter(adapter);
	}
	
	private void getData(){
		data = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("image", R.drawable.bierde_43);
		map1.put("name", "张三");
		map1.put("sex", "男");
		data.add(map1);
		
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("image", R.drawable.bierde_44);
		map2.put("name", "张三22222");
		map2.put("sex", "男22222");
		data.add(map2);
		
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("image", R.drawable.bierde_45);
		map3.put("name", "张三111111");
		map3.put("sex", "男111111");
		data.add(map3);
		
		HashMap<String, Object> map4 = new HashMap<String, Object>();
		map4.put("image", R.drawable.bierde_46);
		map4.put("name", "张三44444");
		map4.put("sex", "男44444");
		data.add(map4);
		
		HashMap<String, Object> map5 = new HashMap<String, Object>();
		map5.put("image", R.drawable.bierde_47);
		map5.put("name", "张三5555555");
		map5.put("sex", "男555555");
		data.add(map5);
		
		HashMap<String, Object> map6 = new HashMap<String, Object>();
		map6.put("image", R.drawable.bierde_48);
		map6.put("name", "张三66666661");
		map6.put("sex", "男166666");
		data.add(map6);
		
		HashMap<String, Object> map7 = new HashMap<String, Object>();
		map7.put("image", R.drawable.bierde_43);
		map7.put("name", "张三655555561");
		map7.put("sex", "男13333336");
		data.add(map7);
	}
}
