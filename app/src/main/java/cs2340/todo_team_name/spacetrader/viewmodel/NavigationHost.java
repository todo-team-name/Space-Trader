package cs2340.todo_team_name.spacetrader.viewmodel;

import androidx.fragment.app.Fragment;

/**
 * A host (typically an {@code Activity}} that can display fragments and knows how to respond to
 * navigation events.
 */
public interface NavigationHost {
    /**
     * Trigger a navigation to the specified fragment, optionally adding a transaction to the back
     * stack to make this navigation reversible.
     * @param addToBackStack boolean value whether or not to add to stack
     * @param fragment fragment to add
     */
    void navigateTo(Fragment fragment, boolean addToBackStack);
}
