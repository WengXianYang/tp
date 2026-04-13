# Joel (JellybeanJoel) - Project Portfolio Page

**TravelTrio** is a desktop travel management application optimized for users who prefer a Command Line Interface (CLI).
It helps organized and thrifty travelers manage complex trip itineraries, track activity-based budgets, and handle currency exchange rates within a single, lightweight interface.

Given below are my contributions to the project.

### **New Feature: Advanced Activity Management**
* What it does: Allows users to modify specific fields (like time or location) of an existing activity (Edit) or safely remove an activity from the itinerary (Delete).
* Justification: Travel plans are highly subjected to change. This feature gives users the flexibility to correct mistakes or adapt their schedule without the frustration of deleting and re-entering an entire activity from scratch.
* Highlights: 
  * Edit feature supports partial updates, allowing users to leave fields blank to keep current values.
  * Delete feature safely extracts activities from the itinerary while maintaining strict data integrity.
* Implementation:
  * Designed and implemented `EditActivityCommand` and `DeleteActivityCommand`.
  * Introduced optional input prompting mechanisms in the `Ui` class to seamlessly handle blank inputs during partial updates.
  * Integrated with the `ActivityList` to ensure changes reflect immediately without breaking chronological sorting.

### **New Feature: Trip Sharing System**
* What it does: Enables users to save a specific trip to a standalone .txt file and parse shared files back into their active application.
* Justification: Travel is often a group effort. This feature allows users to easily collaborate, share their itineraries and budget plans with friends, or create secure backups of individual trips.
* Highlights: 
  * Exports a selected trip's full itinerary and budget data into a formatted, readable text file.
  * Seamlessly imports and merges shared files back into the user's active `TripList`.
* Implementation: 
  * Created `ExportTripCommand` and `ImportTripCommand` to handle user routing.
  * Maximised code reuse by leveraging and adapting the existing `Storage` parsing logic for file I/O operations, ensuring consistent data formatting across the app.

### **Enhancements to Existing Features**
* **Robust UI Error Recovery:**
  * Replaced the rigid data-entry flow in the `Ui` and `CommandProcessor` classes with robust `while(true)` loops and custom parsers (`promptDate`, `promptTime`).
  * Drastically improved user experience by allowing users to simply re-type a specific faulty field upon validation failure, rather than forcing them to restart a multistep command from scratch.
  
* **Centralized Help Command:**
  * Designed and implemented the `HelpCommand`.
  * Provided a centralized and easily updatable reference guide directly within the CLI to smoothly onboard new users and serve as a quick reference for power users.

### Code Contributed
[RepoSense Link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=jellybeanjoel&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2026-02-20T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=JellybeanJoel&tabRepo=AY2526S2-CS2113-F09-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

  * Contributed across core modules including 'Activity', cross-user data persistence (import/export), and UI validation loops.
  * Key files: `EditActivityCommand.java`, `DeleteActivityCommand.java`, `ImportTripCommand.java`, `ExportTripCommand.java`, `HelpCommand.java`, `Ui.java`.

### **Documentation**
* **User Guide:**
    * Authored a comprehensive document illustrating the step-by-step process on how to use the application, ensuring clarity for new users interacting with the CLI.
    * Documented edge cases and expected behaviors for the activity management and trip-sharing features.

* **Developer Guide:** 
    * Authored the comprehensive design document for the `Edit Activity` feature.
    * Created the PlantUML Sequence Diagram to visually illustrate the step-by-step interaction between the `Ui` prompting, `CommandProcessor` routing, and internal `ActivityList` mutation.

### **Community**
* PR Reviews: Reviewed and approved Pull Requests (PRs), focusing on identifying logic inconsistencies and naming convention errors, ensuring the codebase remained cohesive and readable.
