package tt.cc.com.ttmvvm.mvvm.adapter.viewpage;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.databinding.*;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import tt.cc.com.ttmvvm.BR;

import java.util.ArrayList;


public class MutableAdapter<T> extends PagerAdapter {


    @BindingAdapter({"bindLayouts", "bindLifecycleOwner"})
    public static <T> void bindPageAdapter(ViewPager viewPager, LiveData<ArrayList<PageBind>> layouts, LifecycleOwner owner) {
        if (viewPager.getAdapter() == null) {
            final MutableAdapter adapter = new MutableAdapter(layouts.getValue(), viewPager.getContext(), owner);
            layouts.observe(owner, pageBinds -> adapter.setNewData(pageBinds));
            viewPager.setAdapter(adapter);
        }
    }


    private Context context;
    private ArrayList<PageBind> layouts;
    private LifecycleOwner owner;


    private MutableAdapter(ArrayList<PageBind> layouts, Context context, LifecycleOwner owner) {
        this.context = context;
        this.layouts = layouts;
        this.owner = owner;
    }

    public void setNewData(ArrayList<PageBind> layouts) {
        this.layouts = layouts;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (layouts != null) return layouts.size();
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = DataBindingUtil.inflate(LayoutInflater.from(context), layouts.get(position).getLayout(), container, false).getRoot();
        ViewDataBinding bind = DataBindingUtil.bind(view);
        if (bind != null) {
            bind.setLifecycleOwner(owner);
            Object data = null;
            if (layouts != null) {
                data = layouts.get(position).getBindData();
            }
            if (data instanceof LiveData) {
                bind.setVariable(BR.item, ((LiveData) data).getValue());
            } else {
                bind.setVariable(BR.item, data);
            }
            bind.executePendingBindings();
            container.addView(view);
            return view;
        }
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }


}
