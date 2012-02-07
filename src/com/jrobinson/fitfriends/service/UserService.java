package com.jrobinson.fitfriends.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.jrobinson.fitfriends.model.User;

public class UserService {

	private static final String API_URL = "http://fitocracy-api.heroku.com/data/";

	public static User retrieveUser(String userId) {
		
		String url = API_URL + userId;
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		
		try {
			return client.execute(get, new UserResponseHandler());
			
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
