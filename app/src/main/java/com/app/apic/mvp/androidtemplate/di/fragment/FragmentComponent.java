package com.app.apic.mvp.androidtemplate.di.fragment;

import com.app.apic.mvp.androidtemplate.ui.fragments.BaseFragment;

import dagger.Subcomponent;

/**
 * Created by Korir on 3/12/19.
 * amoskrr@gmail.com
 */
@Subcomponent(modules = FragmentModule.class) public interface FragmentComponent {

    void baseInject(BaseFragment baseFragment);
    @Subcomponent.Builder interface Builder{
        Builder fragmentModule(FragmentModule fragmentModule);
        FragmentComponent build();
    }
}
