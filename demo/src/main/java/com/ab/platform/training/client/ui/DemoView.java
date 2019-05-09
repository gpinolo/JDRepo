package com.ab.platform.training.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Created by gdecesare on 17/05/2017.
 */
public class DemoView extends Composite {

  interface DemoUiBinder
      extends UiBinder<HTMLPanel, DemoView> {
  }

  /*@UiField
  Button sendButton*/;

  /*@UiField
  TextBox nameField;*/

  private static DemoUiBinder ourUiBinder = GWT.create(DemoUiBinder.class);

  public DemoView() {

    initWidget(ourUiBinder.createAndBindUi(this));
  }
}
