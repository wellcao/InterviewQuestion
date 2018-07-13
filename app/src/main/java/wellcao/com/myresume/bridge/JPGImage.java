package wellcao.com.myresume.bridge;

/**
 * @author wellcao
 * @date 2018/7/12
 * class introduction:  扩充抽象类
 */
public class JPGImage extends Image {
    public String parseFile(String fileName) {
        //模拟解析JPG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        // imp  实现类接口    实现类功能
        imp.doPaint(m);

        //  抽象类功能
        return imp.doPaint(m)+"\n"+fileName + "，格式为JPG。";
    }
}
