package wellcao.com.myresume.builder;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import wellcao.com.myresume.R;


/**
 * Created by lizheng on 2018/6/27.
 * ai 老师 总评分雷达图
 */

public class RadarView extends View {

    private Context mContext;
    private int count = 3;
    private float maxValue = 100;//数据最大值
    private float angle = (float) (Math.PI * 2 / count);
    private float radius;                   //网格最大半径
    private int centerX;                  //中心X
    private int centerY;                  //中心Y
    private double[] data = {80, 60, 80};
    private Paint mainPaint;                //雷达区画笔
    private Paint valuePaint;               //数据区画笔
    private Paint textPaint;                //文本画笔


    private Bitmap mRowLeftBitmap;
    private Bitmap mRightBitmap;
    private Bitmap mTopBitmap;

    /** 偏移量  Y */
    private float offsetY=0;

  //  private AttributeSet attrs;

    public RadarView(Context context) {
        super(context);
        init(context,null);
    }


    public RadarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs!=null){
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RadarAttrs);
            offsetY = ta.getDimension(R.styleable.RadarAttrs_margin,0);
        }
        mContext = context;
        mRowLeftBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.aiteacher_radar_row_left);

        mRightBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.aiteacher_row_right);

        mTopBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.aiteacher_row_top);


        mainPaint = new Paint();
        mainPaint.setColor(Color.parseColor("#ffffffff"));
        mainPaint.setAntiAlias(true); //消除锯齿
        mainPaint.setStyle(Paint.Style.STROKE); //绘制空心圆

        valuePaint = new Paint();
        valuePaint.setAntiAlias(true); //消除锯齿
        valuePaint.setColor(Color.parseColor("#ffffffff"));


        textPaint = new Paint();
        valuePaint.setAntiAlias(true); //消除锯齿
        textPaint.setColor(Color.parseColor("#ffffffff"));
        textPaint.setTextSize(mContext.getResources().getDimension(R.dimen.aiteacher_row_textsize));

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = Math.min(h, w) / 2 * 0.6f;//半径占整个view 的 百分之60
        //中心坐标
        centerX = w / 2;
        centerY = h / 2+(int) offsetY;
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }


    /**
     * 雷达圆
     *
     * @param canvas
     */
    private void drawRound(Canvas canvas) {
        //最内层的圆
        canvas.drawCircle(centerX, centerY, radius / 3, mainPaint);
        //第二个圆
        canvas.drawCircle(centerX, centerY, radius / 3 * 2, mainPaint);

        //最外层的圆
        canvas.drawCircle(centerX, centerY, radius, mainPaint);


    }

    /**
     * 绘制直线
     */
    private void drawLines(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            path.reset();
            path.moveTo(centerX, centerY);
            float x = (float) (centerX + radius * Math.cos(angle * i));
            float y = (float) (centerY + radius * Math.sin(angle * i));
            path.lineTo(x, y);
            canvas.drawPath(path, mainPaint);
        }
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < count; i++) {
            double percent = data[i] / maxValue;
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);


            if (i == 1) {
                int height = mRowLeftBitmap.getHeight();
                int width = mRowLeftBitmap.getWidth();
                canvas.drawBitmap(mRowLeftBitmap, x - width, y - height, valuePaint);
                canvas.drawText("纠音", x - width, y - height - 15, textPaint);
            }
            if (i == 0) {
                int height = mRightBitmap.getHeight();
                int width = mRightBitmap.getWidth();
                canvas.drawBitmap(mRightBitmap, x, y, valuePaint);
                float f = textPaint.measureText("流畅性");
                canvas.drawText("流畅性", x + width - f, y, textPaint);
            }

            if (i == 2) {
                int height = mTopBitmap.getHeight();
                int width = mTopBitmap.getWidth();
                canvas.drawBitmap(mTopBitmap, x, y - height, valuePaint);
                float f = textPaint.measureText("准确性");

                canvas.drawText("准确性", x + width - f, y - height - 15, textPaint);
            }
        }
    }


    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            double percent = data[i] / maxValue;
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);
            if (i == 0) {
                path.moveTo(x, centerY);
            } else {
                path.lineTo(x, y);
            }
            //绘制小圆点
            canvas.drawCircle(x, y, 10, valuePaint);
        }
        valuePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, valuePaint);
        valuePaint.setAlpha(127);
        //绘制填充区域
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //三个圆
        drawRound(canvas);

        //中心点到各圆的直线
        drawLines(canvas);
        //分值
        drawRegion(canvas);

        //文字
        drawText(canvas);
    }

    /**
     * 设置数据
     *
     * @param data
     */
    public void setData(double[] data) {
        this.data = data;
        invalidate();
    }


}
