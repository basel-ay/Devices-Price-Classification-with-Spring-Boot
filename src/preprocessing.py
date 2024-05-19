import pandas as pd
import numpy as np
from sklearn.preprocessing import StandardScaler

# Define the original feature set used for training
original_features = [
    "battery_power",
    "clock_speed",
    "fc",
    "int_memory",
    "m_dep",
    "mobile_wt",
    "n_cores",
    "pc",
    "px_height",
    "px_width",
    "ram",
    "sc_h",
    "sc_w",
    "talk_time",
]


def feature_engineering(data):
    data["screen_area"] = data["sc_h"] * data["sc_w"]
    # data["camera_mp_ratio"] = data["fc"] / data["pc"].replace(0, np.nan)
    # data["pixel_density"] = (data["px_height"] * data["px_width"]) / data["screen_area"]
    # data["pixel_density"].replace([np.inf, -np.inf], np.nan, inplace=True)

    data["log_ram"] = np.log1p(data["ram"])
    data["log_battery_power"] = np.log1p(data["battery_power"])
    data["log_int_memory"] = np.log1p(data["int_memory"])

    # Handle potential issues with qcut by dropping duplicates
    try:
        data["battery_power_bins"] = pd.qcut(
            data["battery_power"], q=4, labels=False, duplicates="drop"
        )
    except ValueError:
        data["battery_power_bins"] = pd.cut(data["battery_power"], bins=4, labels=False)

    try:
        data["ram_bins"] = pd.qcut(data["ram"], q=4, labels=False, duplicates="drop")
    except ValueError:
        data["ram_bins"] = pd.cut(data["ram"], bins=4, labels=False)

    try:
        data["int_memory_bins"] = pd.qcut(
            data["int_memory"], q=4, labels=False, duplicates="drop"
        )
    except ValueError:
        data["int_memory_bins"] = pd.cut(data["int_memory"], bins=4, labels=False)

    return data


def preprocess(data, scaler):
    data = feature_engineering(data)

    # Fill NaN values generated in new features
    data.fillna(0, inplace=True)

    # Scale only the original features
    data[original_features] = scaler.transform(data[original_features])

    return data
