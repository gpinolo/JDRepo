package com.ab.platform.training.demo1.client.ui.mainactivity;

import com.ab.ah.scad.acl.caf.to.UserPreferenceMetadataTO;
import com.ab.ah.scad.acl.caf.to.WorkstationTO;
import com.ab.oneleo.uis.gwt.client.applicationinfo.ApplicationInfoEvent;
import com.ab.oneleo.uis.gwt.client.core.AbstractView;
import com.ab.oneleo.uis.gwt.client.core.ModuleUtils;
import com.ab.oneleo.uis.gwt.client.service.utils.AbstractAsyncCallBack;
import com.ab.oneleo.uis.gwt.client.shortcut.ShortcutCallback;
import com.ab.oneleo.uis.gwt.client.shortcut.ShortcutManager;
import com.ab.oneleo.uis.gwt.client.widget.userpreferences.widget.UserPreference;
import com.ab.oneleo.uis.gwt.client.widget.userpreferences.widget.UserPreferencesModal;
import com.ab.oneleo.uis.gwt.shared.service.UserPreferencesServiceClient;
import com.ab.oneleo.uis.gwt.shared.service.UserPreferencesServiceClientAsync;
import com.ab.oneleo.uis.gwt.shared.service.WorkstationServiceClient;
import com.ab.oneleo.uis.gwt.shared.service.WorkstationServiceClientAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;

import java.util.List;

/**
 * @author developer
 */
public class MainActivityView extends AbstractView<MainActivityViewPresenter, Place> {
  
  private static final int SHORTCUTS = 85;
  
  // UIBinder init
  private static MainActivityUiBinder uiBinder = GWT.create(MainActivityUiBinder.class);
  
  /**
   * @author developer
   */
  interface MainActivityUiBinder extends UiBinder<Widget, MainActivityView> {
  }
  
  EventBus eventBus = ModuleUtils.clientFactory.getEventBus();
  
  // Other
  private SimplePanel appWidget;
  
  // UI Fields
  @UiField
  HTMLPanel content;
  
  @UiField
  HTMLPanel header;
  
  /**
   * 
   */
  @UiField
  public UserPreferencesModal userPreferencesModal;
  
  private UserPreferencesServiceClientAsync userPreferenceServiceClient =
      GWT.create(UserPreferencesServiceClient.class);
  
  private WorkstationServiceClientAsync workstationServiceClient = GWT.create(WorkstationServiceClient.class);
  
  /**
   * 
   */
  public MainActivityView() {
    this.setPresenter(new MainActivityViewPresenter(ModuleUtils.clientFactory, this));
  }
  
  /**
   * @param appWidget
   */
  public MainActivityView(SimplePanel appWidget) {
    this();
    this.appWidget = appWidget;
    initWidget(uiBinder.createAndBindUi(this));
    ShortcutManager.getInstance().bindShortcut(this, new ShortcutCallback() {
      @Override
      public void execute() {
        // simulate the click on about button
        aboutClick(null);
      }
    }, KeyCodes.KEY_ALT, SHORTCUTS);
  }
  
  @Override
  protected void onLoad() {
    super.onLoad();
    content.add(appWidget);
  }
  
  /**
   * @param e
   */
  @UiHandler("logout")
  public void logoutClick(ClickEvent e) {
    getPresenter().logout();
  }
  
  /**
   * @param e
   */
  @UiHandler("about")
  public void aboutClick(ClickEvent e) {
    eventBus.fireEvent(new ApplicationInfoEvent());
  }
  
  /**
   * @param e
   */
  @UiHandler("headerLink")
  public void headerLinkClick(ClickEvent e) {
    getPresenter().goToHome();
  }
  
  /**
   * @param e
   */
  @UiHandler("userPreferences")
  public void handleClick(ClickEvent e) {
    userPreferencesClickAction();
  }
  
  /**
   * @param e
   */
  @UiHandler("interoperabilityTrackingButton")
  public void interoperabilityTrackingViewButtonClick(ClickEvent e) {
    getPresenter().getInteroperabilityTrackingView();
  }
  
  /**
   * @param e
   */
  @UiHandler("interoperabilityAdministrationButton")
  public void interoperabilityAdministrationViewButtonClick(ClickEvent e) {
    getPresenter().getInteroperabilityAdministrationView();
  }
  
  protected void userPreferencesClickAction() {
    
    userPreferenceServiceClient.readUserPreferenceMetadata("workstation",
        new AbstractAsyncCallBack<UserPreferenceMetadataTO>() {
          
          @Override
          public void doOnSucces(UserPreferenceMetadataTO userPreferenceMetadataTO) {
            if (userPreferenceMetadataTO != null) {
              workstationServiceClient
                  .listAllWorkstation(new AbstractAsyncCallBack<List<WorkstationTO>>() {
                    
                    @Override
                    public void doOnSucces(List result) {
                      UserPreference userPreference = new UserPreference("workstation");
                      userPreference.setList(result, "code", "description");
                      
                      userPreferencesModal.addPreferenceRow(userPreference);
                      userPreferencesModal.show();
                    }
                    
                  });
            } else {
              userPreferencesModal.show();
            }
          }
          
        });
  }
  
}
