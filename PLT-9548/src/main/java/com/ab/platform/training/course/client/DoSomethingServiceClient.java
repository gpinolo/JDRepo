package com.ab.platform.training.course.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by gdecesare on 16/05/2017.
 */
@RemoteServiceRelativePath("DoSomethingServiceClient")
public interface DoSomethingServiceClient extends RemoteService {
  String doWork();

  /**
   * Utility/Convenience class.
   * Use DoSomethingServiceClient.App.getInstance() to access static instance of TestServiceAsync
   */
  public static class App {
    private static final DoSomethingServiceClientAsync ourInstance =
        (DoSomethingServiceClientAsync) GWT.create(DoSomethingServiceClient.class);

    public static DoSomethingServiceClientAsync getInstance() {
      return ourInstance;
    }
  }
}
