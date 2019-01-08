package tt.cc.com.ttmvvm.ui.widgt;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import tt.cc.com.ttmvvm.R;
import tt.cc.com.ttmvvm.utlis.AppUtils;
import tt.cc.com.ttmvvm.utlis.ResUtils;


/**
 * Created by Administrator on 2017/12/8.
 */

public class CustomToolbar extends Toolbar {

    private Context context;
    private View title_line;

    public CustomToolbar(Context context) {
        super(context);
        this.context = context;
    }

    public CustomToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    private TextView mTvMainTitleLeft;
    private TextView mTvMainTitle;
    private TextView mTvMainTitleRight;
    private ImageView iv_logo;
    private ImageView iv_title_left;
    private ImageView iv_title_right;
    private RelativeLayout rlToolbar;

    public ImageView getIv_title_left() {
        return iv_title_left;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        rlToolbar = findViewById(R.id.rl_toolbar);

        mTvMainTitleLeft = (TextView) findViewById(R.id.tv_title_left);
        mTvMainTitle = (TextView) findViewById(R.id.tv_title);
        mTvMainTitleRight = (TextView) findViewById(R.id.tv_title_right);
        iv_logo = findViewById(R.id.iv_title_logo);
        title_line = findViewById(R.id.title_line);
        iv_title_left = findViewById(R.id.iv_title_left);
        iv_title_right = findViewById(R.id.iv_title_right);

        setToolbarLayoutParams();

    }

    private void setToolbarLayoutParams() {
        if (rlToolbar != null) {
            CustomToolbar.LayoutParams params = (LayoutParams) rlToolbar.getLayoutParams();
            //
            int statusBarHeight = AppUtils.getStatusBarHeight(context);
            params.setMargins(0, statusBarHeight, 0, 0);

            ViewGroup.LayoutParams rootLayoutParams = getLayoutParams();
            rootLayoutParams.height = ResUtils.getDimensionPixelOffset(R.dimen.app_toolbar_content_height) + statusBarHeight;
            requestLayout();
        }
    }


    /**
     * 点击左边返回
     */
    /*public void setLeftImgBack() {
        iv_title_left.setVisibility(VISIBLE);
        rl_left_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }

            }
        });
    }*/

    //设置主title的内容
    public void setMainTitle(String text) {
        this.setTitle(" ");
        if (mTvMainTitle != null) {
            mTvMainTitle.setVisibility(View.VISIBLE);
            mTvMainTitle.setText(text);
        }
    }

    public void setMainTitleSize(int size) {
        if (mTvMainTitle != null) {
            mTvMainTitle.setTextSize(size);
        }
    }

    //设置title图标
    public void setMainTitleDrawable(int res) {
        Drawable dwright = ContextCompat.getDrawable(getContext(), res);
        dwright.setBounds(0, 0, dwright.getMinimumWidth(), dwright.getMinimumHeight());
        if (mTvMainTitle != null) {
            mTvMainTitle.setCompoundDrawables(null, null, dwright, null);
        }
    }

    //设置title点击事件
    public void setMainTitleOnClick(OnClickListener clickListener) {
        if (mTvMainTitle != null)
            mTvMainTitle.setOnClickListener(clickListener);
    }

    //设置主title的内容文字的颜色
    public void setMainTitleColor(int color) {
        mTvMainTitle.setTextColor(color);
    }

    public View getMainTitle() {
        return mTvMainTitle;
    }

    //设置title左边文字
    public void setMainTitleLeftText(String text) {
        mTvMainTitleLeft.setVisibility(View.VISIBLE);
        mTvMainTitleLeft.setText(text);
    }

