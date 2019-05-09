package com.ab.platform.training.course.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by gdecesare on 16/05/2017.
 */
public interface DoSomethingServiceClientAsync {

  void doWork(AsyncCallback<String> async);
}
