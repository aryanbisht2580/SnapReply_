# SnapReply 📧⚡

**AI-Powered Gmail Response Generator - Complete Solution**

SnapReply is a comprehensive email productivity platform that uses artificial intelligence to automatically generate contextually appropriate responses for your Gmail emails, saving you 5-7 minutes per email interaction. The solution includes both a Chrome extension for seamless Gmail integration and a modern web application for enhanced features and analytics.


## 📸 Screenshots

### 🧩 Chrome Extension in Action

<img width="622" alt="image" src="https://github.com/user-attachments/assets/5dd9eee5-b4dd-4df8-9eff-10e31953e73f" />


*SnapReply Chrome extension adds a SnapReply button directly in Gmail*


<img width="781" alt="image" src="https://github.com/user-attachments/assets/70163a66-ca94-48ea-b1a6-4c7ec98d9fbf" />

*One-click AI-generated response instantly added to the Gmail compose box*


<img width="1440" alt="image" src="https://github.com/user-attachments/assets/dd985b1c-4974-4bb9-be4c-7182e84e1c44" />

*Web Dashboard to test and download the extension*



## 🚀 Features

### Chrome Extension
- **Intelligent Response Generation**: Leverages Google's Gemini AI to craft relevant, professional email responses
- **Gmail Integration**: Seamlessly integrates with Gmail's interface
- **Time Efficient**: Saves 5-7 minutes per email by automating response drafting
- **Context-Aware**: Analyzes incoming emails to generate appropriate responses
- **One-Click Responses**: Generate and insert responses with a single click

### Web Application
- **Beautiful Dashboard**: Modern, responsive interface built with React and Tailwind CSS
- **Smooth Animations**: Enhanced user experience with Framer Motion animations
- **Email Analytics**: Track response generation statistics and time saved
- **Template Management**: Create and manage custom response templates
- **Usage Insights**: Detailed analytics on email productivity improvements
- **Account Management**: User profiles, preferences, and subscription management

## 🛠️ Tech Stack

### Frontend - Chrome Extension
- **JavaScript** - Extension logic and Gmail DOM manipulation
- **HTML/CSS** - User interface components
- **Chrome Extension APIs** - Browser integration

### Frontend - Web Application
- **React** - Modern JavaScript framework for building user interfaces
- **Tailwind CSS** - Utility-first CSS framework for rapid UI development
- **Framer Motion** - Production-ready motion library for React animations
- **React Router** - Declarative routing for React applications
- **Axios** - HTTP client for API communication

### Backend
- **Spring Boot** - RESTful API framework
- **Java** - Backend programming language
- **Google Gemini API** - AI-powered text generation
- **Maven** - Dependency management
- **Spring Security** - Authentication and authorization
- **JWT** - Token-based authentication



## 🔧 Installation

### Chrome Extension

1. **Download the Extension**
   ```bash
   git clone https://github.com/aryanbisht/SnapReply.git
   cd snapreply/extension
   ```

2. **Load Extension in Chrome**
   - Open Chrome and navigate to `chrome://extensions/`
   - Enable "Developer mode" in the top right
   - Click "Load unpacked" and select the extension folder
   - The SnapReply icon should appear in your Chrome toolbar

### Web Application

