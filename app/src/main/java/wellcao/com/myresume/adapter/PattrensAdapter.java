package wellcao.com.myresume.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import wellcao.com.myresume.R;
import wellcao.com.myresume.base.IRecyclerAdapter;

/**
 * @author wellcao
 * @date 2018/8/8
 * class introduction:
 */
public class PattrensAdapter extends IRecyclerAdapter<String,PattrensAdapter.PatternHolder> {

    private LayoutInflater inflater;
    private Context mContext;

    public PattrensAdapter(OnItemCLickListener listener) {
        super(listener);
    }

    @Override
    public PatternHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null){
            mContext=parent.getContext();
            inflater = LayoutInflater.from(mContext);
        }
        return new PatternHolder(inflater.inflate(R.layout.item_pattren, parent, false));
    }

    @Override
    public void onBindViewHolder(PatternHolder holder, int position) {
        holder.initData(getItem(position),position);
    }

    @Override
    public int getItemCount() {
        return getCount();
    }

    class PatternHolder extends RecyclerView.ViewHolder{

        private Button button;
        PatternHolder(View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.bt_pattren);
        }

        public void initData(String content, final int position){
            button.setText(content);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemCLickListener.onItemClick(position,button);
                }
            });
        }
    }
}
