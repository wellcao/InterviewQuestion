package wellcao.com.myresume.base;


import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.Suppress;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class IRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {


    private List<T> infos = new ArrayList<>();

    protected OnItemCLickListener onItemCLickListener;


    public void add(int index, T info) {
        if (infos == null) {
            infos = new ArrayList<>();
        }
        infos.add(index, info);
    }

    public void add(T info) {
        if (infos == null) {
            infos = new ArrayList<>();
        }
        infos.add(info);
    }

    @Suppress
    public void add(List<T> infos) {
        if (this.infos == null) {
            this.infos = new ArrayList<>();
        }
        if (infos == null) {
            return;
        }
        this.infos.addAll(infos);
    }

    @Suppress
    public void add(int index, List<T> infos) {
        if (this.infos == null) {
            this.infos = new ArrayList<>();
        }
        if (infos == null) {
            return;
        }
        this.infos.addAll(index, infos);
    }


    public void addAll(List<T> infos) {
        if (this.infos == null) {
            this.infos = new ArrayList<>();
        }
        if (infos == null) {
            return;
        }
        this.infos.addAll(infos);
    }

    public void addAll(int index, List<T> infos) {
        if (this.infos == null) {
            this.infos = new ArrayList<>();
        }
        if (infos == null) {
            return;
        }
        this.infos.addAll(index, infos);
    }

    public void remove(T info) {
        if (infos == null) {
            infos = new ArrayList<>();
            return;
        }
        infos.remove(info);
    }

    public void removeAll(List<T> list) {
        if (infos == null) {
            infos = new ArrayList<>();
            return;
        }
        if (list != null)
            infos.removeAll(list);
    }

    public void remove(int index) {
        if (infos == null) {
            infos = new ArrayList<>();
            return;
        }
        infos.remove(index);
    }

    public void clear() {
        if (infos == null) {
            return;
        } else {
            infos.clear();
        }
        notifyDataSetChanged();
    }

    public List<T> getInfos() {

        if (infos == null) {
            infos = new ArrayList<>();
        }
        return infos;
    }

    public T getItem(int postion) {
        return this.infos.get(postion);
    }


    public int getCount() {
        return this.infos == null ? 0 : this.infos.size();
    }


    public IRecyclerAdapter(OnItemCLickListener listener) {
        this.onItemCLickListener = listener;
    }

    protected void setOnItemCLickListener(OnItemCLickListener onItemCLickListener) {
        this.onItemCLickListener = onItemCLickListener;
    }

    public interface OnItemCLickListener {
        void onItemClick(int postion, View view);
    }

}
