package com.example.PowerTrans;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.view.LayoutInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Button;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.soulapp.MESSAGE";
    public LayoutInflater inflater;
    public LinearLayout lLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        lLayout = (LinearLayout)findViewById(R.id.layout2);
        add_wire(getCurrentFocus());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Some changes
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

    public void add_wire(View view){
        // add comment
        LinearLayout L = (LinearLayout)inflater.inflate(R.layout.buttons,null);
        lLayout.addView(L);

    }

    public void remove_wire(View view){

       // int child = lLayout.getChildCount();
       //lLayout.removeViews((child-1),1);


        //Вызов getParent() возвращает FrameLayout в который вложена кнопка Del
        LinearLayout fl=(LinearLayout) view.getParent();
        //Определяем родительскую группу LinearLayout в которую мы добавляли item
        LinearLayout ll=(LinearLayout) fl.getParent();
        //Теперь у нас есть все данные, чтобы определить номер позиции в которой
        //находится item в родительской группе
        int index=ll.indexOfChild(fl);
        //Зная индекс item в группе LinearLayout, можно удалить  элемент
        ll.removeViewAt(index);
    }

	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.item2 :
	            sendMessage(this.getCurrentFocus());
	            return true;
	      //  case R.id.action_settings:
	        //    openSettings();
	         //   return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}


    public void onConfigurationChanged(Configuration newConfig) {
       super.onConfigurationChanged(newConfig);
    }
	
}
