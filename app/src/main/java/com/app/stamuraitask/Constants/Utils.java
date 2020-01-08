package com.app.stamuraitask.Constants;

import android.widget.Toast;

import com.app.stamuraitask.App;
import com.app.stamuraitask.AppConstants;
import com.app.stamuraitask.Interfaces.PageSelectCallback;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.app.stamuraitask.App.getContext;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class Utils {
    public static void proceed(PageSelectCallback pageSelectCallback, int page,
                               AppConstants.LayoutDirection direction){
        if (pageSelectCallback != null) {
            pageSelectCallback.onPageSelected(page,
                   direction);
        }
    }

    public static String getCurrentDate(){
        try{
            java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
            return dateFormat.format(new Date());
        }catch (Exception e){

        }
        return "";
    }

    public static String getCurrentTime(){
        try{
            Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
            return (sdf.format(d));
        }catch (Exception e){

        }
        return "";
    }
    public static void showShortToast(String message){
        Toast.makeText(App.getContext(),message,Toast.LENGTH_SHORT).show();
    }
    public static void showLongToast(String message){
        Toast.makeText(App.getContext(),message,Toast.LENGTH_LONG).show();
    }
}
