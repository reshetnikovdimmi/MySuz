package com.suz.StoksSuz;

import androidx.annotation.NonNull;

import com.suz.common.BaseView;
import com.suz.database.Aksy;

import java.util.List;

public interface ProjectsView extends BaseView {

    void showProjects(@NonNull List<Aksy> aksy);

    void openProfileFragment(@NonNull String emploee);
}

