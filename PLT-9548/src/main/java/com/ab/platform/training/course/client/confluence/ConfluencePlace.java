package com.ab.platform.training.course.client.confluence;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ConfluencePlace extends Place
{
	private String token;
	
	public ConfluencePlace(String token)
	{
		this.token = token;
	}

	public String getToken()
	{
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<ConfluencePlace>
	{
		public String getToken(ConfluencePlace place)
		{
			return place.getToken();
		}

		public ConfluencePlace getPlace(String token)
		{
			return new ConfluencePlace(token);
		}
	}
	
}
