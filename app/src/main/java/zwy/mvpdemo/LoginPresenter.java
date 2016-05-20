package zwy.mvpdemo;

import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/5/20
 * class description:请输入类描述
 */
public class LoginPresenter implements IMode.OnDataListener<User> {
    private ILoginView iLoginView;//通知View执行动作的接口
    private IMode iMode;//Mode对象

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        //生成Mode实例
        iMode = new LoginModeImpl();
    }

    //登录操作，在View中点击登录按钮后，View通知Presenter执行此操作
    public void toLogin() {
        //通过ILoginView接口获取控件中的数据
        String name = iLoginView.getUserName();
        if (TextUtils.isEmpty(name)) {
            iLoginView.showToast("请输入用户名");
            return;
        }

        String pwd = iLoginView.getPwd();
        if (TextUtils.isEmpty(pwd)) {
            iLoginView.showToast("请输入密码");
            return;
        }

        SimpleArrayMap<String, String> map = new SimpleArrayMap<>();
        map.put("userName", name);
        map.put("pwd", pwd);
        //通过ILoginView接口通知View显示Dialog
        iLoginView.showProgressBar();
        //调用Mode的toGetData方法，获取数据,并把接口实现传给Mode
        iMode.toGetData(map, this);

    }

    //实现OnDataListener接口的回调方法，Mode通过这两个方法通知Presenter
    @Override
    public void onDataSuccess(User data) {
        iLoginView.dismissProgressBar();
        if (iLoginView.getUserName().equals(data.getUserName())) {
            iLoginView.loginSussess();
        } else {
            iLoginView.loginFailed("登录失败!");
        }
    }

    @Override
    public void onDataFailed(String msg) {
        iLoginView.dismissProgressBar();
        iLoginView.loginFailed(msg);
    }


}
