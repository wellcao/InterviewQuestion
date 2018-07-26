package wellcao.com.myresume.builder;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by lizheng on 2018/6/27.
 * <p>
 * iconFount 字体图标
 */

public class IconFontTextView extends TextView {

    public IconFontTextView(Context context) {
        super(context);
        init(context);
    }


    public IconFontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IconFontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/iconfont.ttf");

        setTypeface(typeface);
    }
}
