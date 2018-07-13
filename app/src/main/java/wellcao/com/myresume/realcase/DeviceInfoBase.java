package wellcao.com.myresume.realcase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.Locale;

/**
 * Created by hhc on 2018/07/12 0012.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public class DeviceInfoBase implements DeviceInfo{
    private final Context context;
    private final PackageManager packageManager;

    // PackageManager is just a wrapper over Android's PackageManager for unit tests purposes
    public DeviceInfoBase(final Context context, final PackageManager packageManager) {
        this.context = context;
        this.packageManager = packageManager;
    }

    @Override
    public String getDeviceInfo()  {
        try {
            return String.format(Locale.getDefault(),
                    "Important device info for analysis:\n\nVersion:\nNAME=%s\nRELEASE=%s\nSDK_INT=%d\n\nDevice:\nMANUFACTURER=%s\nBRAND=%s\nMODEL=%s\nDEVICE=%s\nPRODUCT=%s\nDENSITY_DPI=%d\n\nOther:\nBOARD=%s\nBOOTLOADER=%s\nDISPLAY=%s\nFINGERPRINT=%s\nHARDWARE=%s\nHOST=%s\nID=%s\nTAGS=%s\nTIME=%d\nTYPE=%s\nUSER=%s",
                    packageManager.getPackageInfo(context.getPackageName(), 0).versionCode,
                    Build.VERSION.RELEASE,
                    Build.VERSION.SDK_INT,
                    Build.MANUFACTURER,
                    Build.BRAND,
                    Build.MODEL,
                    Build.DEVICE,
                    Build.PRODUCT,
                    context.getResources().getDisplayMetrics().densityDpi,
                    Build.BOARD,
                    Build.BOOTLOADER,
                    Build.DISPLAY,
                    Build.FINGERPRINT,
                    Build.HARDWARE,
                    Build.HOST,
                    Build.ID,
                    Build.TAGS,
                    Build.TIME,
                    Build.TYPE,
                    Build.USER);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
