package com.puji.customerrangebar;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;

public class Bar {
	private float mTickTextSize;
	private float mTickCircleRadius;
	private float mTickInnerCircleWidth;
	private float mTickDistance;
	private float mFontHeight;
	private int mTickCount;
	private float mLeftX;
	private float mRightX;
	private float mY;
	private Paint mBaseLinePaint = new Paint();
	private Paint mTickTextPaint;
	private Paint mTickCirclePaint;
	private Paint mTickInnerCirclePaint;
	private float mLength;
	private int mTickSelectedTextColor;
	private int mTickNormalTextColor;
	private float mSpaing;
	
	public float getLeftX()
	{
		return mLeftX;
	}
	
	public float getRightX()
	{
		return mRightX;
	}

	public Bar(Context ctx, float width, float paddingLeft, float paddingRight,
			float thumbCircleRadius, float thumbInnerCircleWidth,
			float thumbOuterCircleWidth, float tickCircleRadius,
			float tickInnerCircleWidth, float baseLineWeight,
			float tickTextSize, float fontHeight, float spaing, int tickCount,
			int baseLineColor, int tickCircleColor, int tickInnerCircleColor,
			int tickNormalTextColor,int tickSelectdTextColor,Align align) {

		mTickCircleRadius = tickCircleRadius;
		mTickInnerCircleWidth = tickInnerCircleWidth;
		mTickTextSize = tickTextSize;
		mFontHeight = fontHeight;
		mTickCount = tickCount;
		mTickNormalTextColor = tickNormalTextColor;
		mTickSelectedTextColor = tickSelectdTextColor;
		mSpaing = spaing;

		mLeftX = paddingLeft + thumbCircleRadius + thumbInnerCircleWidth
				+ thumbOuterCircleWidth;
		mLength = (width
				- paddingLeft
				- (thumbCircleRadius + thumbInnerCircleWidth + thumbOuterCircleWidth)
				* 2 - paddingRight);
		mRightX = mLeftX + mLength;
		mY = fontHeight + thumbCircleRadius + thumbInnerCircleWidth
				+ thumbOuterCircleWidth + spaing;
		mTickDistance = mLength / (mTickCount - 1);
		mBaseLinePaint.setDither(true);
		mBaseLinePaint.setAntiAlias(true);
		mBaseLinePaint.setStrokeWidth(baseLineWeight);
		mBaseLinePaint.setColor(baseLineColor);

		mTickTextPaint = new Paint();
		mTickTextPaint.setDither(true);
		mTickTextPaint.setAntiAlias(true);
		mTickTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mTickTextPaint.setColor(tickNormalTextColor);
		mTickTextPaint.setTextSize(mTickTextSize);
		mTickTextPaint.setTextAlign(align);

		mTickCirclePaint = new Paint();
		mTickCirclePaint.setDither(true);
		mTickCirclePaint.setAntiAlias(true);
		mTickCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mTickCirclePaint.setStyle(Paint.Style.FILL);
		mTickCirclePaint.setColor(tickCircleColor);

		mTickInnerCirclePaint = new Paint();
		mTickInnerCirclePaint.setDither(true);
		mTickInnerCirclePaint.setAntiAlias(true);
		mTickInnerCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mTickInnerCirclePaint.setStyle(Paint.Style.FILL);
		mTickInnerCirclePaint.setColor(tickInnerCircleColor);
	}

	public void draw(Canvas canvas,int tickIndex,List<String> data) {
		drawLine(canvas);
		drawTick(canvas,tickIndex,data);
	}

	public void drawLine(Canvas canvas) {
		canvas.drawLine(mLeftX, mY, mRightX, mY, mBaseLinePaint);
	}

	public void drawTick(Canvas canvas,int tickIndex,List<String> data) {



		for (int i = 0; i < mTickCount; i++) {

			if(data !=null)
			{
				if(i == tickIndex)
				{
					mTickTextPaint.setColor(mTickSelectedTextColor);
					canvas.drawText(data.get(i), mLeftX + i * mTickDistance, mFontHeight, mTickTextPaint);
				}else
				{
					mTickTextPaint.setColor(mTickNormalTextColor);
					canvas.drawText(data.get(i), mLeftX + i * mTickDistance, mFontHeight+mSpaing, mTickTextPaint);
				}
			}

			canvas.drawCircle(mLeftX + i * mTickDistance, mY, mTickCircleRadius
					+ mTickInnerCircleWidth, mTickInnerCirclePaint);
			canvas.drawCircle(mLeftX + i * mTickDistance, mY, mTickCircleRadius,
					mTickCirclePaint);
		}
	}

	 int getNearestTickIndex(Thumb thumb) {

		final int nearestTickIndex = (int) ((thumb.getX() - mLeftX + mTickDistance / 2f)
				/ mTickDistance);
		return nearestTickIndex;
	}

	 float getNearestTickCoordinate(Thumb thumb)
	 {
		 final int nearestTickIndex = getNearestTickIndex(thumb);
		 final float nearestTickCoordinate = mLeftX + (nearestTickIndex*mTickDistance);
		 return nearestTickCoordinate;
	 }
}
