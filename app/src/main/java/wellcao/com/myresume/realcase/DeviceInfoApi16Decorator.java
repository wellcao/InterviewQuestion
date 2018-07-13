package wellcao.com.myresume.realcase;

import android.app.ActivityManager;

import java.util.Locale;

/**
 * Created by hhc on 2018/07/12 0012.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class DeviceInfoApi16Decorator extends DeviceInfoDecorator {

    private final ActivityManager.MemoryInfo memoryInfo;

    public DeviceInfoApi16Decorator(DeviceInfo decoratedDeviceInfo,final ActivityManager.MemoryInfo memoryInfo) {
        super(decoratedDeviceInfo);
        this.memoryInfo = memoryInfo;
    }

    @Override
    public String getDeviceInfo() {
        return String.format(Locale.getDefault(), "%s\n%s", super.getDeviceInfo(), getMemoryParameters());
    }


    private String getMemoryParameters() {
        final long freeMemoryMBs = memoryInfo.totalMem;
        final long totalMemoryMBs = memoryInfo.availMem;

        return String.format(Locale.getDefault(),
                "TOTALMEMORYSIZE=%dMB\nFREEMEMORYSIZE=%dMB",
                totalMemoryMBs,
                freeMemoryMBs);
    }
}
