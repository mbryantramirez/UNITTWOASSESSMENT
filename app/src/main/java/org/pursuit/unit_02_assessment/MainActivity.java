package org.pursuit.unit_02_assessment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static android.content.Intent.EXTRA_TEXT;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  private Toolbar toolbar;
  private FloatingActionButton fab;
  private TextView emailTextView;
  private TextView secondTextView;
  private TextView infoTextView;
  private EditText inputEditText;
  private Button submitButton;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    /**
     * you are setting supportactionbar before you set the view
     */
    setSupportActionBar(toolbar);
    findViews();

    // TODO: Set an OnClickListener for the FloatingActionButton "fab" object, and in the onClick method, add an implicit intent to "send to" a mail app an email message to "mail.pursuit.org", with the subject "Email from Pursuit", and the body text of "This is my text!".
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        /**
         * use Uri.parse(mailto:{email address your sending an email to})
         *
         * no need to set type or putExtra email
         *
         * Intent.createChooser() is not needed you can just start the intent
         *
         * work on variable naming be specific what type of intent is this mailIntent would be a more specific name
         */
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text");
        intent.putExtra(Intent.EXTRA_EMAIL, "mail.pursuit.org");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email from Pursuit");
        intent.putExtra(Intent.EXTRA_TEXT, "This is my text!");
        startActivity(Intent.createChooser(intent, "Sender Email"));

      }
    });
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();
    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    // TODO: Create an instance of the RandomGame class, and a field of type "int" which will store a random number using a method from the RandomGame class. Set the OnClickListener for the Button "submitButton" object.
    final RandomGame randomGame = new RandomGame();
    final int number = randomGame.getRandomNumber();

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String mytext = "You lose!";
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        String value = inputEditText.getText().toString();
        /**
         * This crashes if the edittext value is not a number
         */
        if (Integer.parseInt(value) == number) {
          intent.putExtra("result", "You won");
          startActivity(intent);
        } else {
          infoTextView.setText(mytext);
        }

      }
    });

    // TODO: In the onClick method of the listener, use methods from the RandomGame class to check if the number in the EditText matches the number in the field above. If they match, send the winning phrase to the next activity called "SecondActivity", with an explicit intent, and an intent extra with the key "result", and the winning phrase as the value. If not, change the TextView "info_textview" text to display the losing phrase.
    // TODO: Create another activity called "SecondActivity", and add it to the Android Manifest, adding also the "MainActivity" as its parent activity. Add a TextView to "SecondActivity", with an id of "second_textView", set its height and width to "match_parent". Set its color to black, and set its font to "Cursive".
    // TODO: In the activity "SecondActivity", get the intent extra using the key "result", and use the String value it returns to set the value of the TextView "second_textView".
    // TODO: Use the "onSavedInstanceState" method to save the values of each of the TextViews/EditTexts of both activities prior to orientation change, and set their values in the onCreate method.
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_toast) {
      Toast.makeText(this, "Hello , Pursuit", Toast.LENGTH_SHORT).show();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    int id = item.getItemId();
    Intent intent;
    String phone = "2125551212";
    switch (id) {
      case R.id.nav_phone:
        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phone));
        startActivity(intent);
        break;
      case R.id.nav_sms:
        Uri uri = Uri.parse("smsto: 2125551212");
        intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "Welcome to pursuit");
        startActivity(intent);
        break;
      case R.id.nav_map_location:
        /**
         * Your uri String is correct but it needs to the tag geo: infront of it
         *  format your code more often command option L
         */
        intent = new Intent(Intent.ACTION_VIEW,
            Uri.parse("0,0?q=40.7429595,-73.94192149999998(Pursuit Android HQ)"));
        startActivity(intent);
        break;
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  public void findViews() {

    submitButton = findViewById(R.id.submit_button);
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    fab = (FloatingActionButton) findViewById(R.id.fab);
    emailTextView = findViewById(R.id.email_textView);
    secondTextView = findViewById(R.id.secondTextView);
    infoTextView = findViewById(R.id.info_textview);


  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);

  }
}
