package cs2340.todo_team_name.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import cs2340.todo_team_name.spacetrader.R;

public class CreateAccountFragment extends Fragment {
    private EditText user;
    private EditText password;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_account_fragment, container, false);
        user = view.findViewById(R.id.new_username_input);
        password = view.findViewById(R.id.new_password_input);
//        final TextInputLayout usernameTextInput = view.findViewById(R.id.username_input_layout);
//        final TextInputEditText usernameEditText = view.findViewById(R.id.username_input);
//        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_input_layout);
//        final TextInputEditText passwordEditText = view.findViewById(R.id.password_input);
//        Button signInButton = view.findViewById(R.id.sign_in_button);
//
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!isUsernameValid(usernameEditText.getText())) {
//                    usernameTextInput.setError(getString(R.string.error_username));
//                } else{
//                    usernameTextInput.setError(null);
//                }
//
//                if(!isPasswordValid(passwordEditText.getText())) {
//                    passwordTextInput.setError(getString(R.string.error_password));
//                } else {
//                    passwordTextInput.setError(null);
//                }

        // Once validation is complete start new activity
//            }
//        });

        return view;
    }

    public void createAccount(Intent intent) {
        String username = "";
        String pass = "";
        username = user.getText().toString();
        pass = password.getText().toString();
        intent.putExtra("username", username);
        intent.putExtra("password", pass);

    }
}

