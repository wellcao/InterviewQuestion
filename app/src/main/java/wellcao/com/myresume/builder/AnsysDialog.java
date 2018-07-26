package wellcao.com.myresume.builder;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wellcao.com.myresume.R;


/**
 * @author wellcao
 * @date 2018/6/28
 * class introduction: 报告弹窗
 */
public class AnsysDialog extends Dialog {

    private View contentView;
    private TextView tvLetterHeader;
    private TextView tvLetterContent;
    private TextView tvLetterFooter;
    private TextView tvSpeekTimeLeft;
    private TextView tvSpeekTimeMiddle;
    private TextView tvSpeekTimeRight;
    private TextView tvStarLeft;
    private TextView tvStarRight;
    private TextView tvScoreLeft;
    private TextView tvScoreMiddle;
    private TextView tvScoreRight;
    private RadarView radarView;
    private Button btClose;

    private String letterHeader;
    private String letterContent;
    private String letterFooter;
    private int speekTime;
    private int starReward;
    private int score;
    private double[] radarData;

    private AnsysDialog(@NonNull Context context) {
        super(context, R.style.CommonDialogStyle);
    }

    private AnsysDialog translate(AnsysDialog orignal){
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_ansys_aiteacher);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        initView();
        initData();
        contentView=findViewById(android.R.id.content);
        initListener();
    }

    private void initView(){
        // 文字
        tvLetterHeader=findViewById(R.id.tv_letter_header_aiteacher);
        tvLetterContent=findViewById(R.id.tv_letter_content_aiteacher);
        tvLetterFooter=findViewById(R.id.tv_left_footer_aiteacher);

        // 开口时长
        tvSpeekTimeLeft=findViewById(R.id.tv_speekTime_left_aiteacher);
        tvSpeekTimeMiddle=findViewById(R.id.tv_timecount_middle_aiteacher);
        tvSpeekTimeRight=findViewById(R.id.tv_timecount_middle_aiteacher);
        // 奖励
        tvStarLeft=findViewById(R.id.tv_star_left_aiteacher);
        tvStarRight=findViewById(R.id.tv_star_right_aiteacher);
        // 得分
        tvScoreLeft=findViewById(R.id.tv_score_left_aiteacher);
        tvScoreMiddle=findViewById(R.id.tv_score_middle_aiteacher);
        tvScoreRight=findViewById(R.id.tv_score_right_aiteacher);

        radarView=findViewById(R.id.radar_aiteacher);
        btClose=findViewById(R.id.bt_close_aiteacher);
    }

    private void initData(){
        if (letterHeader!=null){
            tvLetterHeader.setText(letterHeader);
        }
        if (letterContent!=null){
            tvLetterContent.setText(letterContent);
        }
        if (letterFooter!=null){
            tvLetterFooter.setText(letterFooter);
        }

        // 开口时长
        if (1000>speekTime&&speekTime>=100){
            visible(tvSpeekTimeLeft,tvSpeekTimeMiddle,tvSpeekTimeRight);
            tvSpeekTimeLeft.setText(String.valueOf(speekTime/100));
            tvSpeekTimeMiddle.setText(String.valueOf((speekTime%100)/10));
            tvSpeekTimeRight.setText(String.valueOf(speekTime%10));
        }else if (10<=speekTime&&speekTime<100){
            gone(tvSpeekTimeLeft);
            visible(tvSpeekTimeMiddle,tvSpeekTimeRight);
            tvSpeekTimeMiddle.setText(String.valueOf(speekTime/10));
            tvSpeekTimeRight.setText(String.valueOf(speekTime%10));
        }else if (0<=speekTime&&speekTime<10){
            gone(tvSpeekTimeLeft,tvSpeekTimeMiddle);
            visible(tvSpeekTimeRight);
            tvSpeekTimeRight.setText(String.valueOf(speekTime));
        }

        // 奖励星星
        if (100>starReward&&starReward>=10){
            visible(tvStarLeft,tvStarRight);
            tvStarLeft.setText(String.valueOf(starReward/10));
            tvStarRight.setText(String.valueOf(starReward%10));
        }else if (0<=starReward&&starReward<10){
            gone(tvStarLeft);
            visible(tvStarRight);
            tvStarRight.setText(String.valueOf(starReward%10));
        }

        // 得分
        if (1000>score&&score>=100){
            visible(tvScoreLeft,tvScoreMiddle,tvScoreRight);
            tvScoreLeft.setText(String.valueOf(score/100));
            tvScoreMiddle.setText(String.valueOf((score%100)/10));
            tvScoreRight.setText(String.valueOf(score%10));
        }else if (10<=score&&score<100){
            gone(tvScoreLeft);
            visible(tvScoreMiddle,tvScoreRight);
            tvScoreMiddle.setText(String.valueOf(score/10));
            tvScoreRight.setText(String.valueOf(score%10));
        }else if (0<=score&&score<10){
            gone(tvScoreLeft,tvScoreMiddle);
            visible(tvScoreRight);
            tvScoreRight.setText(String.valueOf(score));
        }
    }

    private void initListener(){
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setLetterHeader(String str){
        this.letterHeader=str;
    }

    public void setLetterContent(String str){
        this.letterContent=str;
    }

    public void setLetterFooter(String str){
        this.letterFooter=str;
    }

    public void setSpeekTime(int speekTime){
        this.speekTime=speekTime;
    }

    public void setStarReward(int starReward){
        this.starReward=starReward;
    }

    public void setScore(int score){
        this.score=score;
    }

    public void setRadarData(double[] d){
        radarData=d;
    }


    public static class Builder{
        private AnsysDialog dialog;
        public Builder(Context context){
            dialog=new AnsysDialog(context);
        }

        public Builder letterHeader(String str){
            dialog.setLetterHeader(str);
            return this;
        }

        public Builder letterContent(String str){
            dialog.setLetterContent(str);
            return this;
        }

        public Builder letterFotter(String str){
            dialog.setLetterFooter(str);
            return this;
        }

        public Builder speekTime(int i){
            dialog.setSpeekTime(i);
            return this;
        }

        public Builder starReward(int i){
            dialog.setStarReward(i);
            return this;
        }

        public Builder score(int i){
            dialog.setScore(i);
            return this;
        }

        public Builder radarData(double[] d){
            dialog.radarData=d;
            return this;
        }

        public Builder cancleable(boolean b){
            dialog.setCancelable(b);
            return this;
        }

        public AnsysDialog build() {
            return dialog.translate(dialog);
        }
    }

    private void visible(View... views){
        for (int i=0;i<views.length;i++){
            views[i].setVisibility(View.VISIBLE);
        }
    }

    private void invisible(View... views){
        for (int i=0;i<views.length;i++){
            views[i].setVisibility(View.INVISIBLE);
        }
    }

    private void gone(View... views){
        for (int i=0;i<views.length;i++){
            views[i].setVisibility(View.GONE);
        }
    }
}
