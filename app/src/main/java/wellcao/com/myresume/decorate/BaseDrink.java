package wellcao.com.myresume.decorate;

import wellcao.com.myresume.extend.Drink;

/**
 * Created by hhc on 2018/07/11 0011.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 * introduction:使用装饰器，我们只需对配料进行一次建模，
 * 然后可以自由地将其与更清洁的结果相结合。为此，我们需要一个基类（在本例中为BaseDrink），
 * 它将作为主要组件从哪里扩展行为; 一个装饰器抽象（在这个例子中是DrinkDecorator）和我们需要扩展行为的任何数量的装饰器实现
 */

public class BaseDrink implements Drink {
    @Override
    public String server() {
        return "Please, a drink with:";
    }
}
