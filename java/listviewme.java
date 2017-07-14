package com.example.pro.test1;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by pro on 2017/5/17.
 */

public class listviewme extends ListView {
    public listviewme(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int x = (int) ev.getX();
                int y = (int) ev.getY();
                int itemnum = pointToPosition(x, y);
                if (itemnum == AdapterView.INVALID_POSITION)
                    break;
                else{
                    if(itemnum==0){ // 选择项为1
                        if(itemnum==(getAdapter().getCount()-1)){// 列表只有一项
                            setSelector(R.drawable.app_list_corner_round);
                        }else{ // 列表不止一项
                            setSelector(R.drawable.app_list_corner_round_top);
                        }
                    }else if(itemnum==(getAdapter().getCount()-1)) // 选择项为最后一项
                        setSelector(R.drawable.app_list_corner_round_bottom);
                    else{
                        setSelector(R.drawable.app_list_corner_shape);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
