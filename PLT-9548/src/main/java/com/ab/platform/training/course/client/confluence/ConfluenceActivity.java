package com.ab.platform.training.course.client.confluence;

import com.ab.oneleo.uis.gwt.client.clientfactory.ClientFactory;
import com.ab.oneleo.uis.gwt.client.core.GenericAbstractActivity;

public class ConfluenceActivity extends GenericAbstractActivity<ConfluenceView> implements ConfluencePresenter {

	public ConfluenceActivity(ConfluencePlace place, ClientFactory clientFactory) {
		super(place, ConfluenceView.class, clientFactory);
	}

}
