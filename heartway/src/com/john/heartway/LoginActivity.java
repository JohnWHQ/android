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
 * app��ҳ ����û�
 *  1��¼
 *  2ע��    ����
 * @author John
 *
 */
public class LoginActivity extends Activity implements OnClickListener{

	//��¼ ע�� button
	Button bt_login;
	Button bt_register;
	
	//�û���  ����EditText
	EditText username;
	EditText password;
	
	//��ס���븴ѡ��
	CheckBox chk_rn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������  
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
	 * ��ʼ��BUTTON TEXT�ؼ� ���õ������
	 * @author John
	 */
	private void init() {
		// TODO Auto-generated method stub
		//��BUTTON  ��¼ ע��
		bt_login=(Button) findViewById(R.id.btn_login);
		bt_register=(Button) findViewById(R.id.btn_login_regist);
		//��BUTTON�ĵ�������¼�
		bt_login.setOnClickListener(this);
		bt_register.setOnClickListener(this);
		
		//��EditText �û��� ����
	    username=(EditText) findViewById(R.id.username);
	    password=(EditText) findViewById(R.id.password);
	    
		//��ʼ����ס����
	     chk_rn = (CheckBox) findViewById(R.id.chk_rn);
	     
	    //�û��˺��������
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

	
	//���ñ�ҳ��ȫ��onclick�¼�
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
			Toast.makeText(this, "��¼�쳣�������ԣ�", Toast.LENGTH_SHORT).show();

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
	 * ��¼btn������ �������� ������ҳ
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
	 * У������
	 * ��ס���빦��
	 */
	private boolean chkandremb() {
      String name= username.getText().toString();
      String pwd =  password.getText().toString();
      if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd))
      {
    	  Toast.makeText(this, "�û��������벻��Ϊ��", Toast.LENGTH_SHORT).show();
    	  return  false;
      }
      
		if(chk_rn.isChecked())
      {
    	 if(Utils.saveUsrInfo(this,name,pwd))
    	 {
    		 Log.d("LoginActivity", "�û������뱣��ɹ���");
    	 }
      }
	  return true;
		
	}

////������˵���
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    
}
