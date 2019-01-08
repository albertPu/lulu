package tt.cc.com.ttmvvm.mvvm;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import jp.wasabeef.glide.transformations.BlurTransformation;
import tt.cc.com.ttmvvm.utlis.glid.GlideCircleTransform;
import tt.cc.com.ttmvvm.utlis.glid.GlideRoundTransform;

/**
 * created by Albert
 */
public class Bind {


    @BindingAdapter("bindFocusChangeListener")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener listener) {
        editText.setOnFocusChangeListener(listener);
    }

    @BindingAdapter("bindTouchListener")
    public static void bindTouchListener(EditText editText, View.OnTouchListener listener) {
        editText.setOnTouchListener(listener);
    }


    @BindingAdapter("bindGroupSelect")
    public static void bindClearAllSelect(RadioGroup radioGroup, String value) {
        radioGroup.clearCheck();
        int childCount = radioGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = radioGroup.getChildAt(i);
            if (childAt instanceof RadioButton) {
                if (TextUtils.equals(((RadioButton) childAt).getText().toString(), value)) {
                    radioGroup.check(childAt.getId());
                }
            }
        }
    }


    @BindingAdapter("bindEdSelection")
    public static void bindEdSelection(EditText editText, int position) {
        if (editText.toString().length() > position) {
            try {
                editText.setSelection(position);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static ValueAnimator slideAnimator(int start, int end, View view, int duration) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(animation -> {
            int animator1 = (int) animation.getAnimatedValue();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = animator1;
            view.setLayoutParams(layoutParams);
        });
        animator.setDuration(duration);
        return animator;
    }

    public enum ExpAnimatorState {
        Open, Close, None
    }


    @BindingAdapter("bind:color")
    public static void textColor(TextView textView, ObservableField<Integer> color) {
        //  int color1 = TtApplication.Companion.getContext().getResources().getColor(color.get());
        textView.setTextColor(color.get());
    }

    @BindingAdapter("bindImageUrl")
    public static void bindImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter("bindBlurImageUrl")
    public static void bindBlurImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url).bitmapTransform(new BlurTransformation(view.getContext(), 14, 3))
                .into(view);
    }

    @BindingAdapter("bindCircleImageUrl")
    public static void bindCircleImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url).bitmapTransform(new GlideCircleTransform(view.getContext()))
                .into(view);
    }

    @BindingAdapter(value = {"bindCornerImageUrl", "bindCornerSize"}, requireAll = false)
    public static void bindCornerImageUrl(ImageView view, String url, int size) {
        GlideRoundTransform glideRoundTransform;
        if (size == 0) {
            glideRoundTransform = new GlideRoundTransform(view.getContext());
        } else {
            glideRoundTransform = new GlideRoundTransform(view.getContext(), size);
        }
        Glide.with(view.getContext())
                .load(url).bitmapTransform(new CenterCrop(view.getContext()), glideRoundTransform)
                .into(view);
    }


    @BindingAdapter(value = {"bindRefresh", "bindRefreshListener", "bindLoadMoreListener"}, requireAll = false)
    public static void bindRefresh(SmartRefreshLayout layout, boolean isLoading, OnRefreshListener refreshListener, OnLoadMoreListener moreListener) {
        if (refreshListener != null) {
            layout.setOnRefreshListener(refreshListener);
        }
        if (moreListener != null) {
            layout.setOnLoadMoreListener(moreListener);
        }
        if (isLoading) {
            layout.autoRefresh();
        } else {
            layout.finishRefresh();
            layout.finishLoadMore();
        }
    }


    @BindingAdapter("bindMainColor")
    public static void bindMainColor(MaterialHeader materialHeader, int color) {
        materialHeader.setColorSchemeColors(color);
    }


    @BindingAdapter(value = {"bindViewPageListener", "bindSelectPage"}, requireAll = false)
    public static void bindViewPageListener(ViewPager viewPager, ViewPager.OnPageChangeListener listener, int selectPge) {
        viewPager.setOnPageChangeListener(listener);
        viewPager.setCurrentItem(selectPge);
    }

}
