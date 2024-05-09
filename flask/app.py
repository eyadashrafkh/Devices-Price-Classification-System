import csv
from flask import Flask, request, jsonify
from flask_sqlalchemy import SQLAlchemy
from util import predict, prepare_device_data

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://root:1234@localhost/device_price_system'
db = SQLAlchemy(app)

# Define the Device model
class Device(db.Model):
    __tablename__ = 'device'
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    battery_power = db.Column(db.Integer)
    blue = db.Column(db.Integer)
    clock_speed = db.Column(db.Float)
    dual_sim = db.Column(db.Integer)
    fc = db.Column(db.Integer)
    four_g = db.Column(db.Integer)
    int_memory = db.Column(db.Integer)
    m_dep = db.Column(db.Float)
    mobile_wt = db.Column(db.Float)
    n_cores = db.Column(db.Integer)
    pc = db.Column(db.Integer)
    px_height = db.Column(db.Integer)
    px_width = db.Column(db.Integer)
    ram = db.Column(db.Integer)
    sc_h = db.Column(db.Integer)
    sc_w = db.Column(db.Integer)
    talk_time = db.Column(db.Integer)
    three_g = db.Column(db.Integer)
    touch_screen = db.Column(db.Integer)
    wifi = db.Column(db.Integer)
    price_range = db.Column(db.Integer, nullable=True)

# Function to add data from CSV file to the database
def add_data_from_csv(csv_file_path):
    try:
        with open(csv_file_path, 'r') as file:
            csv_reader = csv.DictReader(file)
            for row in csv_reader:
                # Extract the price if available, otherwise set it to None
                price = int(row.get('price_range')) if 'price_range' in row else None
                
                new_device = Device(
                    battery_power=int(row['battery_power']),
                    blue=int(row['blue']),
                    clock_speed=float(row['clock_speed']),
                    dual_sim=int(row['dual_sim']),
                    fc=int(row['fc']),
                    four_g=int(row['four_g']),
                    int_memory=int(row['int_memory']),
                    m_dep=float(row['m_dep']),
                    mobile_wt=float(row['mobile_wt']),
                    n_cores=int(row['n_cores']),
                    pc=int(row['pc']),
                    px_height=int(row['px_height']),
                    px_width=int(row['px_width']),
                    ram=int(row['ram']),
                    sc_h=int(row['sc_h']),
                    sc_w=int(row['sc_w']),
                    talk_time=int(row['talk_time']),
                    three_g=int(row['three_g']),
                    touch_screen=int(row['touch_screen']),
                    wifi=int(row['wifi']),
                    price_range=price
                )
                db.session.add(new_device)
            db.session.commit()
            return True
    except Exception as e:
        print(f"Error adding data from CSV: {e}")
        return False

# Endpoints
@app.route('/api/devices', methods=['GET'])
def get_all_devices():
    devices = db.session.query(Device).all()
    devices_list = []
    try:
        for device in devices:
            device_data = prepare_device_data(device)
            devices_list.append(device_data)
        json_data = jsonify(devices_list)
        return json_data
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@app.route('/api/devices/<int:id>', methods=['GET'])
def get_device_by_id(id):
    device = db.session.get(Device, id)
    try:
        if device:
            device_data = prepare_device_data(device)
            return jsonify(device_data)
        else:
            return jsonify({"error": "Device not found"}), 404
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@app.route('/api/devices', methods=['POST'])
def add_device():
    try:
        device_data = request.json
        new_device = Device(**device_data)
        db.session.add(new_device)
        db.session.commit()
        return jsonify({"message": "Device added successfully"}), 201
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@app.route('/api/predict/<int:device_id>', methods=['POST'])
def predict_device(device_id):
    device = db.session.get(Device, device_id)
    try:
        if device:
            device_data = prepare_device_data(device)
            features = [device_data]
            prediction = predict([features][0])
            price_ranges = ['Low Cost', 'Medium Cost', 'High Cost', 'Very High Cost']
            predicted_range = price_ranges[prediction[0]]
            device.price_range = prediction[0]
            db.session.commit()
            return jsonify({"message": "Prediction successful", "predicted_price_range": predicted_range}), 200
        else:
            return jsonify({"error": "Device not found"}), 404
    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
        # Provide the path to your CSV file
        csv_file_path = 'dataset/test.csv'
        if add_data_from_csv(csv_file_path):
            print("Data added successfully from CSV file.")
        else:
            print("Failed to add data from CSV file.")
    app.run(port=3000, debug=True)
