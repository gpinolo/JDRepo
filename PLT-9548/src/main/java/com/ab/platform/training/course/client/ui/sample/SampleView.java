package com.ab.platform.training.course.client.ui.sample;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.ab.oneleo.uis.gwt.client.core.AbstractView;

public class SampleView extends AbstractView<SampleActivity, SamplePlace> {

	private static DefaultViewUiBinder uiBinder = GWT.create(DefaultViewUiBinder.class);

  @UiField
  Label completionLabel1;

	interface DefaultViewUiBinder extends UiBinder<Widget, SampleView> {
	}

	public SampleView() {
    initWidget(uiBinder.createAndBindUi(this));
    completionLabel1.setText("Label1");
	}

}
