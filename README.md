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

