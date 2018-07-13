package wellcao.com.myresume.bridge;

/**
 * @author wellcao
 * @date 2018/7/12
 * class introduction:
 */
public class PNGImage extends Image {
    public String parseFile(String fileName) {
        //模拟解析PNG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imp.doPaint(m);
        return imp.doPaint(m)+"\n"+fileName + "，格式为PNG。";
    }
}
