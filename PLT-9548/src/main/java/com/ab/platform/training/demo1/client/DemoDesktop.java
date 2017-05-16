package com.ab.platform.training.demo1.client;

import com.ab.oneleo.uis.gwt.client.applicationinfo.ApplicationInfoModalWidget;
import com.ab.oneleo.uis.gwt.client.applicationinfo.presenter.ApplicationInfoModal;
import com.ab.oneleo.uis.gwt.client.applicationinfo.presenter.ApplicationInfoModalPresenterImpl;
import com.ab.oneleo.uis.gwt.client.clientfactory.ClientFactory;
import com.ab.oneleo.uis.gwt.client.core.ModuleUtils;
import com.ab.oneleo.uis.gwt.client.exception.UISUncaughtExceptionHandler;
import com.ab.oneleo.uis.gwt.client.mvp.ActivityMapperWithClientFactory;
import com.ab.oneleo.uis.gwt.client.mvp.ViewAsyncFactory;
import com.ab.oneleo.uis.gwt.client.util.LayoutUtils;
import com.ab.oneleo.uis.gwt.client.widget.changepassword.ChangePasswordModal;
import com.ab.oneleo.uis.gwt.client.widget.changepassword.presenter.ChangePasswordModalPresenter;
import com.ab.oneleo.uis.gwt.client.widget.changepassword.presenter.ChangePasswordModalPresenterImpl;
import com.ab.oneleo.uis.gwt.client.widget.lock.LockActiveSessionModal;
import com.ab.oneleo.uis.gwt.client.widget.lock.presenter.LockActiveSessionModalPresenter;
import com.ab.oneleo.uis.gwt.client.widget.lock.presenter.LockActiveSessionModalPresenterImpl;
import com.ab.oneleo.uis.gwt.client.widget.notification.enhancer.NotificationPdfViewerRenderer;
import com.ab.oneleo.uis.gwt.client.widget.place.HomePlace;
import com.ab.platform.training.demo1.client.ui.mainactivity.MainActivityView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.*;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Created by gdecesare on 16/05/2017.
 */
public class DemoDesktop implements EntryPoint {



  public void onModuleLoad() {

    ClientFactory factory = GWT.create(ClientFactory.class);


    final EventBus eventBus = factory.getEventBus();
    final PlaceController placeController = factory.getPlaceController();

    SimplePanel appWidget = new SimplePanel();

    UISUncaughtExceptionHandler.init();

    ModuleUtils.initModule(newActivityMapper(), newViewFactory());

    MainActivityView mainActivity = new MainActivityView(appWidget);

    PlaceHistoryMapper historyMapper = factory.getPlaceHistoryMapper();
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, new HomePlace("default"));

    ModuleUtils.start(appWidget);

    InterModuleComunication create = GWT.create(InterModuleComunication.class);
    create.initHandlers(eventBus);

    LayoutUtils.bindFocusedButtons();
    LayoutUtils.bindBlurredButtons();

    RootPanel.get().add((Widget) mainActivity);

    LayoutUtils.disableBrowserClosePopup();

    ModuleUtils.clientFactory.getPlaceController().goTo(new HomePlace("test"));

    ChangePasswordModal changePasswordModal = new ChangePasswordModal();
    ChangePasswordModalPresenter changePasswordModalPresenter = new ChangePasswordModalPresenterImpl(factory,
        changePasswordModal);
    changePasswordModal.setPresenter(changePasswordModalPresenter);
    LockActiveSessionModal activeSessionModal = new LockActiveSessionModal(changePasswordModal);
    activeSessionModal.setHeight("auto");
    LockActiveSessionModalPresenter activeSessionModalPresenter = new LockActiveSessionModalPresenterImpl(factory,
        activeSessionModal);
    activeSessionModal.setPresenter(activeSessionModalPresenter);

    setNotificationUtilCallback();
    NotificationPdfViewerRenderer.defineNotificationPdfviewFunction();

    ApplicationInfoModalWidget applicationInfoModal = GWT.create(ApplicationInfoModal.class);
    ApplicationInfoModalPresenterImpl applicationInfoModalPresenter =
        new ApplicationInfoModalPresenterImpl(factory, applicationInfoModal);
    applicationInfoModal.setPresenter(applicationInfoModalPresenter);

  }

  private ViewAsyncFactory newViewFactory() {
    return new ViewAsyncFactoryimpl();
  }

  private ActivityMapperWithClientFactory newActivityMapper() {
    return new ActivityMapperWithClientFactoryImpl();
  }

  public static native void setNotificationUtilCallback() /*-{
      $wnd.formatNotificationMessage = function(message) {
          var x= $entry(@com.ab.oneleo.uis.gwt.client.widget.notification.enhancer.NotificationRenderUtility::generateMessage(Ljava/lang/String;))(message);
          return x;
      }
  }-*/;
}
