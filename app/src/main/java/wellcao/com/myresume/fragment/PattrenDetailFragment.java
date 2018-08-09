package wellcao.com.myresume.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wellcao.com.myresume.R;
import wellcao.com.myresume.TestActivity;
import wellcao.com.myresume.base.BaseFragment;
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
import wellcao.com.myresume.factory.demo1.Chart;
import wellcao.com.myresume.factory.factorymethod.LineFactory;
import wellcao.com.myresume.factory.staticfactory.ChartFactory;
import wellcao.com.myresume.realcase.DeviceInfo;
import wellcao.com.myresume.realcase.DeviceInfoBase;
import wellcao.com.myresume.utils.XmlUtils;

/**
 * @author wellcao
 * @date 2018/8/8
 * class introduction:
 */
public class PattrenDetailFragment extends BaseFragment implements View.OnClickListener{

    private TextView tvOutput;
    private Button bt_perform;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_pattren_detail;
    }

    @Override
    protected void initView(View v) {
        tvOutput = v.findViewById(R.id.tv_output);
        bt_perform = v.findViewById(R.id.bt_perform);
    }

    @Override
    protected void initData() {
        Bundle b = getArguments();
        String titleName = (String) b.get("title");
        ((TestActivity)(getActivity())).setTitleName(titleName);
    }

    @Override
    protected void initListener() {
        bt_perform.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String output = doFactoryDemo1();
        tvOutput.setText(output);
    }

    /*************************************
     *
     *                                    装饰者模式
                                                       *************************************/

    private String doDecrator(){
        //Drink justWhiteRum = new WhiteRumDecorator(new BaseDrink());
        Drink daiquiriDrink = new IceDecorator(new SugarDecorator(new LimeJuiceDecorator(new WhiteRumDecorator(new BaseDrink()))));
        // Drink daiquiriWithoutSugarDrink = new IceDecorator(new LimeJuiceDecorator(new WhiteRumDecorator(new BaseDrink())));
        // Drink daiquiriDoubleRumDrink = new IceDecorator(new SugarDecorator(new LimeJuiceDecorator(new WhiteRumDecorator(new WhiteRumDecorator(new BaseDrink())))));
        // Drink daiquiriDoubleRumWithoutSugarDrink = new IceDecorator(new LimeJuiceDecorator(new WhiteRumDecorator(new WhiteRumDecorator(new BaseDrink()))));
        return daiquiriDrink.server();
    }

    private String doRealCase(){
/*        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)getSystemService(Context.ACTIVITY_SERVICE)).getMemoryInfo(memoryInfo);
        DeviceInfo deviceInfo=new DeviceInfoApi16Decorator(new DeviceInfoDecorator(new DeviceInfoBase(this, getPackageManager())),memoryInfo);*/

        DeviceInfo deviceInfo =new DeviceInfoBase(getActivity(),getActivity().getPackageManager());
        return deviceInfo.getDeviceInfo();
    }

    /*************************************
     *
     *                                    桥接模式
                                                      *************************************/
    private String doBridge(){
        Image image;
        ImageImp imp;
        image = new PNGImage();
        imp = new WindowsImp();
        image.setImageImp(imp);
        return image.parseFile("图像1");
    }





    /*************************************
     *
     *                                    建造者模式
                                                     *************************************/
    private void showBuilderDialog(){
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        new AnsysDialog.Builder(getActivity()).letterHeader("fafsdafds")
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
        ab =  (ActorBuilder) XmlUtils.getClassList(getActivity()).get(1); //反射生成具体建造者对象

        Actor actor = new ActorController().construct(ab);
        return "输出： "+
                "\n性别：" + actor.getSex()
                +"\n面容：" + actor.getFace()
                +"\n服装：" + actor.getCostume()
                +"\n发型：" + actor.getHairstyle();
    }


    /*************************************
     *
     *                                    工厂系列
                                                    *************************************/
    private String doFactoryDemo1(){
        Chart chart = new Chart("line");
        return chart.display();
    }

    private String doStaticFactory(){
        wellcao.com.myresume.factory.staticfactory.Chart chart = ChartFactory.getProduct("line");
        return chart.display();
    }

    private String doFactoryMethod(){
        wellcao.com.myresume.factory.factorymethod.ChartFactory chartFactory = new LineFactory();
        wellcao.com.myresume.factory.factorymethod.Chart chart = chartFactory.getProduct();
        return  chart.display();
    }


}
