package com.mpqi.viewpagerdemo.fragment;

import com.mpqi.viewpagerdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TestFragment extends Fragment {

	public static TestFragment newInstance(String s) {
		TestFragment fragment = new TestFragment();
		Bundle bundle = new Bundle();
		bundle.putString("hello", s);
		fragment.setArguments(bundle);
		// bundle��������ÿ����ǩ�ﴫ������
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Bundle bundle = getArguments();
		String str = bundle.getString("hello", "��������������");
		View view = inflater.inflate(R.layout.layout2, null);
		TextView textView = (TextView) view.findViewById(R.id.layout_text);
		textView.setText(str);
		return view;
	}
}
