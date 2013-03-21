package com.aki.Game.OOXX;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class menuTable extends TableLayout {
	
	Button btn[];
	float scale;//螢幕係數 size*scale+0.5f = dpi
	
	public menuTable(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public menuTable(Context context , GameActivity main) {
		super(context);
		scale = getResources().getDisplayMetrics().density;
		
		TableRow row = new TableRow(context);
		btn = new Button[3];
		String[] test = {"開始","幫助","離開"};
		
		for(int i = 0 ; i < btn.length ; i++){
			btn[i] = new Button(context);
			
			btn[i].setText(test[i]);
			btn[i].setHeight((int)(50*scale+0.5f));
			btn[i].setWidth((int)(50*scale+0.5f));
			row.addView(btn[i]);
		}
		final GameActivity m = main;
		final menuTable t = this;
		btn[0].setOnClickListener(//開始
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					m.start.setVisibility(View.VISIBLE);
					t.setVisibility(View.GONE);
				}
			}
		);
		
		btn[2].setOnClickListener(//離開
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						m.finish();
					}
				}
			);
		
		this.addView(row);
	}
}
