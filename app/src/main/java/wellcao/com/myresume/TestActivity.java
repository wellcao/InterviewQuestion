package wellcao.com.myresume;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import wellcao.com.myresume.bridge.Image;
import wellcao.com.myresume.bridge.ImageImp;
import wellcao.com.myresume.bridge.PNGImage;
import wellcao.com.myresume.bridge.WindowsImp;
import wellcao.com.myresume.builder.Actor;
import wellcao.com.myresume.builder.ActorBuilder;
import wellcao.com.myresume.builder.ActorController;
import wellcao.com.myresume.builder.AnsysDialog;
import wellcao.com.myresume.decorate.BaseDrink;
import wellcao.com.myresume.decorate.IceDecorator;
import wellcao.com.myresume.decorate.LimeJuiceDecorator;
import wellcao.com.myresume.decorate.SugarDecorator;
import wellcao.com.myresume.decorate.WhiteRumDecorator;
import wellcao.com.myresume.extend.Drink;
import wellcao.com.myresume.realcase.DeviceInfo;
import wellcao.com.myresume.realcase.DeviceInfoBase;
import wellcao.com.myresume.utils.XmlUtils;

/**
 * Created by hhc on 2018/07/11 0011.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class TestActivity extends AppCompatActivity {

    private TextView tvOutput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        initData();
    }

    private void initView(){
        tvOutput = findViewById(R.id.tv_output);
    }

    private void initData(){

    }

    public void perform(View view) {
        //Toast.makeText(this,"perform",Toast.LENGTH_LONG).show();
        String output = doBuilderTest();
        tvOutput.setText(output);
        //showBuilderDialog();
    }

    private String doDecrator(){
        //Drink justWhiteRum = new WhiteRumDecorator(new BaseDrink());
        Drink daiquiriDrink = new IceDecorator(new SugarDecorator(new LimeJuiceDecorator(new WhiteRumDecorator(new BaseDrink()))));
       // Drink daiquiriWithoutSugarDrink = new IceDecorator(new LimeJuiceDecorator(new WhiteRumDecorator(new BaseDrink())));
       // Drink daiquiriDoubleRumDrink = new IceDecorator(new SugarDecorator(new LimeJuiceDecorator(new WhiteRumDecorator(new WhiteRumDecorator(new BaseDrink())))));
       // Drink daiquiriDoubleRumWithoutSugarDrink = new IceDecorator(new LimeJuiceDecorator(new WhiteRumDecorator(new WhiteRumDecorator(new BaseDrink()))));
        return daiquiriDrink.server();
    }

    //  桥接模式   一个维度持有其它维度的对象接口
    private String doBridge(){
        Image image;
        ImageImp imp;
        image = new PNGImage();
        imp = new WindowsImp();
        image.setImageImp(imp);
        return image.parseFile("图像1");
    }


    private String doRealCase(){
/*        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)getSystemService(Context.ACTIVITY_SERVICE)).getMemoryInfo(memoryInfo);
        DeviceInfo deviceInfo=new DeviceInfoApi16Decorator(new DeviceInfoDecorator(new DeviceInfoBase(this, getPackageManager())),memoryInfo);*/

        DeviceInfo deviceInfo =new DeviceInfoBase(this,getPackageManager());
        return deviceInfo.getDeviceInfo();
    }


    private void showBuilderDialog(){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            new AnsysDialog.Builder(this).letterHeader("fafsdafds")
                    .letterContent("地方所得税的范德萨范德萨范德萨发地方大V嘎嘎嘎法规")
                    .letterFotter("无名者")
                    .speekTime(99)
                    .starReward(23)
                    .score(66)
                    .radarData(new double[]{10d,80d,10d})
                    .cancleable(false)
                    .build().show();
    }

    private String doBuilderTest(){
        ActorBuilder ab; //针对抽象建造者编程
        ab =  (ActorBuilder) XmlUtils.getClassList(this).get(1); //反射生成具体建造者对象

        Actor actor = new ActorController().construct(ab);
        return "输出： "+
                "\n性别：" + actor.getSex()
                +"\n面容：" + actor.getFace()
                +"\n服装：" + actor.getCostume()
                +"\n发型：" + actor.getHairstyle();
    }

    @Override
    public void onBackPressed() {
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            super.onBackPressed();
        }
    }
}
