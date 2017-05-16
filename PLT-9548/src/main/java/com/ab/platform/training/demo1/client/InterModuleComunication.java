package com.ab.platform.training.demo1.client;

import com.ab.oneleo.uis.gwt.client.logout.DefaultLogoutHandler;
import com.ab.oneleo.uis.gwt.client.logout.LogoutEvent;
import com.ab.oneleo.uis.gwt.client.util.LayoutUtils;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.web.bindery.event.shared.Event.Type;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author developer
 */
public class InterModuleComunication {
  
  private EventBus eventBus;
  
  /**
   * @param eventBus
   * @param placeController
   */
  public void initHandlers(EventBus eventBus) {
    this.eventBus = eventBus;
    logout();
    handleChangePage();
  }
  
  private void handleChangePage() {
    addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {
      /**
       * @param event
       */
      public void onPlaceChange(PlaceChangeEvent event) {
        LayoutUtils.removeFocusOnAllButton();
      }
    });
  }
  
  private void logout() {
    addHandler(LogoutEvent.TYPE, new DefaultLogoutHandler(GWT.getHostPageBaseURL() + "logout"));
  }
  
  private <H> void addHandler(Type<H> type, H handler) {
    this.eventBus.addHandler(type, handler);
  }
  
}
