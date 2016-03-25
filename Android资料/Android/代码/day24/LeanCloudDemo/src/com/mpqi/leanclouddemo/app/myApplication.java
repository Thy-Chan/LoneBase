package com.mpqi.leanclouddemo.app;

import java.util.Arrays;
import java.util.List;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.CountCallback;
import com.avos.avoscloud.DeleteCallback;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;
import com.avos.avoscloud.SaveCallback;

import android.app.Application;
import android.util.Log;

public class myApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		// ���ʹ�������ڵ㣬��������д��� AVOSCloud.useAVCloudUS();
		AVOSCloud.initialize(this, "1NqhM5FLPGaoKoISURt3grfW",
				"NsolKxc1VRcMTyow7vCTpkyC");

		// avObjectSave();// ͬ�� ����
		// avObjectQuery();// ͬ�� ��ѯ ��Ҫ�Լ��¿�һ���߳�

		// saveInbackground();//�첽 ����
		// queryInbackground();// �첽 ��ѯ

		// update();// ����
		// updateWithOutData();// ����
		// updateNew();

		// remove();
		// deleteInbackground();

		// pointerSave();
		// pointerSvaveStay();

		// selectInbackground();//������ѯ
//		selectLike();
//		countInbackground();
		
		selectEqualTo();
	}

	// ==========================day24============================================
	
	private void selectEqualTo(){//ʹ������ƥ��  ���й�ϵ��ѯ
		AVObject myPost = AVObject.createWithoutData("Post", "564949b200b0d1db33734b33");
		
		AVQuery<AVObject> query = AVQuery.getQuery("Comment");
		query.whereEqualTo("post", myPost);
		query.findInBackground(new FindCallback<AVObject>() {
		  public void done(List<AVObject> commentList, AVException e) {
		    // myPost �������������۶��� commentList ���ˡ�
			  for (AVObject avObject : commentList) {
				Log.i("test", avObject.getString("content"));
			}
		  }
		});
	}
	
	private void countInbackground(){//��ѯ��¼����
		AVQuery<AVObject> query = AVQuery.getQuery("Post");
		query.whereEqualTo("pubUser", "LeanCloud�ٷ��ͷ�");
		query.countInBackground(new CountCallback() {
		  public void done(int count, AVException e) {
		    if (e == null) {
		      // The count request succeeded. Log the count
		      Log.i("succeeded", "LeanCloud�ٷ��ͷ� ������ " + count + " ��΢��");
		    } else {
		      // The request failed
		    }
		  }
		});
	}
	
	private void selectLike() {// ģ����ѯ ������ Mysql�� Like
		// ���ҳ����� username �� LeanCloud ��ͷ���û�
		AVQuery<AVObject> query = AVQuery.getQuery("_User");
		query.whereStartsWith("username", "LeanCloud");

		query.findInBackground(new FindCallback<AVObject>() {

			@Override
			public void done(List<AVObject> avObjects, AVException e) {
				if (e == null) {// ��ѯ�ɹ�
					Log.i("test", "ģ����ѯ�ɹ�");
					for (AVObject avObject : avObjects) {
						String userName = avObject.getString("username");
						String pwd = avObject.getString("password");
						Log.i("test", userName + "\t  " + pwd);
					}
				} else {// ��ѯʧ��
					e.printStackTrace();
					Log.i("test", "ģ����ѯʧ��");
				}
			}
		});
	}

	private void selectInbackground() {// ������ѯ
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		// query.whereEqualTo("pubUser", "LeanCloud�ٷ��ͷ�");

		// String[] names = {"LeanCloud�ٷ��ͷ�", "LeanCloud����", "����������"};
		// query.whereContainedIn("pubUser", Arrays.asList(names));

		String[] names = { "LeanCloud�ٷ��ͷ�", "LeanCloud����", "����������" };
		query.whereNotContainedIn("pubUser", Arrays.asList(names));

		query.findInBackground(new FindCallback<AVObject>() {// ��ѯ֮��Ļص�����

			@Override
			public void done(List<AVObject> avObjects, AVException e) {
				if (e == null) {// ��ѯ�ɹ�
					Log.i("test", "������ѯ�ɹ�");
					for (AVObject avObject : avObjects) {
						String content = avObject.getString("content");
						String userName = avObject.getString("pubUser");
						int userVerified = avObject
								.getInt("pubUserCertificate");
						Log.i("test", content + "\t  " + userName + "\t  "
								+ userVerified);
					}
				} else {// ��ѯʧ��
					Log.i("test", "������ѯʧ��");
				}

			}
		});
	}

	private void select() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// ʹ����ͨ ��ɾ���

			}
		}).start();
	}

	// ==========================day23============================================

	private void pointerSvaveStay() {// Ϊ�Ѿ��е�΢���������

		// ����������Ϣ
		AVObject myComment = new AVObject("Comment");
		myComment.put("content", "����һ�����Ե������ۣ����ٺ٣�");

		// �����۹����� objectId Ϊ 5590cdfde4b00f7adb5860c8 ������΢����
		myComment.put("post",
				AVObject.createWithoutData("Post", "564949b200b0d1db33734b33"));
		myComment.saveInBackground();
	}

	private void pointerSave() {// ����AVObject ֮��Ĺ�ϵ
		// ����΢����Ϣ
		AVObject myWeibo = new AVObject("Post");
		myWeibo.put("content", "��Ϊһ������Ա������Ϊ�ؼ��Ժ�Ҫ��Ҫ����д���룿");

		// ����������Ϣ
		AVObject myComment = new AVObject("Comment");
		myComment.put("content", "������д���룬����״̬֮����ò�Ҫͣ���²��°��Ѿ�����Ҫ�ˣ����ָо�����Ҫ��");

		// ���һ��������΢������
		// �����ҪԤ�Ƚ��������� Comment ���н���һ�� Pointer ���Ե� post �У�һ������²���Ҫ��ô����
		myComment.put("post", myWeibo);

		// �⽫�����������ݣ��ֱ�Ϊ΢����Ϣ��������Ϣ
		myComment.saveInBackground();
	}

	private void remove() {// ɾ��ĳ�ֶε�ֵ
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		query.getInBackground("56494a3260b20fc970b97ff4",
				new GetCallback<AVObject>() {

					@Override
					public void done(AVObject post, AVException arg1) {
						post.remove("content");
						post.saveInBackground();
					}

				});
	}

	private void deleteInbackground() {// ɾ��һ��������
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		query.getInBackground("5649795160b294bc126b769d",
				new GetCallback<AVObject>() {

					@Override
					public void done(AVObject arg0, AVException arg1) {
						if (arg0 != null) {
							arg0.deleteInBackground(new DeleteCallback() {

								@Override
								public void done(AVException e) {
									if (e == null) {
										// ɾ���ɹ�
										Log.i("test", "ɾ���ɹ�");
									} else {
										// ����ʧ��
										Log.i("test", "ɾ��ʧ��");
									}

								}
							});
						}

					}
				});
	}

	private void update() {// �������� ���Ȳ�ѯһ��avobject���� ������ID �� �����ֶε�ֵ
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		// ͨ��id ���ҵ��ƶ��� ����
		query.getInBackground("56494a3260b20fc970b97ff4",
				new GetCallback<AVObject>() {

					@Override
					public void done(AVObject post, AVException e) {
						if (e == null) {// ��ѯ�ɹ�
							if (post != null) {
								post.put(
										"content",
										"3333333ÿ��Java����Ա�ر���8���������� ���� http://itindex.net/detail/52950-java-%E5%BC%80%E5%8F%91-%E5%B7%A5%E5%85%B7");
								post.saveInBackground(new SaveCallback() {

									@Override
									public void done(AVException e) {
										if (e == null) {
											Log.i("test", "���³ɹ�");
										} else {
											// ����ʧ��
											Log.i("test", "����ʧ��");
										}

									}
								});
							}
						} else {
							// ��ѯʧ��
						}

					}
				});
	}

	private void updateWithOutData() {// �������� ֻ����ID �� ��Ҫ���µ��ֶ�����ֶε�������
		// ֪�� objectId������ AVObject
		AVObject post = AVObject.createWithoutData("Post",
				"564975d000b0bf37d846c42d");
		// ��������
		post.put(
				"content",
				"44444444ÿ��Java����Ա�ر���8���������� ���� http://itindex.net/detail/52950-java-%E5%BC%80%E5%8F%91-%E5%B7%A5%E5%85%B7");
		// ����
		post.saveInBackground();
	}

	private void updateNew() {// �������� ֻ����ID �� ��Ҫ���µ��ֶ�����ֶε�������
		// ֪�� objectId������ AVObject
		AVObject post = new AVObject("Post");
		post.put("objectId", "564975d000b0bf37d846c42d");
		// ��������
		post.put(
				"content",
				"55555544444444ÿ��Java����Ա�ر���8���������� ���� http://itindex.net/detail/52950-java-%E5%BC%80%E5%8F%91-%E5%B7%A5%E5%85%B7");
		// ����
		post.saveInBackground();
	}

	private void saveInbackground() {// �첽 ����
		AVObject post = new AVObject("Post");
		post.put("content", "1111111�������ʳ����𢣻����ɽ�g��������������֮���������^���L���ꡣ");
		post.put("pubUser", "LeanCloud�ٷ��ͷ�22222");
		post.put("pubUserAvatar",
				"http://tp1.sinaimg.cn/3652761852/50/5730347813/0");
		post.put("pubUserCertificate", 6); // 4 ��ʾ΢��������֤������ġ�
		post.put("pubTimestamp", 1435540999);
		post.saveInBackground(new SaveCallback() {// ����֮��Ľ���ص�����

			@Override
			public void done(AVException e) {
				if (e == null) {
					// ����ɹ���
					Log.i("test", "����ɹ�");
				} else {
					// ����ʧ��
				}

			}
		});
	}

	private void queryInbackground() {// �첽 ��ѯ
		// ���� ���� Post
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		AVObject post;
		// ͨ��id ���ҵ��ƶ��� ����
		query.getInBackground("56494a3260b20fc970b97ff4",
				new GetCallback<AVObject>() {

					@Override
					public void done(AVObject post, AVException e) {
						if (e == null) {// ��ѯ�ɹ�
							// ��ѯ����¼�󣬻�ȡ����
							if (post != null) {
								String content = post.getString("content");
								String userName = post.getString("pubUser");
								int userVerified = post
										.getInt("pubUserCertificate");
								Log.i("test", content + "\t" + userName + "\t"
										+ userVerified);
								String tmp = post.toString();
								try {
									AVObject myPost = AVObject
											.parseAVObject(tmp);
									Log.i("test", "�����л�֮��Ľ��:" + content + "\t"
											+ userName + "\t" + userVerified);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} else {
							// ��ѯʧ��
						}

					}
				});
	}

	private void avObjectQuery() {// ��ѯ
		new Thread(new Runnable() {

			@Override
			public void run() {
				// ���� ���� Post
				AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
				AVObject post;
				// ͨ��id ���ҵ��ƶ��� ����
				try {
					post = query.get("56494a3260b20fc970b97ff4");

					// ��ѯ����¼�󣬻�ȡ����
					if (post != null) {
						String content = post.getString("content");
						String userName = post.getString("pubUser");
						int userVerified = post.getInt("pubUserCertificate");
						Log.i("test", content + "\t" + userName + "\t"
								+ userVerified);
					}
				} catch (AVException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

	}

	private void avObjectSave() {// ����
		new Thread(new Runnable() {

			@Override
			public void run() {
				AVObject post = new AVObject("Post");
				post.put("content", "�������ʳ����𢣻����ɽ�g��������������֮���������^���L���ꡣ");
				post.put("pubUser", "LeanCloud�ٷ��ͷ�");
				post.put("pubUserAvatar",
						"http://tp1.sinaimg.cn/3652761852/50/5730347813/0");
				post.put("pubUserCertificate", 4); // 4 ��ʾ΢��������֤������ġ�
				post.put("pubTimestamp", 1435540999);
				try {
					post.save();
				} catch (AVException e) {
					// e.getMessage() ������쳣��Ϣ
				}

			}
		}).start();
	}
}
