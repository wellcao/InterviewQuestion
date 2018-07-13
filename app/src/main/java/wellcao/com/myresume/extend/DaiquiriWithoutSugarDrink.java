package wellcao.com.myresume.extend;

/**
 * Created by hhc on 2018/07/11 0011.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

class DaiquiriWithoutSugarDrink extends DaiquiriDrink {
    @Override
    public String server() {
        return "Please, a drink with:\n- white rum\n- lime juice\n- ice";
        //return super.server()+" no sugar";
    }
}
