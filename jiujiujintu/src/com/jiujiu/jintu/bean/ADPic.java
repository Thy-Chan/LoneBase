package com.jiujiu.jintu.bean;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * ���ͼƬ
 * 
 * @author mpqi-i7
 *
 */
@AVClassName("ADPic")
public class ADPic extends AVObject {
	private String imgUrl;
	private String adType;//����
	private int position; //�±�ָ��

	public final static String IMGURL_TEXT = "imgUrl";
	public final static String ADTYPE_TEXT = "adType";
	public final static String POSTION_TEXT = "position";

	public final static String TYPE_INDEX_PHONE = "index_phone";// ��ҳ�ֻ�����
	public final static String TYPE_INDEX_THEME = "index_theme";// ��ҳ������
	public final static String TYPE_INDEX_TOP = "index_top";// �����Ử���

	public ADPic() {
	}

	public String getImgUrl() {
		return getString(IMGURL_TEXT);
	}

	public void setImgUrl(String imgUrl) {
		put(IMGURL_TEXT, imgUrl);
	}

	public String getAdType() {
		return getString(ADTYPE_TEXT);
	}

	public void setAdType(String adType) {
		put(ADTYPE_TEXT, adType);
	}

	public int getPosition() {
		return getInt(POSTION_TEXT);
	}

	public void setPosition(int position) {
		put(POSTION_TEXT, position);
	}

}
