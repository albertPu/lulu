package tt.cc.com.ttmvvm.utlis;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.widget.TextView;
import de.greenrobot.common.StringUtils;
import tt.cc.com.ttmvvm.TtApplication;


/**
 * Desc:
 * Created by Jeff on 2018/12/10
 **/
public class AppUtils {


    /**
     * 对银行卡卡号以*号代替，只显示后四位
     *
     * @param bankCard
     * @return
     */
    public static String getBankEncryNum(String bankCard) {
        if (TextUtils.isEmpty(bankCard))
            return "";

        String encryNum = "**** **** **** ";
        if (bankCard.length() > 4) {
            encryNum += bankCard.substring(bankCard.length() - 4, bankCard.length());
        } else {
            encryNum += bankCard;
        }
        return encryNum;
    }


    public static String getAppNameByPID(Context context, int pid) {
        ActivityManager manager
                  = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                return processInfo.processName;
            }
        }
        return "";
    }


    /**
     * 获取状态栏的高度
     *
     * @param ctx
     * @return
     */
    public static int getStatusBarHeight(Context ctx) {
        try {
            int result = 0;
            int resourceId = ctx.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = ctx.getResources().getDimensionPixelSize(resourceId);
            }
            return result;
        } catch (Exception e) {
            return ResUtils.dp2px(20);
        }
    }

    public static String PackgeName() {
        String packgename = "unknow";
        try {
            packgename = TtApplication.Companion.getContext().getPackageManager().getPackageInfo(
                      TtApplication.Companion.getContext().getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packgename;
    }

}
