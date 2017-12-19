package plp.pdq.util;

import android.location.Address;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;


/**
 * This class represents a user, and holds all the associated information to
 * said user, such as name, address, date of birth, etc.
 *
 * TODO: Implement associated payment options
 */
public class User
{
    // A list of all the users of the app
    static private ArrayList<User> registeredUsers;
    // The current user
    static private User activeUser = null;


    String firstName;
    String lastName;
    Address address;
    Date dateOfBirth;


    User()
    {
        this.firstName      = null;
        this.lastName       = null;
        this.address        = null;
        this.dateOfBirth    = null;
    }

    /**
     * Registers the User to the internal list of users.
     */
    public void Register() {
        // If no array, create one
        if (registeredUsers == null)
            registeredUsers = new ArrayList<User>();

        // Add this user to the array, if it doesn't already exist
        if (IndexInRegister() == -1)
            registeredUsers.add(this);
    }

    /**
     * Removes the User from the internal list of users.
     */
    public void Unregister()
    {
        // Get the user's index in the register
        int index = IndexInRegister();

        // Remove the user if it's in the register
        if (index != -1)
            registeredUsers.remove(index);
    }

    /**
     * Returns the index of this User in the Internal register.
     *
     * @return int      The index in the register of this user. Returns -1 if
     *                  the user doesn't exist in the register
     */
    private int IndexInRegister()
    {
        // Make sure the internal register exists, returns -1 if it doesn't
        if (registeredUsers == null)
            return -1;

        // Loop through all registered users. If this user is found in the
        // register, return it's index
        for (int i = 0; i < registeredUsers.size(); i++) {
            if (registeredUsers.get(i) == this) {
                return i;
            }
        }

        // Returns -1 if the loop exits without finding this user
        return -1;
    }

    /**
     * Gets the number of users registered on the internal list
     *
     * @return int      The number of users registered
     */
    public static int NumRegistered()
    {
        // If register doesn't exist, return 0
        if (registeredUsers == null)
            return 0;

        // Return the register size
        return registeredUsers.size();
    }

    /**
     * Gets the active user (the currently "signed in" user).
     *
     * @return User     The currently signed in user.
     */
    public static User GetActive()
    {
        return activeUser;
    }

    /**
     * A testing environment.
     */
    public static void UnitTest()
    {
        User user1 = new User();
        Log.d("UserTest", "Created user1: " + user1);
        Log.d("UserTest", "User's index in register: " + user1.IndexInRegister());
        Log.d("UserTest", "Attempting to unregister"); user1.Unregister();
        Log.d("UserTest", "Registered User"); user1.Register();
        Log.d("UserTest", "User's index in register: " + user1.IndexInRegister());
        Log.d("UserTest", "Registered User Again"); user1.Register();
        Log.d("UserTest", "User's index in register: " + user1.IndexInRegister());
        Log.d("UserTest", "Attempting to unregister"); user1.Unregister();
        Log.d("UserTest", "Attempting to unregister"); user1.Unregister();
    }
}
