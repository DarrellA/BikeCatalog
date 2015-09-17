package net.aucutt.bikecatalog.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import net.aucutt.bikecatalog.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onCancel( View v){
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EditText username = (EditText) findViewById( R.id.username);
        EditText password = (EditText) findViewById( R.id.passText);
        username.setText("");
        password.setText("");
    }

    public void onLogin( View v){
        EditText username = (EditText) findViewById( R.id.username);
        EditText password = (EditText) findViewById( R.id.passText);

        if( username.getText().length() < 1 || password.getText().length() < 1){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.login_dialog_message)
                    .setTitle(R.string.dialog_title);
            builder.setCancelable(false);
            builder.setNeutralButton(android.R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog dialog= builder.create();
            dialog.show();
        }else{
            // TODO: use real authentication.  maybe log audit info as well?
            Intent listIntent = new Intent( this, BikeListActivity.class);
            startActivity( listIntent);
        }
    }
}
