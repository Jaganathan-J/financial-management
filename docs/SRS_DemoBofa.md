# Software Requirements Specification (SRS)

## 1. Environment & Build Configuration
*   **IDE:** Android Studio Meerkat (2024.3.1) or newer.
*   **Language:** Kotlin 2.1.0 (K2 Compiler enabled).
*   **Build System:** Gradle 8.10 with Version Catalogs (TOML).
*   **Min SDK:** API Level 26 (Android 8.0 Oreo).
*   **Target SDK:** API Level 35 (Android 16).

## 2. Core Libraries & Dependencies (2025 Standard)
*   **UI Framework:** Jetpack Compose (BOM 2025.02.00).
    *   `androidx.compose.material3:material3`
    *   `androidx.compose.ui:ui-tooling-preview`
*   **Architecture:**
    *   `androidx.lifecycle:lifecycle-runtime-compose:2.9.0`
    *   `androidx.navigation:navigation-compose:2.8.5`
*   **Dependency Injection:** Hilt 2.55.
*   **Concurrency:** Kotlin Coroutines 1.10.1 + Flow.
*   **Networking:** Retrofit 2.11.0 + OkHttp 5.0.0-alpha.14 + Kotlin Serialization.
*   **Image Loading:** Coil 3.0 (Compose-first).
*   **Machine Learning:** ML Kit (Text Recognition) for Check Scanning.

## 3. Performance Requirements
*   **Frame Rate:** UI must maintain 60fps (16ms frame time) generally; 90/120fps on supported devices.
*   **Startup Time:** < 2 seconds to interactive state (measured via Jetpack Macrobenchmark).
*   **Memory Usage:** Peak heap usage should not exceed 256MB during standard flows.
*   **Network:** API timeout set to 30s; Retry logic with exponential backoff for poor connectivity.

## 4. Security Requirements
*   **Storage:** All sensitive tokens (Refresh Token) stored in `EncryptedSharedPreferences` (MasterKey system).
*   **Network Security:** TLS 1.3 enforced. Certificate Pinning enabled for `api.demobofa.com`.
*   **Screen Privacy:** `FLAG_SECURE` enabled on the *Login* and *Deposit* screens to prevent screenshots/recording.
*   **Obfuscation:** R8 full mode enabled with aggressive shrinkage profiles.

## 5. Compliance & Accessibility
*   **WCAG 2.1 AA:** All touch targets min 48dp. Color contrast ratios > 4.5:1 for text.
*   **Screen Readers:** All ImageVectors (Icons) must have meaningful `contentDescription`. Hidden decorative elements must use `null` descriptions.
*   **Dynamic Type:** Layouts must support font scaling up to 130% without breaking.