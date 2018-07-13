package wellcao.com.myresume.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import wellcao.com.myresume.R;


/**
 * Created by yonina on 2017/8/9.
 */

public class MyToast {

    private static Toast toast;
    private static TextView t;
    private static Handler handler;

    public static void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_toast, null);
        t = (TextView) view.findViewById(R.id.toast_text);
       /*     if (toast != null) {
            toast.cancel();
        }*/
        toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                t.setText(msg.obj + "");
                toast.show();
            }
        };
    }

    public static void show(Object msg) {
        Message message = handler.obtainMessage();
        message.obj = msg;
        handler.sendMessage(message);
    }
}
