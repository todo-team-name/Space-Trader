package cs2340.todo_team_name.spacetrader.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.NavigationHost;

public class OnboardFragment extends Fragment {
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_account_fragment, container, false);
//        final TextInputLayout usernameTextInput = view.findViewById(R.id.new_username_input_layout);
//        final TextInputEditText usernameEditText = view.findViewById(R.id.new_username_input);
//        final TextInputLayout passwordTextInput = view.findViewById(R.id.new_password_input_layout);
//        final TextInputEditText passwordEditText = view.findViewById(R.id.new_password_input);
//        Button signUpButton = view.findViewById(R.id.sign_up_button);
//
//        signUpButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TODO: Validate new username and password
//
//                //Once validation is done, navigate to next fragment to finish setting up commander
//                ((NavigationHost) getActivity()).navigateTo(new ConfigureCommanderFragment(), false);
//            }
//        });

        return view;
    }
}
