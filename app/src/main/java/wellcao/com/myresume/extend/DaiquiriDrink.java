package wellcao.com.myresume.extend;

/**
 * Created by hhc on 2018/07/11 0011.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 * introduction: 常规的鸡尾酒 放了很多佐料
 */

class DaiquiriDrink implements Drink{
    @Override
    public String server() {
        return "Please, a drink with:\n- white rum\n- lime juice\n- sugar\n- ice";
    }
}
