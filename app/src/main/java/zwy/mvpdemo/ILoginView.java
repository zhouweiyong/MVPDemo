package zwy.mvpdemo;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/5/20
 * class description:这里是Presenter期望View做得事情
 */
public interface ILoginView {
    //获取用户名
    String getUserName();

    //获取密码
    String getPwd();

    //登录失败
    void loginFailed(String str);

    //登录成功
    void loginSussess();

    //显示进度框
    void showProgressBar();

    //取消进度框
    void dismissProgressBar();

    void showToast(String toast);

}
