package cn.meshee.freechat.ui.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class BaseFragmentPresenter<V> {

    public BaseFragmentActivity mContext;

    protected Reference<V> mViewRef;

    public BaseFragmentPresenter(BaseFragmentActivity context) {
        mContext = context;
    }

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public V getView() {
        return mViewRef != null ? mViewRef.get() : null;
    }
}
