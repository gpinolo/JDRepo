package com.ab.platform.training.course.client.server;

import com.ab.platform.training.course.client.DoSomethingServiceClient;

/**
 * Created by gdecesare on 16/05/2017.
 */
public class DoSomethingServiceClientImpl implements DoSomethingServiceClient {

  @Override
  public String doWork() {
    return "Yes I do!";
  }
  
}
