package wellcao.com.myresume.bridge;

/**
 * @author wellcao
 * @date 2018/7/12
 * class introduction:
 */
public class UnixImp implements ImageImp {

    @Override
    public String doPaint(Matrix m) {
        //调用Unix系统的绘制函数绘制像素矩阵
        //System.out.print("在Unix操作系统中显示图像：");
        return "在Unix操作系统中显示图像：";
    }
}
