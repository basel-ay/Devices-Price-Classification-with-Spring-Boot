from flask import Flask, request, jsonify
import joblib
import pandas as pd
from src.preprocessing import (
    preprocess,
    original_features,
)  # Ensure original_features is imported

app = Flask(__name__)

# Load the trained model and scaler
model = joblib.load("model/SVC_model.pkl")
scaler = joblib.load("model/scaler.pkl")


@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json()
    input_data = pd.DataFrame([data])

    # Preprocess the input data
    processed_data = preprocess(input_data, scaler)

    # Ensure processed data contains only the original features
    # processed_data = processed_data[original_features]

    # Make prediction
    prediction = model.predict(processed_data)

    return jsonify({"prediction": int(prediction[0])})


if __name__ == "__main__":
    app.run(debug=True)
