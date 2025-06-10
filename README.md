# 🍽️ HitoRecipo – Kotlin Multiplatform Recipe App

**HitoRecipo** is a cross-platform recipe browsing app built using **Kotlin Multiplatform** (KMP). It lets users view and search delicious recipes using the powerful **Spoonacular API**. Built with modern technologies like Jetpack Compose, Ktor, MVVM, and Koin, the app is designed to be clean, modular, and scalable across Android and iOS.

---

## 🚀 Tech Stack

| Layer             | Technology             |
|------------------|------------------------|
| Language         | Kotlin Multiplatform   |
| UI (Android)     | Jetpack Compose        |
| Networking       | Ktor                   |
| Architecture     | MVVM                   |
| Dependency DI    | Koin                   |
| API Provider     | Spoonacular API        |
| Shared Logic     | Kotlin Multiplatform   |

---

## 📱 Features

- 🍲 **View Recipes** – Browse a wide variety of recipes from the Spoonacular API
- 🔍 **Search Recipes** – Find recipes by keywords or ingredients
- 📋 **Recipe Details** – See full recipe info including ingredients and instructions
- 📦 **KMP Support** – Shared business logic runs on both Android and iOS
- ⚙️ **MVVM Architecture** – Clean and maintainable code structure
- 💉 **Koin for DI** – Modular and testable components

---

## 📦 Project Structure

```text
HitoRecipo/
├── androidApp/       # Native Android app using Jetpack Compose
├── iosApp/           # iOS app consuming shared Kotlin logic (SwiftUI or UIKit)
├── shared/           # Shared Kotlin code (data, domain, networking, logic)
│   ├── data/         # Ktor client, repository, API calls
│   ├── domain/       # Models, use-cases, interfaces
│   ├── presentation/ # ViewModels and state management
│   └── di/           # Koin modules and setup
