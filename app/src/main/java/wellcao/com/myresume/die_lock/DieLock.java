package wellcao.com.myresume.die_lock;

import android.widget.TextView;

/**
 * Created by hhc on 2019/04/17 0017.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class DieLock implements T2.OnPrintListener,T1.OnPrintListener{

    public void doTest(){
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread1 = new Thread(new T1(o1, o2,this));
        Thread thread2 = new Thread(new T2(o1,o2,this));
        thread1.start();
        thread2.start();
    }

    @Override
    public void onPrint(String sb) {
      //  System.out.println("sb = [" + sb + "]");
    }
}
