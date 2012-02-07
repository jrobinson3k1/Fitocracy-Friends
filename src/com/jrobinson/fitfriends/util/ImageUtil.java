package com.jrobinson.fitfriends.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class ImageUtil {

	private ImageUtil() {

	}

	public static Bitmap fromURL(String path) throws IOException {

		URL url = new URL(path);
		InputStream is = url.openStream();

		try {
			return BitmapFactory.decodeStream(is);
		}
		finally {
			is.close();
		}
	}

	public static Bitmap getCroppedBitmap(Bitmap source, int width, int height) {

		int x = (source.getWidth() - width) / 2;
		int y = (source.getHeight() - height) / 2;
		
		if(x < 0) {
			width = source.getWidth();
			x = 0;
		}
		if (y < 0) {
			height = source.getHeight();
			y = 0;
		}

		return Bitmap.createBitmap(source, x, y, width, height);
	}

	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap,
			final float roundPx) {

		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}
}
