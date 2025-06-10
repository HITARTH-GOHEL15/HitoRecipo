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

## 🔧 Setup Instructions
Prerequisites
Android Studio Giraffe or newer

Kotlin Multiplatform plugin

Xcode (for iOS)

Spoonacular API key 

---

## Clone the Repository
bash
Copy
Edit
git clone https://github.com/yourusername/HitoRecipo.git
cd HitoRecipo

---

## 🌐 API Reference
Base URL: https://api.spoonacular.com/

Authentication: API Key in query params

Example Endpoint: GET /recipes/complexSearch

---

## 🧑‍💻 Contributing
We welcome contributions! If you'd like to improve the app, fix bugs, or add features:

Fork the repo

Create a new branch

Make your changes

Submit a Pull Request 🚀

---

## 💬 Contact
Made by Hitarth Gohel

For questions or suggestions, feel free to open an issue or reach out via GitHub.

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

