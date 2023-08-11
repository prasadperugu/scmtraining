FROM nginx:alpine

# Copy the HTML files to the image
COPY . /usr/share/nginx/html

# Expose port 5500 for the application
EXPOSE 80

# Start nginx web server
CMD ["nginx", "-g", "daemon off;"]