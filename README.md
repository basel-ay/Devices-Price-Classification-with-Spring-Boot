# Devices Price Classification System

This project is an AI-based system designed to classify device prices based on their characteristics. It comprises two main components:
1. **Python Project**: Handles data preprocessing, feature engineering, model training, and price prediction.
2. **Spring Boot Project**: Provides RESTful APIs to interact with the prediction model and manage device data.

## Project Overview
The goal is to build a system that predicts device price ranges using machine learning techniques. The system allows sellers to classify device prices based on specifications such as battery power, RAM, screen dimensions, and more.

## Setup Instructions

### Prerequisites
- Python 3.7+
- Java 8+
- Maven 3.6+
- Git

### Python Project Setup
1. **Clone the Repository:**
    ```sh
    git clone https://github.com/yourusername/device-price-classification.git
    cd device-price-classification/python
    ```

2. **Create and Activate a Virtual Environment:**
    ```sh
    python -m venv venv
    source venv/bin/activate  # On Windows use `venv\Scripts\activate`
    ```

3. **Install Dependencies:**
    ```sh
    pip install -r requirements.txt
    ```

4. **Run the Python Application:**
    ```sh
    python app.py
    ```

### Spring Boot Project Setup
1. **Navigate to the Spring Boot Directory:**
    ```sh
    cd device-price-classification/springboot
    ```

2. **Build the Project:**
    ```sh
    mvn clean install
    ```

3. **Run the Spring Boot Application:**
    ```sh
    mvn spring-boot:run
    ```

## Running the Application

### Python Application
The Python application runs a Flask server that provides an endpoint to predict device prices.

### Spring Boot Application
The Spring Boot application provides a set of RESTful APIs to manage devices and predict their prices by interacting with the Python service.

## API Endpoints

### Device Management
- **GET /api/devices/**: Retrieve a list of all devices.
- **GET /api/devices/{id}**: Retrieve details of a specific device by ID.
- **POST /api/devices/**: Add a new device.
  - **Request Body:**
    ```json
    {
        "battery_power": 1500,
        "blue": 1,
        "clock_speed": 2.0,
        "dual_sim": 1,
        "fc": 5,
        "four_g": 1,
        "int_memory": 16,
        "m_dep": 0.5,
        "mobile_wt": 150,
        "n_cores": 4,
        "pc": 12,
        "px_height": 1920,
        "px_width": 1080,
        "ram": 2048,
        "sc_h": 15,
        "sc_w": 7,
        "talk_time": 10,
        "three_g": 1,
        "touch_screen": 1,
        "wifi": 1
    }
    ```

### Prediction
- **POST /api/predict/{deviceId}**: Predict the price of a device and save the result in the device entity.
  - **Request Body:** None
  - **Response:**
    ```json
    {
        "deviceId": 1,
        "predicted_price_range": 2
    }
    ```

![image](https://github.com/basel-ay/Devices-Price-Classification-with-Spring-Boot/assets/64821137/48ad408b-1377-4ce2-b6b1-89c39ce92187)
