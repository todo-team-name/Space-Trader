package cs2340.todo_team_name.spacetrader.views;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cs2340.todo_team_name.spacetrader.R;

/**
 * Activity for OnBoard fragment
 */
public class OnboardFragment extends Fragment {
    /**
     * Handles creating the view for our OnboardFragment
     * @param inflater a layout inflater
     * @param container a layout container
     * @param savedInstanceState a saved instance state
     * @return a created view
     */
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        //        final TextInputLayout usernameTextInput =
        // view.findViewById(R.id.new_username_input_layout);
//        final TextInputEditText usernameEditText = view.findViewById(R.id.new_username_input);
//        final TextInputLayout passwordTextInput =
//          view.findViewById(R.id.new_password_input_layout);
//        final TextInputEditText passwordEditText = view.findViewById(R.id.new_password_input);
//        Button signUpButton = view.findViewById(R.id.sign_up_button);
//
//        signUpButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //VALIDATE
//
//                //Once validation is done, navigate to next fragment to finish setting up
//                  commander
//                ((NavigationHost) getActivity()).
//                  navigateTo(new ConfigureCommanderFragment(), false);
//            }
//        });

        return inflater.inflate(R.layout.create_account_fragment, container, false);
    }
}