    /**
     * 点击左边返回
     */
    public void setLeftBack() {
        mTvMainTitleLeft.setVisibility(VISIBLE);
        mTvMainTitleLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }

            }
        });
    }

    public void setLeftImgClick(OnClickListener clickListener) {
        iv_title_left.setVisibility(VISIBLE);
        iv_title_left.setOnClickListener(clickListener);
    }

    public void setRightImgClick(OnClickListener clickListener) {
        iv_title_right.setVisibility(VISIBLE);
        iv_title_right.setOnClickListener(clickListener);
    }


    public void setLeftImg(int res) {
        iv_title_left.setVisibility(VISIBLE);
        iv_title_left.setImageResource(res);
    }

    public void setRightImg(int res) {
        iv_title_right.setVisibility(VISIBLE);
        iv_title_right.setImageResource(res);
    }


    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        if (color == 0) {
//            title_line.setVisibility(GONE);
        }
    }

    @Override
    public void setBackgroundResource(int resid) {
        super.setBackgroundResource(resid);
        if (resid == 0) {
//            title_line.setVisibility(GONE);
        }
    }

    //设置title左边点击事件
    public void setMainTitleLeftOnClick(OnClickListener clickListener) {
        mTvMainTitleLeft.setOnClickListener(clickListener);
    }


    //设置title左边文字颜色
    public void setMainTitleLeftColor(int color) {
        mTvMainTitleLeft.setTextColor(color);
    }

//    //设置title左边图标
//    public void setMainTitleLeftDrawable(int res) {
////        Drawable dwLeft = ContextCompat.getDrawable(getContext(), res);
//        if (res > 0) {
////            Drawable dwLeft = SkinManager.getInstance().getDrawable(res);
////            dwLeft.setBounds(0, 0, dwLeft.getMinimumWidth() - 5, dwLeft.getMinimumHeight() - 5);
//
//            mTvMainTitleLeft.setCompoundDrawables(dwLeft, null, null, null);
//        } else {
//            mTvMainTitleLeft.setCompoundDrawables(null, null, null, null);
//        }
//    }

    public View getMainTitleLeftView() {
        return mTvMainTitleLeft;
    }

    //设置title右边文字
    public void setMainTitleRightText(String text) {
        mTvMainTitleRight.setVisibility(View.VISIBLE);
        mTvMainTitleRight.setText(text);
    }

    //设置title右边文字颜色
    public void setMainTitleRightColor(int color) {
        mTvMainTitleRight.setTextColor(color);
    }

//    //设置title右边图标
//    public void setMainTitleRightDrawable(int res) {
////        Drawable dwRight = ContextCompat.getDrawable(getContext(), res);
//        Drawable dwRight = SkinManager.getInstance().getDrawable(res);
//        dwRight.setBounds(0, 0, dwRight.getMinimumWidth(), dwRight.getMinimumHeight());
//        mTvMainTitleRight.setCompoundDrawables(null, null, dwRight, null);
//    }

    public View getMainTitleRightView() {
        return mTvMainTitleRight;
    }

    //设置title点击事件
    public void setMainTitleRightOnClick(OnClickListener clickListener) {
        mTvMainTitleRight.setOnClickListener(clickListener);
    }

    public void setLogoResource(int resId) {
        iv_logo.setVisibility(VISIBLE);
        iv_logo.setImageResource(resId);
    }

    //设置toolbar状态栏颜色
    public void setToolbarBackground(int res) {
        this.setBackgroundResource(res);
    }

    //设置toolbar左边图标
    public void setToolbarLeftBackImageRes(int res) {
        this.setNavigationIcon(res);
    }

    //设置toolbar左边文字
    public void setToolbarLeftText(String text) {
        this.setNavigationContentDescription(text);
    }

    //设置toolbar的标题
    public void setToolbarTitle(String text) {
        this.setTitle(text);
    }

    //设置toolbar标题的颜色
    public void setToolbarTitleColor(int color) {
        this.setTitleTextColor(color);
    }

    //设置toolbar子标题
    public void setToolbarSubTitleText(String text) {
        this.setSubtitle(text);
    }

    //设置toolbar子标题颜色
    public void setToolbarSubTitleTextColor(int color) {
        this.setSubtitleTextColor(color);
    }


    public TextView getmTvMainTitleLeft() {
        return mTvMainTitleLeft;
    }

    public View showBarLine() {
        title_line.setVisibility(VISIBLE);
        return title_line;
    }

    public void setRightIconDrawable(Drawable rightIconDrawable) {
        iv_title_right.setVisibility(VISIBLE);
        iv_title_right.setBackground(rightIconDrawable);
    }

}
