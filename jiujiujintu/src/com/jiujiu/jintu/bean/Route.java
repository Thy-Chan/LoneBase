package com.jiujiu.jintu.bean;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * �г�
 * @author mpqi-i7
 *
 */
@AVClassName("Route")
public class Route extends AVObject{
	private TourismProduct tourismProduct;//���β�Ʒ
	private String title;//����
	private String titleIcon;//����Icon
	private String titleType;//��������
	private int position;//˳��λ��
	private String content;//��������
}
