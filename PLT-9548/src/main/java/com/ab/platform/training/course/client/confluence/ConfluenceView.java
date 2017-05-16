package com.ab.platform.training.course.client.confluence;

import com.ab.oneleo.uis.gwt.client.core.AbstractView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by gdecesare on 16/05/2017.
 */
public class ConfluenceView extends AbstractView<ConfluencePresenter, ConfluencePlace> {

  private static DefaultViewUiBinder uiBinder = GWT.create(DefaultViewUiBinder.class);

  interface DefaultViewUiBinder extends UiBinder<Widget, ConfluenceView> {
  }


  public ConfluenceView() {
    initWidget(uiBinder.createAndBindUi(this));
  }
}
