# 🏘️ Grama Suvidha Portal
### *Digital Village Notice Board — Panchayat Infrastructure Transparency App*

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/>
  <img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"/>
  <img src="https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpack-compose&logoColor=white"/>
  <img src="https://img.shields.io/badge/Architecture-Clean%20MVVM-FF6B35?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/DI-Hilt-1B8A4A?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Database-Room-1B8A4A?style=for-the-badge"/>
</p>

<p align="center">
  <i>"Empowering rural citizens with digital transparency into Panchayat infrastructure development."</i>
</p>

---

## 📖 Project Overview

**Grama Suvidha Portal** is a modern, production-grade Android application designed to bridge the transparency gap in rural Panchayat governance. Villagers often have no visibility into government-funded infrastructure projects — where the money goes, who is responsible, and whether work is progressing on schedule.

This app solves that by acting as a **Digital Village Notice Board**, giving every citizen real-time access to:

- All ongoing, completed, and upcoming Panchayat projects
- Budget allocation and spending details
- Contractor information and accountability
- Visual before/after project galleries
- AI-generated progress summaries in plain language
- An offline-accessible citizen feedback system

Built as a **portfolio-grade, hackathon-winning** Android project following industry-standard architecture.

---

## ✨ Features

### 🏠 Home Dashboard
- Beautiful Material 3 project cards
- Real-time summary stats (Total / Done / Active / Delayed)
- Live search across title, description, and location
- Filter chips: All / In Progress / Completed / Delayed / Upcoming
- Pull-to-refresh for latest data
- AI rotating village insights banner
- Shimmer skeleton loading states
- Empty and error states with retry

### 📋 Project Details
- Hero gradient header with animated progress bar
- Budget allocation vs. amount spent cards
- AI-generated progress summary panel
- Horizontal image gallery with dot indicators (before/after photos)
- Contractor details and timeline information
- Geo-location map placeholder with coordinates
- Chronological project update timeline
- One-tap feedback FAB

### 💬 Citizen Feedback System
- 1–5 star rating with emoji labels
- 7 issue type chips (Quality, Delay, Corruption, Safety, etc.)
- Multi-line comment field with live AI categorization
- Citizen name and contact fields with validation
- Image upload placeholder
- Offline-first: feedback stored locally, synced when online
- Snackbar confirmation on success

### 🌐 Multi-Language Support
- English (default)
- Kannada (ಕನ್ನಡ) — full translation of all UI strings
- Dynamic language switching via Settings
- DataStore-persisted language preference
- Locale-aware date and currency formatting

### 📴 Offline-First Architecture
- All projects cached in Room database on first sync
- Fully functional after initial data load, even without internet
- Feedback queued locally, synced to server when online
- Room as single source of truth

### 🤖 AI Features (Simulated GenAI)
- AI-generated progress summaries based on project status
- Real-time AI issue categorization as user types feedback
- Rotating village insight banners with AI-style observations
- Ready for Gemini API / Vertex AI integration

---

## 📸 Screenshots

| Home Dashboard | Project Details | Feedback Form | Settings |
|:-:|:-:|:-:|:-:|
| *[Home Screenshot]* | *[Details Screenshot]* | *[Feedback Screenshot]* | *[Settings Screenshot]* |

> 📌 Run the app in Android Studio Emulator to see the full UI.

---

## 🏗️ Architecture

This project follows **Clean Architecture** with strict layer separation:

```
┌─────────────────────────────────────────┐
│              UI Layer                    │
│  Screens · ViewModels · Components      │
│  (Jetpack Compose + StateFlow)          │
├─────────────────────────────────────────┤
│              Domain Layer               │
│  Models · Repository Interfaces        │
│  Use Cases · Business Logic            │
├─────────────────────────────────────────┤
│              Data Layer                 │
│  Local (Room) · Remote (Retrofit)      │
│  DTOs · Mappers · Repository Impl      │
└─────────────────────────────────────────┘
```

### Architecture Diagram

```
MainActivity
    └── GramaSuvidhaNavHost (Navigation Compose)
            ├── HomeScreen  ←→  HomeViewModel  ←→  GetProjectsUseCase
            ├── DetailsScreen ←→ DetailsViewModel ←→ GetProjectByIdUseCase
            ├── FeedbackScreen ←→ FeedbackViewModel ←→ SubmitFeedbackUseCase
            └── SettingsScreen ←→ SettingsViewModel ←→ LanguageUtils

Use Cases → Repository Interface (domain)
                 ↕ (DI binding)
Repository Implementation (data)
    ├── Room DAO (offline cache / single source of truth)
    └── Retrofit + MockApiInterceptor (remote / refresh)
```

