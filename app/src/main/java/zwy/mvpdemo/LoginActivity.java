package zwy.mvpdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;

/**
 * 例子用到Android-Bootstrap框架
 * https://github.com/Bearded-Hen/Android-Bootstrap
 */
public class LoginActivity extends Activity implements View.OnClickListener, ILoginView {

    private BootstrapEditText et_user_name;
    private BootstrapEditText et_pwd;
    private BootstrapButton btn_login;
    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_user_name = (BootstrapEditText) findViewById(R.id.et_user_name);
        et_pwd = (BootstrapEditText) findViewById(R.id.et_pwd);
        btn_login = (BootstrapButton) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        //生成一个Presenter实例，并把回到的接口传给Presenter，以便Presenter通知View某个执行动作
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                //调用Presenter的方法，通知Presenter执行登录操作
                loginPresenter.toLogin();
                break;
        }
    }

    //Presenter通过此方法获取UserName
    @Override
    public String getUserName() {
        return et_user_name.getText().toString().trim();
    }

    //Presenter通过此方法获取PassWord
    @Override
    public String getPwd() {
        return et_pwd.getText().toString().trim();
    }

    //Presenter通过此方法通知View登录失败
    @Override
    public void loginFailed(String str) {
        showToast(str);
    }

    //Presenter通过此方法通知View登录成功
    @Override
    public void loginSussess() {
        showToast("登录成功@！#@！");
    }

    //Presenter通过此方法通知View显示Dialog
    @Override
    public void showProgressBar() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("正在登录...");
        }
        progressDialog.show();
    }

    //Presenter通过此方法通知View取消Dialog
    @Override
    public void dismissProgressBar() {
        progressDialog.dismiss();
    }

    //Presenter通过此方法通知View显示Toast
    @Override
    public void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}
