package com.ab.platform.training.demo1.client;

import com.ab.oneleo.uis.gwt.client.clientfactory.ClientFactory;
import com.ab.oneleo.uis.gwt.client.mvp.ActivityCallbackHandler;
import com.ab.oneleo.uis.gwt.client.mvp.ActivityMapperWithClientFactory;
import com.google.gwt.place.shared.Place;

/**
 * Created by gdecesare on 16/05/2017.
 */
public class ActivityMapperWithClientFactoryImpl implements ActivityMapperWithClientFactory {

  @Override
  public boolean getActivity(
      Place place, ClientFactory clientFactory, ActivityCallbackHandler activityCallbackHandler) {
    return false;
  }
}
