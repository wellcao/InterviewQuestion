package wellcao.com.myresume.bridge;

/**
 * @author wellcao
 * @date 2018/7/12
 * class introduction:
 *
 *  PS:  修正后的抽象化角色
 */
public class BMPImage extends Image {

    @Override
    public String parseFile(String fileName) {
        //模拟解析BMP文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        return imp.doPaint(m)+"\n"+fileName + "，格式为BMP。";
    }
}