---

## 📁 Folder Structure

```
app/src/main/java/com/gramssuvidha/portal/
│
├── GramaSuvidhaApp.kt              # @HiltAndroidApp Application class
├── MainActivity.kt                 # Entry point with SplashScreen
│
├── data/
│   ├── local/
│   │   ├── GramaSuvidhaDatabase.kt # Room Database
│   │   ├── converter/
│   │   │   └── StringListConverter.kt
│   │   ├── dao/
│   │   │   ├── ProjectDao.kt
│   │   │   ├── FeedbackDao.kt
│   │   │   └── ProjectUpdateDao.kt
│   │   └── entity/
│   │       ├── ProjectEntity.kt
│   │       ├── FeedbackEntity.kt
│   │       └── ProjectUpdateEntity.kt
│   ├── mapper/
│   │   └── Mappers.kt              # DTO ↔ Entity ↔ Domain converters
│   ├── remote/
│   │   ├── api/
│   │   │   ├── GramaSuvidhaApiService.kt  # Retrofit interface
│   │   │   └── MockApiInterceptor.kt      # 10-project mock JSON
│   │   └── model/
│   │       ├── ProjectDto.kt
│   │       └── FeedbackDto.kt
│   └── repository/
│       ├── ProjectRepositoryImpl.kt
│       ├── FeedbackRepositoryImpl.kt
│       └── AIRepositoryImpl.kt
│
├── di/
│   ├── DatabaseModule.kt           # Room + DAOs
│   ├── NetworkModule.kt            # Retrofit + OkHttp + Mock
│   └── RepositoryModule.kt        # Interface → Impl bindings
│
├── domain/
│   ├── model/
│   │   ├── Project.kt              # + ProjectCategory + ProjectStatus enums
│   │   ├── Feedback.kt            # + IssueType enum
│   │   └── ProjectUpdate.kt
│   ├── repository/
│   │   ├── ProjectRepository.kt
│   │   ├── FeedbackRepository.kt
│   │   └── AIRepository.kt
│   └── usecase/
│       ├── GetProjectsUseCase.kt
│       ├── GetProjectByIdUseCase.kt
│       └── SubmitFeedbackUseCase.kt
│
├── ui/
│   ├── components/
│   │   ├── AiSummaryCard.kt
│   │   ├── EmptyAndErrorState.kt
│   │   ├── ProjectComponents.kt   # AnimatedProgressBar, StatusChip, etc.
│   │   └── ShimmerProjectCard.kt
│   ├── details/
│   │   ├── DetailsScreen.kt
│   │   ├── DetailsUiState.kt
│   │   └── DetailsViewModel.kt
│   ├── feedback/
│   │   ├── FeedbackScreen.kt
│   │   ├── FeedbackUiState.kt
│   │   └── FeedbackViewModel.kt
│   ├── home/
│   │   ├── HomeScreen.kt
│   │   ├── HomeUiState.kt
│   │   └── HomeViewModel.kt
│   ├── navigation/
│   │   ├── GramaSuvidhaNavHost.kt
│   │   └── Screen.kt
│   ├── settings/
│   │   ├── SettingsScreen.kt
│   │   └── SettingsViewModel.kt
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
│
└── utils/
    ├── Extensions.kt
    ├── LanguageUtils.kt
    └── Resource.kt
```

---

## 🛠️ Tech Stack

| Category         | Technology |
|-----------------|------------|
| Language         | Kotlin 2.0 |
| UI Framework     | Jetpack Compose + Material 3 |
| Architecture     | MVVM + Clean Architecture + Repository Pattern |
| DI               | Hilt (Dagger) |
| Database         | Room with TypeConverters |
| Networking       | Retrofit 2 + OkHttp + Gson |
| Mock API         | Custom OkHttp Interceptor |
| Image Loading    | Coil 2 |
| Navigation       | Navigation Compose |
| Async            | Kotlin Coroutines + Flow + StateFlow |
| Preferences      | DataStore Preferences |
| Splash Screen    | AndroidX SplashScreen API |
| Build System     | Gradle with Version Catalog (libs.versions.toml) |

---

