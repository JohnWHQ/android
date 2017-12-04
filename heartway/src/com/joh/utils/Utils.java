package com.joh.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Xml;

import com.john.domain.user;

public class Utils {
	/**
	 * �����û��� �� ���뵽����
	 * 
	 * @param unm�û���
	 * @param psw ����
	 * @return true �ɹ�
	 * @throws
	 */
	public static boolean saveUsrInfo(Context c,String unm, String pwd) {
		try {
			File dir = c.getFilesDir();
			File filedir =new File(dir, "unpwd.txt");
			//String path = "/data/data/com.john.heartway/unpwd.txt";
			FileOutputStream fos = new FileOutputStream(filedir);
			String data = unm + "##" + pwd;
			fos.write(data.getBytes());
			fos.flush();
			fos.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * ��ȡ��ס���˺ź�����
	 * @return       map<String ,String>  �û��� name ����password
 	 */
	public static Map<String, String> getUserInfo(Context c) {
		
		try {
			File dir = c.getFilesDir();
			File filedir =new File(dir, "unpwd.txt");
			//String path = "/data/data/com.john.heartway/unpwd.txt";
			FileInputStream fis = new FileInputStream(filedir);
			BufferedReader reader =new BufferedReader(new InputStreamReader(fis));
			String data = reader.readLine();
			
			if(!TextUtils.isEmpty(data))
			{
				String[] split = data.split("##");
				
				Map<String,String> info =new HashMap<String, String>();
				info.put("name", split[0]);
				info.put("password", split[1]);
				return info;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	/**
	 * ��ȡ��ǰ�ֻ��ڲ��洢���
	 * @param c ��ǰ������
	 * @return
	 */
	public static String getInternalStorageInfo(Context c)
	{
    	File path=Environment.getDataDirectory();
    	// ���һ������״̬����
        StatFs stat = new StatFs(path.getPath());
        
        long blockSize = stat.getBlockSize();	// ���һ�������Ĵ�С
        
        long totalBlocks = stat.getBlockCount();	// �������������
        
        long availableBlocks = stat.getAvailableBlocks();	// ��ÿ��õ���������
        
        // �ܿռ�
        String totalMemory =  Formatter.formatFileSize(c, totalBlocks * blockSize);
        // ���ÿռ�
        String availableMemory = Formatter.formatFileSize(c, availableBlocks * blockSize);
		
		return "�ֻ��ڲ��洢�ռ䣺\n"+"�ܿռ�: " + totalMemory + "\n���ÿռ�: " + availableMemory+"\n";
	}
	/**
	 * ��ȡSDcard�洢���
	 * @param c  ��ǰ������
	 * @return
	 */
	public static String getExternalStorageInfo(Context c)
	{

    	File path=Environment.getExternalStorageDirectory();
    	// ���һ������״̬����
        StatFs stat = new StatFs(path.getPath());
        
        long blockSize = stat.getBlockSize();	// ���һ�������Ĵ�С
        
        long totalBlocks = stat.getBlockCount();	// �������������
        
        long availableBlocks = stat.getAvailableBlocks();	// ��ÿ��õ���������
        
        // �ܿռ�
        String totalMemory =  Formatter.formatFileSize(c, totalBlocks * blockSize);
        // ���ÿռ�
        String availableMemory = Formatter.formatFileSize(c, availableBlocks * blockSize);
		
		return "SDcard�洢�ռ䣺\n"+"�ܿռ�: " + totalMemory + "\n���ÿռ�: " + availableMemory+"\n";
		
	}
//
//	/**
//	 * 
//	 *test
//	 */
//	public  static boolean writeUserInfo()
//	{
//		List<user> l =Utils.createUserInfo();
//		XmlSerializer xs=Xml.newSerializer();
//		
//		try {
//			File path = new File(Environment.getExternalStorageDirectory(),"userInfo.xml");
//			FileOutputStream fos=new FileOutputStream(path);
//			
//			xs.setOutput(fos, "utf-8");
//			
//			xs.startDocument("utf-8", true );
//			xs.startTag(null, "users");
//			
//
//
//			for(user u:l)
//			{
//			   xs.startTag(null, "user");
//			   xs.attribute(null, "id", String.valueOf(u.getId()));
//			   
//			   xs.startTag(null, "username");
//			   xs.text(String.valueOf(u.getUsername()));
//			   xs.endTag(null, "username");
//			   
//			   xs.startTag(null, "password");
//			   xs.text(String.valueOf(u.getPassword()));
//			   xs.endTag(null, "password");
//			   
//			   xs.endTag(null, "user");
//			}
//			
//			xs.endTag(null, "users");
//			xs.endDocument();
//			return true;
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//		
//		return false;
//		
//	}
//	public static List<user> getInfoFromXml()
//	{
//		
//		XmlPullParser xp =Xml.newPullParser();
//		
//		try {
//			File path =new File(Environment.getExternalStorageDirectory(),"userInfo.xml");
//			FileInputStream fis= new FileInputStream(path);
//			
//			xp.setInput(fis, "utf-8");
//	        int eventType =xp.getEventType();
//	        
//	        List<user> l=null;
//	        user u =null;
//	        
//	        while(eventType!=XmlPullParser.END_DOCUMENT)
//	        {
//	        	String tagname=xp.getName();
//	        	switch (eventType) {
//				case XmlPullParser.START_TAG:
//					if(tagname.equals("users"))
//					{
//						l=new ArrayList<user>();
//					}
//					else if(tagname.equals("user"))
//					{
//						u=new user();
//						u.setId(Integer.parseInt(xp.getAttributeValue(null, "id")));
//					}
//					else if (tagname.equals("username"))
//					{
//						u.setUsername(String.valueOf(xp.nextText()));
//					}else if(tagname.equals("password"))
//					{
//						u.setPassword(String.valueOf(xp.nextText()));
//					}
//					break;
//				case XmlPullParser.END_TAG:
//					if(tagname.equals("user"))
//					{
//						l.add(u);
//					}
//					break;
//				default:
//					break;
//				}
//	        	eventType=xp.next();
//	        }
//			
//			return l;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//		
//	}
//	public static List<user> createUserInfo()
//	{
//		List<user> userlist=new ArrayList<user>();
//		
//		user u1= new user();
//		u1.setId(0001);
//		u1.setUsername("wang");
//		u1.setPassword("123");
//		userlist.add(u1);
//		
//		user u2= new user();
//		u2.setId(0002);
//		u2.setUsername("han");
//		u2.setPassword("123");
//		userlist.add(u2);
//		
//		user u3= new user();
//		u3.setId(0003);
//		u3.setUsername("qi");
//		u3.setPassword("123");
//		userlist.add(u3);
//		
//		user u4= new user();
//		u4.setId(0004);
//		u4.setUsername("��");
//		u4.setPassword("123");
//		userlist.add(u4);
//		
//		user u5= new user();
//		u5.setId(0003);
//		u5.setUsername("��");
//		u5.setPassword("123");
//		userlist.add(u5);
//		
//		
//		return userlist;
//		
//	}
//	/**
//	 * 
//	 *test
//	 */
}
