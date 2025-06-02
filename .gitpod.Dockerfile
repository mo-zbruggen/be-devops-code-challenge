FROM gitpod/workspace-full:latest

# Install Java 17 and Maven
RUN sudo apt-get update && sudo apt-get install -y openjdk-17-jdk maven

# Install Python tools
RUN pip3 install --upgrade pip && pip install flask

# Docker-in-Docker setup
RUN sudo apt-get install -y docker.io

# Kubernetes CLI tools
RUN curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl" \
    && chmod +x kubectl && sudo mv kubectl /usr/local/bin/
