package android.xwpeng.tviewdesign.util;

/**
 * Created by xwpeng on 16-12-21.
 */

public class SystemUtil {
    /**
     *根据事件code获取事件名
     */
    public static String getEventName(int eventCode) {
        String name = null;
        switch (eventCode) {
            case 0:
                name = "ACTION_DOWN";
                break;
            case 1:
                name = "ACTION_UP";
                break;
            case 2:
                name = "ACTION_MOVE";
                break;
            case 3:
                name = "ACTION_CANCEL";
                break;
            case 4:
                name = "ACTION_OUTSIDE";
                break;
        }
        return name;
    }
}
