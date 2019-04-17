package wellcao.com.myresume.singleton;

/**
 * Created by hhc on 2019/04/17 0017.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class Singleton {

    // ①: 恶汉
/*    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }

    public String function(){
        return "第二种：利用类的静态属性只会在类第一次加载的时候才会初始化";
    }*/

    // ②： 懒汉

/*    private static Singleton mInstance;

    private Singleton(){

    }

    public void getInstance(){
        if (mInstance == null){
            synchronized (Singleton.class){
                if (mInstance == null){   // 必须加次判断，否则同步锁无效
                    mInstance = new Singleton();
                }
            }
        }
    }*/

}

/*

③： JDK 1.5的新特性
public enum Singleton{
    SINGLETON;

    public String function(){
        return "Singleton enum";
    }
}
*/


