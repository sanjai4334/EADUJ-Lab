#!/bin/bash

# Compile the Java files
javac TCPServer.java
javac TCPClient.java

# Run the server in a new terminal window
gnome-terminal -- bash -c "java TCPServer; exec bash"

# Run two clients in separate terminal windows
gnome-terminal -- bash -c "java TCPClient; exec bash"
gnome-terminal -- bash -c "java TCPClient; exec bash"
