# 🔐 MnemonicGen

A professional Java-based utility to generate 24-word mnemonic phrases and securely encrypt them using AES. Designed for secure, offline secret management.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Ubuntu](https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)

---

## 🚀 Features
* **Mnemonic Generation:** Automatically creates a secure 24-word recovery phrase.
* **AES Encryption:** High-grade encryption to protect your data.
* **Master Password:** PBKDF2-style key derivation for secure locking.
* **Zero-Cloud:** All data stays local in `vault.enc`.


## 🛠️ Setup & Installation

### Prerequisites
* **Java 17+**
* **Maven 3.6+**

### Installation
```bash
## Clone the repository
`git clone [https://github.com/tejasdhakate62-dev/MnemonicGen.git](https://github.com/tejasdhakate62-dev/MnemonicGen.git)`
`cd MnemonicGen`

### Compile the project
```bash
mvn clean compile

## 🚀 Features
* **Mnemonic Generation:** Automatically creates a secure 24-word recovery phrase.
* **AES Encryption:** High-grade encryption to protect your data.
* **Master Password:** PBKDF2-style key derivation for secure locking.
* **Zero-Cloud:** All data stays local in `vault.enc`.

### 🛠️ Setup & Installation

### Prerequisites
* **Java 17+**
* **Maven 3.6+**

### Installation
```bash
### Clone the repository
git clone [https://github.com/tejasdhakate62-dev/MnemonicGen.git](https://github.com/tejasdhakate62-dev/MnemonicGen.git)
cd MnemonicGen

### Compile the project
```bash
mvn clean compile

### 💻 How to Use
### 1. Generate (Lock)
```bash
mvn exec:java -Dexec.mainClass="com.tejas.Generator"

### 2. Recover (Unlock)
```bash
mvn exec:java -Dexec.mainClass="com.tejas.Decryptor"

MnemonicGen/
├── src/main/java/com/tejas/
│   ├── Generator.java  # Handles phrase creation & encryption
│   └── Decryptor.java  # Handles phrase recovery & decryption
├── vault.enc           # Encrypted data (Do not upload!)
└── pom.xml             # Project dependencies
