## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


# Logistics Application (Factory Method & Abstract Factory)

## Project Purpose
This application demonstrates the Factory Method and Abstract Factory software design patterns in Java 17. It allows a client application to instantiate transport methods (Road/Sea) and UI component families (Windows/macOS) based on runtime arguments.

## Package Structure
```text
src/
└── com/logistics/
    ├── log/      # Factory Method (Transport, Truck, Ship, Logistics, RoadLogistics, SeaLogistics)
    ├── ui/       # Abstract Factory (Button, Checkbox, WindowsFactory, MacOSFactory, etc.)
    ├── app/      # DeliveryApplication client
    └── Main.java # Entry point & validation logic

Prerequisites

    Java Development Kit (JDK) 17 or higher

    Git

How to Build and Run
Step 1: Compile the source code
javac -d bin src/com/logistics/*.java src/com/logistics/*/*.java

Step 2: Run the application
java -cp bin com.logistics.Main <ROAD|SEA> <WINDOWS|MACOS>

Supported Input Values
Delivery Modes: ROAD, SEA
UI Platforms: WINDOWS, MACOS

Sample Run
$ java -cp bin com.logistics.Main ROAD WINDOWS
Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse