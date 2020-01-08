package com.app.stamuraitask.RoomDB;

import android.os.AsyncTask;

import androidx.sqlite.db.SimpleSQLiteQuery;

import com.app.stamuraitask.App;
import com.app.stamuraitask.Interfaces.OnUserDataFetched;
import com.app.stamuraitask.Models.UserRating;

import java.util.List;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class DBOperation {
    public static void insertRating(final UserRating rating) {
        class SaveTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {

                if(rating!=null){
                    DatabaseClient.getInstance(App.getContext()).getAppDatabase()
                            .taskDao()
                            .insert(rating);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }

    public static void getUserRatings(final OnUserDataFetched onUserDataFetched) {
        class GetTasks extends AsyncTask<Void, Void, List<UserRating>> {
            @Override
            protected List<UserRating> doInBackground(Void... voids) {
//                List<UserRating> taskList = DatabaseClient
//                        .getInstance(App.getContext())
//                        .getAppDatabase()
//                        .taskDao()
//                        .getAll();
                List<UserRating> taskList =  DatabaseClient
                        .getInstance(App.getContext())
                        .getAppDatabase()
                        .taskDao().runtimeQuery(new SimpleSQLiteQuery(RawQueries.query_order_descending));
                return taskList;
            }

            @Override
            protected void onPostExecute(List<UserRating> tasks) {
                super.onPostExecute(tasks);
                if(onUserDataFetched!=null){
                    onUserDataFetched.onDataFetched(tasks);
                }
            }
        }

        GetTasks gt = new GetTasks();
        gt.execute();
    }

}
