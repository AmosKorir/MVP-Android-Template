package com.app.apic.mvp.androidtemplate.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;
import com.app.apic.data.utils.RxUtil;
import com.app.apic.domain.constants.DIConstants;
import com.app.apic.mvp.androidtemplate.di.activity.ActivityComponent;
import com.app.apic.mvp.androidtemplate.di.fragment.FragmentComponent;
import com.app.apic.mvp.androidtemplate.di.fragment.FragmentModule;
import com.app.apic.mvp.androidtemplate.ui.activities.BaseActivity;
import io.reactivex.disposables.CompositeDisposable;
import java.net.UnknownHostException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Korir on 3/12/19.
 * amoskrr@gmail.com
 */
public class BaseFragment extends Fragment {
  private static final int NO_LAYOUT = -1;
  private CompositeDisposable compositeDisposable;
  private static final int PERMISSION_ACCESS_COARSE_LOCATION = 400;
  @Inject @Named(DIConstants.ACTIVITY) Context context;
  @Inject FragmentManager fragmentManager;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injector().baseInject(this);
  }

  protected FragmentComponent injector() {
    return activityInjector().fragmentBuilder().fragmentModule(new FragmentModule(this)).build();
  }

  protected ActivityComponent activityInjector() {
    return ((BaseActivity) getActivity()).injector();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    dispose();
  }

  protected void dispose() {
    RxUtil.dispose(compositeDisposable);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable
      ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (getLayoutId() != NO_LAYOUT) {
      View view = inflater.inflate(getLayoutId(), container, false);
      ButterKnife.bind(this, view);
      return view;
    } else {
      return super.onCreateView(inflater, container, savedInstanceState);
    }
  }

  public int getLayoutId() {
    return NO_LAYOUT;
  }

  public boolean onBackPressed() {
    return false;
  }

  @Override public void onStart() {
    super.onStart();
  }

  public void handleError(Throwable throwable) {
    if (isAdded()) {
      if (!(throwable instanceof UnknownHostException)) {
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
      }
    }
  }
}
