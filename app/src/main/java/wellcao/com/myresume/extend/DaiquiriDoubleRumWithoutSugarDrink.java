package wellcao.com.myresume.extend;

/**
 * Created by hhc on 2018/07/11 0011.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

class DaiquiriDoubleRumWithoutSugarDrink extends DaiquiriDoubleRumDrink{
    @Override
    public String server() {
        return "Please, a drink with:\n- double white rum\n- lime juice\n- ice";
        //return super.server()+" with double white rum";
    }
}
