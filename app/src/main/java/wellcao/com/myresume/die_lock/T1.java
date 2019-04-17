package wellcao.com.myresume.die_lock;

import android.widget.TextView;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Created by hhc on 2019/04/17 0017.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class T1 implements Runnable {

    private Object o1,o2;
    private int count;
    private OnPrintListener onPrintListener;
    private StringBuilder sb = new StringBuilder();

    public T1(Object o1, Object o2, OnPrintListener onPrintListener){
        this.o1 = o1;
        this.o2 =o2;
        this.onPrintListener = onPrintListener;
    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(8300);
                synchronized (o1){
                    try {
                        Thread.sleep(1000);
                        synchronized (o2){
                            print();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void print(){
        count++;
        //return "[O2]: "+count+"\n";
        System.out.println("____"+"[O2]: "+count);
        sb.append("____"+"[O2]: "+count+"\n");

    }


    public interface OnPrintListener{
        void onPrint(String sb);
    }
}
