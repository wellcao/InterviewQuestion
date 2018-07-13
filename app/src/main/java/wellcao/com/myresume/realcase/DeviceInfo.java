package wellcao.com.myresume.realcase;

/**
 * Created by hhc on 2018/07/12 0012.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 *
 * PS: 真实场景： 在这次日志埋点时，需要获取设备相关的信息
 *   但是之前的DeviceUtils里面没有获取location、cpu等功能
 *   要是按照以前的逻辑： 直接在修改deviceutils这个类 添加方法（方法都写成了静态）
 *   如果不是静态，就可以写个子类  在子类里面添加方法
 *
 *   换个思路：
 *   我们把这些方法看成一个功能，就是          getDeviceInfo().
 *   这个方法是唯一功能，那么我们就可以在装饰者和被装饰者肯定都是有这个功能的，把它拿到装饰者和被装饰者实现的共同接口中
 *    我们把这个共同接口定义成DeviceInfo
 */

public interface DeviceInfo {

    String getDeviceInfo();
}
