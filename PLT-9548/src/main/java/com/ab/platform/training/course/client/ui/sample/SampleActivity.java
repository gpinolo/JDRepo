package com.ab.platform.training.course.client.ui.sample;

import com.ab.oneleo.uis.gwt.client.clientfactory.ClientFactory;
import com.ab.oneleo.uis.gwt.client.core.GenericAbstractActivity;

public class SampleActivity extends GenericAbstractActivity<SampleView> {

	public SampleActivity(SamplePlace place, ClientFactory clientFactory) {
		super(place, SampleView.class, clientFactory);
	}

}
