package com.jiujiu.jintu.application;

import java.io.File;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.jiujiu.jintu.bean.ADPic;
import com.jiujiu.jintu.bean.Route;
import com.jiujiu.jintu.bean.RoutePic;
import com.jiujiu.jintu.bean.TourismProduct;
import com.jiujiu.jintu.bean.TypeGroup;
import com.jiujiu.jintu.util.JJJCONFIG;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;

public class MainApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		AVObject.registerSubclass(TourismProduct.class);
		AVObject.registerSubclass(ADPic.class);
		AVObject.registerSubclass(TypeGroup.class);
		AVObject.registerSubclass(Route.class);
		AVObject.registerSubclass(RoutePic.class);
		AVOSCloud.initialize(this,
				"sxp70bmrjxib2w1rzppp0sli0ffjeexu193dlc50v27n0135",
				"los07ul613fo1pfzrfvv5lrp69umailbbwlldv98p3r3etdb");
		initImageLoader();
	}

	/**
	 * ��ʼ��ImageLoader
	 */
	private void initImageLoader() {
		File cacheDir = StorageUtils.getOwnCacheDirectory(this,
				JJJCONFIG.cacheIMGDir);// ��ȡ�������Ŀ¼��ַ
		// 1.���ImageLoaderConfiguration������
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				this)
				// max width, max,height���������ÿ�������ļ�����󳤿�
				// .memoryCacheExtraOptions(400, 400)
				// �̳߳��ڼ��ص�����
				.threadPoolSize(3)
				// �߳����ȼ�
				.threadPriority(Thread.NORM_PRIORITY - 2)
				// Ӳ�̻���50MB
				.discCacheSize(50 * 1024 * 1024)
				// �������ʱ���URI������MD5
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				// �������ʱ���URI������HASHCODE����
				.discCacheFileNameGenerator(new HashCodeFileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				// �����File����
				.discCacheFileCount(100)
				// �Զ��建��·��
				.discCache(new UnlimitedDiscCache(cacheDir))
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				// connectTimeout (5 s), readTimeout (30 s)��ʱʱ��
				.imageDownloader(
						new BaseImageDownloader(this, 5 * 1000, 30 * 1000))
				.build();
		ImageLoader.getInstance().init(config);// ȫ�ֳ�ʼ��������
	}

	private void initADPics() {
		initADPic("http://ac-sxp70bmr.clouddn.com/64a17a0a47fbb16d.png",
				ADPic.TYPE_INDEX_PHONE, 0);
		initADPic("http://ac-sxp70bmr.clouddn.com/1ea3ecda6a19ade7.png",
				ADPic.TYPE_INDEX_PHONE, 1);
		initADPic("http://ac-sxp70bmr.clouddn.com/00728cd47b372260.png",
				ADPic.TYPE_INDEX_PHONE, 2);
		initADPic("http://ac-sxp70bmr.clouddn.com/27263fc96923d096.png",
				ADPic.TYPE_INDEX_PHONE, 3);
		initADPic("http://ac-sxp70bmr.clouddn.com/3bcf7a3cfe3cc768.png",
				ADPic.TYPE_INDEX_PHONE, 4);
		initADPic("http://ac-sxp70bmr.clouddn.com/c16090a2a6cf6ebc.png",
				ADPic.TYPE_INDEX_PHONE, 5);

		initADPic("http://ac-sxp70bmr.clouddn.com/7a29e92b14159f2c.png",
				ADPic.TYPE_INDEX_THEME, 0);
		initADPic("http://ac-sxp70bmr.clouddn.com/726e6b0ef37f7805.png",
				ADPic.TYPE_INDEX_THEME, 1);
		initADPic("http://ac-sxp70bmr.clouddn.com/3323ac0f1683ada0.png",
				ADPic.TYPE_INDEX_THEME, 2);
		initADPic("http://ac-sxp70bmr.clouddn.com/60f1bd52dfe79357.png",
				ADPic.TYPE_INDEX_THEME, 3);
		initADPic("http://ac-sxp70bmr.clouddn.com/56fb2a6360784f39.png",
				ADPic.TYPE_INDEX_THEME, 4);

		initADPic("http://ac-sxp70bmr.clouddn.com/728e24b003243b90.jpg",
				ADPic.TYPE_INDEX_TOP, 0);
		initADPic("http://ac-sxp70bmr.clouddn.com/490d16508a799c21.jpg",
				ADPic.TYPE_INDEX_TOP, 1);
		initADPic("http://ac-sxp70bmr.clouddn.com/4246c908a3ab4cc8.jpeg",
				ADPic.TYPE_INDEX_TOP, 2);
		initADPic("http://ac-sxp70bmr.clouddn.com/daf7b541e42bfe57.jpg",
				ADPic.TYPE_INDEX_TOP, 3);
		initADPic("http://ac-sxp70bmr.clouddn.com/2edb2c2522ca3af1.jpg",
				ADPic.TYPE_INDEX_TOP, 4);

	}

	private void initTourismProducts() {
		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/b156c81e61ad7d64.jpg", "98",
				"9849", "9995", "[����]<ŷ�ް˹�15����>�ɶ���ֹ��¬�������ڣ�����ŷ��");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/1dc31e07d93207be.jpg", "91",
				"498", "558", "<��կ��-����˫��3����>���Ʋ�Ʒ�������ھ����ۼƳ���3����");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/836515874e288b1c.jpg", "79",
				"2580", "2680", "<����-�Ƕ���������5����>������ѡ ��������100Ԫÿ��");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/8388dab59bf53d71.jpg", "77",
				"397", "399", "<�����Ǵ��ԭ-��������3����>��˫��ᣬȫ����Ը����");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/7776a99b637775cb.jpg", "100",
				"3364", "3379", "<�ռ���5��6����>2�����ɻ1��˽��ɳ̲�������ǣ���Ǳ");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/3a97974a4deaa02b.jpg", "99",
				"3278", "3295", "[����]<����-������5��6����>����0�Է� ҹ�����˽�");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/2a875dd6e1a7b992.jpg", "100",
				"5315", "5335", "<�ձ�����6��7����>�ɶ�ֱ�ɴ��棬˫�����Ų� ǧ��Ŷ�");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/e6d0406dbc5682ad.jpg", "87",
				"3063", "3069", "<�����׶�-����6����>��ǩ֤���ɶ���ֹ���׽��ó����߻�ͷ·");

		initTourismProduct(
				"http://ac-sxp70bmr.clouddn.com/a826c847a6c47751.jpg", "97",
				"2289", "3499", "<��������5����>4�������ǾƵ꣬�����ʻ����ÿ��˯����Ȼ��");

	}

	private void initTypeGroups() {
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/9c873571079e8898.png",
				"������", "���� ���� ͸���ŷ�����", 0);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/43688c44efc37e60.png",
				"�ܱ���", "ɽˮ��� һ������", 1);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/cf36eff825910c53.png",
				"������", "��Ʊ+�Ƶ� �Ż�ʡ����ȫ��", 2);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/08007364ef2ba638.png",
				"��+������ѡ", "����ѡ�� ��������", 4);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/fddc6a42fa339125.png",
				"����", "ȫ���� ���κ��� ��������", 5);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/c0bb1a482ff6e6ef.png",
				"������Ʊ", "��ɽʤˮ ��Ȫ ������԰��Ʊ", 6);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/a1e3e112ce45bd91.png",
				"�Լ���", "����+�Ƶ� ��ֵ����ĩ", 7);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/530d71bda40fb7bc.png",
				"��������", "����ȫ�� �������", 8);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/87ea9518c5b4545c.png",
				"ǩ֤", "���� ���� ̽��ǩ֤", 9);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/9dec7a9dc8e8e56b.png",
				"1Ԫ�ᱦ", "С���ֻ� �ֻ����� 1Ԫ����", 10);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/0d3f2a3044453f41.png",
				"�Ƶ�", "��ջ ���� �����Ƶ�", 11);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/06b6b79b48727f7f.png",
				"��Ʊ", "��Э��֤ ���ౣ�� ���ͼ۸�", 12);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/9680ce13e7915eff.png",
				"��Ʊ", "�ֻ�����Ԥ�� ��ǰ60�칺Ʊ", 13);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/cb47dca4de6423ab.png",
				"�þñ�", "�Ƚ����һ��� ��ȫ�ɿ� ��ʱ��", 14);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/52a9c46e92013878.png",
				"ţ����", "����WiFi������ ��������", 15);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/3bbbdbe39df8ed0e.png",
				"ţ�˶���", "˽�˶��� ��˾���� ���Ѱ���", 16);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/db79a535b7278a35.png",
				"��Ʒ������", "������ѡ �Ż��ײͷ���", 17);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/132997a405bd4eee.png",
				"Ԥ����Ͽ����", "��Ͽ�۹� ��������ԤԼ", 18);
		initTypeGroup("http://ac-sxp70bmr.clouddn.com/ffd81486bbf753c7.png",
				"������˰", "�������� ������˰", 10);
	}

	private void initTypeGroup(String imgUrl, String title1, String title2,
			int position) {
		TypeGroup typeGroup = new TypeGroup();
		typeGroup.setImgUrl(imgUrl);
		typeGroup.setTitle1(title1);
		typeGroup.setTitle2(title2);
		typeGroup.setPosition(position);
		typeGroup.saveInBackground();
	}

	private void initTourismProduct(String ImgTitleUrl, String Atisfaction,
			String PriceNew, String setPriceOld, String Title) {
		TourismProduct tProduct = new TourismProduct();
		tProduct.setImgTitleUrl(ImgTitleUrl);
		tProduct.setAtisfaction(Atisfaction);
		tProduct.setPriceNew(PriceNew);
		tProduct.setPriceOld(setPriceOld);
		tProduct.setTitle(Title);
		tProduct.saveInBackground();
	}

	private void initADPic(String imgUrl, String adType, int position) {
		ADPic adPic = new ADPic();
		adPic.setImgUrl(imgUrl);
		adPic.setAdType(adType);
		adPic.setPosition(position);
		adPic.saveInBackground();
	}
}
