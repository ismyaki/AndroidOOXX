package com.aki.Game.OOXX;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class GameActivity extends Activity {
	
	RelativeLayout layout;
	RelativeLayout.LayoutParams lp;
	
	StartTable start;
	menuTable menu;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game); 
        // 
        layout = (RelativeLayout)this.findViewById(R.id.RelativeLayout01);
        lp =new RelativeLayout.LayoutParams(-2, -2);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
        //
        menu = new menuTable(this , this);
        start = new StartTable(this , this);
        //
        layout.addView(menu, lp);
        layout.addView(start, lp);
        //
        start.setVisibility(View.GONE);
	}
}