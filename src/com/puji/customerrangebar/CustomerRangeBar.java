package com.puji.customerrangebar;

import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

public class CustomerRangeBar extends View {

	private static final String TAG = "customerrangebar";

	/**
	 * 滑块外圆环默认宽度
	 */
	private final static int DEFAULT_THUMB_OUTER_CIRCLE_WIDTH_DP = 5;

	/**
	 * 滑块内圆环默认高度
	 */
	private final static int DEFAULT_THUMB_INNER_CIRCLE_WIDTH_DP = 5;

	/**
	 * 滑块内圆默认半径
	 */
	private final static int DEFAULT_THUMB_CIRCLE_RADIUS_DP = 10;

	/**
	 * 刻度外圆环默认宽度
	 */
	private final static int DEFAULT_TICK_OUTER_CIRCLE_WIDTH_DP = 5;

	/**
	 * 刻度内圆默认半径
	 */
	private final static int DEFAULT_TICK_CIRCLE_RADIUS_DP = 5;

	/**
	 * 时间轴默认厚度
	 */
	private final static int DEFAULT_BASELINE_WEIGHT_DP = 5;

	/**
	 * 默认的刻度字体大小
	 */
	private final static int DEAFULT_TICK_TEXT_SIZE_SP = 12;

	/**
	 * 滑块外圆环宽度
	 */
	private float mThumbOuterCircleWidth;

	/**
	 * 滑块外圆环颜色
	 */
	private int mThumbOuterCircleColor;

	/**
	 * 滑块内圆环宽度
	 */
	private float mThumbInnerCircleWidth;

	/**
	 * 滑块内圆环颜色
	 */
	private int mThumbInnerCircleColor;

	/**
	 * 滑块内圆半径
	 */
	private float mThumbCircleRadius;

	/**
	 * 滑块内圆颜色
	 */
	private int mThumbCircleColor;

	/**
	 * 刻度内圆半径
	 */
	private float mTickCircleRadius;

	/**
	 * 刻度内圆颜色
	 */
	private int mTickCircleColor;

	/**
	 * 刻度外圆环宽度
	 */
	private float mTickOuterCircleWidth;

	/**
	 * 刻度外圆环颜色
	 */
	private int mTickOuterCircleColor;

	/**
	 * 时间轴厚度
	 */
	private float mBaseLineWeight;

	/**
	 * 刻度文字对齐方式
	 */
	private int mTickTextAlign;

	/**
	 * 正常的刻度文字颜色
	 */
	private int mTickTextNormalColor;

	/**
	 * 处于选中状态的刻度文字颜色
	 */
	private int mTickTextSelectedColor;

	/**
	 * 刻度文字大小
	 */
	private float mTickTextSize;

	/**
	 * 当前被选中刻度索引
	 */
	private int mTickIndex = 2;

	/**
	 * 刻度总数
	 */
	private int mTickCount;

	/**
	 * 控件的默认宽度
	 */
	private float mDefaultWidth;

	/**
	 * 控件的默认高度
	 */
	private float mDefaultHeight;

	private Bar mBar;

	private Thumb mThumb;

	private OnRangeBarChangeListener mListener;

	private boolean mFirstSetTickCount = true;

	private List<String> mData;

	private int mBaseLineColor;

	public void setData(List<String> data) {
		mData = data;

	}

	public OnRangeBarChangeListener getmListener() {
		return mListener;
	}

	public void setmListener(OnRangeBarChangeListener mListener) {
		this.mListener = mListener;
	}

	public float getThumbOuterCircleWidth() {
		return mThumbOuterCircleWidth;
	}

	public void setThumbOuterCircleWidth(float mThumbOuterCircleWidth) {
		this.mThumbOuterCircleWidth = mThumbOuterCircleWidth;
		createBar();
		createThumb();
	}

	public int getThumbOuterCircleColor() {
		return mThumbOuterCircleColor;
	}

	public void setThumbOuterCircleColor(int mThumbOuterCircleColor) {
		this.mThumbOuterCircleColor = mThumbOuterCircleColor;
		createBar();
		createThumb();
	}

	public float getThumbInnerCircleWidth() {
		return mThumbInnerCircleWidth;
	}

	public void setThumbInnerCircleWidth(float mThumbInnerCircleWidth) {
		this.mThumbInnerCircleWidth = mThumbInnerCircleWidth;
		createBar();
		createThumb();
	}

	public int getThumbInnerCircleColor() {
		return mThumbInnerCircleColor;
	}

	public void setThumbInnerCircleColor(int mThumbInnerCircleColor) {
		this.mThumbInnerCircleColor = mThumbInnerCircleColor;
		createBar();
		createThumb();
	}

