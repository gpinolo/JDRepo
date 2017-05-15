package com.ab.platform.training.course.client;

import com.ab.platform.training.course.client.ui.sample.SamplePlace;
import com.ab.oneleo.uis.gwt.client.core.ModuleUtils;
import com.ab.oneleo.uis.gwt.client.widget.messagehandling.AlertAreaUtils;
import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DemoDev implements EntryPoint {

	public void onModuleLoad() {

		AlertAreaUtils.initAlertArea();
		
		ModuleUtils.simpleViewStart(new Demo(), new SamplePlace("Sample"));

	}

}

