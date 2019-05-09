package com.ab.platform.training.course.client.ui.sample;

import static com.ab.oneleo.uis.gwt.client.service.utils.LoadingIndicatorStrategyUtils.loadingIndicatorWrap;

import com.ab.oneleo.uis.gwt.client.service.utils.AbstractAsyncCallBack;
import com.ab.oneleo.uis.gwt.client.widget.date.monthyearselector.DateBox;
import com.ab.platform.training.course.client.DoSomethingServiceClient;
import com.ab.platform.training.course.client.DoSomethingServiceClientAsync;
import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.ab.oneleo.uis.gwt.client.core.AbstractView;

public class SampleView extends AbstractView<SampleActivity, SamplePlace> {

	private static DefaultViewUiBinder uiBinder = GWT.create(DefaultViewUiBinder.class);

  private DoSomethingServiceClientAsync doSomethingClientServiceAsync = GWT.create(DoSomethingServiceClient.class);

  @UiField
  Label completionLabel1;

  @UiField
  DateBox dateBox;

  @UiField
  Button dosomething;

	interface DefaultViewUiBinder extends UiBinder<Widget, SampleView> {
	}

	public SampleView() {
    initWidget(uiBinder.createAndBindUi(this));
    completionLabel1.setText("Label1");
	}

  @UiHandler("dosomething")
  public void onDoSomethingButtonClick(ClickEvent clickEvent){

    doSomethingClientServiceAsync.doWork(loadingIndicatorWrap(new AbstractAsyncCallBack<String>() {

      @Override
      public void doOnSucces(String result) {
        completionLabel1.setText(result);
      }
    }));

  }
}
