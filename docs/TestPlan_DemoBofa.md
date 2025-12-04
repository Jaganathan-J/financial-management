# Comprehensive Test Plan

## 1. Testing Strategy Pyramid
*   **Unit Tests (70%):** Logic validation (ViewModels, UseCases, Util).
*   **Integration Tests (20%):** Component interaction (Repositories + Room/API mocks).
*   **UI/E2E Tests (10%):** Critical User Journeys (Maestro / Espresso).

## 2. Unit Testing (JUnit 5 + MockK)
### Scope
*   **DepositValidationTest:** Verify input amount > 0, amount <= daily limit, image paths not null.
*   **AccountFormatterTest:** Verify masking logic ("...0688") and currency formatting.
*   **AuthViewModelTest:** Verify state transitions (Loading -> Success/Error) upon login action.

## 3. Compose UI Testing
Using `compose-test-rule`.
### Scenarios to Automate
1.  **Login Screen Rendering:**
    *   Assert "Log In" button is displayed.
    *   Assert Input fields accept text.
    *   Assert "Log In" click triggers loading state.
2.  **Dashboard Navigation:**
    *   Perform click on "Deposit Checks" bottom tab.
    *   Assert TopBar title changes or Content Description matches.
3.  **Grid Consistency:**
    *   On Dashboard, verify that 4 cards (Spending, FICO, Deal, Alert) are visible on the screen.

## 4. Integration Testing (Hilt + OkHttpMockWebServer)
*   **Happy Path:** Inject MockWebServer, enqueue 200 Response for `/accounts/summary`. verify Repository returns mapped Domain objects.
*   **Error Path:** Enqueue 500 Error. Verify Repository throws specific `NetworkException`.

## 5. Manual QA Checklist
*   **Biometrics:** Test enrollment, success, fail, and fallback to password.
*   **Camera:** application behavior when Camera permission is denied permanently.
*   **Network:** Test app behavior in Airplane mode (Should show cached data + Snackbar).
*   **Accessibility:** Traverse entire app using *only* Navigation Rail/Switch Access.