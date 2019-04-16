package wellcao.com.myresume.touchdispatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import wellcao.com.myresume.R;
import wellcao.com.myresume.base.BaseFragment;

/**
 * Created by hhc on 2019/04/14 0014.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class TouchDispatchAdapter extends BaseAdapter{

    private List<String> mList;
    private Context mContext;
    private LayoutInflater mInflater;
    private int totalHeight = 0;
    private int count =0;

    public TouchDispatchAdapter(Context context, List<String> list){
        mContext = context;
        mList = list;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public String getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int positon,
                        View view, ViewGroup viewGroup) {
        if (view == null){
            view = mInflater.inflate(R.layout.item_touch_dispatch,viewGroup,false);
        }
        view.measure(0,0);
        totalHeight += view.getMeasuredHeight();
        count++;
        TextView textView = view.findViewById(R.id.tv_item_touch_dispatch);
        textView.setText(mList.get(positon));
        return view;
    }
}
