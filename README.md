# 🔐 MnemonicGen

A professional Java-based utility to generate 24-word mnemonic phrases and securely encrypt them using AES. Designed for secure, offline secret management.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Ubuntu](https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)

---

## 📖 Theory of Operation
MnemonicGen follows industry-standard security practices to ensure your data remains private:
* **Generation:** Creates a unique 24-word phrase for wallet recovery or secure storage.
* **Encryption:** Uses a Master Password to derive a key and lock data with **AES (Advanced Encryption Standard)**.
* **Storage:** Data is saved locally in `vault.enc`. It never touches the cloud.

---

## 🚀 Features
* **Mnemonic Generation:** Automatically creates a secure 24-word recovery phrase.
* **AES Encryption:** High-grade encryption to protect your data.
* **Master Password:** PBKDF2-style key derivation for secure locking.
* **Zero-Cloud:** All data stays local in `vault.enc`.

---

## 🛠️ Setup & Installation

### Prerequisites
* **Java 17+**
* **Maven 3.6+**

### All Commands (Quick Start)
```bash
# 1. Clone the repository
git clone [https://github.com/tejasdhakate62-dev/MnemonicGen.git](https://github.com/tejasdhakate62-dev/MnemonicGen.git)
cd MnemonicGen

# 2. Compile the project
mvn clean compile

# 3. Generate (Lock)
mvn exec:java -Dexec.mainClass="com.tejas.Generator"

# 4. Recover (Unlock)
mvn exec:java -Dexec.mainClass="com.tejas.Decryptor"

📂 Project Structure
MnemonicGen/
├── src/main/java/com/tejas/
│   ├── Generator.java  # Handles phrase creation & encryption
│   └── Decryptor.java  # Handles phrase recovery & decryption
├── vault.enc           # Encrypted data (DO NOT UPLOAD!)
└── pom.xml             # Project dependencies

👤 Author
Tejas Dhakate
Role: Computer Engineering Student
University: Rashtrasant Tukadoji Maharaj Nagpur University (RTMNU)
GitHub: @tejasdhakate62-dev
Email: tejasdhakate62@gmail.com
