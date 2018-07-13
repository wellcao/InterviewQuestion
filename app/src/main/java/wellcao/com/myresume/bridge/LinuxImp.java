package wellcao.com.myresume.bridge;

/**
 * @author wellcao
 * @date 2018/7/12
 * class introduction:
 */
public class LinuxImp implements ImageImp {

    @Override
    public String doPaint(Matrix m) {
        //调用Linux系统的绘制函数绘制像素矩阵
        //System.out.print("在Linux操作系统中显示图像：");
        return "在Linux操作系统中显示图像：";
    }
}
