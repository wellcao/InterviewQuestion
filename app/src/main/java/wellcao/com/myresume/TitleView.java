package wellcao.com.myresume;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by yonina on 2017/6/23.
 */

public class TitleView extends LinearLayout {
    private TextView ivLeft;
    private TextView tvTitle;
    private TextView ivRight1, ivRight2;
    private LinearLayout llRight;
    private Resources resources;
    public View rlContent;
    private TextView tvKeHuMessageNum;
    private TextView tvKeHuMessageNum2;

    private EventBarState mEventBarState;
    private EventBarState mEventBarState2;

    private enum EventBarState {
        register, unregister, registering
    }


    public TitleView(Context context) {
        this(context, null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.utils_title, this);
        ivLeft = (TextView) findViewById(R.id.ivTitleBack);
        tvTitle = (TextView) findViewById(R.id.tvTitleName);
        ivRight1 = (TextView) findViewById(R.id.ivTitleRightImg1);
        ivRight2 = (TextView) findViewById(R.id.ivTitleRightImg2);
        llRight = (LinearLayout) findViewById(R.id.lvTitleRight);
        rlContent = findViewById(R.id.rlContent);
        tvKeHuMessageNum = (TextView) findViewById(R.id.tvKeHuMessageNum);
        tvKeHuMessageNum2 = (TextView) findViewById(R.id.tvKeHuMessageNum2);
        resources = context.getResources();
        mEventBarState = EventBarState.unregister;
        mEventBarState2 = EventBarState.unregister;
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleAttrs);
            String title = ta.getString(R.styleable.TitleAttrs_titleName);
            tvTitle.setText(title);

            int gravity = ta.getInt(R.styleable.TitleAttrs_titleGravity, 1);

            RelativeLayout.LayoutParams
                    rl = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            switch (gravity) {
                case 1:
                    rl.addRule(RelativeLayout.RIGHT_OF, ivLeft.getId());
                    rl.leftMargin = ((RelativeLayout.LayoutParams) tvTitle.getLayoutParams()).leftMargin;
                    tvTitle.setLayoutParams(rl);
                    tvTitle.setGravity(Gravity.LEFT | Gravity.CENTER);
                    break;
                case 2:
                    rl = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    tvTitle.setLayoutParams(rl);
                    tvTitle.setGravity(Gravity.CENTER);
                    break;
                case 3:
                    tvTitle.setGravity(Gravity.RIGHT | Gravity.CENTER);
                    break;
            }

            int leftClick = ta.getInt(R.styleable.TitleAttrs_titleLeftClose, 2);

