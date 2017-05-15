package com.ab.platform.training.course.client.ui.sample;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SamplePlace extends Place
{
	private String token;
	
	public SamplePlace(String token)
	{
		this.token = token;
	}

	public String getToken()
	{
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<SamplePlace>
	{
		public String getToken(SamplePlace place)
		{
			return place.getToken();
		}

		public SamplePlace getPlace(String token)
		{
			return new SamplePlace(token);
		}
	}
	
}
