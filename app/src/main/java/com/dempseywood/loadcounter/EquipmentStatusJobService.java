package com.dempseywood.loadcounter;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

/**
 * Created by musing on 10/08/2017.
 */

public class EquipmentStatusJobService extends JobService {

    public static final Integer EquipmentStatusJobId = 23;

    private HttpRequestTask task;
    @Override
    public boolean onStartJob(final JobParameters params) {
        Log.i("EquipmentStatusJob", "starting job");
        task =  new HttpRequestTask(this.getApplicationContext(), null){
            @Override
            protected void onPostExecute(Boolean success){
                if(success) {
                    Log.i("EquipmentStatusJob", "task finished");
                }else{
                    Log.i("EquipmentStatusJob", "task failed, rescheduling  job");
                }
                jobFinished(params, !success);
            }
        };
        task.execute();

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i("load counter", "onStopJob");
        if(task != null){
            Log.i("load counter", "cancelling job");
            task.cancel(true);
        }
        return true;
    }
}
