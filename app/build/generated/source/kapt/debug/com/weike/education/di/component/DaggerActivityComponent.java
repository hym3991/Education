// Generated by Dagger (https://google.github.io/dagger).
package com.weike.education.di.component;

import android.app.Activity;
import com.weike.education.base.BaseInjectActivity_MembersInjector;
import com.weike.education.di.module.ActivityModule;
import com.weike.education.di.module.ActivityModule_ProvideActivityFactory;
import com.weike.education.model.app.ChoosePhaseActivity;
import com.weike.education.model.app.MainActivity;
import com.weike.education.model.app.SectionDetailActivity;
import com.weike.education.mvp.presenter.app.ChoosePhasePresenter;
import com.weike.education.mvp.presenter.app.MainPresenter;
import com.weike.education.mvp.presenter.app.SectionDetailPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerActivityComponent implements ActivityComponent {
  private ApiComponent apiComponent;

  private Provider<Activity> provideActivityProvider;

  private DaggerActivityComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  private MainPresenter getMainPresenter() {
    return new MainPresenter(
        Preconditions.checkNotNull(
            apiComponent.getRetrofitHelper(),
            "Cannot return null from a non-@Nullable component method"));
  }

  private ChoosePhasePresenter getChoosePhasePresenter() {
    return new ChoosePhasePresenter(
        Preconditions.checkNotNull(
            apiComponent.getRetrofitHelper(),
            "Cannot return null from a non-@Nullable component method"));
  }

  private SectionDetailPresenter getSectionDetailPresenter() {
    return new SectionDetailPresenter(
        Preconditions.checkNotNull(
            apiComponent.getRetrofitHelper(),
            "Cannot return null from a non-@Nullable component method"));
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideActivityProvider =
        DoubleCheck.provider(ActivityModule_ProvideActivityFactory.create(builder.activityModule));
    this.apiComponent = builder.apiComponent;
  }

  @Override
  public Activity getActivity() {
    return provideActivityProvider.get();
  }

  @Override
  public void inject(MainActivity activity) {
    injectMainActivity(activity);
  }

  @Override
  public void inject(ChoosePhaseActivity activity) {
    injectChoosePhaseActivity(activity);
  }

  @Override
  public void inject(SectionDetailActivity activity) {
    injectSectionDetailActivity(activity);
  }

  private MainActivity injectMainActivity(MainActivity instance) {
    BaseInjectActivity_MembersInjector.injectMPresenter(instance, getMainPresenter());
    return instance;
  }

  private ChoosePhaseActivity injectChoosePhaseActivity(ChoosePhaseActivity instance) {
    BaseInjectActivity_MembersInjector.injectMPresenter(instance, getChoosePhasePresenter());
    return instance;
  }

  private SectionDetailActivity injectSectionDetailActivity(SectionDetailActivity instance) {
    BaseInjectActivity_MembersInjector.injectMPresenter(instance, getSectionDetailPresenter());
    return instance;
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private ApiComponent apiComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (apiComponent == null) {
        throw new IllegalStateException(ApiComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder apiComponent(ApiComponent apiComponent) {
      this.apiComponent = Preconditions.checkNotNull(apiComponent);
      return this;
    }
  }
}
