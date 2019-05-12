import socket               # Import socket module

s = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 5000                # Reserve a port for your service.

s.connect((host, port))
while 1:
    print s.recv(5000)
    s.send("message processed.."+'\n')

s.close 
