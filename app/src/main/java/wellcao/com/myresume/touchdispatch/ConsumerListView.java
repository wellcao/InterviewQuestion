package wellcao.com.myresume.touchdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by hhc on 2019/04/15 0015.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class ConsumerListView extends ListView {
    public ConsumerListView(Context context) {
        super(context);
    }

    public ConsumerListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ConsumerListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ConsumerListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    private float lastY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
     //   return super.dispatchTouchEvent(ev);
      //  return true;
        if (solutionOn){
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                getParent().getParent().requestDisallowInterceptTouchEvent(true);
            } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
                if (lastY > ev.getY()) {
                    // 如果是向上滑动，且不能滑动了，则让ScrollView处理
                    if (!canScrollList(1)) {
                        getParent().getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                } else if (ev.getY() > lastY) {
                    // 如果是向下滑动，且不能滑动了，则让ScrollView处理
                    if (!canScrollList(-1)) {
                        getParent().getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                }
            }
            lastY = ev.getY();
            boolean result = super.dispatchTouchEvent(ev);
            System.out.println("____ListView  $  dispatchTouchEvent()  $  value = "+result);
            return result;
        }else {
            boolean result = super.dispatchTouchEvent(ev);
            System.out.println("____ListView  $  dispatchTouchEvent()  $  value = "+result);
            return result;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = super.onInterceptTouchEvent(ev);
        System.out.println("____ListView  $  onInterceptTouchEvent()  $  value = "+result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean result = super.onTouchEvent(ev);
        System.out.println("____ListView  $  onTouchEvent()  $  value = "+result);
        return result;
    }


    private boolean solutionOn;

    public void setTagOn(boolean b){
        solutionOn = b;
    }
}
