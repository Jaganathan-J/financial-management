# Functional Specification Document (FSD): Demo BOFA Android

## 1. Authentication Flow
### 1.1 Description
The entry point of the application. Handles user identification via credentials or biometrics.
### 1.2 Screen Reference
*   **Splash Screen:** Static logo display while initializing dependency graph.
*   **Login Screen:** Contains `User ID` (masked input), `Password`, `Biometric` toggle, and `Logo`.
### 1.3 Logic & Validation
*   **Masking:** User ID field must support alphanumeric masking (e.g., "jagan****").
*   **Biometrics:** If enabled, the app must invoke `BiometricPrompt` immediately after the Splash screen.
*   **Errors:** Invalid credentials must trigger a generic "Incorrect User ID or Password" Snackbar; account lockouts occur after 3 failed attempts.

## 2. Dashboard & Accounts
### 2.1 Description
The primary post-login interface featuring a dual-tab layout.
### 2.2 Screen Reference
*   **Accounts Tab:** List of `CardView` items (Adv Plus Banking, Credit Cards).
*   **Dashboard Tab:** Grid Layout (spending, FICO, Rewards).
### 2.3 Functional Logic
*   **Tab Switching:** Tapping "ACCOUNTS" or "DASHBOARD" at the top toggles the `StateFlow` viewing mode without reloading the activity.
*   **Data Fetching:** Pull-to-refresh logic triggers a concurrent fetch of Account Balances, Rewards, and Alerts.
*   **Badge Logic:** The "Inbox" and "Erica" icons in the Sticky Header must reflect unread counts pushed from the Notification Service.

## 3. Mobile Check Deposit (RDC)
### 3.1 Description
A critical feature allowing users to deposit checks via camera capture.
### 3.2 Screen Reference
*   **Deposit Checks Screen:** Contains "Front of Check" and "Back of Check" capture areas, "Deposit to" selector, and "Amount" input.
### 3.3 User Journey
1.  User taps "Deposit Checks" in Bottom Nav.
2.  User selects "Front of Check".
3.  **System Requirement:** App requests `CAMERA` permission.
4.  Custom Camera UI launches with an overlay guide (rectangular bounding box).
5.  Image capture is validated locally (blur detection, aspect ratio).
6.  User enters amount.
7.  "NEXT" button enables *only* when both images and valid amount are present.
### 3.4 Edge Cases
*   **Camera Permission Denied:** Show explanation dialog with a link to App Settings.
*   **Low Light:** Detect luminosity and prompt user to turn on flash.
*   **Limit Exceeded:** If amount > Daily Limit, show inline error.

## 4. Global Navigation Module
### 4.1 Bottom Navigation
*   **Persistence:** Visible on all top-level screens (Accounts, Pay & Transfer, Deposit, Invest).
*   **State:** Maintains back-stack state per tab (Jetpack Navigation with `saveState` and `restoreState`).
### 4.2 Menu Drawer (More)
*   **Reference:** *Menu Screen*
*   **Structure:** Full-screen vertical list grouped by category (Profile, Statements, Support).
*   **Search:** Integrated Search Bar activating "Erica" text input mode.