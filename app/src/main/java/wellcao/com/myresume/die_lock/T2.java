package wellcao.com.myresume.die_lock;

/**
 * Created by hhc on 2019/04/17 0017.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class T2 implements Runnable{

    private Object o1,o2;
    private int count;
    private OnPrintListener onPrintListener;
    StringBuilder sb = new StringBuilder();

    public T2(Object o1, Object o2,OnPrintListener onPrintListener){
        this.o1 = o1;
        this.o2 =o2;
        this.onPrintListener = onPrintListener;
    }


    @Override
    public void run() {
        while (true){
            synchronized (o2){
                try {
                    Thread.sleep(900);
                    synchronized (o1){
                        print();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void print(){
        count++;
        //return "[O1]: "+count+"\n";
        System.out.println("___"+"[O1]: "+count);
        sb.append("___"+"[O1]: "+count+"\n");
        onPrintListener.onPrint(sb.toString());

    }


    public interface OnPrintListener{
        void onPrint(String sb);
    }
}
