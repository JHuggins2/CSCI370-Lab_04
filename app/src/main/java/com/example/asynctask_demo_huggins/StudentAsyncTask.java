package com.example.asynctask_demo_huggins;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentAsyncTask extends AsyncTask<Void,Void, ArrayList> {

    private ListView listView;
    private Context context;

    public StudentAsyncTask(ListView listView, Context context) {
        this.listView = listView;
        this.context = context;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p>
     * This will normally run on a background thread. But to better
     * support testing frameworks, it is recommended that this also tolerates
     * direct execution on the foreground thread, as part of the {@link #execute} call.
     * <p>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param voids The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected ArrayList doInBackground(Void... voids) {
        StudentDAO studentDAO = new StudentDAO();
        return studentDAO.getAllStudents();
    }

    /**
     * <p>Runs on the UI thread after {@link #doInBackground}. The
     * specified result is the value returned by {@link #doInBackground}.
     * To better support testing frameworks, it is recommended that this be
     * written to tolerate direct execution as part of the execute() call.
     * The default version does nothing.</p>
     *
     * <p>This method won't be invoked if the task was cancelled.</p>
     *
     * @param arrayList The result of the operation computed by {@link #doInBackground}.
     * @see #onPreExecute
     * @see #doInBackground
     */
    @Override
    protected void onPostExecute(ArrayList arrayList) {
        super.onPostExecute(arrayList);
        StudentAdapter studentAdapter = new StudentAdapter(context, arrayList);

        listView.setAdapter(studentAdapter);
    }
}
