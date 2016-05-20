package zwy.mvpdemo;

import android.support.v4.util.SimpleArrayMap;
import android.util.SparseArray;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/5/20
 * class description:请输入类描述
 */
public interface IMode {

    void toGetData(SimpleArrayMap<String, String> map, OnDataListener onDataListener);

    interface OnDataListener<T> {
        void onDataSuccess(T data);

        void onDataFailed(String msg);
    }
}
