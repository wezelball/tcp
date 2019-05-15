#!/usr/bin/env python2

import socket
import sys

# Connects to the server
# Code will wait for connection instead of crashing
def openSocket(server):
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    connected = False
    while not connected:
        try:
            s.connect(server)
            connected = True
            return s
        except Exception as e:  # don't crash
            pass
    


server_address = ('127.0.0.1', 65000)
datain = ""
dataout = ""
gotdata = False
buffer_size = 1024

# Open the network socket
sock = openSocket(server_address)

try: 
    while datain <> "bye":
        datain += sock.recv(buffer_size)
        print ('Received %s' % datain)
        if not datain:
            break
        if not datain.endswith("\n"):
            continue
        lines = datain.split("\n")
        lines = filter(None, lines)
        for line in lines:
            if line.startswith("nobj"):
                dataout = "nobj:1\n"
                gotdata = True
            elif line.startswith("Xc"):
                dataout = "Xc:300\n"
                gotdata = True
        
        if gotdata == True:
            sock.sendall(dataout)
            dataout = ""
            datain = ""
            gotdata = False
                
except Exception as e:
    sock = openSocket(server_address)

#finally:
#    print('Closing socket')
#    sock.close()