package wellcao.com.myresume.builder;

/**
 * @author wellcao
 * @date 2018/7/26
 * class introduction:
 */
public class DevilBuilder extends ActorBuilder {
    public  void buildType()
    {
        actor.setType("恶魔");
    }
    public  void buildSex()
    {
        actor.setSex("妖");
    }
    public  void buildFace()
    {
        actor.setFace("丑陋");
    }
    public  void buildCostume()
    {
        actor.setCostume("黑衣");
    }
    public  void buildHairstyle()
    {
        actor.setHairstyle("光头");
    }

    //覆盖钩子方法
    public boolean isBareheaded()
    {
        return true;
    }
}
