package tt.cc.com.ttmvvm.mvvm.ui;

/**
 * created by Albert
 */
public class Action {
    private int key;

    public static final int FinishActivity = 1;
    public static final int FinishFragment = 2;
    public static final int Show_Component = 3;
    public static final int Open_Dialog = 4;
    public static final int Close_Dialog = 5;
    public static final int State_View_Loading = 6;
    public static final int State_View_Empty = 7;
    public static final int State_View_Success = 8;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
