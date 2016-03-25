package com.mpqi.myjiujiujintu.bean;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * ���β�Ʒ
 * 
 * @author mpqi-i7
 *
 */
@AVClassName("TourismProduct")
public class TourismProduct extends AVObject {
	private String imgTitleUrl;// ����ͼƬ
	private String title;// ����
	private String priceNew;// ���ۺ���¼�
	private String priceOld;// ԭ��
	private String atisfaction;// �����

	private final String imgTitleUrl_TEXT = "imgTitleUrl";
	private final String title_TEXT = "title";
	private final String priceNew_TEXT = "priceNew";
	private final String priceOld_TEXT = "priceOld";
	private final String atisfaction_TEXT = "atisfaction";

	public TourismProduct() {
	}
	
	public String getImgTitleUrl() {
		return getString(imgTitleUrl_TEXT);
	}

	public void setImgTitleUrl(String imgTitleUrl) {
		put(imgTitleUrl_TEXT, imgTitleUrl);
	}

	public String getTitle() {
		return getString(title_TEXT);
	}

	public void setTitle(String title) {
		put(title_TEXT, title);
	}

	public String getPriceNew() {
		return getString(priceNew_TEXT);
	}

	public void setPriceNew(String priceNew) {
		put(priceNew_TEXT, priceNew);
	}

	public String getPriceOld() {
		return getString(priceOld_TEXT);
	}

	public void setPriceOld(String priceOld) {
		put(priceOld_TEXT, priceOld);
	}

	public String getAtisfaction() {
		return getString(atisfaction_TEXT);
	}

	public void setAtisfaction(String atisfaction) {
		put(atisfaction_TEXT, atisfaction);
	}

}
