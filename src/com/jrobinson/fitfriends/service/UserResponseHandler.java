package com.jrobinson.fitfriends.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jrobinson.fitfriends.model.User;
import com.jrobinson.fitfriends.util.StringUtil;

public class UserResponseHandler implements ResponseHandler<User> {

	public User handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {

		if (response.getStatusLine().getStatusCode() == 200) {
			InputStream is = response.getEntity().getContent();
			try {
				return parse(StringUtil.consumeStream(is));
			}
			finally {
				is.close();
			}
		}
		
		return null;
	}
	
	private User parse(String json) {
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		Gson gson = gsonBuilder.create();
		return gson.fromJson(json, User.class);
	}
}
