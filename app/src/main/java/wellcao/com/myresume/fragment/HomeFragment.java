package wellcao.com.myresume.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import wellcao.com.myresume.R;
import wellcao.com.myresume.TestActivity;
import wellcao.com.myresume.adapter.PattrensAdapter;
import wellcao.com.myresume.base.BaseFragment;
import wellcao.com.myresume.base.IRecyclerAdapter;
import wellcao.com.myresume.die_lock.DieLocKFragment;
import wellcao.com.myresume.singleton.SingletonFragment;
import wellcao.com.myresume.touchdispatch.TouchDispatchFragment;

/**
 * @author wellcao
 * @date 2018/8/8
 * class introduction:
 */
public class HomeFragment extends BaseFragment{

    private final String[] patterns ={"装饰模式","桥接模式","建造者模式","工厂系列","事件传递","单例模式","死锁问题"};
    private RecyclerView rvPatterns;
    private PattrensAdapter mAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View v) {
        rvPatterns=v.findViewById(R.id.rv_design_patterns);
        rvPatterns.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new PattrensAdapter(new IRecyclerAdapter.OnItemCLickListener() {
            @Override
            public void onItemClick(int postion, View view) {
                openFragment(postion);
            }
        });
        rvPatterns.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        for (String pattern : patterns) {
            mAdapter.add(pattern);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {

    }

    private void openFragment(int position){
        String patternName = patterns[position];
        Bundle b =new Bundle();
        b.putString("title",patternName);
        ((TestActivity)getActivity()).setTitleName(patternName);
        BaseFragment fragment = null;
        switch (patternName){
            case "事件传递":
                fragment = fragment(TouchDispatchFragment.class, b);
                break;
            case "单例模式":
                fragment = fragment(SingletonFragment.class, b);
                break;
            case "死锁问题":
                fragment = fragment(DieLocKFragment.class,b);
                break;
            default:
                fragment = fragment(PattrenDetailFragment.class, b);
                break;
        }
        startFragment(fragment);
    }
}
