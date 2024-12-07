# **Report for Multi-Fragment App with SharedPreferences**

## **Name:** Inshrah Alam  
## **ID:** 0384  

---

## **Implementation of SharedPreferences and Fragments**  

### **1. SharedPreferences**  
- **Purpose**: To persistently store user preferences, ensuring the data remains accessible even after the app is closed or restarted.  
- **Implementation Steps**:  
  - Created a `SharedPreferences` instance in `UserSettingsFragment` using `getSharedPreferences("UserPrefs", 0)`.  
  - Used `SharedPreferences.Editor` to save user input (e.g., username, email, password) when the "Save Preferences" button is tapped.  
  - Used the `apply()` method to commit changes asynchronously for efficiency.  
  - Retrieved and displayed the saved preferences in `ProfileViewFragment` using the `getString()` method of `SharedPreferences`.  
  - Added a "Reset Preferences" button in `UserSettingsFragment` to clear all stored preferences using `SharedPreferences.Editor.clear()`.  

### **2. Fragments**  
- **Purpose**: To modularize the app into two functional components for better navigation and usability.  
  - **Fragment 1**: `UserSettingsFragment`:  
    - Allows users to input and save preferences.  
    - Includes data validation to ensure no empty fields are saved.  
    - Displays a confirmation message upon successful saving or resetting of preferences.  
  - **Fragment 2**: `ProfileViewFragment`:  
    - Dynamically displays user preferences retrieved from `SharedPreferences`.  
    - Automatically updates displayed data when the app is reopened or preferences are modified.  
- **Navigation**:  
  - Used `FragmentManager` in `MainActivity` to switch between the fragments.  
  - Added buttons in the `activity_main.xml` layout for user-friendly navigation.  

---

## **Key Challenges and Solutions**  

### **1. Ensuring Data Validation**  
- **Challenge**: Validating user input in `UserSettingsFragment` to prevent empty fields.  
- **Solution**: Used `TextUtils.isEmpty()` to check each field and displayed a `Toast` message if any field was empty.  

### **2. Handling Persistent Data**  
- **Challenge**: Making sure preferences persisted across app restarts.  
- **Solution**: Implemented `SharedPreferences` to store data persistently. Used the `apply()` method to save data asynchronously without blocking the UI thread.  

### **3. Fragment Communication**  
- **Challenge**: Ensuring seamless data flow between fragments.  
- **Solution**: Retrieved `SharedPreferences` in `ProfileViewFragment` to dynamically update displayed preferences. This avoided the need for direct communication between fragments.  

### **4. Resetting Preferences**  
- **Challenge**: Clearing all stored preferences and ensuring the UI reflects the reset state.  
- **Solution**: Used `SharedPreferences.Editor.clear()` to reset preferences and added a `Toast` message to inform the user of the successful reset.  

### **5. Navigation Between Fragments**  
- **Challenge**: Providing an intuitive way for users to switch between fragments.  
- **Solution**: Added navigation buttons in `activity_main.xml` and implemented click listeners in `MainActivity` to switch fragments using `FragmentManager`.  

---

## **Conclusion**  

This multi-fragment app successfully allows users to save, retrieve, and reset preferences using `SharedPreferences`. The modular design with fragments ensures a user-friendly experience and adheres to modern Android development principles. Challenges like data persistence, validation, and navigation were addressed effectively, resulting in a functional and scalable application.

