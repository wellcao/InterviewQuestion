package wellcao.com.myresume.factory.demo1;

/**
 * @author wellcao
 * @date 2018/8/8
 * class introduction:  传统方法
 */
public class Chart {

    private String type;
    private Histogram histogram;
    private Line line;
    private Pie pie;

    public Chart(String type) {
        this.type = type;
        switch (type) {
            case "histogram":
                histogram = new Histogram();
                break;
            case "line":
                line = new Line();
                break;
            case "pie":
                pie = new Pie();
                break;
            default:
                break;
        }
    }

    public String display(){
        String content = "";
        switch (type) {
            case "histogram":
                content = histogram.displayHistogram();
                break;
            case "line":
                content = line.displayLine();
                break;
            case "pie":
                content = pie.displayPie();
                break;
            default:
                break;
        }
        return content;
    }
}
