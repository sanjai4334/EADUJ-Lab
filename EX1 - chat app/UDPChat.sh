#!/bin/bash

# Compile the Java files
javac UDPServer.java
javac UDPClient.java

# Run the server in a new terminal window
gnome-terminal -- bash -c "java UDPServer; exec bash"

# Run two clients in separate terminal windows
gnome-terminal -- bash -c "java UDPClient; exec bash"
