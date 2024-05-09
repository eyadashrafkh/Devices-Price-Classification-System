import joblib
import warnings
import numpy as np
import pandas as pd
from sklearn import set_config
set_config(transform_output='pandas')
# Ignore the warning
warnings.filterwarnings("ignore")

def predict(features):
    
    # Convert features to DataFrame
    df = pd.DataFrame.from_dict(features)
    if 'ID' in df.columns:
        df.drop('ID', axis=1, inplace=True)
    if 'price_range' in df.columns:
        df.drop('price_range', axis=1, inplace=True)

    # Define numerical features
    numerical_features = ['battery_power', 'clock_speed', 'fc', 'int_memory', 'm_dep', 'mobile_wt', 'n_cores', 'pc', 'px_height', 'px_width', 'ram', 'sc_h', 'sc_w', 'talk_time']
    # Define categorical features
    categorical_features = ['blue', 'dual_sim', 'four_g', 'three_g', 'touch_screen', 'wifi']

    # Load the numerical transformer
    loaded_num_preprocessor = joblib.load('dataset/num_preprocessor.joblib')
    # Load the categorical transformer
    loaded_cat_preprocessor = joblib.load('dataset/cat_preprocessor.joblib')

    # Preprocess the numerical input features
    num_transformed = loaded_num_preprocessor.transform(df[numerical_features])
    # Preprocess the categorical input features
    cat_transformed = loaded_cat_preprocessor.transform(df[categorical_features])
    # Combine the preprocessed numerical and categorical input features
    features_transformed = np.concatenate((num_transformed, cat_transformed), axis=1)

    # Load the trained model
    model = joblib.load('models/opt_lr_model.pkl')
    # Make predictions
    pred = model.predict(features_transformed)
    
    return pred

def prepare_device_data(device):
    device_data = {
        'ID': device.id,
        'battery_power': device.battery_power,
        'blue': device.blue,
        'clock_speed': device.clock_speed,
        'dual_sim': device.dual_sim,
        'fc': device.fc,
        'four_g': device.four_g,
        'int_memory': device.int_memory,
        'm_dep': device.m_dep,
        'mobile_wt': device.mobile_wt,
        'n_cores': device.n_cores,
        'pc': device.pc,
        'px_height': device.px_height,
        'px_width': device.px_width,
        'ram': device.ram,
        'sc_h': device.sc_h,
        'sc_w': device.sc_w,
        'talk_time': device.talk_time,
        'three_g': device.three_g,
        'touch_screen': device.touch_screen,
        'wifi': device.wifi,
        'price_range': device.price_range
    }
    return device_data
