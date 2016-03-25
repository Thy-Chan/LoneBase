package com.mpqi.myjiujiujintu.bean;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

@AVClassName("City")
public class City extends AVObject {
	public static String CITYNAME_TEXT = "cityName";// ��������
	public static String SORT_TEXT = "sort";// ����ĸ����
	public static String PINYIN_TEXT = "pinyin";// ƴ��
	public static String HOTNUM_TEXT = "hotNum";//���ų������� 

	public final String getCityName() {
		return getString(CITYNAME_TEXT);
	}

	public City() {
	}

	public void setCityName(String cityName) {
		put(CITYNAME_TEXT, cityName);
	}

	public String getSort() {
		return getString(SORT_TEXT);
	}

	public void setSort(String sort) {
		put(SORT_TEXT, sort);
	}

	public String getPinyin() {
		return getString(PINYIN_TEXT);
	}

	public void setPinyin(String pinyin) {
		put(PINYIN_TEXT, pinyin);
	}

	public String getHotNum() {
		return getString(HOTNUM_TEXT);
	}

	public void setHotNum(int hotNum) {
		put(HOTNUM_TEXT, hotNum);
	}
}
