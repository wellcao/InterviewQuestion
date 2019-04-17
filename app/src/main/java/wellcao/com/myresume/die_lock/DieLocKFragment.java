package wellcao.com.myresume.die_lock;

import android.view.View;
import android.widget.TextView;

import wellcao.com.myresume.R;
import wellcao.com.myresume.base.BaseFragment;

/**
 * Created by hhc on 2019/04/17 0017.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class DieLocKFragment extends BaseFragment{

    private TextView tvDieLock;


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_die_lock;
    }

    @Override
    protected void initView(View v) {
        tvDieLock = v.findViewById(R.id.tv_excute_die_lock);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        tvDieLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DieLock dieLock = new DieLock();
                dieLock.doTest();
            }
        });
    }
}
