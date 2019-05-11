import socket
import select

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect(("localhost", 25000))
while True:
    r, _, _ = select.select([client_socket], [], [])
    if r:
        data = client_socket.recv(4096)
        #string_data = data.decode('utf-8')
        string_data = data
        print str(string_data) == 'q'
        if str(string_data) == 'q' or string_data == 'Q':
            print ('Connection closed')
            client_socket.close()
            break
        else:
            print (string_data)