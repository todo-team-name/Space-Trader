package cs2340.todo_team_name.spacetrader.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cs2340.todo_team_name.spacetrader.R;

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
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

    // TODO: Methods to validate username and password
    private boolean isUsernameValid(@Nullable Editable username){
        return true;
    }

    private boolean isPasswordValid(@Nullable Editable password){
        return true;
    }
}
