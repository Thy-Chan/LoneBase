package com.jiujiu.jintu.util;

public class IMGSize {
	private static String imageView = "?imageView/";// ����ָ����������ͼ
	private static String imageMogr = "?imageMogr/v2/auto-orient/";// �ü�ͼƬ

	/**
	 * ����ָ����������ͼ
	 * 
	 * @param url
	 *            ͼƬ��ַ ������Ϊ��
	 * @param w
	 *            �� ����Ϊ��
	 * @param h
	 *            �� ����Ϊ��
	 * 
	 * @param mode
	 *            ����ģʽ
	 * @return <ImageDownloadURL>?imageView/<mode> /w/<Width>
	 *         /h/<Height>/q/<Quality> /format/<Format>
	 * 
	 *         http://qiniuphotos.qiniudn.com/gogopher.jpg?imageView/1/w/200/h/
	 *         200
	 * 
	 *         <mode> ͼ�����Դ����ģʽ <Width> ָ��Ŀ������ͼ�Ŀ�ȣ���λ�����أ�px�� <Height>
	 *         ָ��Ŀ������ͼ�ĸ߶ȣ���λ�����أ�px <Quality> ָ��Ŀ������ͼ��ͼ��������ȡֵ��Χ 1-100 <Format>
	 *         ָ��Ŀ������ͼ�������ʽ��ȡֵ��Χ��jpg, gif, png, webp ��ͼƬ��ʽ
	 * 
	 *         <mode>=1 ��ʾ�޶�Ŀ������ͼ�Ŀ�Ⱥ͸߶ȣ��Ŵ󲢴�����ͼ���봦�ü�Ϊָ�� <Width>x<Height> ��С��ͼƬ��
	 *         <mode>=2 ָ�� <Width> �� <Height>����ʾ�޶�Ŀ������ͼ�ĳ��Ϳ�������ͼ�Ĵ�С�޶���ָ���Ŀ�߾����ڡ�
	 *         <mode>=2 ָ�� <Width> ����ָ�� <Height>����ʾ�޶�Ŀ������ͼ�Ŀ�ȣ��߶ȵȱ���������Ӧ��
	 *         <mode>=2 ָ�� <Height> ����ָ�� <Width>����ʾ�޶�Ŀ������ͼ�ĸ߶ȣ���ȵȱ���������Ӧ��
	 * 
	 *         ������ /thumbnail/<ImageSizeGeometry> ��
	 *         /crop/<ImageSizeAndOffsetGeometry> ���������⡣
	 * 
	 *         �ο���http://docs.qiniu.com/api/v6/image-process.html
	 */
	public static String getImgUrl_imageView(String url, int w, int h, int mode) {
		if (w < 1 && h < 1) {// ��� ��͸߶�Ϊ�� �ͷ���Զurl
			return url;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(url);

		if (mode < 1 || mode > 2) {
			sb.append(imageView).append(2);
		} else {
			sb.append(imageView).append(mode);			
		}

		if (w > 0) {
			sb.append("/").append("w").append("/").append(w);
		}
		if (h > 0) {
			sb.append("/").append("h").append("/").append(h);
		}

		return sb.toString();
	}

	/***
	 * �߼�ͼ����ӿڣ��ڶ��棩�����ԡ��ü�����ת��ת����
	 * 
	 * @param url
	 *            ͼƬ��ַ ������Ϊ��
	 * @param crop_w
	 *            �ü��Ŀ�
	 * @param crop_h
	 *            �ü��ĸ�
	 * @param thumbnail_w
	 *            �ü�������ͼƬ�Ŀ�
	 * @param thumbnail_h
	 *            �ü�������ͼƬ�ĸ�
	 * 
	 * @return <ImageDownloadURL>?imageMogr/v2 /auto-orient
	 *         /thumbnail/<ImageSizeGeometry> /gravity/<GravityType>
	 *         /crop/<ImageSizeAndOffsetGeometry> /quality/<ImageQuality>
	 *         /rotate/<RotateDegree> /format/<DestinationImageFormat>
	 * 
	 *         �ο���http://docs.qiniu.com/api/v6/image-process.html
	 */
	public static String getImgUrl_imageMogr(String url, int crop_w,
			int crop_h, int thumbnail_w, int thumbnail_h) {
		StringBuilder sb = new StringBuilder();
		sb.append(url).append(imageMogr).append("crop/!");
		if (crop_w > 0) {
			sb.append(crop_w);
		}
		if (crop_h > 0) {
			sb.append("x").append(crop_h);
		}
		sb.append("/thumbnail/!");
		if (thumbnail_w > 0) {
			sb.append(thumbnail_w);
		}
		if (thumbnail_h > 0) {
			sb.append("x").append(thumbnail_h);
		}

		return sb.toString();
	}
}
