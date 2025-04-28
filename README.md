# Fetch Rewards Coding Exercise - Android App

This is my submission for the Fetch Rewards Software Engineering - Mobile coding exercise.

The native Android app fetches a list of items from a remote server and displays them grouped by `listId`.  
Users can expand and collapse each group to view its sorted item (sorted first by "listId" then by the number inside "name").
Items with blank or null names are filtered out before display.

---

## Features
- Fetch data from a remote API using Retrofit
- Display data grouped by `listId`
- Sort items by `listId` and item `name` (number inside name)
- Collapse and expand sections smoothly for easy to read lists
- "See All" section to view all items across all lists
- Modern Android Architecture (ViewModel, Repository)

---


## Tech Stack
- **Kotlin**
- **Android Jetpack** (ViewModel, LiveData)
- **Retrofit2** (Networking)
- **RecyclerView** 
- **Material Design 3** Components

---

## How to Run the Project
1. Clone the repository:
    ```bash
    git clone https://github.com/YOUR_USERNAME/fetch-rewards-coding-exercise.git
    ```
2. Open in **Android Studio** (latest version recommended).
3. Connect an emulator or physical device.
4. Run the app!

---

## Notes
- Min SDK: 24
- Target SDK: 35
- Kotlin version: 2.0.21
- Gradle version: 8.9.2

