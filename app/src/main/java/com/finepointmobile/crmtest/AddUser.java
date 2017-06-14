package com.finepointmobile.crmtest;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by danielmalone on 6/13/17.
 */

public class AddUser extends AppCompatActivity {

    EditText mFirstName;
    Button mButton;
    User mUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);

        mFirstName = (EditText) findViewById(R.id.first_name);
        mButton = (Button) findViewById(R.id.save);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser = new User(mFirstName.getText().toString(), "asdf", "asdf");
                new SaveData().execute();
            }
        });
    }

    private class SaveData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                    .build();
            db.mUserDao().insertAll(mUser);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            startActivity(new Intent(AddUser.this, MainActivity.class));
        }
    }
}
