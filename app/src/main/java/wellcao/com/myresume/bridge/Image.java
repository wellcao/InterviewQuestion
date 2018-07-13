package wellcao.com.myresume.bridge;

/**
 * @author wellcao
 * @date 2018/7/12
 * class introduction: 抽象图像类：抽象类
 *  PS: 抽象化角色
 *
 *  持有实现化角色的接口
 */
abstract public class Image {

    protected ImageImp imp;

    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }

    //  实现类维度对应功能
    public abstract String parseFile(String fileName);
}
