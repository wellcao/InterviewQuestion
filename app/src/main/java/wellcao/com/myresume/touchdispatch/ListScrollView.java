package wellcao.com.myresume.touchdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by hhc on 2019/04/14 0014.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class ListScrollView extends ScrollView {

    private ListView listView;


    public ListScrollView(Context context) {
        super(context);
    }

    public ListScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ListScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //  step 1:
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
     /*   if (listView != null && checkArea(listView, ev)) {
            return false;
        }*/
        boolean result =  super.dispatchTouchEvent(ev);
        System.out.println("____ScrollView  $  dispatchTouchEvent()  $  value = "+result);
        return result;
//     return listView.dispatchTouchEvent(ev);
    }

    //  step 2:
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
    /*    if (listView != null && checkArea(listView, ev)) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);*/
        if (solutionOn){
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                onTouchEvent(ev);
                System.out.println("____ScrollView  $  onInterceptTouchEvent()  $  value = "+false);
                return false;
            }
            System.out.println("____ScrollView  $  onInterceptTouchEvent()  $  value = "+true);
            return true;
        }else {
            boolean result = super.onInterceptTouchEvent(ev);
            System.out.println("____ScrollView  $  onInterceptTouchEvent()  $  value = "+result);
            return result;
        }
    }

    //  step 3:
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //if (listView != null && checkArea(listView, ev)) {
        //   return listView.dispatchTouchEvent(ev);
        //}
        boolean result = super.onTouchEvent(ev);
        System.out.println("____ScrollView  $  onTouchEvent()  $  value = "+result);
        return result;
    }

    /**
     *  测试view是否在点击范围内
     * @param v
     * @return
     */
    private boolean checkArea(View v, MotionEvent event){
        float x = event.getRawX();
        float y = event.getRawY();
        int[] locate = new int[2];
        v.getLocationOnScreen(locate);
        int l = locate[0];
        int r = l + v.getWidth();
        int t = locate[1];
        int b = t + v.getHeight();
        if (l < x && x < r && t < y && y < b) {
            return true;
        }
        return false;
    }

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    private boolean solutionOn;
    public void setTagOn(boolean b){
        solutionOn = b;
    }
}
