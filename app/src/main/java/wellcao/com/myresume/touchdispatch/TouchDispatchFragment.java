package wellcao.com.myresume.touchdispatch;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wellcao.com.myresume.R;
import wellcao.com.myresume.base.BaseFragment;

/**
 * Created by hhc on 2019/04/14 0014.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 *
 * point:  ScrollView嵌套ListView问题
 *  ①.  ListView只显示第一个条目内容
 *       solution 1:  重写ListView的onMeaure()，设置测量方式为At_Most
 *       solution 2:  动态指定ListView的高度  ( 这种方式必须用LinearLayout包裹住ListView，这样设置才会有效 )
 *
 *
 *  ②.  滑动冲突，ScrollView消费了滑动事件，导致Listview滑不动
 *       solution 1:  外部拦截法  ListScrollView
 *       solution
 *
 */

public class TouchDispatchFragment extends BaseFragment implements View.OnClickListener{

    private ConsumerListView listView;
    private List<String> mDatas = new ArrayList<>();
    private TouchDispatchAdapter mAdapter;
   // private ScrollView scrollView;
    private ListScrollView scrollView;

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.tv_problem_lv_height:
                eventType = EVENT_TYPE.PROBLEM_LV_HEIGHT.ordinal();
                break;
            case R.id.tv_solution_lv_height:
                eventType = EVENT_TYPE.SOLUTION_LV_HEIGHT.ordinal();
                break;
            case R.id.tv_problem_touch_conflict:
                eventType = EVENT_TYPE.PROBLEM_TOUCH_CONFLICT.ordinal();
                break;
            case R.id.tv_solution_touch_conflict:
                eventType = EVENT_TYPE.SOLUTION_TOUCH_CONFLECT.ordinal();
                break;
            default:
                break;
        }
        tvProLvHeight.setTextColor(Color.WHITE);
        tvSoLvHeight.setTextColor(Color.WHITE);
        tvProTouConflict.setTextColor(Color.WHITE);
        tvSoTouConflict.setTextColor(Color.WHITE);
        if (view instanceof TextView){
            ((TextView) view).setTextColor(Color.parseColor("#333333"));
        }
        doSometing();
    }
    private int eventType;

    private TextView tvProLvHeight,tvSoLvHeight,tvProTouConflict, tvSoTouConflict;


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_touch_dispatch;
    }

    @Override
    protected void initView(View v) {
        listView = v.findViewById(R.id.lv_touch_dispatch);
        scrollView = v.findViewById(R.id.scrollView);
        tvProLvHeight = v.findViewById(R.id.tv_problem_lv_height);
        tvSoLvHeight = v.findViewById(R.id.tv_solution_lv_height);
        tvProTouConflict = v.findViewById(R.id.tv_problem_touch_conflict);
        tvSoTouConflict = v.findViewById(R.id.tv_solution_touch_conflict);
        scrollView.setListView(listView);
        tvProLvHeight.setTextColor(Color.parseColor("#333333"));
    }

    @Override
    protected void initData() {
        for (int i=0;i<10;i++){
            mDatas.add("zhang san");
            mDatas.add("li si");
            mDatas.add("wang wu ma zi");
            mDatas.add("qian qi");
        }
        mAdapter = new TouchDispatchAdapter(getContext(), mDatas);
        listView.setAdapter(mAdapter);
        //setListViewHeightBasedOnChildren(listView);
    }

    @Override
    protected void initListener() {
        tvProLvHeight.setOnClickListener(this);
        tvSoLvHeight.setOnClickListener(this);
        tvProTouConflict.setOnClickListener(this);
        tvSoTouConflict.setOnClickListener(this);
    }

    public void setListViewHeightBasedOnChildren() {
        // 获取ListView对应的Adapter
        int totalHeight = 0;
        for (int i = 0, len = mAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = mAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        if (eventType == EVENT_TYPE.SOLUTION_LV_HEIGHT.ordinal()){
            params.height = totalHeight+ (listView.getDividerHeight() * (mAdapter.getCount() - 1));
        }else {
            params.height = 800;
        }

        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
      /*  ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        layoutParams.height = params.height;
        scrollView.setLayoutParams(layoutParams);*/
    }

    private void doSometing(){
        if (eventType == EVENT_TYPE.PROBLEM_LV_HEIGHT.ordinal()){
            //setListViewHeightBasedOnChildren();
            listView.setAdapter(mAdapter);
            scrollView.setTagOn(false);
            listView.setTagOn(false);
        }else if (eventType == EVENT_TYPE.SOLUTION_LV_HEIGHT.ordinal()){
            setListViewHeightBasedOnChildren();
            scrollView.setTagOn(false);
            listView.setTagOn(false);
        }else if (eventType == EVENT_TYPE.PROBLEM_TOUCH_CONFLICT.ordinal()){
            setListViewHeightBasedOnChildren();
            scrollView.setTagOn(false);
            listView.setTagOn(false);
        }else {
            scrollView.setTagOn(true);
            listView.setTagOn(true);
            setListViewHeightBasedOnChildren();
        }
    }
}
