package com.aki.Game.OOXX;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class StartTable extends TableLayout{
	
	float scale;//螢幕係數 size*scale+0.5f = dpi
	boolean user = true;
	boolean win = false;
	Button btn[];
	TableRow row;
	
	public StartTable(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public StartTable(Context context , GameActivity main) {
		super(context);
		scale = getResources().getDisplayMetrics().density;
		btn = new Button[9];
        row = new TableRow(context);
        this.addView(row);
        
        for(int i = 0 , j = 0 ; i < btn.length ;i++ , j++){
        	btn[i] = new Button(context);
        	btn[i].setText(" ");
        	btn[i].setHeight((int)(50*scale+0.5f));
        	btn[i].setWidth((int)(50*scale+0.5f));
        	
        	final int n = i;
        	btn[i].setOnClickListener(
        		new View.OnClickListener(){
        			public void onClick(View v){
        				if(!win){
	        				if(btn[n].getText().equals(" ")){
		        				if(user){
		        					btn[n].setText("O");
		        					user = false;
		        				}else{
		        					btn[n].setText("X");
		        					user = true;
		        				}
		        			}
	        				win();
        				}
        			}
        		}
        	);
        	row.addView(btn[i]);
        	if(j == 2){
        		j = -1;
        		row = new TableRow(context);
        		this.addView(row);
			}
        }
        //btn[8].setVisibility(View.INVISIBLE);//隱藏 存在於排版位址
        //btn[8].setVisibility(View.GONE);//隱藏 不存在於排版位址 下面會往上捕
        //btn[8].layout.setVisibility(View.VISIBLE);//顯示
        
        row = new TableRow(context);
        
        Button b = new Button(context);//新局
        b.setText("新局");
        b.setWidth((int)(50*this.scale+0.5f));
        b.setHeight((int)(50*this.scale+0.5f));
        b.setOnClickListener(//新局
        	new View.OnClickListener(){
        		public void onClick(View v){
        			for(int i = 0 ; i <btn.length ; i++){
        					btn[i].setText(" ");
        					btn[i].setTextColor(Color.BLACK);
        					user = true;
        					win = false;
        			}
        		}
        	}
        );
        
        Button b2 = new Button(context);//離開
        b2.setText("離開");
        b2.setWidth((int)(50*this.scale+0.5f));
        b2.setHeight((int)(50*this.scale+0.5f));
        
        final GameActivity m = main;
		final StartTable t = this;
        b2.setOnClickListener(//離開
    		new View.OnClickListener() {
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				m.menu.setVisibility(View.VISIBLE);
    				t.setVisibility(View.GONE);
    			}
    		}
    	);
        
        row.addView(b);
        row.addView(b2);
        this.addView(row);
	}
	public void win(){
		int[][] bkey = 
			{
				{0,1,2},// 橫
				{3,4,5},
				{6,7,8},
				
				{0,3,6},// 直
				{1,4,7},
				{2,5,8},
				
				{0,4,8}, // 斜
				{2,4,6},
			};
		
		for(int i = 0 ; i < bkey.length ; i++){
			if(!btn[bkey[i][0]].getText().equals(" ") &&
					(btn[bkey[i][0]].getText().equals(btn[bkey[i][1]].getText()) && 
							btn[bkey[i][1]].getText().equals(btn[bkey[i][2]].getText()))){
				btn[bkey[i][0]].setTextColor(Color.RED);
				btn[bkey[i][1]].setTextColor(Color.RED);
				btn[bkey[i][2]].setTextColor(Color.RED);
				win = true;
				break;
			}
		}
	}
}