	public float getThumbCircleRadius() {
		return mThumbCircleRadius;
	}

	public void setThumbCircleRadius(float mThumbCircleRadius) {
		this.mThumbCircleRadius = mThumbCircleRadius;
		createBar();
		createThumb();
	}

	public int getThumbCircleColor() {
		return mThumbCircleColor;
	}

	public void setThumbCircleColor(int mThumbCircleColor) {
		this.mThumbCircleColor = mThumbCircleColor;
		createBar();
		createThumb();
	}

	public float getTickCircleRadius() {
		return mTickCircleRadius;

	}

	public void setTickCircleRadius(float mTickCircleRadius) {
		this.mTickCircleRadius = mTickCircleRadius;
		createBar();
		createThumb();
	}

	public int getTickCircleColor() {
		return mTickCircleColor;
	}

	public void setTickCircleColor(int mTickCircleColor) {
		this.mTickCircleColor = mTickCircleColor;
		createBar();
		createThumb();
	}

	public float getTickOuterCircleWidth() {
		return mTickOuterCircleWidth;
	}

	public void setTickOuterCircleWidth(float mTickOuterCircleWidth) {
		this.mTickOuterCircleWidth = mTickOuterCircleWidth;
		createBar();
		createThumb();
	}

	public int getTickOuterCircleColor() {
		return mTickOuterCircleColor;
	}

	public void setTickOuterCircleColor(int mTickOuterCircleColor) {
		this.mTickOuterCircleColor = mTickOuterCircleColor;
		createBar();
		createThumb();
	}

	public float getBaseLineWeight() {
		return mBaseLineWeight;
	}

	public void setBaseLineWeight(float mBaseLineWeight) {
		this.mBaseLineWeight = mBaseLineWeight;
		createBar();
		createThumb();
	}

	public int getTickTextAlign() {
		return mTickTextAlign;
	}

	public void setTickTextAlign(int mTickTextAlign) {
		this.mTickTextAlign = mTickTextAlign;
		createBar();
		createThumb();
	}

	public int getTickTextNormalColor() {
		return mTickTextNormalColor;

	}

	public void setTickTextNormalColor(int mTickTextNormalColor) {
		this.mTickTextNormalColor = mTickTextNormalColor;
		createBar();
		createThumb();
	}

	public int getTickTextSelectedColor() {
		return mTickTextSelectedColor;
	}

	public void setTickTextSelectedColor(int mTickTextSelectedColor) {
		this.mTickTextSelectedColor = mTickTextSelectedColor;
		createBar();
		createThumb();
	}

	public float getTickTextSize() {
		return mTickTextSize;
	}

	public void setTickTextSize(float mTickTextSize) {
		this.mTickTextSize = mTickTextSize;
		createBar();
		createThumb();
	}

	public int getTickIndex() {
		return mTickIndex;
	}

	public void setTickIndex(int mTickIndex) {
		this.mTickIndex = mTickIndex;
		createBar();
		createThumb();
	}

	public int getTickCount() {
		return mTickCount;
	}

	public void setTickCount(int tickCount) {
		if (isValidTickCount(tickCount)) {
			this.mTickCount = tickCount;
			if (mFirstSetTickCount) {
				mTickIndex = 0;
				if (mListener != null) {
					mListener.onIndexChangeListener(this, mTickIndex);
				}
			}

			if (indexOutOfRange(mTickIndex)) {
				mTickIndex = 0;
				if (mListener != null) {
					mListener.onIndexChangeListener(this, mTickIndex);
				}
			}

			createBar();
			createThumb();
		} else {
			throw new IllegalArgumentException(
					"tickCount less than 2; invalid tickCount.");
		}

	}

	public float getDefaultWidth() {
		return mDefaultWidth;
	}

	public void setDefaultWidth(float mDefaultWidth) {
		this.mDefaultWidth = mDefaultWidth;
	}

	public float getDefaultHeight() {
		return mDefaultHeight;
	}

	public void setDefaultHeight(float mDefaultHeight) {
		this.mDefaultHeight = mDefaultHeight;
	}

	public CustomerRangeBar(Context context) {
		super(context);

	}