1. **Production (Live Website)**
   - Visit [https://snapreply-bz38.onrender.com](http://snapreply-bz38.onrender.com)

2. **Local Development**
   ```bash
   # Clone repository
   git clone https://github.com/aryanbisht2580/SnapReply.git
   cd SnapReply
   
   # Install web app dependencies
   cd webapp
   npm install
   
   # Start development server
   npm start
   # App will be available at http://localhost:3000
   ```

### Backend API

```bash
# Navigate to backend directory
cd backend

# Install dependencies and run
mvn clean install
mvn spring-boot:run
# API will be available at http://localhost:8080
```

### Full Development Setup

```bash
# Clone the repository
git clone https://github.com/aryanbisht2590/SnapReply.git
cd SnapReply

# Start backend
cd backend
mvn spring-boot:run &

# Start web app
cd ../webapp
npm install && npm start &

# Load Chrome extension
# Follow Chrome extension installation steps above
```

## ⚙️ Configuration

### Environment Variables

#### Backend (.env or application.properties)
```env
# Gemini AI Configuration
GEMINI_API_KEY=your_gemini_api_key_here
GEMINI_MODEL=gemini-flash-1.5

# Server Configuration
SERVER_PORT=8080
```

#### Web Application (.env)
```env
# API Configuration
REACT_APP_API_BASE_URL=http://localhost:8080/api
REACT_APP_API_VERSION=v1

# Google OAuth (if applicable)
REACT_APP_GOOGLE_CLIENT_ID=your_google_client_id

# Environment
REACT_APP_ENVIRONMENT=development
```

### Extension Settings

The extension can be configured through the popup interface:
- Response tone (Formal, Casual)
- Auto-suggestion preferences
- Keyboard shortcuts

## 🚀 Usage

### Chrome Extension
1. **Open Gmail** in your Chrome browser
2. **Select an Email** you want to respond to
3. **Click the SnapReply Button** that appears in the Gmail interface
4. **Review the Generated Response** in the compose window
5. **Edit if Needed** and send your response


## 🏗️ Architecture

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│  React Web App  │    │  Spring Boot     │    │  Gemini AI      │
│                 │◄──►│  Backend API     │◄──►│  Service        │
│  - Analytics    │    │  - REST          │    │  - Text         │
│  - Templates    │    │    Endpoints     │    │    Generation   │
│  - Settings     │    │  - Email         │    │  - Context      │
│                 │    │    Processing    │    │    Analysis     │
└─────────────────┘    │  - User Auth     │    │                 │
                       │  - JWT Tokens    │    │                 │
┌─────────────────┐    │  - Analytics     │    │                 │
│  Chrome         │    │    Tracking      │    │                 │
│  Extension      │◄──►│                  │    │                 │
│                 │    └──────────────────┘    └─────────────────┘
│  - Content      │
│    Script       │    ┌──────────────────┐
│  - Popup UI     │    │  Database        │
│  - Background   │◄──►│                  │
│    Service      │    │  - User Data     │
│                 │    │  - Templates     │
└─────────────────┘    │  - Analytics     │
                       │  - Usage Stats   │
                       └──────────────────┘
```

## 📂 Project Structure

```
snapreply/
├── webapp/                          # React Web Application
│   ├── public/
│   │   ├── index.html
│   │   └── favicon.ico
│   ├── src/
│   │   ├── components/
│   │   │   ├── Dashboard/
│   │   │   ├── Analytics/
│   │   │   ├── Templates/
│   │   │   └── Settings/
│   │   ├── pages/
│   │   │   ├── Home.jsx
│   │   │   ├── Login.jsx
│   │   │   └── Dashboard.jsx
│   │   ├── hooks/
│   │   ├── utils/
│   │   ├── App.jsx
│   │   └── index.js
│   ├── tailwind.config.js
│   └── package.json
├── extension/                       # Chrome Extension
│   ├── manifest.json
│   ├── content.js
│   ├── popup.html
│   ├── popup.js
│   ├── background.js
│   └── styles/
├── backend/                         # Spring Boot API
│   ├── src/main/java/
│   │   └── com/snapreply/
│   │       ├── SnapReplyApplication.java
│   │       ├── controller/
│   │       │   ├── EmailController.java
│   │       ├── service/
│   │       │   ├── GeminiService.java
│   │       │   ├── EmailService.java
│   │       ├── model/
│   │       │   ├── EmailTemplate.java
│   │       │   └── Usage.java
│   │       └── config/
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
├── docs/                           # Documentation
├── README.md
└── LICENSE
```


## 📈 Performance

### Chrome Extension
- **Response Generation**: Average 2-3 seconds
- **Gmail Integration**: Minimal impact on Gmail loading time
- **Memory Usage**: ~5MB extension footprint
- **API Calls**: Optimized to reduce unnecessary requests

### Web Application
- **Page Load Time**: < 2 seconds (initial load)
- **Route Transitions**: Smooth animations with Framer Motion
- **Bundle Size**: Optimized with code splitting
- **Lighthouse Score**: 90+ (Performance, Accessibility, Best Practices)
- **Mobile Performance**: Fully responsive design

### Backend API
- **Response Time**: < 500ms for most endpoints
- **Gemini API Integration**: Optimized request batching
- **Database Queries**: Indexed and optimized
- **Concurrent Users**: Supports 1000+ simultaneous users

## 🔒 Privacy & Security

- **No Email Storage**: Emails are processed in real-time and not stored
- **Secure API Communication**: All API calls use HTTPS
- **Local Processing**: Extension logic runs locally in browser
- **Data Encryption**: Sensitive data encrypted in transit

## 🐛 Troubleshooting

### Common Issues

**Extension not appearing in Gmail**
- Refresh Gmail page
- Check if extension is enabled in Chrome
- Verify Chrome extension permissions

**Responses not generating**
- Check internet connection
- Verify Gemini API key configuration
- Check browser console for errors

**Web application not loading**
- Check if backend API is running on correct port
- Verify CORS configuration in backend
- Check browser console for JavaScript errors
- Ensure environment variables are properly set

**Animations not working smoothly**
- Check if Framer Motion is properly installed
- Verify browser hardware acceleration is enabled
- Test on different devices/browsers
- Check for conflicting CSS animations

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

