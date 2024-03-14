# AND101 Project 4 - CodeMath

Submitted by: **Brian Zhang**

Time spent: **6** hours spent in total

## Summary

**Tip Calculator** is an android app that provides a user-friendly interface to input the bill amount, select a tip percentage via a slider, and calculate the tip and total amounts to be split among the party.

If I had to describe this project in three (3) emojis, they would be: **💸🧮🤑**

## Application Features

The following REQUIRED features are completed:

- [X] At least one (1) user input
- [X] At least one (1) interactive View
- [X] At least one (1) output of a calculation based on the user input

The following STRETCH features are implemented:

- [X] Implement ViewBinding to reduce boilerplate code and increase efficiency
- [X] Add at least one (1) additional functionality

The following EXTRA features are implemented:

- [X] Including a number of people field in a tip calculator
- [X] Implement dynamic feedback based on conditional formatting

## Video Demo

Here's a video / GIF that demos all of the app's implemented features:

<p align="center">
  <img src='https://imgur.com/j3BvJ7P.gif' title='Video Demo' width='' alt='Video Demo' />
</p>

GIF created with **ScreentoGif**

<!-- Recommended tools:
- [Kap](https://getkap.co/) for macOS
- [ScreenToGif](https://www.screentogif.com/) for Windows
- [peek](https://github.com/phw/peek) for Linux. -->

## Notes

- **Detailed Interface:** The tip calculator has a clean design with inputs for the bill amount and options to select tip percentage and party size.
- **SeekBar:** A slider allows users to adjust the tip percentage dynamically, with real-time updates to the calculated tip displayed.
- **Dynamic Feedback:** Text and color feedback changes based on the selected tip percentage, giving users a qualitative understanding of their tip amount.
- **Language & Framework:** Written in Kotlin, utilizing Android's AppCompatActivity.
- **Layout:** UI components are set up programmatically in the onCreate method, linking XML views to Kotlin variables.
- **Formatting:** Utilizes DecimalFormat to ensure monetary values are displayed in a user-friendly format.
- **Listeners:** Implements listeners for the SeekBar and EditText to recalculate the totals whenever the user changes the input values.
- **Color Feedback:** Uses ContextCompat.getColor to apply color changes to feedback text, providing an immediate visual cue to the user.
- **ArrayAdapter & Spinner:** The app uses these to allow users to select the party size from a predefined list, which is part of the UI layout resources.

## License

Copyright **2024** **Brian Zhang**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
