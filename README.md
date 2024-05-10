# Devices Price Classification System

---

## Overview:

This project aims to develop a Devices Price Classification System using Python and Spring Boot. The system consists of two main components: a Python project for building machine learning models to predict device prices based on their specifications, and a Spring Boot project to create RESTful API endpoints for interacting with the models.

## Directory Structure:

- **dataset**: Contains all processed and non-processed data, preprocessing code, saved pipeline of the preprocessing and exploratory data analysis (EDA) of the data.
  
- **devicepricesystem**: Contains the Spring Boot project for handling device entities and API endpoints.

- **flask**: Contains Flask API with the required endpoints.

- **models**: Contains the saved machine learning models and model code.

## Python Project:

- **Data Preparing**:
  - Perform data preprocessing and engineering.
  - Exploratory Data Analysis (EDA) to understand the dataset, highlighting 1-2 insights.

- **Modeling Steps**:
  - Train machine learning models using different algorithms.
  - Evaluate models using various metrics (e.g., confusion matrix).

- **Endpoints**:
  - Implement RESTful API to add and get devices specifications and predict devices prices.
  - API takes device specifications as input, sends it to the ML model, and returns the predicted price.

## Spring Boot Project:

- **Entities**:
  - Define the 'Device' entity to describe each device in the system.

- **Endpoints**:
  - Implement RESTful endpoints to handle operations like retrieving device details, adding new devices, and predicting prices.

- **Prediction Endpoint**:
  - Endpoint to call the Python API for price prediction and save the result in the device entity.
  - Apply best practices like transaction management.

## Testing:
- Tested using Thunder Client and the test dataset.
- Perform predictions for 10 devices from the provided test dataset and saved the predictions in the database.

## Data Storage:

- Integerated MySQL with both flask and Spring boot.

---

## Getting Started:

1. Clone the repository.
2. Navigate to the respective directories: 'dataset', 'devicepricesystem', 'flask', 'models'.
3. Create the Schema in your database.
4. Ensure all dependencies are installed.
5. Run the applications according to the provided instructions.
6. Use Postman or Thunder Client to use with the API.