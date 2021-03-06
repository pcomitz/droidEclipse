package com.phc.drawgrid;

import java.util.ArrayList;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MyTouchListener implements OnTouchListener 
{
	private MyGridView view; 
	private ArrayList<Point> arrayList; 
	
	public MyTouchListener(MyGridView v)
	{
		this.view = v;
		arrayList = new ArrayList<Point>(); 
	}

	//@Override
	public boolean onTouchOLD(View v, MotionEvent event) 
	{
		boolean returnValue = false; 
		Point p = new Point(); 
		
		 switch (event.getAction()) 
		 {
		 	case MotionEvent.ACTION_DOWN:
		 	{
		 		Log.v(UpdateView2Activity.MYTAG, "MovtionEvent.ACTION_DOWN"); 
		 		p.x = (int) event.getX(); 
		    	p.y = (int) event.getY();
		 		arrayList.add(p); 
		 		Log.v(UpdateView2Activity.MYTAG,"size is:"+arrayList.size()+", x is:"+p.x+", y is:"+p.y); 
		 		returnValue = true; 
		 		break; 
		 	}
	        case MotionEvent.ACTION_MOVE:
	        {
	        	Log.v(UpdateView2Activity.MYTAG, "MovtionEvent.ACTION_MOVE"); 
	        	p.x = (int) event.getX(); 
	        	p.y = (int) event.getY();
	        	arrayList.add(p); 
	        	Log.v(UpdateView2Activity.MYTAG,"size is:"+arrayList.size()+", x is:"+p.x+", y is:"+p.y); 
	        	returnValue = true; 
	        	break; 	
	        }
	        case MotionEvent.ACTION_UP:
		 	{
		 		Log.v(UpdateView2Activity.MYTAG, "MovtionEvent.ACTION_UP"); 
		 		p.x = (int) event.getX(); 
		    	p.y = (int) event.getY();
		 		arrayList.add(p); 
		 		Log.v(UpdateView2Activity.MYTAG,"size is:"+arrayList.size()+", x is:"+p.x+", y is:"+p.y); 
		 		
		 		//set the point to be drawn
		 		view.setPoints(arrayList); 
		 		view.invalidate(); 
		 		
		 		returnValue = true; 
		 		break; 
		 	}
		
	        default:
	        	returnValue=  false;
		 	}
		 	return returnValue;
	}	
	
	@Override
	public boolean onTouch(View v, MotionEvent event) 
	{
		boolean returnValue = false; 
		Point p = new Point(); 
		int action = event.getAction();
		
		//check for any DOWN, MOVE, or UP
		if((action == MotionEvent.ACTION_DOWN)||(action == MotionEvent.ACTION_MOVE)||
		  (action == MotionEvent.ACTION_UP))
		{
			p.x = (int) event.getX(); 
	    	p.y = (int) event.getY();
	 		arrayList.add(p); 
	 		Log.v(UpdateView2Activity.MYTAG,"size is:"+arrayList.size()+", x is:"+p.x+", y is:"+p.y); 
	 		
	 		//set the point to be drawn
	 		view.setPoints(arrayList); 
	 		view.invalidate(); 
	 		
	 		
	 		if(action == MotionEvent.ACTION_UP)
	 		{
	 			this.view.clearArrayList(); 
	 		}
	 		returnValue = true; 
		}
		
		
		return returnValue; 
	} //new onTouch
	
	
} ///~