            if (leftClick == 1) {
                ivLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Activity activity = (Activity) TitleView.this.getContext();
                        activity.onBackPressed();
                    }
                });
            }

            int lv = ta.getInt(R.styleable.TitleAttrs_titleLeftVisibility, 1);

            switch (lv) {
                case 1:
                    ivLeft.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    ivLeft.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    ivLeft.setVisibility(View.GONE);
                    break;
            }
            int rv = ta.getInt(R.styleable.TitleAttrs_titleRightVisibility, 1);

            switch (rv) {
                case 1:
                    ivRight1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    ivRight1.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    ivRight1.setVisibility(View.GONE);
                    break;
            }
            int rv2 = ta.getInt(R.styleable.TitleAttrs_titleRight2Visibility, 1);

            switch (rv2) {
                case 1:
                    ivRight2.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    ivRight2.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    ivRight2.setVisibility(View.GONE);
                    break;
            }


            Drawable rightDrawable = ta.getDrawable(R.styleable.TitleAttrs_titleRightImg);
            if (null != rightDrawable) {
                if (Build.VERSION.SDK_INT >= 17) {
                    ivRight1.setCompoundDrawablesRelativeWithIntrinsicBounds(rightDrawable, null, null, null);
                } else {
                    ivRight1.setCompoundDrawables(null, null, null, null);
                }
//                ivRight1.setImageDrawable(rightDrawable);
            }

            Drawable right2Drawable = ta.getDrawable(R.styleable.TitleAttrs_titleRightImg2);
            if (null != right2Drawable) {
                if (Build.VERSION.SDK_INT >= 17) {
                    ivRight2.setCompoundDrawablesRelativeWithIntrinsicBounds(right2Drawable, null, null, null);
                } else {
                    ivRight2.setCompoundDrawables(null, null, null, null);
                }
            }

            Drawable background = ta.getDrawable(R.styleable.TitleAttrs_titleBg);
            if (null != background) {
                if (Build.VERSION.SDK_INT >= 16) {
                    rlContent.setBackground(background);
                } else {
                    rlContent.setBackgroundDrawable(background);
                }
            }

            String txt = ta.getString(R.styleable.TitleAttrs_titleLeftTxt);
            if (!TextUtils.isEmpty(txt)) {
                ivLeft.setText(txt);
                if (Build.VERSION.SDK_INT >= 17) {
                    ivLeft.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
                } else {
                    ivLeft.setCompoundDrawables(null, null, null, null);
                }
            }

            Drawable leftDrawable = ta.getDrawable(R.styleable.TitleAttrs_titleLeftImg);
            if (null != leftDrawable) {
//                ivLeft.setImageDrawable(leftDrawable);
                if (Build.VERSION.SDK_INT >= 17) {
                    ivLeft.setCompoundDrawablesRelativeWithIntrinsicBounds(leftDrawable, null, null, null);
                } else {
                    ivLeft.setCompoundDrawables(null, null, null, null);
                }
            }
            txt = ta.getString(R.styleable.TitleAttrs_titleRightTxt);
            if (!TextUtils.isEmpty(txt)) {
                ivRight1.setText(txt);
            }

            ta.recycle();
        }
       // EventBus.getDefault().register(this);
        if (isInTouchMode()) {
            return;
        }

    }


    /**
     * 设置标题
     *
     * @param txt
     */
    public void setTitle(CharSequence txt) {
        tvTitle.setText(txt);
    }

    /**
     * 设置标题颜色
     *
     * @param color
     */
    public void setTitleColor(int color) {
        tvTitle.setHintTextColor(color);
    }

    /**
     * 设置左边图片
     *
     * @param res
     */

    public void setLeftImg(int res) {
        if (Build.VERSION.SDK_INT >= 17) {
            ivLeft.setCompoundDrawablesRelativeWithIntrinsicBounds(resources.getDrawable(res), null, null, null);
        } else {
            ivLeft.setCompoundDrawables(resources.getDrawable(res), null, null, null);
        }
    }

    /**
     * 设置右边图片
     *
     * @param res
     */
/*
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View setRight1Img(int res) {
        ivRight1.setVisibility(View.VISIBLE);
        ivRight1.setCompoundDrawablesRelativeWithIntrinsicBounds(resources.getDrawable(res), null, null, null);
        return ivRight1;
    }
*/

    /**
     * 设置右边文字
     *
     */
  /*  @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View setRight1Text(String res) {
        ivRight1.setVisibility(View.VISIBLE);
        ivRight1.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        ivRight1.setText(res);
        return ivRight1;
    }*/

    public String getRight1Text(){
        if (ivRight1!=null&&ivRight1.getVisibility()==VISIBLE){
            return ivRight1.getText().toString().trim();
        }
        return "";
    }

    public View setRight1TextColor(int res) {
        ivRight1.setTextColor(res);
        return ivRight1;
    }

    public View setRight2Text(String res) {
        ivRight2.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= 17) {
            ivRight2.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        } else {
            ivRight2.setCompoundDrawables(null, null, null, null);
        }
        ivRight2.setText(res);
        return ivRight2;
    }

    /**
     * 设置左边图标隐藏
     */
    public void setLeftHide(int visible) {
        ivLeft.setVisibility(visible);
    }

    /**
     * 设置右边边图标隐藏
     */
    public void setRight1Hide(int visible) {
        ivRight1.setVisibility(visible);
    }

    public void setLeftClick(View.OnClickListener click) {
        ivLeft.setOnClickListener(click);
    }

    public TextView setRightClick(View.OnClickListener click) {
        ivRight1.setOnClickListener(click);
        return ivRight1;
    }
    public TextView setRight2Click(View.OnClickListener click) {
        ivRight2.setOnClickListener(click);
        return ivRight2;
    }

    public void setTitleNameColor(int color){
        tvTitle.setTextColor(Color.parseColor("#333333"));
    }

}
