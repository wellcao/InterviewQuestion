package wellcao.com.myresume.factory.abstractfactory;

/**
 * @author wellcao
 * @date 2018/8/9
 * class introduction:
 */
public class RedChartFactory implements AbstractChartFactory{


    @Override
    public Line createLineFactory() {
        return new RedLine();
    }

    @Override
    public RedPie createPieFactory() {
        return new RedPie();
    }
}
