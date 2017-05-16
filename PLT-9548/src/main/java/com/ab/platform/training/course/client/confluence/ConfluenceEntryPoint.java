package com.ab.platform.training.course.client.confluence;

import com.ab.oneleo.uis.gwt.client.clientfactory.ClientFactory;
import com.ab.oneleo.uis.gwt.client.core.ModuleUtils;
import com.ab.oneleo.uis.gwt.client.mvp.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.*;

/**
 * Created by gdecesare on 16/05/2017.
 */
public class ConfluenceEntryPoint implements EntryPoint {

  public void onModuleLoad() {
    ModuleUtils.initModule(newActivityMapper(), newViewFactory());
    RootPanel.get().add((Widget) GWT.create(ConfluenceView.class));
  }

  private ViewAsyncFactory newViewFactory() {

    return new ViewAsyncFactory() {

      public void getView(Class<? extends IsWidget> clazz, final GetViewCallback callback) {

        if (ConfluenceView.class.equals(clazz)) {
          GWT.runAsync(new DefaultRunAsyncCallback() {
            public void onSuccess() {
              callback.onGetView((Composite)GWT.create(ConfluenceView.class));
            }
          });
        }

      }
    };

  }

  private ActivityMapperWithClientFactory newActivityMapper() {

    ActivityMapperWithClientFactory activityMapper = new ActivityMapperWithClientFactory() {

      public boolean getActivity(final Place place, final ClientFactory clientFactory, final ActivityCallbackHandler activityCallbackHandler) {

        if (place instanceof ConfluencePlace) {
          GWT.runAsync(new DefaultRunAsyncCallback() {
            public void onSuccess() {
              activityCallbackHandler.onRecieveActivity(new ConfluenceActivity((ConfluencePlace) place, clientFactory));

            }
          });
          return true;
        }

        return false;

      }

    };

    return activityMapper;

  }
}
