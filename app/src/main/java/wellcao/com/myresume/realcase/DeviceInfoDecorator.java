package wellcao.com.myresume.realcase;

/**
 * Created by hhc on 2018/07/12 0012.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class DeviceInfoDecorator implements DeviceInfo {

    private DeviceInfo decoratedDeviceInfo;

    public DeviceInfoDecorator(DeviceInfo decoratedDeviceInfo){
        this.decoratedDeviceInfo = decoratedDeviceInfo;
    }
    @Override
    public String getDeviceInfo() {
        return decoratedDeviceInfo.getDeviceInfo();
    }
}
