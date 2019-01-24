package persenter;

import com.fiction.view.MvpView;

public abstract class BasePresenter<T extends MvpView>{

    public T mView;

    public void attach(T view) {
        mView = view;
    }

    public void detach() {
        mView = null;
    }

}
