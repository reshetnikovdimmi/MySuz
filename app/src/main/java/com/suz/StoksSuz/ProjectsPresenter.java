package com.suz.StoksSuz;

import com.suz.Entry_and_promotions.Retrofit.AksyList;
import com.suz.common.BasePresenter;

public class ProjectsPresenter extends BasePresenter {

    private final ProjectsView mView;
    private final AksyList mAksyList;

    public ProjectsPresenter(ProjectsView mView, AksyList mAksyList) {
        this.mView = mView;
        this.mAksyList = mAksyList;
    }

    public void getAksy(){

    }

    public void openProfileFragment(String username) {
        mView.openProfileFragment(username);
    }
}
