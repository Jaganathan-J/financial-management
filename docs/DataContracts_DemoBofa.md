# Data Contracts & API Specification

**Base URL:** `https://api.demobofa.com/v1`
**Content-Type:** `application/json`

## 1. Authentication
### Login
`POST /auth/login`
**Request:**
```json
{
  "userId": "jagan123",
  "password": "s3cur3P@ss",
  "biometricSignature": "<optional_crypto_object>"
}
```
**Response (200 OK):**
```json
{
  "accessToken": "eyJh...",
  "refreshToken": "r8s...",
  "expiresIn": 3600,
  "userProfile": {
    "firstName": "Jaganathan",
    "enrollmentType": "ADV_PLUS"
  }
}
```

## 2. Accounts Domain
### Get Dashboard Summary
`GET /accounts/summary?includeRewards=true`
**Response:**
```json
{
  "accounts": [
    {
      "id": "acc_0688",
      "type": "CHECKING",
      "displayName": "Adv Plus Banking",
      "mask": "0688",
      "balance": 1608.03,
      "currency": "USD",
      "isFdicInsured": true
    },
    {
      "id": "card_0012",
      "type": "CREDIT",
      "displayName": "Customized Cash Rewards Visa Signature",
      "mask": "0012",
      "balance": 11576.90
    }
  ],
  "widgets": {
    "ficoScore": 769,
    "rewardsBalance": 28.66,
    "spendingTrend": "DOWN_10_PERCENT"
  }
}
```

## 3. Check Deposit Domain
### Submit Deposit
`POST /checks/deposit`
**Header:** `Authorization: Bearer <token>`
**Format:** `multipart/form-data`
**Parts:**
*   `front_image`: (Binary/JPEG)
*   `back_image`: (Binary/JPEG)
*   `meta`: JSON String
    ```json
    {
      "accountId": "acc_0688",
      "amount": 450.00,
      "clientTimestamp": "2025-11-20T14:30:00Z"
    }
    ```

## 4. Error Handling
All endpoints return standard error envelopes:
```json
{
  "errorCode": "AUTH_001",
  "userMessage": "Your session has expired. Please log in again.",
  "traceId": "abc-123-xyz"
}
```