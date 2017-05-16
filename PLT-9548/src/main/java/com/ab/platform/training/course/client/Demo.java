package com.ab.platform.training.course.client;

import com.ab.oneleo.uis.gwt.client.clientfactory.ClientFactory;
import com.ab.oneleo.uis.gwt.client.core.ModuleUtils;
import com.ab.oneleo.uis.gwt.client.mvp.ActivityCallbackHandler;
import com.ab.oneleo.uis.gwt.client.mvp.ActivityMapperWithClientFactory;
import com.ab.oneleo.uis.gwt.client.mvp.GetViewCallback;
import com.ab.oneleo.uis.gwt.client.mvp.ViewAsyncFactory;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.ab.platform.training.course.client.ui.sample.SampleView;
import com.ab.platform.training.course.client.ui.sample.SampleActivity;
import com.ab.platform.training.course.client.ui.sample.SamplePlace;
import com.ab.oneleo.uis.gwt.client.mvp.DefaultRunAsyncCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Demo implements EntryPoint {

	public void onModuleLoad() {

		ModuleUtils.initModule(newActivityMapper(), newViewFactory());
    RootPanel.get().add((Widget) GWT.create(SampleView.class));
	}

	private ViewAsyncFactory newViewFactory() {

		return new ViewAsyncFactory() {

			public void getView(Class<? extends IsWidget> clazz, final GetViewCallback callback) {

				if (SampleView.class.equals(clazz)) {
					GWT.runAsync(new DefaultRunAsyncCallback() {
						public void onSuccess() {
							callback.onGetView((Composite)GWT.create(SampleView.class));
						}
					});
				}

			}
		};

	}

	private ActivityMapperWithClientFactory newActivityMapper() {

		ActivityMapperWithClientFactory activityMapper = new ActivityMapperWithClientFactory() {

			public boolean getActivity(final Place place, final ClientFactory clientFactory, final ActivityCallbackHandler activityCallbackHandler) {

				if (place instanceof SamplePlace) {
					GWT.runAsync(new DefaultRunAsyncCallback() {
						public void onSuccess() {
							activityCallbackHandler.onRecieveActivity(new SampleActivity((SamplePlace) place, clientFactory));

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