## 🚀 Setup Instructions

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or later
- JDK 17
- Android SDK 35
- Minimum device/emulator: Android 8.0 (API 26)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/grama-suvidha.git
   cd grama-suvidha
   ```

2. **Open in Android Studio**
   - `File → Open` → Select the `Grma Suvidha` folder
   - Wait for Gradle sync to complete

3. **Run the app**
   - Select an emulator or physical device (API 26+)
   - Press `Run ▶` or `Shift+F10`

4. **First launch**
   - The app syncs mock data from the `MockApiInterceptor` on first run
   - All 10 Panchayat projects are cached in Room database
   - The app is fully usable offline after this first sync

> ⚠️ **No API key or internet connection required** — the app uses a built-in mock interceptor.

---

## 📴 Offline-First Explained

Grama Suvidha uses a **Room-as-single-source-of-truth** pattern:

```
Network Request (Retrofit)
        ↓
   MockApiInterceptor
        ↓
   Parse JSON → DTO
        ↓
  Map DTO → Entity
        ↓
 Insert into Room DB
        ↓
  Room Flow emits update
        ↓
ViewModel collects → UI updates
```

1. On app start, `HomeViewModel` triggers `projectRepository.refreshProjects()`
2. Data is saved to Room via `ProjectDao.insertProjects()`
3. `getProjects()` observes a `Flow<List<ProjectEntity>>` from Room
4. Any future data changes (from refresh) automatically propagate to UI via Flow
5. **Feedback** is saved locally first (`isSubmitted = false`), then synced to server. If network is unavailable, it remains queued and synced on next `syncPendingFeedback()` call.

---

## 🌐 Localization Explained

The app supports **English** and **Kannada** via Android's standard resource system:

- `res/values/strings.xml` — English
- `res/values-kn/strings.xml` — Kannada (ಕನ್ನಡ)

Language preference is persisted in **DataStore** (`LanguageUtils.kt`). The `MainActivity` reads this preference and applies it before setting content. Language switching in Settings triggers a state update that cascades through the app.

> 💡 To add more languages, add a `res/values-<locale>/strings.xml` file with translations.

---

## 🤖 AI Feature Explained

The AI features are **simulated** using smart rule-based logic in `AIRepositoryImpl.kt`:

| Feature | How it works |
|---------|-------------|
| **Progress Summary** | Generates contextual text based on `progress%` + `status` using template branching |
| **Issue Categorization** | Keyword matching on feedback text (corruption → ⚠️ Corruption, delay → ⏰ Timeline, etc.) |
| **Village Insights** | Rotating list of pre-generated insights, emitted via `Flow` with a 3.5s delay |

To integrate **real AI** (Google Gemini):
1. Add `implementation("com.google.ai.client.generativeai:generativeai:<version>")` to `build.gradle.kts`
2. Replace the `delay()` calls in `AIRepositoryImpl` with actual `generativeModel.generateContent(prompt)` calls
3. Add your Gemini API key to `local.properties`

---

## 🔮 Future Improvements

| Feature | Priority |
|---------|----------|
| Real Gemini API integration | High |
| Google Maps geo-location for projects | High |
| Push notifications for project updates | High |
| Admin portal for Panchayat officials | High |
| Photo upload via Firebase Storage | Medium |
| Biometric authentication for officials | Medium |
| Multi-Panchayat support | Medium |
| PDF report generation | Low |
| WhatsApp share integration | Low |
| RTL language support (Urdu/Arabic) | Low |
| Widget for home screen | Low |

---

## 👨‍💻 Resume-Ready Description

> **Grama Suvidha Portal** — *Android Developer, 2024*
>
> Designed and built a full-stack production-grade Android application for rural Panchayat governance transparency using Kotlin, Jetpack Compose, and Clean Architecture. Implemented offline-first architecture with Room database, Retrofit with mock API interceptor, Hilt DI, and Kotlin Coroutines/Flow for reactive state management. Features include a 10-project mock dataset, citizen feedback with AI issue categorization, multi-language support (English + Kannada), and animated Material 3 UI components including shimmer loaders, progress bars, and image galleries. Project demonstrates SOLID principles, separation of concerns, and production-ready code quality.

---

## 🤝 Contribution Guide

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Follow the existing architecture patterns (Clean Architecture layers)
4. Add appropriate documentation and comments
5. Ensure the app compiles and runs without errors
6. Submit a pull request with a clear description of changes

### Code Standards
- Follow Kotlin coding conventions
- Use `Resource<T>` sealed class for all async operations
- Keep ViewModels free of Android framework dependencies where possible
- All new screens must have a corresponding `UiState` data class
- All new DB operations must go through the Repository → UseCase → ViewModel chain

---

## 📄 License

```
MIT License

Copyright (c) 2024 Grama Suvidha Portal

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction.
```

---

<p align="center">
  Made with ❤️ for rural India 🇮🇳<br/>
  <i>ಗ್ರಾಮ ಸುವಿಧಾ — ಡಿಜಿಟಲ್ ಗ್ರಾಮ ನೋಟಿಸ್ ಬೋರ್ಡ್</i>
</p>
