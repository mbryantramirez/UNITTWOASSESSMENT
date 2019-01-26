# Unit 02 Assessment

This assessment should be completed within 3 (three) hours after it has commenced. Please download the following project to your computer:

This project has 20 (twenty) tasks which must be completed in their entirety to receive full-credit. These tasks are denoted throughout the project as `TODO` comments. Please replace each `TODO` comment with the requested code. Please select the "TODO" tab at the bottom of Android Studio to list them all.

### In `nav_header_main.xml`:
1. Change the color of the layout background to a color of your choosing.
1. Add a ImageView, give it an id of "navigation_imageView", set its width and height to "wrap content", and set its source from a file in the drawable resource folder: an image of yourself.
1. Add a TextView, give it an id of "title_textView", set its width to "match_parent", and set its height to "wrap_content". Set its text to your full name.
1. Add a TextView, give it an id of "subtitle_textView", and set its width and height to "wrap_content". Set its text to "Android 5.4 Cohort Fellow".
1. Add a TextView, give it an id of "email_textView", set its width and height to "wrap_content", and set its text to your Pursuit Email Address. Make the email a clickable link.

### In `RandomGameTest.java`:
1. Initialize any test variables with object values in a "setUp()" method that runs before any of the unit tests.
1. Create a test method called "test_get_random_number_method()". Add logic to confirm that the number returned from the getRandomNumber() method is between 1 and 100, including both 1 and 100.
1. Create a test method called "test_check_guess_method()". Add logic to confirm that the boolean value returned is true if the numbers passed to the checkGuess() method are equal, and false if they are not equal.
1. Create a test method called "test_get_string_result()". Add logic to confirm that the String value returned from the getStringResult() method matches expected output based on what boolean value is passed to the parameter.
1. Create a test method called "test_string_to_int()". Add logic to confirm that the method stringToInt() returns a valid integer value based on the String input provided.

### In `MainActivity.java`:

#### Send Implicit Intents
1. If the user selects the "nav_phone" view, add an implicit intent to "dial" the number "2125551212" in the phone app.
1. If the user selects the "nav_sms" view, add an implicit intent to "send to" the number "2125551212" in the sms text messaging app the message "Welcome to Pursuit!".
1. If the user selects the "nav_map_location" view, add an implicit intent to "view" the coordinates "0,0?q=40.7429595,-73.94192149999998(Pursuit Android HQ)" in the Google Maps app.
1. Set an OnClickListener for the FloatingActionButton "fab" object, and in the onClick method, add an implicit intent to "send to" a mail app an email message to "mail.pursuit.org", with the subject "Email from Pursuit", and the body text of "This is my text!".

#### Make a Toast
1. Write code to handle the "Toast" Option click, and display a Toast to the screen with the text "Hello, Pursuit!".

#### Play a Game and declare Explicit Intents
1. Create an instance of the RandomGame class, and a field of type "int" which will store a random number using a method from the RandomGame class. Set the OnClickListener for the Button "submitButton" object.
1. In the onClick method of the listener, use methods from the RandomGame class to check if the number in the EditText matches the number in the field above. If they match, send the winning phrase to the next activity called "SecondActivity", with an explicit intent, and an intent extra with the key "result", and the winning phrase as the value. If not, change the TextView "info_textview" text to display the losing phrase.
1. Create another activity called "SecondActivity", and add it to the Android Manifest, adding also the "MainActivity" as its parent activity. Add a TextView to "SecondActivity", with an id of "second_textView", set its height and width to "match_parent". Set its color to black, and set its font to "Cursive".
1. In the activity "SecondActivity", get the intent extra using the key "result", and use the String value it returns to set the value of the TextView "second_textView".
1. Use the "onSavedInstanceState" method to save the values of each of the TextViews/EditTexts of both activities prior to orientation change, and set their values in the onCreate method.

## Key Requirements

* All spelling of method names, and values of XML property types must be either written or declared AS DESCRIBED IN EACH TASK DESCRIPTION.
* All literal values (Strings, Colors, and numerical Dimensions) known at compile time MUST be defined in resource files, and referenced appropriately in views

## Submission

Please initialize a git repository within the root project folder, add and commit your changes, push to a remote repository, then paste the link to this remote Github repository into Canvas by no later than 10:00pm EST. Good luck!
