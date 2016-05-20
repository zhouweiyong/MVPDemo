###MVP实例
通过登录的一个小例子介绍MVP的简单用法，代码有做详细注释

####实例效果
![Mou icon](https://github.com/zhouweiyong/MVPDemo/blob/master/Image.png)
###MVP简单介绍
>Mode：负责获取数据，数据源可以为：数据库、网络、内存等。

* 从网络，数据库，文件，传感器，第三方等数据源读写数据。
* 对外部的数据类型进行解析转换为APP内部数据交由上层处理。
* 对数据的临时存储,管理，协调上层数据请求。

>View：展示层，对应xml布局文件和Activity，主要负责控件数据展示、控件数据更改、控件样式更改，控件监听，控件生成和展示，不涉及业务代码

* 提供UI交互
* 在presenter的控制下修改UI。
* 将业务事件交由presenter处理。

注意: View层不存储数据，不与Model层交互。
在Android中View层一般是Activity、Fragment、View（控件）、ViewGroup（布局等）等。



>Presenter：负责View和Mode的交互，主要实现业务代码，对数据的判断和计算

作为View与Model交互的中间纽带，处理与用户交互的负责逻辑。Presenter包含了根据用户在视图中的行为去更新模型的逻辑。视图仅仅只是将用户的行为告知Presenter，而Presenter负责从视图中取得数据然后发送给模型。



