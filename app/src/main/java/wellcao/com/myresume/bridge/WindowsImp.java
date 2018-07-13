package wellcao.com.myresume.bridge;

/**
 * @author wellcao
 * @date 2018/7/12
 * class introduction: Windows操作系统实现类：具体实现类
 */
public class WindowsImp implements ImageImp{

    public String doPaint(Matrix m) {
        //调用Windows系统的绘制函数绘制像素矩阵
        //System.out.print("在Windows操作系统中显示图像：");
        return "在Windows操作系统中显示图像：";
    }
}
