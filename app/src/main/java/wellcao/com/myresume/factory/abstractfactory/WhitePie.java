package wellcao.com.myresume.factory.abstractfactory;


import wellcao.com.myresume.factory.factorymethod.Chart;

/**
 * @author wellcao
 * @date 2018/8/8
 * class introduction:
 */
public class WhitePie implements Pie {
    @Override
    public String display() {
        return "我是 白 Pie";
    }
}
