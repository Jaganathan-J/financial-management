# Assumptions & Technical Decisions

## 1. Third-Party Restrictions & libraries
*   **Assumption:** It is assumed the client approves the use of open-source libraries. We are using **Retrofit** (Networking), **Coil** (Image Loading), and **Hilt** (DI) as they are standard, maintained by Google/Square, and widely accepted in enterprise banking for stability.
*   **PDF Rendering:** For the "Statements and Documents" section (Menu), we assume the use of the native Android PDF Renderer or passing an Intent to an external PDF viewer to reduce app size.

## 2. Backend Capabilities
*   **Orchestration Layer:** We assume the backend provides a "BFF" (Backend for Frontend) layer that aggregates balances, FICO scores, and rewards into a single `/summary` response to minimize mobile radio usage and battery drain.
*   **Image Processing:** While we use local ML Kit for basic check boundary detection, we assume the actual OCR for check amount and account reading happens Server-Side for security compliance.

## 3. Security & Compliance
*   **Session Management:** We assume a short-lived Access Token (15 min) and a Secure Cookie/Refresh Token rotation mechanism. The app will auto-logout after 5 minutes of background inactivity.
*   **Emulator Policy:** The app will proactively block execution on rooted devices and emulators in the Production build flavor using Play Integrity API.

## 4. Design Implementation
*   **Icons:** We assume access to the proprietary Bank of America icon font/SVG set. Placeholders (Material Icons) will be used in the Initial Development Phase.
*   **"Erica" Assistant:** We assume this is implemented as a Web View or a specialized native SDK provided by the AI team. For this documentation, we treat it as a separate module entry point.