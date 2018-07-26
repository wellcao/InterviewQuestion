package wellcao.com.myresume.builder;

/**
 * @author wellcao
 * @date 2018/7/26
 * class introduction:
 */
public class ActorController {
    //逐步构建复杂产品对象
    public Actor construct(ActorBuilder ab)
    {
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        actor=ab.createActor();
        return actor;
    }
}
