package wellcao.com.myresume;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.widget.TextView;

public class Bindings {

    @BindingAdapter({"font"})
    public static void setFont(TextView textView, String fontName) {
      //  textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/" + fontName));
    }

}
