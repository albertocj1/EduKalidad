# EDUKALIDAD

This project is a JavaFX application developed in Visual Studio Code (VS Code).

## Prerequisites

Before you begin, ensure you have met the following requirements:
- **Java Development Kit (JDK)**: Install JDK 11 or later. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **JavaFX SDK**: Download the JavaFX SDK from [here](https://gluonhq.com/products/javafx/).
- **Visual Studio Code**: Install the latest version of VS Code from [here](https://code.visualstudio.com/).
- **VS Code Extensions**:
  - Install the [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) for VS Code.
  - Install the [JavaFX extension](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-javafx) if available.

## Setting Up the Project

1. **Clone the Repository**:
   ```sh
   git clone <repository-url>
   cd <repository-directory>

2. **Configure the JavaFX SDK**:
- Extract the downloaded JavaFX SDK to a directory of your choice.
- Open VS Code and go to `File -> Preferences -> Settings`.
- In the search bar, type `java.fx.sdk`.
- Add the path to the JavaFX SDK.
  
3. **Set Up VS Code for JavaFX**:
- Open the command pallete (Ctrl + Shift + P) and select `Java: Configure Classpath`.
- Add the JavaFX library files to your classpath. These are typically located in the `lib` directory of your JavaFX SDK.

4. **Create `launch.json` Configuration:**
- In the `.vscode` directory, create a `launch.json` file if it doesn't already exist.
- Add the following configuration to run your JavaFX application:
  ```json
  {
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Current File",
            "request": "launch",
            "mainClass": "${file}"
        },
        {
            "type": "java",
            "name": "App",
            "request": "launch",
            "mainClass": "App",
            "projectName": "EDUKALIDAD_fb8da4e",
            "vmArgs": "--module-path C:/javafx-sdk-20.0.1/lib --add-modules javafx.controls,javafx.fxml"
        }
    ]
  }
5. **Run the Application**:
- Run the JavaFX project


   



