package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.chevelle.myapplication.jokebackend.myApi.MyApi;
import com.example.jokeviewer.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by chevelle on 9/5/16.
 */
public class JokeAsyncTask extends AsyncTask<Context, Void, String> {
    private Context context = null;
    private static MyApi MyApiService = null;

    @Override
    protected String doInBackground(Context... params) {
        String data = null;

        context = params[0];

        if (MyApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                                throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            MyApiService = builder.build();
        }

        try {
            data = MyApiService.getJoke().execute().getData();
        }
        catch (Exception anyErr) {
            data = "Error occurred: " + anyErr.getMessage();
        }

        return data;
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent jokeIntent = new Intent(context, JokeActivity.class);
        jokeIntent.putExtra("RD_JOKE", joke);

        context.startActivity(jokeIntent);
    }
}
