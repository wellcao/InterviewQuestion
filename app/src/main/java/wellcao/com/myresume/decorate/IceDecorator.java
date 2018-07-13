package wellcao.com.myresume.decorate;

import wellcao.com.myresume.extend.Drink;

/**
 * Created by hhc on 2018/07/11 0011.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 * introduction:  具体装饰者
 * Ps： 继承自抽象装饰   只需要记住它只要实现自己特定功能就ok  其余工作不用做
 */

public class IceDecorator extends DrinkDecorator {

    public IceDecorator(Drink drink) {
        super(drink);
    }

    public String server() {
        return super.serve() + "\n- ice";
    }
}
