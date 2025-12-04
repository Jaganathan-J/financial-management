# Architectural Design (Android 2025)

## 1. High-Level Architecture
We adhere to **Google's Official Guide to App Architecture (MAD)**, utilizing a reactive, Unidirectional Data Flow (UDF) model.

**Layers:**
1.  **UI Layer (Presentation):** Composable functions + ViewModels.
2.  **Domain Layer:** Clean Architecture UseCases (pure Kotlin).
3.  **Data Layer:** Repositories + Data Sources (Local/Remote).

## 2. Module Structure
Following `nowinandroid` modularization patterns:
*   `:app` (Application entry point, DI graph)
*   `:core:designsystem` (Theme, Typography, Atoms, Molecules)
*   `:core:data` (Repositories, Room DB, DataStore)
*   `:core:network` (Retrofit, OkHttp, API Models)
*   `:core:domain` (UseCases, Interfaces)
*   `:feature:auth` (Login screens, Biometric logic)
*   `:feature:accounts` (Dashboard, Account Details)
*   `:feature:deposit` (Check capture, Image processing)
*   `:feature:menu` (Settings, Disclosures)

## 3. Technology Choice Rationale
*   **Hilt:** Standard Dependency Injection for Android. Scoped bindings (`@Singleton`, `@ViewModelScoped`) for memory management.
*   **Coroutines & Flows:** StateFlow used for UI State (Hot streams), SharedFlow for one-time events (Navigation/Snackbars).
*   **Jetpack Compose:** Imperative UI is retired. Declarative UI allows faster iteration on the complex Card layouts in the Dashboard.

## 4. Pattern Implementation

### 4.1 UI State Management (MVI-lite)
Each ViewModel exposes a single `uiState` data class.
```kotlin
data class AccountsUiState(
    val isLoading: Boolean = false,
    val accounts: List<Account> = emptyList(),
    val marketingTiles: List<Tile> = emptyList(),
    val error: UserMessage? = null
)
```

### 4.2 UseCase Example
`DepositCheckUseCase` handles business logic:
1.  Validates image aspect ratio.
2.  Compresses bitmap.
3.  Calls repository to upload.
4.  Emits Result<TransactionId>.

## 5. Theming (Material 3)
*   **Colors:**
    *   `primary`: BOFA Blue (#00438F)
    *   `secondary`: BOFA Red (#E31837)
    *   `surface`: White (#FFFFFF)
    *   `background`: Light Gray (#F2F2F2)
*   **Typography:** Custom font family defined in `:core:designsystem` applied globally via `MaterialTheme`.

## 6. Data Persistence
*   **Room:** Caches Account Balances for offline access ("Quick View").
*   **Proto DataStore:** Stores typed preferences (e.g., Last Selected Account ID).