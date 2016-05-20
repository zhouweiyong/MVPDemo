package zwy.mvpdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;


/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/5/20
 * class description:请输入类描述
 */
public class LoginModeImpl implements IMode {
    private OnDataListener onDataListener;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {//获取数据成功
                User user = new User();
                user.setUserName("tom");
                user.setPassWord("123456");
                onDataListener.onDataSuccess(user);
            } else {//获取数据失败
                onDataListener.onDataFailed("获取数据失败@！");
            }
        }
    };

    /**
     * @param map            请求的参数
     * @param onDataListener 获取数据结果回调
     */
    @Override
    public void toGetData(SimpleArrayMap<String, String> map, OnDataListener onDataListener) {
        this.onDataListener = onDataListener;
        Log.i(LoginModeImpl.class.getName(), "用户名：" + map.get("userName") + "  password:" + map.get("pwd"));
        //异步模拟网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    mHandler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
