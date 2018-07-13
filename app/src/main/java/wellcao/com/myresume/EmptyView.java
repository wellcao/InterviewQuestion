package wellcao.com.myresume;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class EmptyView extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private TextView tv_noDate, tvLoading, tvNetError;

    @Override
    public void onClick(View v) {
        if (mOnRefreshListener != null) {
            mOnRefreshListener.onRefresh();
        }
    }

    public static interface OnRefreshListener {
        void onRefresh();
    }

    private OnRefreshListener mOnRefreshListener;

    public void setOnRefreshListener(OnRefreshListener listener) {
        this.mOnRefreshListener = listener;
    }

    private View llNoNetWork;
    private View llLoading;
    private View llNoData;
    private View contentView;
//    private ImageView ivLoading;

    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();

    }

    private void initView() {
        LayoutInflater factory = LayoutInflater.from(getContext());
        factory.inflate(R.layout.utils_emptyview, this, true);

        llNoNetWork = findViewById(R.id.llNoNetwork);
        llNoData = findViewById(R.id.llNoData);
        tv_noDate = (TextView) findViewById(R.id.tv_noDate);
        llLoading = findViewById(R.id.llLoading);
        tvNetError = (TextView) findViewById(R.id.tvNetError);
        tvLoading = (TextView) findViewById(R.id.tvLoading);
//        ivLoading = (ImageView) findViewById(R.id.ivLoading);
        llNoNetWork.setOnClickListener(this);
//        animationStart(ivLoading);
    }

    public void setContentView(View v) {
        this.contentView = v;
    }

    public void setLoadingText(String str) {
        tvLoading.setText(str);
    }

    public void noData() {
        noData(0);
    }

    public void loading() {
        loading(0);
    }

    public void noNetWork() {
        noNetWork(0);
    }


    public void noData(final int size) {
        llNoNetWork.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (size == 0) {
                    llNoNetWork.setVisibility(View.GONE);
                    llLoading.setVisibility(View.GONE);
                    tv_noDate.setText("没有数据");
                    llNoData.setVisibility(View.VISIBLE);
                    toogleView(true);
                } else {
                    toogleView(false);
                }
            }
        }, 1);
    }

    public void noDataForNotBind(final int size, final String prompt) {
        llNoNetWork.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (size == 0) {
                    llNoNetWork.setVisibility(View.GONE);
                    llLoading.setVisibility(View.GONE);
                    tv_noDate.setText(prompt);
                    llNoData.setVisibility(View.VISIBLE);
                    toogleView(true);
                } else {
                    toogleView(false);
                }
            }
        }, 1);
    }


    public void liveLoad(final int size, final String txt) {
        llNoNetWork.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (size == 0) {
                    llNoNetWork.setVisibility(View.GONE);
                    llNoData.setVisibility(View.GONE);
                    llLoading.setVisibility(View.VISIBLE);
                    tvLoading.setText(txt);
                    toogleView(true);
                } else {
                    toogleView(false);
                }
            }
        }, 1);
    }

    public void noData(final String text) {
        llNoNetWork.postDelayed(new Runnable() {
            @Override
            public void run() {
                llNoNetWork.setVisibility(View.GONE);
                llLoading.setVisibility(View.GONE);
                tv_noDate.setText(text);
                llNoData.setVisibility(View.VISIBLE);
                toogleView(true);

            }
        }, 1);
    }

    public void Load(final String txt) {
        llNoNetWork.postDelayed(new Runnable() {
            @Override
            public void run() {
                llNoNetWork.setVisibility(View.GONE);
                llNoData.setVisibility(View.GONE);
                llLoading.setVisibility(View.VISIBLE);
                tvLoading.setText(txt);
                toogleView(true);

            }
        }, 1);
    }

    public void noDataForBind(final int size) {
        llNoNetWork.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (size == 0) {
                    llNoNetWork.setVisibility(View.GONE);
                    llLoading.setVisibility(View.GONE);
                    tv_noDate.setText("绑定此播间,可获得查看即时建议权限");
                    llNoData.setVisibility(View.VISIBLE);
                    toogleView(true);
                } else {
                    toogleView(false);
                }
            }
        }, 1);
    }


    public void loading(final int size) {
        try {
            llNoNetWork.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (size == 0) {
                        llNoNetWork.setVisibility(View.GONE);
                        llNoData.setVisibility(View.GONE);
                        llLoading.setVisibility(View.VISIBLE);
                        toogleView(true);
                    } else {
                        toogleView(false);
                    }
                }
            }, 1);
        } catch (Exception e) {

        }


    }

    public void noNetWork(final String txt) {
        try {
            llNoNetWork.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setVisibility(View.VISIBLE);
                    llLoading.setVisibility(View.GONE);
                    llNoData.setVisibility(View.GONE);
                    llNoNetWork.setVisibility(View.VISIBLE);
                    tvNetError.setText(txt);
                    toogleView(true);

                }
            }, 1);
        } catch (Exception e) {

        }
    }

    public void noNetWork(final int size) {
        try {
            llNoNetWork.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (size == 0) {
                        setVisibility(View.VISIBLE);
                        llLoading.setVisibility(View.GONE);
                        llNoData.setVisibility(View.GONE);
                        llNoNetWork.setVisibility(View.VISIBLE);
                        toogleView(true);
                    } else {
                        toogleView(false);
                    }
                }
            }, 1);

        } catch (Exception e) {

        }

    }

    public void hide() {

        try {
            if (getVisibility() == View.GONE) {
                return;
            }

            llNoNetWork.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toogleView(false);
                }
            }, 1);

        } catch (Exception e) {

        }
    }

    private void toogleView(final boolean showEmpy) {
        try {
            if (showEmpy) {
                setVisibility(View.VISIBLE);
                if (contentView != null) {
                    contentView.setVisibility(GONE);
                }
            } else {
                setVisibility(View.GONE);
                if (contentView != null) {
                    contentView.setVisibility(VISIBLE);
                }
            }
        } catch (Exception e) {

        }
    }


    public void empty(EmptyState state) {
        empty(state, 0);
    }

    public void empty(EmptyState state, int size) {
        try {
            if (state == EmptyState.loading) {
                loading(size);
            } else if (state == EmptyState.noData) {
                noData(size);
            } else if (state == EmptyState.noNetWork) {
                noNetWork(size);
            } else {

            }
        } catch (Exception e) {

        }
    }

    public static enum EmptyState {
        noData, noNetWork, loading, none
    }

    private void animationStart(ImageView view) {
        try {
            // 加载动画，动画用户使img图片不停的旋转
            Animation mAnimation = AnimationUtils.loadAnimation(mContext,
                    R.anim.dialog_loading);
            view.startAnimation(mAnimation);
        } catch (Exception e) {

        }
    }

}
