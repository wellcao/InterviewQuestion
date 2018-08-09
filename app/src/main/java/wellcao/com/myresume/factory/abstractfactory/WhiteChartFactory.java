package wellcao.com.myresume.factory.abstractfactory;

/**
 * @author wellcao
 * @date 2018/8/9
 * class introduction:
 */
public class WhiteChartFactory implements AbstractChartFactory{

    @Override
    public Line createLineFactory() {
        return new WhiteLine();
    }

    @Override
    public Pie createPieFactory() {
        return new WhitePie();
    }
}
