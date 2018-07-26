package wellcao.com.myresume.builder;

/**
 * @author wellcao
 * @date 2018/7/26
 * class introduction:
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public  abstract void buildType();
    public  abstract void buildSex();
    public  abstract void buildFace();
    public  abstract void buildCostume();
    public  abstract void buildHairstyle();

    //工厂方法，返回一个完整的游戏角色对象
    public Actor createActor()
    {
        return actor;
    }

    //钩子方法
    public boolean isBareheaded() {
        return false;
    }
}
