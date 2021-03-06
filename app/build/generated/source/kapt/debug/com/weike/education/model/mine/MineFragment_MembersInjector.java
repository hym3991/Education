// Generated by Dagger (https://google.github.io/dagger).
package com.weike.education.model.mine;

import com.weike.education.base.BaseInjectFragment_MembersInjector;
import com.weike.education.mvp.presenter.mine.MinePresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MineFragment_MembersInjector implements MembersInjector<MineFragment> {
  private final Provider<MinePresenter> mPresenterProvider;

  public MineFragment_MembersInjector(Provider<MinePresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MineFragment> create(Provider<MinePresenter> mPresenterProvider) {
    return new MineFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MineFragment instance) {
    BaseInjectFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
