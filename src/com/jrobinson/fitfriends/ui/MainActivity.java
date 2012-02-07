package com.jrobinson.fitfriends.ui;

import java.io.IOException;

import com.jrobinson.fitfriends.R;
import com.jrobinson.fitfriends.model.User;
import com.jrobinson.fitfriends.service.UserService;
import com.jrobinson.fitfriends.util.ImageUtil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		new UserAsyncTask().execute("Loplcopter");
	}

	private class UserAsyncTask extends AsyncTask<String, Void, User> {

		@Override
		protected User doInBackground(String... params) {

			String userId = params[0];
			return UserService.retrieveUser(userId);
		}

		@Override
		protected void onPostExecute(User result) {

			super.onPostExecute(result);

			TextView nameTextView = (TextView) findViewById(R.id.user_name_TextView);
			nameTextView.setText(result.getUser().getName());
			
			TextView levelTextView = (TextView) findViewById(R.id.user_level_TextView);
			levelTextView.setText("Level " + result.getLevel());
			
			TextView progressTextView = (TextView) findViewById(R.id.user_progress_TextView);
			progressTextView.setText(result.getProgress().getProgressText());
			
			TextView aboutTextView = (TextView) findViewById(R.id.user_about_TextView);
			aboutTextView.setText("\"" + result.getAbout() + "\"");

			ImageView picImageView = (ImageView) findViewById(R.id.user_pic_ImageView);
			
			Bitmap bitmap = null;
			try {
				bitmap = ImageUtil.fromURL(result.getUser().getImage());
			}
			catch (IOException e) {
				e.printStackTrace();
			}

			if (bitmap != null) {
				int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
				bitmap = ImageUtil.getCroppedBitmap(bitmap, size, size);
				bitmap = ImageUtil.getRoundedCornerBitmap(bitmap, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
				picImageView.setImageBitmap(bitmap);
			}
			
			findViewById(R.id.user_progress_ProgressBar).setVisibility(View.GONE);
		}
	}
}