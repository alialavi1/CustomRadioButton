package com.puji.customerrangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Thumb {

	private Paint mThumbOuterCirclePaint;
	private Paint mThumbInnerCirclePaint;
	private Paint mThumbCirclePaint;

	private float mThumbCircleRadius;
	private float mThumbInnerCircleRadius;
	private float mThumbOuterCircleRadius;
	private float mTargetRadiusPx;

	private float mX;
	private float mY;
	
	private boolean mIsPressed;
	
	public void setX(float x)
	{
		mX = x;
	}
	
	public float getX()
	{
		return mX;
	}
	
	boolean isPressed()
	{
		return mIsPressed;
	}

	void press()
	{
		mIsPressed = true;
	}
	
	void release()
	{
		mIsPressed = false;
	}
	
	boolean isInTargetZone(float x,float y)
	{
		if(Math.abs(x-mX) <= mTargetRadiusPx && Math.abs(y-mY) <= mTargetRadiusPx)
		{
			return true;
		}
		return false;
	}
	public Thumb(Context ctx, float width, float paddingLeft,
			float paddingRight, float thumbCircleRadius,
			float thumbInnerCircleWidth, float thumbOuterCircleWidth,
			float fontHeight, float l, int tickCount, int thumbCircleColor,
			int thumbInnerCircleColor, int thumbOuterCircleColor) {

		mTargetRadiusPx = thumbCircleRadius + thumbInnerCircleWidth
				+ thumbOuterCircleWidth;
		mX = paddingLeft + thumbCircleRadius + thumbInnerCircleWidth
				+ thumbOuterCircleWidth;
		mY = fontHeight + thumbCircleRadius + thumbInnerCircleWidth
				+ thumbOuterCircleWidth + l;
		mThumbCircleRadius = thumbCircleRadius;
		mThumbInnerCircleRadius = thumbCircleRadius + thumbInnerCircleWidth;
		mThumbOuterCircleRadius = mThumbInnerCircleRadius
				+ thumbOuterCircleWidth;

		mThumbOuterCirclePaint = new Paint();
		mThumbOuterCirclePaint.setDither(true);
		mThumbOuterCirclePaint.setAntiAlias(true);
		mThumbOuterCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mThumbOuterCirclePaint.setStyle(Paint.Style.FILL);
		mThumbOuterCirclePaint.setColor(thumbOuterCircleColor);

		mThumbInnerCirclePaint = new Paint();
		mThumbInnerCirclePaint.setDither(true);
		mThumbInnerCirclePaint.setAntiAlias(true);
		mThumbInnerCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mThumbInnerCirclePaint.setStyle(Paint.Style.FILL);
		mThumbInnerCirclePaint.setColor(thumbInnerCircleColor);

		mThumbCirclePaint = new Paint();
		mThumbCirclePaint.setDither(true);
		mThumbCirclePaint.setAntiAlias(true);
		mThumbCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mThumbCirclePaint.setStyle(Paint.Style.FILL);
		mThumbCirclePaint.setColor(thumbCircleColor);

	}

	public void draw(Canvas canvas) {
		canvas.drawCircle(mX, mY, mThumbOuterCircleRadius,
				mThumbOuterCirclePaint);
		canvas.drawCircle(mX, mY, mThumbInnerCircleRadius,
				mThumbInnerCirclePaint);
		canvas.drawCircle(mX, mY, mThumbCircleRadius, mThumbCirclePaint);
	}
}
