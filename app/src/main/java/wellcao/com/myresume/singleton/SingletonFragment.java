package wellcao.com.myresume.singleton;

import android.view.View;
import android.widget.TextView;

import wellcao.com.myresume.R;
import wellcao.com.myresume.base.BaseFragment;

/**
 * Created by hhc on 2019/04/17 0017.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class SingletonFragment extends BaseFragment implements View.OnClickListener{

    private TextView tvContent;
    private TextView tvFirst,tvSecond,tvThird,tvFourth;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_singleton;
    }

    @Override
    protected void initView(View v) {
        tvContent = v.findViewById(R.id.tv_content_singleton);
        tvFirst = v.findViewById(R.id.tv_first_singleton);
        tvSecond = v.findViewById(R.id.tv_second_singleton);
        tvThird = v.findViewById(R.id.tv_third_singleton);
        tvFourth = v.findViewById(R.id.tv_forth_singleton);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        tvFirst.setOnClickListener(this);
        tvSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int resId = view.getId();
        switch (resId){
            case R.id.tv_first_singleton:
               // tvContent.setText(Singleton.SINGLETON.function());
                break;
            case R.id.tv_second_singleton:
               // tvContent.setText(Singleton.getInstance().function());
                break;
            default:
                break;
        }
    }
}
