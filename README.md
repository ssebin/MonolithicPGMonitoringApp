# Postgraduate Monitoring System (Monolithic Version)

## Introduction

The **Postgraduate Monitoring System (PGMS)** is a console-based Java application designed to streamline and enhance the management of postgraduate students within an academic institution. This monolithic version operates as a single-tiered application where all functionalities are tightly integrated into one system.

## Features

- **Manage Students**
  - Add, edit, remove, and view student information.
- **Manage Supervisors**
  - Add, edit, remove, and view supervisor information.
- **Supervisor Appointment**
  - Assign and remove supervisors to/from students.
  - View students without supervisors.
  - View students under a specific supervisor.
- **Progress Update Management**
  - Add, edit, remove, and view progress updates for students.

## Prerequisites

- **Java Development Kit (JDK)**
  - **Version:** Java 22 (Ensure you have the correct version installed).
  - **Download:** [Oracle Java SE Downloads](https://www.oracle.com/java/technologies/downloads/)
- **Eclipse IDE** (Optional but recommended)
  - **Version:** Latest or any version compatible with Java 22.
  - **Download:** [Eclipse Downloads](https://www.eclipse.org/downloads/)
- **Command-Line Interface**
  - Terminal, Command Prompt, or PowerShell.

## Project Structure

- **ProjectRoot/**
  - **src/**
    - Contains all the Java source code organized by packages.
  - **bin/**
    - Contains compiled `.class` files (if any).
  - **README.md**
    - Documentation file.

## How to Run the Application

1. **Import the Project into Eclipse**

   - Open **Eclipse IDE**.
   - Go to **`File` > `Import`**.
   - Select **`General` > `Existing Projects into Workspace`**, then click **`Next`**.
   - Click **`Browse`** next to **`Select root directory`**, navigate to the **ProjectRoot** directory, and select it.
   - Ensure the project appears in the **`Projects`** list and is checked.
   - Click **`Finish`**.

2. **Build the Project**

   - Eclipse should automatically build the project upon import.
   - If not, right-click on the project in the **Package Explorer** and select **`Refresh`** and then **`Build Project`**.

3. **Run the Application**

   - In the **Package Explorer**, navigate to the `MainUI.java` file located in `src/com/postgrad/application/`.
   - Right-click on `MainUI.java`.
   - Select **`Run As` > `Java Application`**.
   - The application will launch, and you can interact with it through the **Console** view.
