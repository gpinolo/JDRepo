package com.ab.platform.training.demo1.client.ui.mainactivity;

import com.ab.oneleo.uis.gwt.client.clientfactory.ClientFactory;
import com.ab.oneleo.uis.gwt.client.core.ModuleUtils;
import com.ab.oneleo.uis.gwt.client.logout.LogoutEvent;
import com.ab.oneleo.uis.gwt.client.mvp.DefaultRunAsyncCallback;
import com.ab.oneleo.uis.gwt.client.mvp.Presenter;
import com.ab.oneleo.uis.gwt.client.widget.place.HomePlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;

/**
 * @author developer
 */
public class MainActivityViewPresenter implements Presenter {
  
  private ClientFactory clientFactoryActivity;
  
  /**
   * @param clientFactoryActivity
   * @param mainActivityView
   */
  public MainActivityViewPresenter(ClientFactory clientFactoryActivity, MainActivityView mainActivityView) {
    this.clientFactoryActivity = clientFactoryActivity;
  }
  
  /**
   * 
   */
  public void goToHome() {
    GWT.runAsync(new DefaultRunAsyncCallback() {
      /**
       * 
       */
      public void onSuccess() {
        goTo(new HomePlace("home"));
      }
    });
    
  }
  
  /**
   * @param place
   */
  public void goTo(Place place) {
    clientFactoryActivity.getPlaceController().goTo(place);
  }
  
  /**
   * 
   */
  public void home() {
    GWT.runAsync(new DefaultRunAsyncCallback() {
      /**
       * 
       */
      public void onSuccess() {
        goTo(new HomePlace("test page"));
      }
    });
  }
  
  /**
   * 
   */
  public void logout() {
    ModuleUtils.clientFactory.getEventBus().fireEvent(new LogoutEvent());
  }
  
  /**
   * 
   */
  public void goToUserInfo() {
    GWT.runAsync(new DefaultRunAsyncCallback() {
      /**
       * 
       */
      public void onSuccess() {
        //goTo(new UserInfoDemoPlace("userInfoDemo"));
      }
    });
  }
  
  /**
   * 
   */
  public void getInteroperabilityAdministrationView() {
    //goTo(new InteroperabilityAdministrationPlace("home"));
  }
  
  /**
   * 
   */
  public void getInteroperabilityTrackingView() {
    //goTo(new InteroperabilityTrackingPlace("home"));
  }
  
}
