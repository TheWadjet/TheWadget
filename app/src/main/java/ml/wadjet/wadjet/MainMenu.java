package ml.wadjet.wadjet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.ACTION_SENDTO, "brightsvl@gmail.com");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Hello developers!");
                    intent.putExtra(Intent.EXTRA_TEXT, "I'm writing to...");
                    startActivity(Intent.createChooser(intent, "Send Email"));
                } catch (Exception e) {
                    Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    public void exit(View view) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public void showAbout(View view) {
        Snackbar.make(view, "Program created by SV_VL, Hardkun and Oleg", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void start(View view) {
        try {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            Snackbar.make(view, e.toString(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }
}
