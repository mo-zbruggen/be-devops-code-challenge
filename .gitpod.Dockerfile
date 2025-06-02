FROM gitpod/workspace-full:latest

# Install Java 17 and Maven
RUN sudo apt-get update && sudo apt-get install -y openjdk-17-jdk maven

# Install Python tools
RUN pip3 install --upgrade pip && pip install flask

# Docker-in-Docker setup
RUN sudo apt-get install -y docker.io