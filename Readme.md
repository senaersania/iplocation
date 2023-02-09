# IP Location
- Purpose : track all ecs ip address from json file

# Configuration
```
Tech: JDK 8
```
```
MODIFY
    readFileService.readFile("/Users/sena/ecs/ecs_ap-southeast-5_sg-k1a09pphn39em9ns91zk.json")
INTO
    readFileService.readFile("/your_path/ecs.json")
```

# Feature
```
http://localhost:8080/iplocation
```

# Output
```
Status Code: 403, Message: IP to geolocation lookup for domain or service name is not supported on your free subscription. This feature is available to all paid subscriptions only.
Status Code: 423, Message: '172.31.170.213' is a bogon (Private-Use (RFC1918)) IP address.
Status Code: 423, Message: '172.31.22.241' is a bogon (Private-Use (RFC1918)) IP address.
IP : 149.129.213.188, Location: Indonesia
Status Code: 423, Message: '172.31.170.0' is a bogon (Private-Use (RFC1918)) IP address.
Status Code: 423, Message: '172.31.22.241' is a bogon (Private-Use (RFC1918)) IP address.
IP : 149.129.224.189/32, Location: Indonesia
Status Code: 423, Message: '172.31.22.0' is a bogon (Private-Use (RFC1918)) IP address.
IP : 149.129.224.189/32, Location: Indonesia
Status Code: 403, Message: IP to geolocation lookup for domain or service name is not supported on your free subscription. This feature is available to all paid subscriptions only.
Status Code: 423, Message: '172.31.0.0' is a bogon (Private-Use (RFC1918)) IP address.
Status Code: 423, Message: '172.18.38.126' is a bogon (Private-Use (RFC1918)) IP address.
Status Code: 423, Message: '172.16.32.29' is a bogon (Private-Use (RFC1918)) IP address.
IP : 47.95.254.239, Location: China
IP : 39.105.10.53, Location: China
IP : 43.230.89.70, Location: Hong Kong
IP : 43.230.89.71, Location: Hong Kong
IP : 39.105.124.221/32, Location: China
IP : 161.117.85.120/32, Location: Singapore
IP : 47.88.152.76/32, Location: Singapore
IP : 43.230.89.70, Location: Hong Kong
IP : 43.230.89.71, Location: Hong Kong
IP : 43.230.89.71, Location: Hong Kong
IP : 43.230.89.70, Location: Hong Kong
IP : 123.57.91.43/32, Location: China
IP : 47.241.11.131/32, Location: Singapore
IP : 114.113.113.210/32, Location: China
IP : 103.91.177.86/32, Location: China
IP : , Location: Indonesia
IP : , Location: Indonesia
```