package wellcao.com.myresume;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

import wellcao.com.myresume.base.BaseActivity;
import wellcao.com.myresume.base.BaseFragment;
import wellcao.com.myresume.fragment.HomeFragment;
import wellcao.com.myresume.utils.StatusBarUtil;

/**
 * Created by hhc on 2018/07/11 0011.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class TestActivity extends BaseActivity {

    private TitleView titleView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        StatusBarUtil.setMyStatusBarColor(this);
        initView();
        initData();
    }

    private void initView(){
        titleView = findViewById(R.id.titleView_homework);
    }

    private void initData(){
        startFragment(HomeFragment.class);
    }



    @Override
    public void onBackPressed() {
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected int fragmentLayoutId() {
        return R.id.fl_content;
    }

    @Override
    protected void onBackPressedNotice(List<BaseFragment> tag) {
        titleView.setTitle("设计模式");
    }

    public void setTitleName(String titleName){
        titleView.setTitle(titleName);
    }
}
