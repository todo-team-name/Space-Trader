package cs2340.todo_team_name.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    //private EditText user;
    //private EditText password;
    private LoginViewModel loginViewModel;

    /**
     * Handles creating LoginActivity
     * @param savedInstanceState a saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        loadFragment(new LoginFragment());
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        //user = findViewById(R.id.username_input);
        //password = findViewById(R.id.password_input);

    }

    /**
     * Loads fragment in LoginActivity
     * @param fragment the fragment to load
     */
    private void loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragments, fragment)
                    .commit();
        }
    }

    /**
     * Logs user in the LoginView
     * @param view the corresponding Login View
     */
    public void login(View view) {
        Intent intent = new Intent(this, PlayerActivity.class);
        LoginFragment sellFrag =
                (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragments);
        sellFrag.login(intent);
        String user_name = intent.getStringExtra("username");
        String pass = intent.getStringExtra("password");
        loginViewModel.login_request(user_name, pass, this, intent);
        //String token = loginViewModel.tokenResult();
        //token = loginViewModel.tokenResult();
        //Log.i("TOKEN", token);
        //Log.i("TOKEN", "SHOULD HAVE PRINTED");
        //intent.putExtra("token", token);
        //startActivity(intent);
    }

    /**
     * Opens Create Account Fragment
     * @param view the provided view
     */
    public void openCreateAccount(View view) {
        loadFragment(new CreateAccountFragment());
    }

    /**
     * Dispatches the create account request from the view model
     * @param view the provided view
     */
    public void createAccount(View view) {
        Intent intent = new Intent(this, ConfigurationActivity.class);
        CreateAccountFragment createFrag = (CreateAccountFragment) getSupportFragmentManager().
                findFragmentById(R.id.fragments);
        createFrag.createAccount(intent);
        loginViewModel.createAccountRequest(intent, this);
    }


}
