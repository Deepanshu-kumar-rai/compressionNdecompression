# 📦 CompX – File Compression & Decompression Utility

CompX is a **Java-based desktop application** that allows users to **compress and decompress files** with a simple and user-friendly interface.  
It uses the **Deflate algorithm (LZ77 + Huffman coding)** to achieve efficient, lossless compression.

---

## ✨ Features
- 🎨 **Modern Swing UI** with decorative heading and clean design  
- 📂 **File selection dialogs** for easy input/output  
- ⚡ **Lossless compression** using the Deflate algorithm  
- 📊 Achieves **50–80% size reduction** for text and structured data  
- 🛠️ Separate **compressor** and **decompressor** modules for clean architecture  
- 🚀 Clear **success/error dialogs** for better user experience  

---
## 🖥️ Technologies Used
- **Java SE 8+**  
- **Swing (GUI Framework)**  
- **Deflate algorithm** (`java.util.zip.Deflater`, `Inflater`)  

---

## 📌 Project Structure
CompX/
│── GUI/
│   └── AppFrame.java         # Main application window
│
│── comp_decomp/
│   ├── compressor.java       # Compression logic (Deflate)
│   └── decompressor.java     # Decompression logic
│
│── README.md                 # Project documentation

📸##Project snips

<img width="1321" height="884" alt="Screenshot 2025-09-02 090949" src="https://github.com/user-attachments/assets/0ae46cbc-3413-4a65-9beb-1b4ec4a6c2fc" />

<img width="1584" height="965" alt="Screenshot 2025-09-02 110149" src="https://github.com/user-attachments/assets/0d9d3a0f-f322-4c19-a1e8-a653fa4607af" />

<img width="1046" height="967" alt="Screenshot 2025-09-02 110256" src="https://github.com/user-attachments/assets/714ffbae-36e3-4ac1-b95c-2e49d2712381" />