	public CustomerRangeBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		rangeBarInit(context, attrs);

	}

	public CustomerRangeBar(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		rangeBarInit(context, attrs);

	}

	/**
	 * 初始化View的属性
	 * 
	 * @param context
	 * @param attrs
	 */
	private void rangeBarInit(Context context, AttributeSet attrs) {

		DisplayMetrics metrics = getResources().getDisplayMetrics();

		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.RangeBar, 0, 0);
		mThumbCircleColor = ta.getColor(R.styleable.RangeBar_thumbCircleColor,
				Color.YELLOW);
		mThumbInnerCircleColor = ta.getColor(
				R.styleable.RangeBar_thumbInnerCircleColor, Color.BLUE);
		mThumbOuterCircleColor = ta.getColor(
				R.styleable.RangeBar_thumbOuterCircleColor, Color.WHITE);
		mThumbCircleRadius = ta.getDimension(
				R.styleable.RangeBar_thumbCircleRadius, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_THUMB_CIRCLE_RADIUS_DP, metrics));
		mThumbInnerCircleWidth = ta.getDimension(
				R.styleable.RangeBar_thumbInnerCircleWidth, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_THUMB_INNER_CIRCLE_WIDTH_DP, metrics));
		mThumbOuterCircleWidth = ta.getDimension(
				R.styleable.RangeBar_thumbOuterCircleWidth, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_THUMB_OUTER_CIRCLE_WIDTH_DP, metrics));
		mBaseLineWeight = ta.getDimension(R.styleable.RangeBar_baselineWeight,
				TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
						DEFAULT_BASELINE_WEIGHT_DP, metrics));
		mTickCircleColor = ta.getColor(R.styleable.RangeBar_tickCircleColor,
				Color.BLUE);
		mTickCircleRadius = ta.getDimension(
				R.styleable.RangeBar_thumbCircleRadius, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_TICK_CIRCLE_RADIUS_DP, metrics));
		mTickCount = ta.getInteger(R.styleable.RangeBar_tickCount, 4);
		mTickIndex = ta.getInteger(R.styleable.RangeBar_tickIndex, 0);
		mBaseLineColor = ta.getColor(R.styleable.RangeBar_baseLineColor,
				Color.YELLOW);
		mTickOuterCircleColor = ta.getColor(
				R.styleable.RangeBar_tickOuterCircleColor, Color.WHITE);
		mTickOuterCircleWidth = ta.getDimension(
				R.styleable.RangeBar_tickOuterCircleWidth, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_TICK_OUTER_CIRCLE_WIDTH_DP, metrics));

		mTickTextAlign = ta.getInteger(R.styleable.RangeBar_tickTextAlign, 1);
		mTickTextNormalColor = ta.getColor(
				R.styleable.RangeBar_tickTextNormalColor, Color.BLACK);
		mTickTextSelectedColor = ta.getColor(
				R.styleable.RangeBar_tickTextSelectedColor, Color.YELLOW);
		mTickTextSize = ta.getDimension(R.styleable.RangeBar_tickTextSize,
				TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
						DEAFULT_TICK_TEXT_SIZE_SP, metrics));
		ta.recycle();

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);

		int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
		int measureHeight = MeasureSpec.getSize(heightMeasureSpec);

		int width = 0;
		int height = 0;

		if (widthMode == MeasureSpec.EXACTLY) {
			width = measureWidth;
		} else {
			width = (int) mDefaultWidth;
		}

		if (heightMode == MeasureSpec.EXACTLY) {
			height = Math.max(measureHeight,
					Math.round(calculateDefaultHeight() + 0.5f));
		} else {
			height = Math.round(calculateDefaultHeight() + 0.5f);
		}

		width = width + getPaddingLeft() + getPaddingRight();
		height = height + getPaddingTop() + getPaddingBottom();
		setMeasuredDimension(width, height);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);

		float length = getWidth()
				- (mThumbCircleRadius + mThumbInnerCircleWidth + mThumbOuterCircleWidth)
				* 2 - getPaddingLeft() - getPaddingRight();

		mBar = new Bar(getContext(), getWidth(), getPaddingLeft(),
				getPaddingRight(), mThumbCircleRadius, mThumbInnerCircleWidth,
				mThumbOuterCircleWidth, mTickCircleRadius,
				mTickOuterCircleWidth, mBaseLineWeight, mTickTextSize,
				getFontHeight(), getDp(10), mTickCount, mBaseLineColor,
				mTickCircleColor, mTickOuterCircleColor, mTickTextNormalColor,
				mTickTextSelectedColor, Align.values()[mTickTextAlign]);

		mThumb = new Thumb(getContext(), getWidth(), getPaddingLeft(),
				getPaddingRight(), mThumbCircleRadius, mThumbInnerCircleWidth,
				mThumbOuterCircleWidth, getFontHeight(), getDp(10), mTickCount,
				mThumbCircleColor, mThumbInnerCircleColor,
				mThumbOuterCircleColor);

		mThumb.setX(getPaddingLeft() + mThumbCircleRadius
				+ mThumbInnerCircleWidth + mThumbOuterCircleWidth
				+ (mTickIndex / (float) (mTickCount - 1)) * length);

		final int newTickIndex = mBar.getNearestTickIndex(mThumb);

		if (newTickIndex != mTickIndex) {
			mTickIndex = newTickIndex;
			if (mListener != null) {
				mListener.onIndexChangeListener(this, mTickIndex);
			}
		}

	}

	/**
	 * 判断设置的刻度值是否有效
	 * 
	 * @param tickCount
	 * @return
	 */
	private boolean isValidTickCount(int tickCount) {
		return (tickCount > 1);
	}

	/**
	 * 判断当前被选中的刻度是否在有效范围
	 * 
	 * @param tickIndex
	 * @return
	 */
	private boolean indexOutOfRange(int tickIndex) {
		return (mTickIndex < 0 || mTickIndex >= mTickCount);
	}

	/**
	 * 得到字体所占的高度
	 * 
	 * @return
	 */
	private int getFontHeight() {
		Paint paint = new Paint();
		paint.setTextSize(mTickTextSize);
		FontMetrics fontMetrics = paint.getFontMetrics();
		return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
	}

	/**
	 * 计算默认高度
	 * 
	 * @return
	 */
	private float calculateDefaultHeight() {
		return getFontHeight()
				+ (getDp(mThumbCircleRadius + mThumbInnerCircleWidth
						+ mThumbOuterCircleWidth)) * 2 + getDp(10);

	}

	/**
	 * 得到以dp为单位的值
	 * 
	 * @param value
	 * @return
	 */
	private float getDp(float value) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
				getResources().getDisplayMetrics());
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		mBar.draw(canvas, mTickIndex, mData);
		mThumb.draw(canvas);
	}

	private void createBar() {
		mBar = new Bar(getContext(), getWidth(), getPaddingLeft(),
				getPaddingRight(), mThumbCircleRadius, mThumbInnerCircleWidth,
				mThumbOuterCircleWidth, mTickCircleRadius,
				mTickOuterCircleWidth, mBaseLineWeight, mTickTextSize,
				getFontHeight(), getDp(10), mTickCount, mBaseLineColor,
				mTickCircleColor, mTickOuterCircleColor, mTickTextNormalColor,
				mTickTextSelectedColor, Align.values()[mTickTextAlign]);
		invalidate();

	}

	private void createThumb() {
		mThumb = new Thumb(getContext(), getWidth(), getPaddingLeft(),
				getPaddingRight(), mThumbCircleRadius, mThumbInnerCircleWidth,
				mThumbOuterCircleWidth, getFontHeight(), getDp(10), mTickCount,
				mThumbCircleColor, mThumbInnerCircleColor,
				mThumbOuterCircleColor);

		invalidate();
	}

	private void pressThumb(Thumb thumb) {
		if (mFirstSetTickCount == true) {
			mFirstSetTickCount = false;
		}

		thumb.press();
		invalidate();
	}

	private void releaseThumb(Thumb thumb) {
		final float nearestTickX = mBar.getNearestTickCoordinate(thumb);
		thumb.setX(nearestTickX);
		thumb.release();
		invalidate();
	}

	private void moveThumb(Thumb thumb, float x) {
		if (x < mBar.getLeftX() || x > mBar.getRightX()) {
			// Do nothing.
		} else {
			thumb.setX(x);
			invalidate();
		}
	}

	private void onActionDown(float x, float y) {
		if (!mThumb.isPressed() && mThumb.isInTargetZone(x, y)) {
			pressThumb(mThumb);
		}
	}

	private void onActionUp(float x, float y) {
		if (mThumb.isPressed()) {
			releaseThumb(mThumb);
		} else {
			mThumb.setX(x);
			releaseThumb(mThumb);

			final int newTickIndex = mBar.getNearestTickIndex(mThumb);
			if (newTickIndex != mTickIndex) {
				mTickIndex = newTickIndex;

				if (mListener != null) {
					mListener.onIndexChangeListener(this, mTickIndex);
				}
			}

		}
	}

	private void onActionMove(float x) {
		if (mThumb.isPressed()) {
			moveThumb(mThumb, x);
		}

		final int newTickIndex = mBar.getNearestTickIndex(mThumb);
		if (newTickIndex != mTickIndex) {
			mTickIndex = newTickIndex;

			if (mListener != null) {
				mListener.onIndexChangeListener(this, mTickIndex);
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (!isEnabled()) {
			return false;
		}

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			onActionDown(event.getX(), event.getY());
			return true;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			onActionUp(event.getX(), event.getY());
			this.getParent().requestDisallowInterceptTouchEvent(false);
			return true;

		case MotionEvent.ACTION_MOVE:
			onActionMove(event.getX());
			break;
		default:
			return false;
		}
		return super.onTouchEvent(event);
	}

	private static interface OnRangeBarChangeListener {
		public void onIndexChangeListener(CustomerRangeBar customerRangerBar,
				int thumbIndex);
	}
}
