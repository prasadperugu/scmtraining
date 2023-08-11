# Use an official Python runtime as a parent image
FROM python:3.9-slim-buster
# Set the working directory to /app
WORKDIR /server
# Copy the current directory contents into the container at /app
COPY . /server
EXPOSE 12345
# Run the command to start the script
CMD [ "python", "./server.py" ]