package wellcao.com.myresume.decorate;

import wellcao.com.myresume.extend.Drink;

/**
 * Created by hhc on 2018/07/11 0011.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 * PS: 抽象装饰（Decorator）角色：持有一个构件（Component）对象的实例，并实现一个与抽象构件接口一致的接口。
 *
 * 其中对接装饰模式的四个特点之2
 *
 * 它的义务： 1.  只需和被装饰者实现同一个接口   2. 需要持有被装饰者对象   衣服嘛  没肯定得装个人
 */

abstract class DrinkDecorator implements Drink{
    private final Drink decoratedDrink;

    public DrinkDecorator(Drink drink) {
        this.decoratedDrink = drink;
    }

    public String serve() {
        return decoratedDrink.server();
    }
}
