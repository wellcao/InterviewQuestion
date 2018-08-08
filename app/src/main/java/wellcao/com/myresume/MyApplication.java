package wellcao.com.myresume;

import android.app.Application;

import wellcao.com.myresume.widget.MyToast;

/**
 * Created by hhc on 2017/12/18 0018.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MyToast.init(this);
       // CrashReport.initCrashReport(this, "1ef3fe43a1", false);
    }
}
