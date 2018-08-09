package wellcao.com.myresume.factory.factorymethod;

/**
 * @author wellcao
 * @date 2018/8/9
 * class introduction:
 */
public class PieFactory implements ChartFactory{
    @Override
    public Chart getProduct() {
        return new Pie();
    }
}
