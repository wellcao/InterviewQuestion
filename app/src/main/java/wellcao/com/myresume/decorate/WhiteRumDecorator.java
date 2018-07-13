package wellcao.com.myresume.decorate;

import wellcao.com.myresume.extend.Drink;

/**
 * Created by hhc on 2018/07/12 0012.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class WhiteRumDecorator extends DrinkDecorator {

    public WhiteRumDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String server() {
        return super.serve() + "\n- white rum";
    }
}
