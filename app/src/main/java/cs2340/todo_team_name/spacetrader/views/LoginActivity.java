package cs2340.todo_team_name.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.R;

public class LoginActivity extends AppCompatActivity {
    private EditText user;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        loadFragment(new LoginFragment());
        user = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);

    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragments, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void login(View view) {
        Intent intent = new Intent(this, ConfigurationActivity.class);
        LoginFragment sellFrag = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragments);
        sellFrag.login(intent);
        startActivity(intent);
    }


}
