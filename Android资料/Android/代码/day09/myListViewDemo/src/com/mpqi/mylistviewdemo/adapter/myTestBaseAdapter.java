package com.mpqi.mylistviewdemo.adapter;

import java.util.List;

import com.mpqi.mylistviewdemo.R;
import com.mpqi.mylistviewdemo.bean.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myTestBaseAdapter extends BaseAdapter {

	private Context context;// ��ǰ�Ự
	private List<User> list;// ����Դ
	private LayoutInflater inflater;// ���� View ������ 

	public myTestBaseAdapter(Context context, List<User> list) {
		super();
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	private class holver{//����ÿһ�������ڲ��Ŀؼ�
		ImageView headImageView;//ͷ��
		TextView nameTextView;//����
		TextView sexTextView;//�Ա�
	}
	
	@Override
	public int getCount() {// ��ȡ�������ݵĳ���
		return list.size();
	}

	@Override
	public Object getItem(int position) {// ��ȡָ���±��������ݶ���
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {// ��ȡ����ID �� �±�
		return list.get(position).getUserid();
	}

	@Override
	// ��ȡÿ��item ���еĲ��ֿؼ� ����
	public View getView(int position, View convertView, ViewGroup parent) {

		holver h = null;
		
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.simpleitem, null);
			h = new holver();
			// ��ȡ�ؼ� ������
			h.headImageView = (ImageView) convertView
					.findViewById(R.id.simple_img);
			h.nameTextView = (TextView) convertView
					.findViewById(R.id.simple_name);
			h.sexTextView = (TextView) convertView
					.findViewById(R.id.simple_sex);
			convertView.setTag(h);
			
		}else {
			h = (holver) convertView.getTag();
		}

		User user = list.get(position);

		h.headImageView.setImageResource(user.getHeadImage());
		h.nameTextView.setText(user.getName());
		h.sexTextView.setText(user.getSex());
		

		return convertView;
	}

}
