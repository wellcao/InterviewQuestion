package wellcao.com.myresume.factory.staticfactory;

/**
 * @author wellcao
 * @date 2018/8/8
 * class introduction:
 */
public class ChartFactory {
    public static Chart getProduct(String tag){
        Chart chart = null;
        switch (tag){
            case "line":
                chart = new Line();
                break;
            case "pie":
                chart = new Pie();
                break;
            default:
                break;
        }
        return chart;
    }
}
