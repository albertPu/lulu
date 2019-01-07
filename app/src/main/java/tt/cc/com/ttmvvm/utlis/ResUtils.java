package tt.cc.com.ttmvvm.utlis;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import tt.cc.com.ttmvvm.TtApplication;


/**
 * Desc:
 * Created by Jeff on 2018/8/24
 **/
public class ResUtils {
    private ResUtils() {
    }

    /**
     * 服务器上传的默认的xxxhdpi的图片
     * xxxhdpi = 4
     * xxhdpi = 3
     * xhdpi = 2
     * hdpi = 1.5
     * mdpi = 1
     */
    private final static int defaultDensity = 4;
    private static final String RES_ID = "id";
    private static final String RES_STRING = "string";
    private static final String RES_DRABLE = "drawable";
    private static final String RES_LAYOUT = "layout";
    private static final String RES_STYLE = "style";
    private static final String RES_COLOR = "color";
    private static final String RES_DIMEN = "dimen";
    private static final String RES_ANIM = "anim";
    private static final String RES_MENU = "menu";
    private static final String RES_MIPMAP = "mipmap";

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        final float scale = TtApplication.Companion.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(float pxValue) {
        final float scale = TtApplication.Companion.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int px2sp(float pxValue) {
        float fontScale = TtApplication.Companion.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int sp2px(float spValue) {
        float fontScale = TtApplication.Companion.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获取屏幕缩放倍数
     *
     * @return
     */
    public static float getdensity() {
        float scale = TtApplication.Companion.getContext().getResources().getDisplayMetrics().density;
        return scale;
    }

    /**
     * 获取color资源
     *
     * @param color color资源id
     * @return color值
     */
    public static int getColor(@ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return TtApplication.Companion.getContext().getResources().getColor(color, null);
        } else {
            return TtApplication.Companion.getContext().getResources().getColor(color);
        }
    }

    /**
     * 获取string资源id
     *
     * @param id string资源id
     * @return string
     */
    public static String getString(@StringRes int id) {
        return TtApplication.Companion.getContext().getResources().getString(id);
    }

    /**
     * 获取string资源id
     *
     * @param id         资源id
     * @param formatArgs 字符串占位符的值
     * @return string
     */
    public static String getString(@StringRes int id, Object... formatArgs) {
        return TtApplication.Companion.getContext().getResources().getString(id, formatArgs);
    }

    /**
     * 获取drawable
     *
     * @param drawableId drawable资源id
     * @return drawable
     */
    public static Drawable getDrawable(int drawableId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return TtApplication.Companion.getContext().getResources().getDrawable(drawableId, null);
        } else {
            return TtApplication.Companion.getContext().getResources().getDrawable(drawableId);
        }
    }

    /**
     * 根据id 获取string数组资源
     *
     * @param id id
     * @return 字符串数组
     */
    public static String[] getStringArray(@ArrayRes int id) {
        return TtApplication.Companion.getContext().getResources().getStringArray(id);
    }

    /**
     * 根据id 获取int 数组资源
     *
     * @param id id
     * @return int数组
     */
    public static int[] getIntArray(@ArrayRes int id) {
        return TtApplication.Companion.getContext().getResources().getIntArray(id);
    }

    /**
     * 根据id 获取某个dimen的值,如果是dp或sp的单位,将其乘以density,如果是px,则不乘   返回float
     *
     * @param id id
     * @return dimen的值
     */
    public static float getDimension(@DimenRes int id) {
        return TtApplication.Companion.getContext().getResources().getDimension(id);
    }

    /**
     * 根据id 获取某个dimen的值,如果是dp或sp的单位,将其乘以density,如果是px,则不乘  返回int
     *
     * @param id id
     * @return dimen的值
     */
    public static int getDimensionPixelOffset(@DimenRes int id) {
        return TtApplication.Companion.getContext().getResources().getDimensionPixelOffset(id);
    }

    /**
     * 根据id 获取某个dimen的值 则不管写的是dp还是sp还是px,都会乘以denstiy.
     *
     * @param id id
     * @return dimen的值
     */
    public static int getDimensionPixelSize(@DimenRes int id) {
        return TtApplication.Companion.getContext().getResources().getDimensionPixelSize(id);
    }

    /**
     * 获取assert文件中的文件的路径
     *
     * @param path assert文件中的文件路径
     * @return 拼接了file:///android_asset/ 的路径
     */
    public static String getAssertPath(String path) {
        return String.format("file:///android_asset/%s", path);
    }

    /**
     * 获取raw文件中的文件的路径
     *
     * @param fileName 文件名字
     * @return 拼接了android.resource://%s/raw/ 的路径
     */
    public static String getRawPath(String fileName) {
        return String.format("android.resource://%s/raw/%s", AppUtils.PackgeName(), fileName);
    }

    /**
     * Return bitmap.
     *
     * @param resId The resource id.
     * @return bitmap
     */
    public static Bitmap getBitmap(@DrawableRes final int resId) {
        Drawable drawable = ContextCompat.getDrawable(TtApplication.Companion.getContext(), resId);
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                  drawable.getIntrinsicHeight(),
                  Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * Return bitmap.
     *
     * @param resId     The resource id.
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     * @return bitmap
     */
    public static Bitmap getBitmap(@DrawableRes final int resId,
                                   final int maxWidth,
                                   final int maxHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        final Resources resources = TtApplication.Companion.getContext().getResources();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);
        options.inSampleSize = calculateInSampleSize(options, maxWidth, maxHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resId, options);
    }

    /**
     * Return the sample size.
     *
     * @param options   The options.
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     * @return the sample size
     */
    private static int calculateInSampleSize(final BitmapFactory.Options options,
                                             final int maxWidth,
                                             final int maxHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        while ((width >>= 1) >= maxWidth && (height >>= 1) >= maxHeight) {
            inSampleSize <<= 1;
        }
        return inSampleSize;
    }


    /**
     * 获取图片名称获取图片的资源id的方法
     */
    public static int getIdByDrawableName(String imageName) {
        int resId = TtApplication.Companion.getContext().getResources().getIdentifier(imageName, "drawable", TtApplication.Companion.getContext().getPackageName());
        return resId;
    }

    /**
     * 获取资源文件的id
     *
     * @param resName 资源名字
     * @return 资源id值
     */
    public static int getId(String resName) {
        return getResId(resName, RES_ID);
    }

    /**
     * 获取资源文件string的id
     *
     * @param resName 资源名字
     * @return 资源id值
     */
    public static int getStringId(String resName) {
        return getResId(resName, RES_STRING);
    }

    /**
     * 获取资源文件drawable的id
     *
     * @param resName 资源名字
     * @return 资源id值
     */
    public static int getDrawableId(String resName) {
        return getResId(resName, RES_DRABLE);
    }

    /**
     * desc: 获取资源文件mipmap的id
     *
     * @author Jeff created on 2018/10/8 18:22
     */
    public static int getMipmapId(String resName) {
        return getResId(resName, RES_MIPMAP);
    }

    /**
     * 获取资源文件layout的id
     *
     * @param resName 资源名字
     * @return 资源id值
     */
    public static int getLayoutId(String resName) {
        return getResId(resName, RES_LAYOUT);
    }

    /**
     * 获取资源文件style的id
     *
     * @param resName 资源名字
     * @return 资源id值
     */
    public static int getStyleId(String resName) {
        return getResId(resName, RES_STYLE);
    }

    /**
     * 获取资源文件color的id
     *
     * @param resName 资源名字
     * @return 资源id值
     */
    public static int getColorId(String resName) {
        return getResId(resName, RES_COLOR);
    }

    /**
     * 获取资源文件dimen的id
     *
     * @param resName 资源名字
     * @return 资源id值
     */
    public static int getDimenId(String resName) {
        return getResId(resName, RES_DIMEN);
    }

    /**
     * 获取资源文件ainm的id
     *
     * @param resName 资源名字
     * @return 资源id值
     */
    public static int getAnimId(String resName) {
        return getResId(resName, RES_ANIM);
    }

    /**
     * 获取资源文件menu的id
     */
    public static int getMenuId(String resName) {
        return getResId(resName, RES_MENU);
    }

    /**
     * 获取资源文件ID
     *
     * @param resName 资源名字
     * @return 资源id值
     */
    public static int getResId(String resName, String defType) {
        return TtApplication.Companion.getContext().getResources().getIdentifier(resName, defType, TtApplication.Companion.getContext().getPackageName());
    }


}
