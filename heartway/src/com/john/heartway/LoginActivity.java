package com.john.heartway;



import java.util.Map;

import com.joh.utils.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
/**
 * app主页 完成用户
 *  1登录
 *  2注册    功能
 * @author John
 *
 */
public class LoginActivity extends Activity implements OnClickListener{

	//登录 注册 button
	Button bt_login;
	Button bt_register;
	
	//用户名  密码EditText
	EditText username;
	EditText password;
	
	//记住密码复选框
	CheckBox chk_rn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏  
        setContentView(R.layout.activity_login);
        init();

//        if(	Utils.writeUserInfo())
//        {
//           Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(this,"failed", Toast.LENGTH_SHORT).show();
//        }
//        Toast.makeText(this, Utils.getInfoFromXml().toString(), Toast.LENGTH_LONG).show();
    }

	/**
	 * 初始化BUTTON TEXT控件 设置点击监听
	 * @author John
	 */
	private void init() {
		// TODO Auto-generated method stub
		//绑定BUTTON  登录 注册
		bt_login=(Button) findViewById(R.id.btn_login);
		bt_register=(Button) findViewById(R.id.btn_login_regist);
		//绑定BUTTON的点击监听事件
		bt_login.setOnClickListener(this);
		bt_register.setOnClickListener(this);
		
		//绑定EditText 用户名 密码
	    username=(EditText) findViewById(R.id.username);
	    password=(EditText) findViewById(R.id.password);
	    
		//初始化记住密码
	     chk_rn = (CheckBox) findViewById(R.id.chk_rn);
	     
	    //用户账号密码回显
	     Map<String,String> info =Utils.getUserInfo(this);
	     if(info!=null)
	     {
	    	 Log.d("LoginActivity", info.get("name"));
	    	 username.setText(info.get("name"));
	    	 password.setText(info.get("password"));
	     }
	     else
	     {
	    	 Log.d("LoginActivity", "null");
	     }
	}

	
	//设置本页面全局onclick事件
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	int id=arg0.getId();
	switch (id) {
	case R.id.btn_login:
		Log.d("onclick", "from btn_login");
		
		if (chkandremb()) {
			login_click();
		} else {
			Toast.makeText(this, "登录异常，请重试！", Toast.LENGTH_SHORT).show();

		}
		
		break;
	case R.id.btn_login_regist:
		Log.d("onclick", "from btn_register");
		Intent intent = new Intent();  
        intent.setClass(LoginActivity.this, register.class);  
        startActivity(intent);  
		break;

	default:
		break;
	}
		
	}


	/**
	 * 登录btn触发后 启动程序 进入主页
	 * @author John
	 * 
	 */
	private void login_click() {
		// TODO Auto-generated method stub
		
		Intent intent=new Intent();
		intent.setClass(LoginActivity.this,MainActivity.class);
		startActivity(intent);
		finish();
	}


	/**
	 * 校验输入
	 * 记住密码功能
	 */
	private boolean chkandremb() {
      String name= username.getText().toString();
      String pwd =  password.getText().toString();
      if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd))
      {
    	  Toast.makeText(this, "用户名，密码不能为空", Toast.LENGTH_SHORT).show();
    	  return  false;
      }
      
		if(chk_rn.isChecked())
      {
    	 if(Utils.saveUsrInfo(this,name,pwd))
    	 {
    		 Log.d("LoginActivity", "用户名密码保存成功！");
    	 }
      }
	  return true;
		
	}

////主界面菜单栏
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    
}
