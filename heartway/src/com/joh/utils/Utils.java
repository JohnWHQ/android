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
	 * 保存用户名 和 密码到本地
	 * 
	 * @param unm用户名
	 * @param psw 密码
	 * @return true 成功
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
	 * 获取记住的账号和密码
	 * @return       map<String ,String>  用户名 name 密码password
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
	 * 获取当前手机内部存储情况
	 * @param c 当前上下文
	 * @return
	 */
	public static String getInternalStorageInfo(Context c)
	{
    	File path=Environment.getDataDirectory();
    	// 获得一个磁盘状态对象
        StatFs stat = new StatFs(path.getPath());
        
        long blockSize = stat.getBlockSize();	// 获得一个扇区的大小
        
        long totalBlocks = stat.getBlockCount();	// 获得扇区的总数
        
        long availableBlocks = stat.getAvailableBlocks();	// 获得可用的扇区数量
        
        // 总空间
        String totalMemory =  Formatter.formatFileSize(c, totalBlocks * blockSize);
        // 可用空间
        String availableMemory = Formatter.formatFileSize(c, availableBlocks * blockSize);
		
		return "手机内部存储空间：\n"+"总空间: " + totalMemory + "\n可用空间: " + availableMemory+"\n";
	}
	/**
	 * 获取SDcard存储情况
	 * @param c  当前上下文
	 * @return
	 */
	public static String getExternalStorageInfo(Context c)
	{

    	File path=Environment.getExternalStorageDirectory();
    	// 获得一个磁盘状态对象
        StatFs stat = new StatFs(path.getPath());
        
        long blockSize = stat.getBlockSize();	// 获得一个扇区的大小
        
        long totalBlocks = stat.getBlockCount();	// 获得扇区的总数
        
        long availableBlocks = stat.getAvailableBlocks();	// 获得可用的扇区数量
        
        // 总空间
        String totalMemory =  Formatter.formatFileSize(c, totalBlocks * blockSize);
        // 可用空间
        String availableMemory = Formatter.formatFileSize(c, availableBlocks * blockSize);
		
		return "SDcard存储空间：\n"+"总空间: " + totalMemory + "\n可用空间: " + availableMemory+"\n";
		
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
//		u4.setUsername("成");
//		u4.setPassword("123");
//		userlist.add(u4);
//		
//		user u5= new user();
//		u5.setId(0003);
//		u5.setUsername("功");
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
